import React from 'react';
import { Container, Row, Col } from 'reactstrap';

import { Navbar, Nav, NavItem, NavLink } from 'reactstrap';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import {
  faCog
} from '@fortawesome/fontawesome-free-solid'

import {
  NavLink as Link
} from 'react-router-dom';

export default class Footer extends React.Component {

  render() {
    return (
      <Row>
        <Col>
            <Nav className={'py-4 mb-3'}>
              <NavItem>
                <NavLink><Link to="/admin"><FontAwesomeIcon icon={faCog} /> Panel administracyjny</Link></NavLink>
              </NavItem>
              <NavItem>
                <NavLink><Link to="#">Polityka prywatności</Link></NavLink>
              </NavItem>
            </Nav>
        </Col>
      </Row>
    );
  }
}
