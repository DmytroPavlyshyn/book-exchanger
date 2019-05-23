import React, { Component } from 'react';
import './App.css';
import { Route, Link, BrowserRouter as Router, Switch } from 'react-router-dom'
import ExpenceList from './pages/books/ExpenceList';
import RegistrationForm from './pages/account/RegistrationForm';
import Notfound from './pages/common/NotFound';
import AnnouncePublish from './pages/books/AnnouncePublish';

class App extends Component {

  constructor() {
    super();
    console.log("[App] constructor");
  }

  componentDidMount() {
    console.log("[App] componentDidMount");
  }

  componentWillUnmount() {
    console.log("[App] componentWillUnmount");
  }

  render() {
    console.log("[App] render");

    return (
      <Router>
        <div className="App">
          <h1>Book Exchanger</h1>
          <div>
            <Link to="/">Main</Link>
            <br />
            <Link to="/register">Register</Link>
            <br />
            <Link to="/publish">Publish</Link>
          </div>
          <Switch>
            <Route exact path="/" component={ExpenceList} />
            <Route path="/register" component={RegistrationForm} />
            <Route path="/publish" component={AnnouncePublish} />
            <Route component={Notfound} />
          </Switch>
        </div>
      </Router>
    );
  }
}

export default App;



