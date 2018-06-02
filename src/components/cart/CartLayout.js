import React from 'react';

import { Button, Row, Col } from 'reactstrap';
const axios = require('axios');

import CartItem from './CartItem';
import Categories from '../Categories';
import ProductsList from '../ProductsList';
import CartStore from "stores/CartStore";
import * as CartActions from 'actions/CartActions';

export default class CartLayout extends React.Component {

  constructor() {
    super();
    this.state = {
      items: []
    }
    this.getCartItems = this.getCartItems.bind(this);
  }

  getCartItems() {
    this.setState({
      items: CartStore.getCartProducts()
    })
  }

  componentWillMount() {
    CartStore.on('getCartItemsCompleted', this.getCartItems);
  }

  componentWillUnmount() {
    CartStore.removeListener('getCartItemsCompleted', this.getCartItems);
  }

  componentDidMount() {
    CartActions.getCartItems();
  }



  render() {
    return (
      <Row>
        <Col md="12">
          <h3>Mój koszyk</h3>
          <table className={'table table-hover'}>
            <thead>
            <tr>
              <th>Zdjęcie</th>
              <th>Nazwa produktu i opis</th>
              <th>Liczba sztuk</th>
              <th>Cena</th>
              <th></th>
            </tr>
            </thead>
            <tbody>
              {this.state.items.map(item => {
                return <CartItem key={item.id} itemData={item}/>
              })}
            </tbody>
          </table>
          <Button className={'float-right'} color={'primary'}>Złóż zamówienie</Button>
        </Col>
      </Row>
    );
  }
}

