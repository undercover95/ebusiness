import React from 'react';

import { Breadcrumb, BreadcrumbItem } from 'reactstrap';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import { faHome } from '@fortawesome/fontawesome-free-solid'

export default class Breadcrumbs extends React.Component {

  render() {
    return (
      <div>
        <Breadcrumb>
          <BreadcrumbItem><a href="#"><FontAwesomeIcon icon={faHome} /></a></BreadcrumbItem>
          <BreadcrumbItem><a href="#">Library</a></BreadcrumbItem>
          <BreadcrumbItem active>Data</BreadcrumbItem>
        </Breadcrumb>
      </div>
    );
  }
}
