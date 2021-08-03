import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class GoalList extends Component {

    constructor(props) {
        super(props);
        this.state = {goals: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/SpyglassAPI/Goals')
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
            return <tr key={goal.id}>
                <td style={{whiteSpace: 'nowrap'}}>{goal.name}</td>
                <td>{goal.description}</td>
                <td>{goal.startDate}</td>
                <td>{goal.targetDate}</td>
                <td>{goal.targetAmount}</td>
                <td>{goal.amountCurrentlySaved}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/Goals/" + goal.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(goal.id)}>Delete</Button>
                    </ButtonGroup>
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
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th >Name</th>
                            <th >Description</th>
                            <th >Start Date</th>
                            <th >Target Date</th>
                            <th >Target Amount</th>
                            <th >Amount Saved</th>
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