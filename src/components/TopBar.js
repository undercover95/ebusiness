import React from 'react';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  Button
} from 'reactstrap';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import {
  faSignInAlt,
  faSignOutAlt,
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
      userData: null
    };
  }

  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }

  componentDidMount() {
    axios.get('http://localhost:9090/getUser', {
      withCredentials: true // !!!!
    }).then(res => {
        let userDataJson = res.data;
        if(userDataJson != "") {
          this.setState({
            userData: userDataJson
          })
        }
    });

  }

  logout() {
    console.log("proboje wylogowac")

    axios.get('http://localhost:9090/logout', {
      withCredentials: true // !!!!
    }).then(res => {
      console.log(res.data);
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
                <TopBar_cartCounter />
              </NavItem>
            </Nav>
              {
                this.state.userData != null ? (
                  <Nav navbar>
                    <NavItem>
                      <Link activeClassName='active' className="nav-link" to="#"><img src={this.state.userData.avatarURL} width={24} className={'mr-1'}/> {this.state.userData.fullName}</Link>
                    </NavItem>
                    <NavItem>
                      <a className="nav-link" href={'http://localhost:9090/logout'}><FontAwesomeIcon icon={faSignOutAlt} /> Wyloguj się</a>
                    </NavItem>
                  </Nav>
                ) : (
                  <Nav navbar>
                    <NavItem>
                      <Link activeClassName='active' className="nav-link" to="/login"><FontAwesomeIcon icon={faSignInAlt} /> Zaloguj się</Link>
                    </NavItem>
                  </Nav>
                )
              }


          </Collapse>
        </Navbar>
      </div>
    );
  }
}
