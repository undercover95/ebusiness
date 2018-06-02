import React from 'react';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  Badge
} from 'reactstrap';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import {
  faShoppingCart,
  faSignInAlt,
  faUserPlus
} from '@fortawesome/fontawesome-free-solid'

import {
  NavLink as Link
} from 'react-router-dom';

import CartStore from 'stores/CartStore';

export default class TopBar extends React.Component {
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      isOpen: false,
      cartCounter: 0
    };
    this.updateCartItemsCounter = this.updateCartItemsCounter.bind(this);
  }

  componentWillMount() {
    CartStore.on('addProductToCartCompleted', this.updateCartItemsCounter);
  }

  componentWillUnmount() {
    CartStore.removeListener('addProductToCartCompleted', this.updateCartItemsCounter);
  }

  updateCartItemsCounter() {
    this.setState({
      cartCounter: CartStore.getCounter()
    })
  }

  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }
  
  render() {
    return (
      <div>
        <Navbar color="light" light expand="md" className={'mb-3'}>
          <NavbarBrand><Link to="/">Mój sklep internetowy</Link></NavbarBrand>
          <NavbarToggler onClick={this.toggle} />
          <Collapse isOpen={this.state.isOpen} navbar>
            <Nav className="ml-auto" navbar>
              <NavItem>
                <Link activeClassName='active' className="nav-link" to="/cart"><FontAwesomeIcon icon={faShoppingCart} /> Mój koszyk <Badge color="secondary">{this.state.cartCounter}</Badge></Link>
              </NavItem>
              <NavItem>
                <Link activeClassName='active' className="nav-link" to="/register"><FontAwesomeIcon icon={faUserPlus} />  Zarejestruj się</Link>
              </NavItem>
              <NavItem>
                <Link activeClassName='active' className="nav-link" to="/login"><FontAwesomeIcon icon={faSignInAlt} /> Zaloguj się</Link>
              </NavItem>
            </Nav>
          </Collapse>
        </Navbar>
      </div>
    );
  }
}
