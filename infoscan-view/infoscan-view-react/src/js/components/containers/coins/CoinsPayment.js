import React, {Component} from 'react';
import 'css/coinsPayment.css';

class CoinsPayment extends Component{
    render() {
        return (
            <div className="coins-payment">
                <div className="container">
                    <div className="row">
                        <div className="col s12">
                            <h4 className="header grey-text text-darken-1">Пополнение счёта</h4>
                        </div>
                        <div className="col s12 payment-systems">
                            <div className="head grey-text">Платёжные системы</div>
                            <div className="wrapper">
                                <div className="payment-system active">
                                    <div className="system-img">
                                        <img src="/resources/images/qiwipayment.png"/>
                                    </div>
                                </div>
                                <div className="payment-system">
                                    <div className="system-img">
                                        <img src="/resources/images/webmoneypayment.png"/>
                                    </div>
                                </div>
                                <div className="payment-system">
                                    <div className="system-img">
                                        <img src="/resources/images/visapayment.png"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="col s12 content">
                            <div className="head grey-text">Оплата</div>
                            <div className="qiwi-content">
                                <div className="qiwi-elem phone-number">
                                    <span className="grey-text text-darken-3">
                                        <span className="num blue white-text">1</span>
                                        Введите номер телефона
                                    </span>
                                    <input placeholder="79198883535" type="text"/>
                                </div>
                                <div className="qiwi-elem amount">
                                    <span className="grey-text text-darken-3">
                                        <span className="num blue white-text">2</span>
                                        Введите сумму для пополнения
                                    </span>
                                    <input placeholder="0,00 руб" type="text"/>
                                </div>
                            </div>
                            <div className="pay-wrapper">
                                <div className="pay-btn grey darken-3 white-text">Оплатить</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CoinsPayment;