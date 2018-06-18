import React from 'react';
import { Badge, ListGroup, ListGroupItem } from 'reactstrap';
import FontAwesome from 'react-fontawesome';

import * as CategoriesActions from 'actions/CategoriesActions';
import CategoriesStore from 'stores/CategoriesStore';

import {
  NavLink as Link
} from 'react-router-dom';

export default class Categories extends React.Component {

  constructor() {
    super();
    this.state = {
      categoriesData: []
    };
    this.listCategories = this.listCategories.bind(this);
  }

  componentWillMount() {
    CategoriesStore.on('categoriesDataChanged', this.listCategories);
  }

  componentWillUnmount() {
    CategoriesStore.removeListener('categoriesDataChanged', this.listCategories);
  }

  componentDidMount() {
    CategoriesActions.listCategories();
  }

  listCategories() {
    this.setState({
      categoriesData: CategoriesStore.getCategoriesData()
    });

    console.log(this.state.categoriesData);
  }

  render() {
    const categories = this.state.categoriesData;
    //const emptyData = categories.length;

    return (
      <div className={'mb-4'}>
        <h4>Kategorie</h4>
        <ListGroup>
          {
            categories.map(cat => {
              return <ListGroupItem key={cat.id}><Link to={'/category/'+cat.id} >{cat.name}</Link></ListGroupItem>
            })
          }
        </ListGroup>
      </div>
    );
  }
}
