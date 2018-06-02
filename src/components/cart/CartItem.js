import React from 'react';

import { Button, Container, Row, Col } from 'reactstrap';

import Categories from '../Categories';
import ProductsList from '../ProductsList';

export default class CartLayout extends React.Component {

  render() {
    const cartItemData = this.props.itemData;
    return (
      <tr>
        <td>
          <img width={'150'} src="https://placeholdit.imgix.net/~text?txtsize=33&txt=318%C3%97180&w=318&h=180" />
        </td>
        <td>
          <h5>{cartItemData.name}</h5>
          <p>{cartItemData.description}</p>
        </td>
        <td>
          1
        </td>
        <td>
          {cartItemData.price.toFixed(2)} zł
        </td>
        <td>
          <Button outline color="danger">usuń z koszyka</Button>
        </td>
      </tr>
    );
  }
}
