import React from 'react';

import { Row, Col, Jumbotron } from 'reactstrap';

import Categories from './categories/Categories';

export default class MainLayout extends React.Component {

  render() {
    return (
      <Row>
        <Col md='3'>
          <Categories />
        </Col>
        <Col md='9'>
          <Jumbotron>
            <h1 className="display-3">Mój Sklep Internetowy</h1>
            <p className="lead">Witaj w moim sklepie internetowym!</p>
            <hr className="my-2" />
            <p>Aby przejrzeć ofertę sklepu skorzystaj z listy kategorii po lewej.</p>
          </Jumbotron>
        </Col>
      </Row>
    );
  }
}

