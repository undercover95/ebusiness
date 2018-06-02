import React from 'react';

import { Container, Row, Col } from 'reactstrap';

import Categories from './Categories';
import ProductsList from './ProductsList';

export default class CartItem extends React.Component {

  render() {
    return (
      <Row>
        <Col md="12">
          <Categories />
        </Col>
      </Row>
    );
  }
}

