import React from 'react';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import { faHome } from '@fortawesome/fontawesome-free-solid'

import { Row, Col, Card, CardBody } from 'reactstrap';

import AddProductForm from './AddProductForm';
import AddCategoryForm from './AddCategoryForm';

export default class Admin extends React.Component {

  render() {
    return (
      <Row>
        <Col lg={'6'} className={'mb-4'}>
          <Card>
            <CardBody>
              <AddProductForm />
            </CardBody>
          </Card>

        </Col>
        <Col lg={'6'} className={'mb-4'}>
          <Card>
            <CardBody>
              <AddCategoryForm />
            </CardBody>
          </Card>
        </Col>
      </Row>
    );
  }
}
