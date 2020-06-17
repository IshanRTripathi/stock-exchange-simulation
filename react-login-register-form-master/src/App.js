import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import MakeTrade from './components/MakeTrade';
import TradeStatus from './components/TradeStatus';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="container">
        <Route exact path="/" component={Login} />
        <Route path="/register" component={Register} />
        <Route path="/MakeTrade" component={MakeTrade} />
        <Route path="/TradeStatus" component={TradeStatus} />
      </div>
    );
  }
}

export default App;
