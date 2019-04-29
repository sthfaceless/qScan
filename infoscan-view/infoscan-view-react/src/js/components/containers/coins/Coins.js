import React, {Component} from 'react';
import 'css/coins/coins.css';
import {Link} from "react-router-dom";
import SearchBar from "js/components/core/SearchBar";
import PayCard from "js/components/simple/coins/PayCard";
import More from "js/components/core/More";
import PaymentItem from "js/components/simple/coins/PaymentItem";

class Coins extends Component{
    render() {
        return (
            <div className="coins">
                <div className="container">
                    <div className="row">
                        <div className="col s12 l8 operations-history">
                            <div className="header grey-text text-darken-1">
                                История операций
                            </div>
                            <SearchBar searchFilters={this.props.searchFilters}/>
                            <div className="content">
                                {this.props.payments.map(payment => (
                                    <PaymentItem key={payment.id} payment={payment}/>
                                ))}
                                <More/>
                            </div>
                        </div>
                        <div className="col s12 l4 actions">
                            <PayCard balance={this.props.balance}/>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Coins;