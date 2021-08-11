import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';
import axios from 'axios';

class CommentAdd extends Component {

    emptyItem = {
        
        text: '',
       
        

    };

    state = {
        file: null
    }

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem,
        };
    }

     async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const goal = await (await fetch(`/Goals/${this.props.match.params.id}`)).json();
            this.setState({item: goal});
        }
    } 

    handleFile(e){
        let file = e.target.files[0]

        this.setState({file: file})
    }

    handleUpload(e){
        const {item} = this.state;
        
        let file = this.state.file

        let formdata = new FormData()

        formdata.append('file', file)

        axios.post('http://localhost:8080/SpyglassAPI/Goals/newImage/' + item.id, formdata)
        alert("New image uploaded!")
    }

    render() {
        
        const title = <h2>{'Add Image'}</h2>;
    
        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form>
                    <FormGroup>
                        <Label for="file">Comment</Label>
                        <Input type="file" name="file" id="file" onChange={(e)=>this.handleFile(e)}/>
                    </FormGroup>
                    

                    <FormGroup>
                        <Button color="primary" type="Button" onClick={(e)=>this.handleUpload(e)}>Comment</Button>{' '}
                        <Button color="secondary" tag={Link} to="/Goals">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}
export default withRouter(ImageAdd);