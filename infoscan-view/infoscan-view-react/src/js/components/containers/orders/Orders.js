import React, {Component} from "react";
import 'css/orders/orders.css';
import OrdersTop from "js/components/simple/orders/OrdersTop";
import SearchBar from "js/components/core/SearchBar";
import More from "js/components/core/More";
import OrderItem from "js/components/simple/orders/OrderItem";

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
                    <OrdersTop stat={this.props.orders.ordersStat}/>
                    <div className="row">
                        <SearchBar searchFilters={this.props.orders.searchFilters}/>
                    </div>
                    <div className="row">
                        <div className="col s12 content">
                            {this.props.orders.items.map(item => (
                                <OrderItem key={item.id} order={item}/>
                            ))}
                        </div>
                    </div>
                    <div className="row">
                        <More/>
                    </div>
                </div>
            </div>
        );
    }

}

export default Orders;