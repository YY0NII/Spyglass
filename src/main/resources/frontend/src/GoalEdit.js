import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class GoalEdit extends Component {

    emptyGoal = {
        
        name: '',
        description: '',
        image: '',
        startDate: '',
        targetAmount: '',
        amountCurrentlySaved: '',
        

    };

    constructor(props) {
        super(props);
        this.state = {
            goal: this.emptyGoal
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const goal = await (await fetch(`/Goals/${this.props.match.params.id}`)).json();
            this.setState({item: goal});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;
    
        await fetch('/Goals' + (item.id ? '/' + item.id : ''), {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/Goals');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Goal' : 'Add Goal'}</h2>;
    
        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="name">Name</Label>
                        <Input type="text" name="name" id="name" value={item.name || ''}
                               onChange={this.handleChange} autoComplete="name"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="description">Description</Label>
                        <Input type="text" name="description" id="description" value={item.description || ''}
                               onChange={this.handleChange} autoComplete="description"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="startDate">Start Date</Label>
                        <Input type="date" name="startDate" id="startDate" value={item.startDate || ''}
                               onChange={this.handleChange} autoComplete="startDate"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="targetDate">Target Date</Label>
                        <Input type="date" name="targetDate" id="targetDate" value={item.targetDate || ''}
                               onChange={this.handleChange} autoComplete="targetDate"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="amountCurrentlySaved">Amount Saved</Label>
                        <Input type="text" name="amountCurrentlySaved" id="amountCurrentlySaved" value={item.amountCurrentlySaved || ''}
                               onChange={this.handleChange} autoComplete="amountCurrentlySaved"/>
                    </FormGroup>

                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/Goals">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}
export default withRouter(GoalEdit);