import React, {Component} from 'react';
import Header from './layout/Header';
import Body from './layout/Body';
import Footer from './layout/Footer';
import {BrowserRouter} from "react-router-dom";
import {createStore} from 'redux';
import {Provider} from "react-redux";
import reducer from "./store/reducers/reducer";

const store = createStore(reducer);

class Infoscan extends Component {

    render() {
        return (
            <Provider store={store}>
                <BrowserRouter>
                    <Header/>
                    <Body/>
                    <Footer/>
                </BrowserRouter>
            </Provider>
        );
    }

}

export default Infoscan;