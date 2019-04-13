import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import './css/index.css';	
import './css/bootstrap.css';
import InfoScan from './js/infoscan';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(<InfoScan />, document.getElementById('body'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
