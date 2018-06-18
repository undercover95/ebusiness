import React from 'react';
import { Row, Col, Card, CardImg, CardBody,
  CardTitle, CardSubtitle, Button } from 'reactstrap';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import {
  faCartPlus
} from '@fortawesome/fontawesome-free-solid'

import * as CartActions from 'actions/CartActions';
import OpinionStore from 'stores/OpinionStore';

import StarRatings from 'react-star-ratings';
import Opinions from 'components/opinions/Opinions';

const axios = require('axios');

export default class ProductViewLayout extends React.Component {

  constructor() {
    super();
    this.state = {
      productData: null,
      averageRating: 0
    };
    this.getAverageRating = this.getAverageRating.bind(this)
  }

  componentDidMount() {
    let product_id = this.props.match.params.id;

    axios.get('http://localhost:9090/product/'+product_id).then(res => {
      this.setState({
        productData: res.data
      });
    });
  }

  componentWillMount() {
    OpinionStore.on('opinionsDataChanged', this.getAverageRating);
  }

  componentWillUnmount() {
    OpinionStore.removeListener('opinionsDataChanged', this.getAverageRating);
  }

  getAverageRating() {
    let sum = 0.0;

    const opinions = OpinionStore.getOpinionsData();
    opinions.map(op => {
      sum = +sum + +op.star_ratio;
      console.log(sum)
    });

    this.setState({
      averageRating: sum/opinions.length
    });
  }



  render() {

    const noImgUrl = "https://placeholdit.imgix.net/~text?txtsize=33&txt=318%C3%97180&w=318&h=180";
    let data = this.state.productData;

    return (
      <div> {
        data != null ? (
          <div>
            <Row>
            <Col md={"5"}>
              <div style={{'textAlign': 'center'}}>
              <CardImg style={{'height':'300px','width':'120px'}} src={data.image_url != "" ? data.image_url : noImgUrl} alt="Card image cap" />
              </div>
            </Col>
            <Col md={"7"}>
            <h2>{data.name}</h2>
              <hr/>
              <Row>
                <Col className={'text-center'}>
                  <h1>{data.price.toFixed(2)}&nbsp;zł</h1>
                  <Button size="sm" className={'mt-2'} color={'primary'} onClick={() => CartActions.addProductToCart(data.id)}><FontAwesomeIcon icon={faCartPlus} /> Do koszyka</Button>
                </Col>
                <Col className={'text-center'}>
                  Średnia ocena:<br/>
                  <StarRatings
                    rating={this.state.averageRating}
                    starDimension="30px"
                    starSpacing="8px"
                    starRatedColor="gold"
                  />
                </Col>
              </Row>
            <p className={'mt-4'}>{data.description}</p>
            </Col>
            </Row>
            <Opinions product_id={data.id} />
          </div>
        ) : ''
      }
      </div>
    );
  }
}
