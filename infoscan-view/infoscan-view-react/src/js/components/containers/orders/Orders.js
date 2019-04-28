import React, {Component} from "react";
import 'css/orders.css';
import {Link} from "react-router-dom";

class Orders extends Component{
    constructor(props) {
        super(props);
        this.state = {
            filters: {
                date: {
                    dropdown: false
                },
                status: {
                    dropdown: false
                }
            }
        }
    }

    render() {
        return (
            <div className="orders">
                <div className="container">
                    <div className="row top-row">
                        <div className="col s12 header">Ваши заказы</div>
                        <Link to="/orders/make" className="make-order grey darken-3 white-text">Новый заказ</Link>
                        <div className="col s12 subheader">
                            <div className="subheader-element"><span className="green-text">0</span> готовы</div>
                            <div className="subheader-element"><span className="orange-text">0</span> в обработке</div>
                            <div className="subheader-element"><span className="red-text">0</span> отменены</div>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col s12 search">
                            <div className="search-bar">
                                <input type="text" placeholder="Поиск..."/>
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
                                <div className="filter">
                                    <span>Статус</span>
                                    {this.state.filters.status.dropdown ? <div className="filter-drop">
                                        <div className="filter-drop-elem">Принят</div>
                                        <div className="filter-drop-elem">В обработке</div>
                                        <div className="filter-drop-elem">Обработано</div>
                                        <div className="filter-drop-elem">Отменены</div>
                                    </div> : ""}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col s12 content">
                            <Link to="/orders/1" className="order grey-text">
                                <div className="left grey-text">
                                    <div className="date">12-11-2001 18:01</div>
                                </div>
                                <div className="center grey-text text-darken-2">
                                    <span className="name">Пётр петрович</span>
                                </div>
                                <div className="right">
                                    <span className="status orange white-text">В обработке</span>
                                </div>
                            </Link>
                        </div>
                    </div>
                    <div className="row">
                        <div className="foot">
                            <div className="btn grey darken-3">Больше</div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export default Orders;