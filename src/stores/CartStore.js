import { EventEmitter } from 'events';

import Dispather from '../Dispatcher';

class CartStore extends EventEmitter {

  constructor() {
    super();
    this.productsInCart = [];
    this.counter = 0;
  }


  serviceResultOfAddingProductToCart(response) {
    console.log('response add product to cart:',response);
    this.counter = +this.counter + 1;
    this.emit('addProductToCartCompleted');
  }

  serviceResultOfGetCartItems(response) {
    this.productsInCart = response.res;
    this.emit('getCartItemsCompleted');
  }

  getCartProducts() {
    return this.productsInCart;
  }

  getCounter() {
    return this.counter;
  }

  handleActions(action){
    const type = action.type;

    switch(type) {
      case 'ADD_PRODUCT_TO_CART':
        this.serviceResultOfAddingProductToCart(action.data)
        break;
      case 'GET_CART_ITEMS':
        this.serviceResultOfGetCartItems(action.data)
        break;
    }
  }
}

const cartStore = new CartStore;
Dispather.register(cartStore.handleActions.bind(cartStore));

export default cartStore;
