import React, {Component} from 'react';
import Main from "js/containers/Main";
import {Route, Switch} from "react-router-dom";
import NotFound from "js/errors/NotFound";
import OrdersContainer from "js/containers/orders/OrdersContainer";
import CoinsContainer from "js/containers/coins/CoinsContainer";
import Login from "/containers/Login";
import Register from "js/containers/Register";
import License from "js/containers/License";
import Support from "js/containers/Support";
import Restore from "js/containers/Restore";
import Profile from "js/containers/Profile";

class Body extends Component {

    render() {
        return (
            <Switch>
                <Route exact path='/' component={Main}/>
                <Route exact path='/login' component={Login}/>
                <Route exact path='/restore' component={Restore}/>
                <Route exact path='/reg' component={Register}/>
                <Route path='/coins' component={CoinsContainer}/>
                <Route path='/orders' component={OrdersContainer}/>
                <Route exact path='/profile' component={Profile}/>
                <Route exact path='/support' component={Support}/>
                <Route exact path='/license' component={License}/>
                <Route component={NotFound}/>
            </Switch>
        );
    }

}

export default Body;