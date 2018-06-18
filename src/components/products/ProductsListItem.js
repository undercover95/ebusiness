import React from 'react';
import { Card, CardImg, CardBody,
  CardTitle, CardSubtitle, Button, ButtonGroup } from 'reactstrap';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import {
  faCartPlus,
  faEye
} from '@fortawesome/fontawesome-free-solid'

import {
  NavLink as Link
} from 'react-router-dom';

import * as CartActions from 'actions/CartActions';

export default class ProductsListItem extends React.Component {

  addToCart(product_id) {
    console.log("dodaje do koszyka produkt ", product_id)
    CartActions.addProductToCart(product_id);
  }

  render() {

    const noImgUrl = "https://placeholdit.imgix.net/~text?txtsize=33&txt=318%C3%97180&w=200&h=85";
    const productData = this.props.data;

    return (
      <div>
        <Card>
          <CardImg top style={{'height':'200px','width':'85px','margin':'10px auto'}} src={productData.image_url != "" ? productData.image_url : noImgUrl} alt="Card image cap" />
          <CardBody className={'text-center'}>
            <CardTitle style={{'minHeight':'60px'}}>{productData.name}</CardTitle>
            <CardSubtitle className={'mt-3'}>{productData.price.toFixed(2)}&nbsp;zł</CardSubtitle>

            <ButtonGroup>
              <Button size="sm" className={'mt-2'} color={'primary'} onClick={() => this.addToCart(productData.id)}><FontAwesomeIcon icon={faCartPlus} /> Do koszyka</Button>
              <Button tag={Link} to={"/productView/"+productData.id} size="sm" className={'mt-2'} outline color={'info'}><FontAwesomeIcon icon={faEye} /> Zobacz</Button>
            </ButtonGroup>

          </CardBody>
        </Card>
      </div>
    );
  }
}
