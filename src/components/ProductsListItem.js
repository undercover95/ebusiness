import React from 'react';
import { Card, CardImg, CardBody,
  CardTitle, CardSubtitle, Button } from 'reactstrap';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import {
  faCartPlus
} from '@fortawesome/fontawesome-free-solid'

import * as CartActions from 'actions/CartActions';
import CartStore from 'stores/CartStore';


export default class ProductsListItem extends React.Component {

  addToCart(product_id) {
    console.log("dodaje do koszyka produkt ", product_id)
    CartActions.addProductToCart(product_id);
  }

  render() {

    const productData = this.props.data;

    return (
      <div>
        <Card>
          <CardImg top width="100%" src="https://placeholdit.imgix.net/~text?txtsize=33&txt=318%C3%97180&w=318&h=180" alt="Card image cap" />
          <CardBody className={'text-center'}>
            <CardTitle>{productData.name}</CardTitle>
            <CardSubtitle className={'mt-5'}>{productData.price.toFixed(2)} zł</CardSubtitle>
            <Button className={'mt-2'} color={'primary'} onClick={() => this.addToCart(productData.id)}><FontAwesomeIcon icon={faCartPlus} /> Do koszyka</Button>
          </CardBody>
        </Card>
      </div>
    );
  }
}
