import React from 'react';

import { Row, Col, Button } from 'reactstrap';

import GoogleIcon from './google.png';
const axios = require('axios');


export default class Login extends React.Component {

  login(provider) {
    axios.get('http://localhost:9090/login/'+provider).then(res => {
      console.log('logowanie', res.data);
    });
  }

  render() {
    return (
      <Row>
        <Col className={'text-center'}>
          <h3>Zaloguj się przy pomocy istniejącego konta:</h3>
          <div className='social-providers'>
            <Button color='link' onClick={() => {this.login('google')}}><img width={64} height={64} src={GoogleIcon} /></Button>
          </div>
        </Col>
      </Row>
    );
  }
}
