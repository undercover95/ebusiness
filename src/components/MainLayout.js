import React from 'react';

import { Row, Col } from 'reactstrap';

import Categories from './categories/Categories';

export default class MainLayout extends React.Component {

  render() {
    return (
      <Row>
        <Col md='3'>
          <Categories />
        </Col>
        <Col md='9'>
          Slider czy coś<br/>
          Lista ostatnio oglądanych
        </Col>
      </Row>
    );
  }
}

