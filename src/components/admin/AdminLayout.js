import React from 'react';

import { Container, Row, Col } from 'reactstrap';
import Admin from './Admin';

export default class AdminLayout extends React.Component {

  render() {
    return (
      <Row>
        <Col sm="12">
          <Admin />
        </Col>
      </Row>
    );
  }
}

