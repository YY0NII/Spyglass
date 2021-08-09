import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import './GoalList.css'
import { Link } from 'react-router-dom';

class GoalList extends Component {

    constructor(props) {
        super(props);
        this.state = {goals: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('Goals')
            .then(response => response.json())
            .then(data => this.setState({goals: data}));
    }

    async remove(id) {
        await fetch(`/Goals/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedGoals = [...this.state.goals].filter(i => i.id !== id);
            this.setState({goals: updatedGoals});
        });
    }
    
    render() {
        const {goals, isLoading} = this.state;
    
        if (isLoading) {
            return <p>Loading...</p>;
        }
    
        const goalList = goals.map(goal => {
            return <tr class="table-row" key={goal.id}>
                <td style={{whiteSpace: 'nowrap'}}>
                    <h4>Name</h4>
                    <p><b>{goal.name}</b></p>
                    <h4>Description</h4>
                    <p><b>{goal.description}</b></p>

                    <img src={goal.image} width='150px' heigh='150px'></img>
                    <p>
                        <ButtonGroup>
                            <Button  color="primary" tag={Link} to={"/Goals/" + goal.id}>Update Goal</Button>
                            <Button  color="danger" onClick={() => this.remove(goal.id)}>Delete</Button>
                            <Button  color="warning" tag={Link} to={"/Goals/newImage/" + goal.id}>Add image</Button>
                        </ButtonGroup>
                    </p>
                </td>
                
                <td>
                    <h4>Start Date</h4>
                    <p><b>{goal.startDate.slice(0, 10)}</b></p>
                    <h4>Target Date</h4>
                    <p><b>{goal.targetDate.slice(0, 10)}</b></p>
                </td>
                <td>
                    <h4>Target Amount</h4>
                    <p style={{color: 'green'}}><b>${goal.targetAmount}</b></p>
                    <h4>Currently Saved</h4>
                    <p style={{color: 'green'}}><b>${goal.amountCurrentlySaved}</b></p>
                    <h4>Current Progress</h4>
                    <p style={{color: 'red'}}><b>${goal.progress} left to go</b></p>
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
                        <Button color="success" tag={Link} to="/Goals/new">Add Goals</Button>
                    </div>
                    <h3>Goals</h3>
                    <Table style={{
                    width: '700px',
                    height: '800px'}} className="mt-4">
                        <thead>
                        <tr>
                            <th>Goals</th>
                            <th>Dates</th>
                            <th>Funds</th>
                        </tr>
                        </thead>
                        <tbody>
                        {goalList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default GoalList;