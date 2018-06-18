import Dispather from '../Dispatcher';

const axios = require('axios');
const qs = require('qs');

export function getOpinions(product_id) {
  axios.get('http://localhost:9090/opinions/'+product_id).then(res => {
    Dispather.dispatch({
      type: 'GET_OPINIONS',
      data: res.data
    });
  });
}

export function addOpinion(product_id, newOpinion) {

  console.log("dodaje opinie o id: ",product_id)
  axios({
    method: 'post',
    url: 'http://localhost:9090/addopinion/'+product_id,
    data: newOpinion
  }).then((res) => {
    console.log('addOpinion AXIOS completed',res);
    getOpinions(product_id);
  }).catch((err) => {
    console.log('AXIOS addOpinion FAILED', err)
  });
}
