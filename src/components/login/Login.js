import React from 'react';

import { Row, Col, Button } from 'reactstrap';

import GoogleIcon from './google.png';
const axios = require('axios');


export default class Login extends React.Component {

  render() {
    return (
      <Row>
        <Col className={'text-center'}>
          <h3>Zaloguj się przy pomocy istniejącego konta:</h3>
          <div className='social-providers'>
            <a href={'http://localhost:9090/login/google'}>
              <img width={64} height={64} src={GoogleIcon} />
            </a>
          </div>
        </Col>
      </Row>
    );
  }
}
