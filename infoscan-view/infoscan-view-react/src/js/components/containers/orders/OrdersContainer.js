import React, {Component} from 'react';
import {Route, Switch} from "react-router-dom";
import PersonInformation from "./PersonInformation";
import CreateOrder from "./CreateOrder";
import Orders from "./Orders";
import {connect} from "react-redux";

class OrdersContainer extends Component{
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Switch>
                    <Route exact path="/orders/make" component={CreateOrder}/>
                    <Route exact path="/orders/:id" render={(props) =>  <PersonInformation {...props} orders={this.props.orders}/>}/>
                    <Route exact path="/orders" render={(props) => <Orders {...props} orders={this.props.orders} />}/>
                </Switch>
            </div>
        );
    }

}

const mapStateToProps = state => ({
    orders: state.orders
});

export default connect(mapStateToProps) (OrdersContainer);