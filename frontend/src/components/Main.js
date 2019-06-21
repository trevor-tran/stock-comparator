import React from 'react';
import { BrowserRouter as Router, Route, Redirect } from 'react-router-dom';
import SigninForm from './SigninForm';
import SignupForm from './SignupForm';

import '../css/Main.css';

import Footer from './Footer';

function Main() {
  return (
    <React.Fragment>
      <p> hi main</p>
      <Router>
        <Route path="/signin" component={SigninForm} />
        <Route path="/signup" component={SignupForm} />
        {/* <Route path="*" render={() => (
          <Redirect to="/signin" />
        )} /> */}
      </Router>
    </React.Fragment>
  );
}

export default Main;