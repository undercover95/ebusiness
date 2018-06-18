import React from 'react';

import { Button, Form, FormGroup, Label, Input, FormText, Alert } from 'reactstrap';
import * as CategoriesActions from "actions/CategoriesActions";
import ResponseStore from "stores/ResponseStore";

import FormResponse from './FormResponse';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import { faSpinner } from '@fortawesome/fontawesome-free-solid'
import {faExclamationCircle} from "@fortawesome/fontawesome-free-solid/index";

export default class AddCategoryForm extends React.Component {

  constructor() {
    super();
    this.handleSubmit = this.handleSubmit.bind(this);
    this.getResponse = this.getResponse.bind(this);
    this.state = {
      beforeSend: '',
      response: {}
    };
  }

  getResponse() {
    this.setState({
      beforeSend: '',
      response: ResponseStore.getResponse('addCategoryResponse')
    });
    console.log("Dodalem kategorie, odp:",this.state.response)
  }

  componentWillMount() {
    ResponseStore.on('addCategoryResponseReceived', this.getResponse)
  }

  componentWillUnmount() {
    ResponseStore.removeListener('addCategoryResponseReceived', this.getResponse)
  }

  handleSubmit(event) {
    event.preventDefault();
    const data = new FormData(event.target);

    this.setState({
      beforeSend: <Alert color={'secondary'} className='mt-3'><FontAwesomeIcon className={'fa-spin'} icon={faSpinner} /> Trwa dodawanie kategorii...</Alert>
    });

    CategoriesActions.addCategory(data);
  }


  getResponseMessages() {
    return {
      success: {
        title: 'Ok.',
        content: 'Pomyślnie dodano kategorię.'
      },
      failure: {
        title: 'Coś poszło nie tak!',
        content: 'Dodawanie kategorii nie powiodło się.'
      }
    }
  }

  render() {
    return (
      <div>
        <h4>Dodaj nową kategorię</h4>
        <Form onSubmit={this.handleSubmit}>
          <FormGroup>
            <Label htmlFor='categoryName'>Nazwa kategorii:</Label>
            <Input type='text' id='categoryName' name='categoryName' className='form-control' placeholder='Wpisz nazwę kategorii' required/>
          </FormGroup>
          <Button type='submit' color={'primary'}>Dodaj kategorię</Button>
        </Form>
        <span>{this.state.beforeSend}</span>
        <FormResponse messages={this.getResponseMessages()} result={this.state.response.result} />
      </div>
    )
  }
}
