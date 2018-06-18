import Dispather from '../Dispatcher';

const axios = require('axios');
const qs = require('qs');

export function listCategories() {
  axios.get('http://localhost:9090/categories').then((categoriesData) => {
    console.log('listCategories AXIOS completed',categoriesData);
    Dispather.dispatch({
      type: 'GET_CATEGORIES_DATA',
      data: categoriesData.data
    })
  }).catch((err) => {
      console.log('AXIOS listCategories FAILED', err)
    });
}

export function getAllProductsInCategory(cat_id) {
  axios.get('http://localhost:9090/categories').then((categoriesData) => {
    console.log('listCategories AXIOS completed',categoriesData);
    Dispather.dispatch({
      type: 'GET_CATEGORIES_DATA',
      data: categoriesData.data
    })
  }).catch((err) => {
    console.log('AXIOS listCategories FAILED', err)
  });
}

export function addCategory(categoryData) {

  axios({
    method: 'post',
    url: 'http://localhost:9090/addcategory',
    data: categoryData
  }).then((res) => {
    console.log('addCategory AXIOS completed',res);
    //listCategories();
    Dispather.dispatch({
      type: 'ADD_CATEGORY',
      data: res.data
    })
  }).catch((err) => {
    console.log('AXIOS addCategory FAILED', err)
  });
}
