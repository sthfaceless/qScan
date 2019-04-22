import React, {Component} from 'react';
import Header from './layout/Header';
import Body from './layout/Body';
import Footer from './layout/Footer';
import {BrowserRouter} from "react-router-dom";
import {Provider} from "react-redux";
import store from "./store/store";


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