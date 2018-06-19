import React from 'react';
import { Container, Row, Col } from 'reactstrap';

import TopBar from './TopBar';
import MainLayout from './MainLayout';
import CategoryLayout from './categories/CategoryLayout';
import AdminLayout from './admin/AdminLayout';
import CartLayout from './cart/CartLayout';
import ProductViewLayout from './products/ProductViewLayout';
import Login from './login/Login';

import Footer from './Footer';

import {
  BrowserRouter as Router,
  Route
} from 'react-router-dom';

class AppComponent extends React.Component {
  render() {
    return (
      <Router>
        <Container>
          <Row className={'mb-4'}>
            <Col sm={12}>
              <TopBar />
            </Col>
          </Row>
            <Route exact path={'/'} component={MainLayout} />
            <Route path={'/category/:id'} component={CategoryLayout} />
            <Route path={'/admin'} component={AdminLayout} />
            <Route path={'/cart'} component={CartLayout} />
            <Route path={'/productView/:id'} component={ProductViewLayout} />
            <Route path={'/login'} component={Login} />
          <Row>
            <Col sm={12}>
              <Footer />
            </Col>
          </Row>
        </Container>
      </Router>
    );
  }
}

export default AppComponent;
