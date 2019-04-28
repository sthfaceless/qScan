import React, {Component} from 'react';
import 'css/profile.information.css';

class Information extends Component{

    render() {
        return (
            <div className="information">
                <div className="user-info grey-text grey lighten-4">
                    <div className="head white-text grey darken-3">
                        Личная информация
                    </div>
                    <div className="info-element">
                        <div className="name">Имя пользователя</div>
                        <div className="content grey-text text-darken-3">admin</div>
                    </div>
                    <div className="info-element">
                        <div className="name">Email</div>
                        <div className="content grey-text text-darken-3">zerodotax2@mail.ru</div>
                    </div>
                    <div className="info-element">
                        <div className="name">Дата регистрации</div>
                        <div className="content grey-text text-darken-3">15-11-2001 <span className="hide-on-med-and-down">18:03</span></div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Information;