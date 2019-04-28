import React, {Component} from 'react';
import BadRequest from "../../errors/BadRequest";
import 'css/person-information.css';

class PersonInformation extends Component{

    constructor(props) {
        super(props);
        this.state = {
            id: props.match.params.id
        }
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
                            <div className="social-networks">
                                <div className="head">Социальные сети</div>
                                <a href="#" className="sn-element grey darken-3 white-text">
                                    <div className="sn-logo">
                                        <img src="/resources/images/vk.svg"/>
                                    </div>
                                    <div className="sn-name">
                                        Ельцов Данил
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div className="col s12 m8 right-column">
                            <div className="info-block grey lighten-4">
                                <div className="info-name grey darken-3 white-text">
                                    Имена
                                </div>
                                <div className="info-content white-text">
                                    <div className="may-value grey darken-2">Петр Петрович Лукашенко</div>
                                    <div className="may-value grey darken-2">Петр Петрович Лукашенко</div>
                                    <div className="may-value grey darken-2">Петр Петрович Лукашенко</div>
                                </div>
                            </div>
                            <div className="info-block grey lighten-4">
                                <div className="info-name grey darken-3 white-text">
                                    Телефоны
                                </div>
                                <div className="info-content white-text">
                                    <div className="may-value grey darken-2">+7(912)743-67-88</div>
                                    <div className="may-value grey darken-2">+7(912)743-67-88</div>
                                    <div className="may-value grey darken-2">+7(912)743-67-88</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export default PersonInformation;