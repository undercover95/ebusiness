import React from 'react';

import { Row, Col } from 'reactstrap';

import Categories from './Categories';
import ProductsList from '../products/ProductsList';

export default class CategoryLayout extends React.Component {

  constructor() {
    super();
    this.state = {
      cat_id: 1
    }
  }

  componentWillReceiveProps (nextProps) {
    const newCatId = nextProps.match.params.id;

    this.setState({
      cat_id: newCatId
    });
  }

  render() {
    return (
      <Row>
        <Col md="3">
          <Categories />
        </Col>
        <Col md="9">
          <ProductsList cat_id={this.state.cat_id} />
        </Col>
      </Row>
    )
  }
}

