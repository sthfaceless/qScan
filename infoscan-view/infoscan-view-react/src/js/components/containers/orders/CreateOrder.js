import React, {Component} from 'react';
import 'css/orders/createOrder.css';
import DatePicker from "js/components/core/DatePicker";
import RadioGender from "js/components/simple/orders/RadioGender";
import SocialNetworks from "js/components/core/SocialNetworks";

class CreateOrder extends Component{
    constructor(props) {
        super(props);
    }



    render() {
        return (
            <div className="create-order">
                <div className="container">
                    <div className="row">
                        <div className="col s12 grey-text text-darken-3">
                            <div className="header">
                                Создать заказ
                            </div>
                        </div>
                    </div>
                    <div className="row content">
                        <div className="col s12 m6 left">
                            <div className="left-header">Добавить фотографию</div>
                            <div className="user-img">
                                <img src="/resources/images/user.png" alt=""/>
                                <div style={{display: 'none'}} className="over"><img src="/resources/images/plus.svg"/></div>
                            </div>
                            <SocialNetworks networks={[]}/>
                        </div>
                        <div className="col m6 s12 right">
                            <input className="content-field" placeholder="Имя" type="text"/>
                            <input className="content-field" placeholder="Фамилия" type="text"/>
                            <input className="content-field" placeholder="Отчество" type="text"/>
                            <RadioGender class='gender' name='Пол' fieldName='gender' items={[
                                {name: 'Мужской', value: 'man'},
                                {name: 'Женский', value: 'woman'}
                                ]}/>
                            <DatePicker id='order-datepicker' placeholder='Дата рождения'/>
                            <input className="content-field" placeholder="Псевдоним" type="text"/>
                            <input className="content-field" placeholder="Почта" type="text"/>
                            <input className="content-field" placeholder="Телефон" type="text"/>
                            <input className="content-field" placeholder="Ip" type="text"/>
                        </div>
                        <div className="col s12 create">
                            <div className="create-btn grey darken-3 white-text">Сделать заказ</div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export default CreateOrder;