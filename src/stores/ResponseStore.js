import { EventEmitter } from 'events';

import Dispather from '../Dispatcher';

class ResponseStore extends EventEmitter {

  constructor() {
    super();
    this.requestResponses = {
      addProductResponse: null,
      addCategoryResponse: null
    };
  }

  getResponse(response){
    return this.requestResponses[response];
  }


  serviceResultOdAddingProduct(response) {
    console.log('response add product:',response);
    this.requestResponses.addProductResponse = {
      result: response.result
    }
    this.emit('addProductResponseReceived');
  }

  serviceResultOfAddingCategory(response) {
    console.log('response add category:',response);

    this.requestResponses.addCategoryResponse = {
      result: response.result
    }
    this.emit('addCategoryResponseReceived');
  }

  handleActions(action){
    const type = action.type;

    switch(type) {
      case 'ADD_PRODUCT':
        this.serviceResultOdAddingProduct(action.data)
        break;

      case 'ADD_CATEGORY':
        this.serviceResultOfAddingCategory(action.data)
        break;
    }
  }
}

const responseStore = new ResponseStore;
Dispather.register(responseStore.handleActions.bind(responseStore));

export default responseStore;
