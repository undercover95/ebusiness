import React from 'react';

import { Button, Row, Col } from 'reactstrap';

import CartItem from './CartItem';
import CartStore from 'stores/CartStore';
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

  deleteProductFromCart(product_id) {
    CartActions.deleteProductFromCart(product_id);
  }

  getSummary() {
    let sum = 0.0;
    this.state.items.map(item => {
      sum += (item.quantity * (item.price.toFixed(2)));
    });
    return sum.toFixed(2);
  }

  render() {
    return (
      <Row>
        <Col md='12'>
          <h3>Mój koszyk</h3>
          <table className={'table table-hover'}>
            <thead>
            <tr>
              <th>Zdjęcie</th>
              <th>Nazwa produktu</th>
              <th>Liczba szt.</th>
              <th>Cena</th>
              <th></th>
            </tr>
            </thead>
            <tbody>
              {this.state.items.map(item => {
                return <CartItem key={item.id} itemData={item} deleteProductFromCart={this.deleteProductFromCart.bind(this)} />
              })}
            </tbody>
          </table>
          <h4>Razem: {this.getSummary()}&nbsp;zł</h4>

          <Button color={'primary'}>Złóż zamówienie</Button>
        </Col>
      </Row>
    );
  }
}

