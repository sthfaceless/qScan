import React, {Component} from 'react';
import 'css/coins/coinsPayment.css';
import QiwiContent from "js/components/simple/coins/QiwiContent";
import PaymentSystems from "js/components/simple/coins/PaymentSystems";

class CoinsPayment extends Component{
    constructor(props) {
        super(props);
        this.state = {
            content: <QiwiContent/>
        }
    }
    setActive = (component) => {
        this.setState({content: component});
    };
    render() {
        return (
            <div className="coins-payment">
                <div className="container">
                    <div className="row">
                        <div className="col s12">
                            <h4 className="header grey-text text-darken-1">Пополнение счёта</h4>
                        </div>
                        <PaymentSystems setActive={this.setActive}/>
                        <div className="col s12 content">
                            <div className="head grey-text">Оплата</div>
                            {this.state.content}
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