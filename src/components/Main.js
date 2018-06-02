import React from 'react';
import { Container, Row, Col } from 'reactstrap';

import TopBar from './TopBar';
import MainLayout from './MainLayout';
import CategoryLayout from './CategoryLayout';
import AdminLayout from './admin/AdminLayout';
import CartLayout from './cart/CartLayout';

import Breadcrumbs from './Breadcrumbs';
import Footer from './Footer';

import {
  BrowserRouter as Router,
  Route,
  Switch
} from 'react-router-dom';

class AppComponent extends React.Component {
  render() {
    return (
      <Router>
        <Container>
          <Row>
            <Col sm={12}>
              <TopBar />
              <Breadcrumbs />
            </Col>
          </Row>
            <Route exact path={'/'} component={MainLayout} />
            <Route path={'/category/:id'} exact component={CategoryLayout} />
            <Route path={'/admin'} component={AdminLayout} />
          <Route path={'/cart'} component={CartLayout} />
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
