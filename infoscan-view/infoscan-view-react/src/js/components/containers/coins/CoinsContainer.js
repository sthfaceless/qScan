import React, {Component} from 'react';
import {Route, Switch} from "react-router-dom";
import Coins from "./Coins";
import CoinsPayment from "./CoinsPayment";
import {connect} from "react-redux";

class CoinsContainer extends Component{

    render() {
        return (
            <Switch>
                <Route exact path='/coins' render={(props) => <Coins {...props} searchFilters={this.props.coins.searchFilters}
                    balance={this.props.coins.balance} payments={this.props.coins.payments}/>}/>
                <Route exact path='/coins/pay' component={CoinsPayment}/>
            </Switch>
        );
    }
}

const mapStateToProps = state => ({
    coins: state.coins
});

export default connect(mapStateToProps) (CoinsContainer);