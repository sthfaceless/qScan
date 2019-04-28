import React, {Component} from 'react';
import 'css/createOrder.css';
import {Datepicker} from "materialize-css";

class CreateOrder extends Component{
    constructor(props) {
        super(props);
    }

    componentDidMount(){
        Datepicker.init(document.getElementById('order-datepicker'),{
            format: 'dd-mm-yyyy',
            i18n:{
                cancel: 'Отмена',
                clear: 'Очистить',
                done: 'Ок',
                months: ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Ноябрь', 'Декабрь'],
                weekdays: ['Понедельник', 'Вторник', 'Среда', 'Четверг', 'Пятница', 'Суббота', 'Воскресенье'],
                weekdaysAbbrev:	['Пн','Вт','Ср','Чт','Пт','Сб','Вс'],
                weekdaysShort: ['Пн','Вт','Ср','Чт','Пт','Сб','Вс'],
                monthsShort: ['Янв', 'Февр', 'Март', 'Апр', 'Май', 'Июнь', 'Июль', 'Авг', 'Сент', 'Нояб', 'Дек']
            },
            showClearBtn: true
        });
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
                            <div className="social-networks">
                                <div className="head grey-text text-darken-3">Социальные сети <div className="choose-social-network grey-text text-darken-2">Добавить соцсеть</div></div>

                                <div style={{display: 'none '}} className="empty grey-text">Нет информации</div>
                                <a href="#" className="element grey darken-2 white-text">
                                    <div className="sn-logo">
                                        <img src="/resources/images/vk.svg"/>
                                    </div>
                                    <div className="sn-name">
                                        Ельцов Данил
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div className="col m6 s12 right">
                            <input className="content-field" placeholder="Имя" type="text"/>
                            <input className="content-field" placeholder="Фамилия" type="text"/>
                            <input className="content-field" placeholder="Отчество" type="text"/>
                            <div className="gender">
                                <span className="name grey-text">Пол</span>
                                <div className="right">
                                    <label>
                                        <input name="gender" value="man" type="radio" />
                                        <span>Мужской</span>
                                    </label>
                                    <label>
                                        <input name="gender" value="woman" type="radio" />
                                        <span>Женский</span>
                                    </label>
                                </div>
                            </div>
                            <input className="content-field" id="order-datepicker" placeholder="Дата рождения" type="text"/>
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