import { EventEmitter } from 'events';

import Dispather from '../Dispatcher';

class OpinionStore extends EventEmitter {

  constructor() {
    super();
    this.opinionsData = [];
  }

  getOpinionsData() {
    return this.opinionsData;
  }

  updateOpinionsData(data) {
    this.opinionsData = data;
    this.emit('opinionsDataChanged');
  }

  handleActions(action){
    switch(action.type) {
      case 'GET_OPINIONS':
        this.updateOpinionsData(action.data)
        break;
    }
  }
}

const opinionStore = new OpinionStore;
Dispather.register(opinionStore.handleActions.bind(opinionStore));

export default opinionStore;
