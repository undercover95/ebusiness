import React from 'react';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem
} from 'reactstrap';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import {
  faSignInAlt,
  faUserPlus
} from '@fortawesome/fontawesome-free-solid'

import {
  NavLink as Link
} from 'react-router-dom';

import TopBar_cartCounter from './TopBar_cartCounter';
const axios = require('axios');

export default class TopBar extends React.Component {
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      isOpen: false,
    };
  }

  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }

  componentDidMount() {
    axios.get('http://localhost:9090/loginResult').then(res => {
        console.log(res.data);
      }
    );
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
                <TopBar_cartCounter />
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
