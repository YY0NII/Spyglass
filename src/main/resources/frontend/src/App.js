import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import GoalList from './GoalList';
import GoalEdit from "./GoalEdit";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/Goals' exact={true} component={GoalList}/>
            <Route path='/Goals/:id' component={GoalEdit}/>
          </Switch>
        </Router>
    )
  }
}

export default App;