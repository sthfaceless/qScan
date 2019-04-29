import React, {Component} from 'react';
import BadRequest from "../../errors/BadRequest";
import 'css/orders/person-information.css';
import SocialNetworks from "js/components/core/SocialNetworks";
import InfoBlock from "js/components/simple/orders/InfoBlock";

class PersonInformation extends Component{

    constructor(props) {
        super(props);
        this.state = {
            id: props.match.params.id,
            item: this.props.orders.items[0]
        };
    }

    render() {
        if(!/^\d+$/.test(this.state.id))
            return <BadRequest/>;
        return (
            <div className="person-information">
                <div className="container">
                    <div className="row grey-text text-darken-1">
                        <div className="col s12">
                            <h4 className="header">Заказ <span className="blue white-text">457</span></h4>
                        </div>
                        <div className="col s12 m4 left-column">
                            <div className="user-img">
                                <img src="/resources/images/user.png" alt=""/>
                            </div>
                            <SocialNetworks networks={this.state.item.networks}/>
                        </div>
                        <div className="col s12 m8 right-column">
                            {this.state.item.info.map(item => (
                                <InfoBlock key={item.name} name={item.name} items={item.items}/>
                            ))}
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export default PersonInformation;