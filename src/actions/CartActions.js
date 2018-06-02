import Dispather from '../Dispatcher';

const axios = require('axios');
const qs = require('qs');

export function addProductToCart(product_id) {

  let prodData = qs.stringify({
    product_id: product_id
  });

  axios({
    method: 'post',
    url: 'http://localhost:9090/addcartitem',
    data: prodData
  }).then((res) => {
    console.log('addProductToCart AXIOS completed',res);
    Dispather.dispatch({
      type: 'ADD_PRODUCT_TO_CART',
      data: res.data
    })
  }).catch((err) => {
    console.log('AXIOS addProductToCart FAILED', err)
  });
}

export function getCartItems() {
  axios.get('http://localhost:9090/cart').then((productsData) => {
    console.log('getCartItems AXIOS completed', productsData.data);
    Dispather.dispatch({
      type: 'GET_CART_ITEMS',
      data: productsData.data
    })
  }).catch((err) => {
    console.log('AXIOS getCartItems FAILED', err)
  });
}


