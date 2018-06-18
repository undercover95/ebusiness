import Dispather from '../Dispatcher';

const axios = require('axios');
const qs = require('qs');

export function addProduct(productData) {

  axios({
    method: 'post',
    url: 'http://localhost:9090/addproduct',
    data: productData
  }).then((res) => {
    console.log('addProduct AXIOS completed',res);
    Dispather.dispatch({
      type: 'ADD_PRODUCT',
      data: res.data
    })
  }).catch((err) => {
    console.log('AXIOS addProduct FAILED', err)
  });
}
