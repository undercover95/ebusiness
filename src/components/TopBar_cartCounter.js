import React from 'react';
import {
  Badge
} from 'reactstrap';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import {
  faShoppingCart
} from '@fortawesome/fontawesome-free-solid'

import {
  NavLink as Link
} from 'react-router-dom';

import CartStore from 'stores/CartStore';
import * as CartActions from 'actions/CartActions';

export default class TopBar_cartCounter extends React.Component {
  constructor() {
    super();
    this.state = {
      isOpen: false,
      cartCounter: 0
    };
    this.updateCartItemsCounter = this.updateCartItemsCounter.bind(this);
  }

  componentWillMount() {
    CartStore.on('addProductToCartCompleted', this.updateCartItemsCounter);
    CartStore.on('getCartItemsCompleted', this.updateCartItemsCounter);
  }

  componentWillUnmount() {
    CartStore.removeListener('addProductToCartCompleted', this.updateCartItemsCounter);
    CartStore.removeListener('getCartItemsCompleted', this.updateCartItemsCounter);
  }

  componentDidMount() {
    CartActions.getCartItems();
  }

  updateCartItemsCounter() {
    this.setState({
      cartCounter: CartStore.getCounter()
    })
  }

  render() {
    return (
      <Link activeClassName='active' className="nav-link" to="/cart"><FontAwesomeIcon icon={faShoppingCart} /> Mój koszyk <Badge color="secondary">{this.state.cartCounter}</Badge></Link>
    );
  }
}
