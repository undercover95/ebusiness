import React from 'react';

import { Button, Container, Row, Col } from 'reactstrap';

import {
  NavLink as Link
} from 'react-router-dom';


export default class CartLayout extends React.Component {

  render() {
    const cartItemData = this.props.itemData;
    const noImgUrl = "https://placeholdit.imgix.net/~text?txtsize=33&txt=318%C3%97180&w=318&h=180";

    return (
      <tr>
        <td style={{'minWidth':'150px'}} className={'text-center align-middle'}>
          <img width={'150'} style={{'height':'100px','width':'45px'}} src={cartItemData.image_url != "" ? cartItemData.image_url : noImgUrl} />
        </td>
        <td className={'align-middle'}>
          <Link to={"/productView/"+cartItemData.id}><h5 className={'mb-0'}>{cartItemData.name}</h5></Link>
        </td>
        <td style={{'minWidth':'150px'}} className={'align-middle'}>
          {cartItemData.quantity}
        </td>
        <td className={'align-middle'}>
          <strong>{(cartItemData.quantity*cartItemData.price).toFixed(2)}&nbsp;zł</strong><br/>
          {
            cartItemData.quantity > 1 ?
              <small style={{'fontStyle': 'italic', 'color': '#777'}}>{cartItemData.price.toFixed(2)}&nbsp;zł&nbsp;/&nbsp;szt.</small> : ''
          }

        </td>
        <td className={'align-middle'}>
          <Button onClick={() => this.props.deleteProductFromCart(cartItemData.id)} outline color="danger">usuń z koszyka</Button>
        </td>
      </tr>
    );
  }
}
