import React from 'react';
import { Alert } from 'reactstrap';

import FontAwesomeIcon from '@fortawesome/react-fontawesome'
import { faCheckCircle } from '@fortawesome/fontawesome-free-solid'
import { faExclamationCircle } from '@fortawesome/fontawesome-free-solid'

export default class FormResponse extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      visible: true
    };

    this.onDismiss = this.onDismiss.bind(this);
  }

  onDismiss() {
    this.setState({ visible: false });
  }

  render() {

    const messages = this.props.messages;
    const res = this.props.result;

    const alertContent = <span>
      <h5 className={'alert-heading'}>{res ? (
        <span><FontAwesomeIcon icon={faCheckCircle} /> {messages.success.title}</span>
        ) : (
        <span><FontAwesomeIcon icon={faExclamationCircle} /> {messages.failure.title}</span>
        )
      }</h5>
      <p className='mb-0'>{res ? messages.success.content : messages.failure.content}</p>
    </span>

    return (
      (res === null || res === undefined) ? null : <Alert className={'mt-3'} color={res ? 'success' : 'danger'} isOpen={this.state.visible} toggle={this.onDismiss}>{alertContent}</Alert>
    );
  }
}
