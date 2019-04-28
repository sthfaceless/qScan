import React, {Component} from 'react';
import 'css/coins.css';
import {Link} from "react-router-dom";

class Coins extends Component{
    constructor(props) {
        super(props);
        this.state = {
            filters:{
                date: {
                    dropdown: false
                }
            }
        }
    }

    render() {
        return (
            <div className="coins">
                <div className="container">
                    <div className="row">
                        <div className="col s12 l8 operations-history">
                            <div className="header grey-text text-darken-1">
                                История операций
                            </div>
                            <div className="search">
                                <div className="search-bar">
                                    <input placeholder="Поиск..." type="text"/>
                                    <div className="find">Найти</div>
                                </div>
                                <div className="filters grey-text">
                                    <div className="filter">
                                        <span>Дата</span>
                                        {this.state.filters.date.dropdown ? <div className="filter-drop grey-text">
                                            <div className="filter-drop-elem">Новые</div>
                                            <div className="filter-drop-elem">Старые</div>
                                        </div> : ""}
                                    </div>
                                </div>
                            </div>
                            <div className="content">
                                <div className="payment">
                                    <div className="left">
                                        <img src="/resources/images/qiwi.png"/>
                                    </div>
                                    <div className="right">
                                        <div className="info grey-text">
                                            <div className="id">1456</div>
                                            <div className="name grey-text text-darken-2">Пополнение с Qiwi Wallet</div>
                                            <div className="date">12.04.2017</div>
                                        </div>
                                        <div className="amount green-text">
                                            +5
                                        </div>
                                    </div>
                                </div>
                                <div className="more">
                                    <div className="more-btn grey darken-3 white-text">Больше</div>
                                </div>
                            </div>
                        </div>
                        <div className="col s12 l4 actions">
                            <div className="coins-card grey darken-3 white-text">
                                <div className="amount">
                                    <span>42</span> коина
                                </div>
                                <Link to='/coins/pay' className="buy white grey-text text-darken-3">
                                    Пополнить баланс
                                </Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Coins;