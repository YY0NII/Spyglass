import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';


class CommentList extends Component {

    constructor(props) {
        super(props);
        this.state = { comments: [] };
        this.remove = this.remove.bind(this);

    }

    componentDidMount() {
        fetch('comments')
            .then(response => response.json())
            .then(data => this.setState({ comments: data }));

    }

    async remove(id) {
        await fetch(`/comment/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedComments = [...this.state.comments].filter(i => i.id !== id);
            this.setState({ comments: updatedComments });
        });
    }


    render() {
        const{comments, isLoading} = this.state;

        if (isLoading){
            return <p>Loading...</p>
        }

        
        const commentList = comments.map(comment => {
            return <tr class="table-row" key={comment.id}>
                <td style={{whiteSpace: 'nowrap'}}>
                    <h4>Text</h4>
                    <p><b>{comment.text}</b></p>
                    
                    <p>
                        <ButtonGroup>
                            <Button  color="primary" tag={Link} to={"/Goals/" + comment.id}>Update Comment</Button>
                            <Button  color="danger" onClick={() => this.remove(comment.id)}>Delete</Button>
                        </ButtonGroup>
                    </p>
                </td>
                
                
                
                <td>
                    
                </td>
  
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/Goals/new">Add Comment</Button>
                    </div>
                    <h3>Comments</h3>
                    <Table style={{
                    width: '700px',
                    height: '800px'}} className="mt-4">
                        <thead>
                        <tr>
                            <th>Comments</th>
                        </tr>
                        </thead>
                        <tbody>
                        {commentList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default CommentList;