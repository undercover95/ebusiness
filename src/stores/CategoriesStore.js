import { EventEmitter } from 'events';

import Dispather from '../Dispatcher';

class CategoriesStore extends EventEmitter {

  constructor() {
    super();
    this.categoriesData = [];
  }

  getCategoriesData() {
    return this.categoriesData;
  }

  updateCategoriesData(data) {
    this.categoriesData = data;
    this.emit('categoriesDataChanged');
  }

  getCategoryData(cat_id) {
    let res = this.categoriesData.find(el => {
      return el['id'] == cat_id
    });
    console.log(res);
    return res;
  }

  handleActions(action){
    switch(action.type) {
      case 'GET_CATEGORIES_DATA':
        this.updateCategoriesData(action.data)
        break;

    }
  }
}

const categoriesStore = new CategoriesStore;
Dispather.register(categoriesStore.handleActions.bind(categoriesStore));

export default categoriesStore;
