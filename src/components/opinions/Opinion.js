import React from 'react';

import { Row, Col, Card, CardImg, CardBody,
  CardTitle, CardSubtitle, Button, CardText } from 'reactstrap';

import StarRatings from 'react-star-ratings';

export default class Opinion extends React.Component {

  render() {

    const op = this.props.opinionData;
    console.log("opinia", op)
    return (
        <Card className={'mb-3'}>
          <CardBody>
            <CardTitle>{op.title}</CardTitle>
            <StarRatings
              rating={op.star_ratio}
              starDimension="20px"
              starSpacing="5px"
              starRatedColor="gold"
            />
            <CardText>{op.opinion}</CardText>
          </CardBody>
        </Card>
    );
  }
}
