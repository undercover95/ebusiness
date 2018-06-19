import React from 'react';

import { Row, Col } from 'reactstrap';
import ProductsListItem from './ProductsListItem';

import CategoriesStore from 'stores/CategoriesStore';

const axios = require('axios');
export default class ProductsList extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      products: [],
      cat_id: props.cat_id
    }
    this.loadProducts = this.loadProducts.bind(this);
  }

  loadProducts() {
    axios.get('http://localhost:9090/products/'+this.state.cat_id).then((productsData) => {
      //console.log('listProductsInCategory AXIOS completed',productsData);
      this.setState({
        products: productsData.data
      })
    }).catch((err) => {
      console.log('AXIOS listProductsInCategory FAILED', err)
    });
  }

  componentWillReceiveProps (nextProps) {
    const newCatId = nextProps.cat_id;

    this.setState({
      cat_id: newCatId
    });
  }

  componentDidUpdate(prevProps, prevState) {
    if(this.props.cat_id != prevProps.cat_id) {
      this.loadProducts();
    }
  }

  componentDidMount() {
    this.loadProducts();
  }

  getCategoryName(cat_id) {
    let data = CategoriesStore.getCategoryData(cat_id);
    return data === undefined ? '' : data.name;
  }

  render() {
    return (
      <div className={'mb-4'}>
        <h4>Lista Produktów <small style={{'fontStyle': 'italic'}}>w kategorii {this.getCategoryName(this.props.cat_id)}</small></h4>
        <Row>
          {this.state.products.map(product => {
            return (
              <Col key={product.id} xs={'12'} sm={'6'} md={'6'} lg={'4'} className={'mb-4'}>
                <ProductsListItem data={product}/>
              </Col>
            )
          })}
        </Row>
      </div>
    );
  }
}
