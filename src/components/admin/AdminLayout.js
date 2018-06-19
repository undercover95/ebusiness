import React from 'react';

import { Row, Col } from 'reactstrap';
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

