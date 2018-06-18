import React from 'react';

import StarRatings from 'react-star-ratings';

export default class Rating extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      rating: props.rating != null ? props.rating : 0
    }
    this.changeRating = this.changeRating.bind(this);
  }

  changeRating( newRating, name ) {
    this.setState({
      rating: newRating
    });
    this.props.setRating(newRating);
  }

  render() {
    return (
      <StarRatings
        rating={this.state.rating}
        starRatedColor="gold"
        changeRating={this.changeRating}
        numberOfStars={5}
        name='rating'
        starDimension="20px"
        starSpacing="5px"

      />
    );
  }

}
