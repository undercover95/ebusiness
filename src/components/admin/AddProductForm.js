import React from 'react';

import { Button, Form, FormGroup, Label, Input, Alert } from 'reactstrap';

import * as CategoriesActions from "actions/CategoriesActions";
import * as ProductsActions from "actions/ProductsActions";

import CategoriesStore from "stores/CategoriesStore";
import ResponseStore from "stores/ResponseStore";

import FormResponse from './FormResponse';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import {faSpinner} from "@fortawesome/fontawesome-free-solid/index";

export default class AddProductForm extends React.Component {

  constructor() {
    super();
    this.state = {
      categoriesData: [],
      beforeSend: '',
      response: {}
    }
    this.listCategories = this.listCategories.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.getResponse = this.getResponse.bind(this);
  }

  componentWillMount() {
    CategoriesStore.on('categoriesDataChanged', this.listCategories);
    ResponseStore.on('addProductResponseReceived', this.getResponse);
  }

  componentWillUnmount() {
    CategoriesStore.removeListener('categoriesDataChanged', this.listCategories);
    ResponseStore.removeListener('addProductResponseReceived', this.getResponse);
  }

  componentDidMount() {
    CategoriesActions.listCategories();
  }

  listCategories() {
    this.setState({
      categoriesData: CategoriesStore.getCategoriesData()
    });
  }

  getResponse() {
    console.log("OPD drom product")
    this.setState({
      beforeSend: '',
      response: ResponseStore.getResponse('addProductResponse')
    });
  }


  handleSubmit(event) {
    event.preventDefault();
    const data = new FormData(event.target);

    this.setState({
      beforeSend: <Alert color={'secondary'} className='mt-3'><FontAwesomeIcon className={'fa-spin'} icon={faSpinner} /> Trwa dodawanie produktu...</Alert>
    });

    ProductsActions.addProduct(data);
  }

  getResponseMessages() {
    return {
      success: {
        title: 'Ok.',
        content: 'Pomyślnie dodano produkt.'
      },
      failure: {
        title: 'Coś poszło nie tak!',
        content: 'Dodawanie kategorii nie powiodło się.'
      }
    }
  }

  render() {
    const categories = this.state.categoriesData;

    return (
      <div>
        <h4>Dodaj nowy produkt</h4>
        <Form onSubmit={this.handleSubmit}>
          <FormGroup>
            <Label htmlFor='productName'>Nazwa produktu:</Label>
            <Input id='productName' type='text' name='productName' className='form-control' placeholder='Wpisz nazwę produktu' required/>
          </FormGroup>
          <FormGroup>
            <Label htmlFor='productDescription'>Opis produktu:</Label>
            <Input id='productDescription' type='textarea' name='productDescription' className='form-control' placeholder='Wpisz opis produktu' required/>
          </FormGroup>
          <FormGroup>
            <Label htmlFor='productPrice'>Cena produktu:</Label>
            <Input id='productPrice' type='text' name='productPrice' className='form-control' placeholder='Podaj cenę produktu' required/>
          </FormGroup>
          <FormGroup>
            <Label for="productCategory">Kategoria produktu:</Label>
            <Input type="select" name="productCategory" id="productCategory" required>
              {
                categories.map(cat => {
                  return <option value={cat.id} key={cat.id}>{cat.name}</option>
                })
              }
            </Input>
          </FormGroup>
          <Button type='submit' color={'primary'}>Dodaj produkt</Button>
        </Form>
        <span>{this.state.beforeSend}</span>
        <FormResponse messages={this.getResponseMessages()} result={this.state.response.result} />
      </div>
    )
  }
}
