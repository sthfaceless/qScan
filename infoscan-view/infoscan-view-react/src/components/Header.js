import React, {Component} from 'react';
import './../css/header.css';

class Header extends Component{

    render() {
        return (
            <nav className="grey darken-3">
                <div className="nav-wrapper container">
                    <a href="/" className="brand-logo">Info<span className="red-text text-darken-2">Scan</span></a>
                    <ul id="nav-mobile header-links" className="right hide-on-med-and-down">
                        <li><a className="support" href="/support">Помощь</a></li>
                        <li><a className="login" href="/login">Войти</a></li>
                        <li><a className="reg" href="/reg">Зарегистрироваться</a></li>
                    </ul>
                </div>
            </nav>
        );
    }

}

export default Header;