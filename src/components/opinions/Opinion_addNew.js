import React from 'react';

import { Row, Col, Card, CardImg, CardBody,
  CardTitle, CardSubtitle, Button, Form, FormGroup, Label, Input, Alert } from 'reactstrap';
import * as OpinionActions from "actions/OpinionActions";

import Rating from './Rating';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import {faSpinner} from "@fortawesome/fontawesome-free-solid/index";

const axios = require('axios');

export default class Opinion_addNew extends React.Component {

  constructor() {
    super();
    this.state = {
      opinionsData: [],
      beforeSend: '',
      rating: 0
    }
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  setRating(newRating) {
    this.setState({
      rating: newRating
    })
  }

  handleSubmit(event) {
    event.preventDefault();
    const data = new FormData(event.target);

    data.append('opinionStarRatio',this.state.rating)

    OpinionActions.addOpinion(this.props.prod_id, data);
  }

  render() {

    return (
      <div className={'mt-3'}>
        <Form onSubmit={this.handleSubmit}>
          <FormGroup>
            <Label htmlFor='opinionTitle'>Tytuł:</Label>
            <Input id='opinionTitle' type='text' name='opinionTitle' className='form-control' placeholder='Wpisz tytuł opinii' required/>
          </FormGroup>
          <FormGroup>
            <Label htmlFor='opinionText'>Twoja opinia:</Label>
            <Input id='opinionText' type='textarea' name='opinionText' className='form-control' placeholder='Wpisz swoją opinię' maxLength={300} rows={5} required/>
          </FormGroup>
          <FormGroup>
            Ocena: <Rating setRating={this.setRating.bind(this)} />
          </FormGroup>
          <Button type='submit' color={'primary'}>Dodaj opinię</Button>
        </Form>
        <span>{this.state.beforeSend}</span>
      </div>
    );
  }
}
