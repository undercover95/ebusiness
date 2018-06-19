import React from 'react';

import { Row, Col } from 'reactstrap';

import Opinion from './Opinion';
import Opinion_addNew from './Opinion_addNew';

import OpinionStore from 'stores/OpinionStore';
import * as OpinionActions from 'actions/OpinionActions';

export default class Opinions extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      opinions: []
    };
    this.product_id = props.product_id;
    this.listOpinions = this.listOpinions.bind(this);
  }

  componentWillMount() {
    OpinionStore.on('opinionsDataChanged', this.listOpinions);
  }

  componentWillUnmount() {
    OpinionStore.removeListener('opinionsDataChanged', this.listOpinions);
  }

  componentDidMount() {
    OpinionActions.getOpinions(this.product_id);
  }

  listOpinions() {
    this.setState({
      opinions: OpinionStore.getOpinionsData()
    })
  }

  render() {
    const opinions = this.state.opinions;
    return (
      <Row className={'mt-4'}>
        <Col>
          <h3>Opinie o produkcie</h3>
          {
            opinions.length != 0 ? (
              opinions.map((op, i) => {
                return <Opinion key={i} opinionData={op} />
              })
            ) : <p>Ten produkt nie ma jeszcze wystawionych opinii.</p>
          }
          <hr/>
          <h4>Dodaj nową opinię</h4>
          <Opinion_addNew prod_id={this.product_id} />
        </Col>
      </Row>
    );
  }
}
