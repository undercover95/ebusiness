import React from 'react';

import { Card, CardBody,
  CardTitle, CardText } from 'reactstrap';

import StarRatings from 'react-star-ratings';

export default class Opinion extends React.Component {

  render() {

    const op = this.props.opinionData;

    return (
        <Card className={'mb-3'}>
          <CardBody>
            <CardTitle>{op.title}</CardTitle>
            <StarRatings
              rating={op.star_ratio}
              starDimension='20px'
              starSpacing='5px'
              starRatedColor='gold'
            />
            <CardText>{op.opinion}</CardText>
          </CardBody>
        </Card>
    );
  }
}
