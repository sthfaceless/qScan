import React, {Component} from 'react';
import {Link} from "react-router-dom";
import Navbar from "js/header/Navbar";
import {Sidenav} from "materialize-css";

class AnonymousHeader extends Component {

    componentDidMount(){
        Sidenav.init(document.getElementById('slide-out'), {});
    }
    render() {
        return (
            <>
                <Navbar>
                    <li><Link className="support-header" to="/support">Помощь</Link></li>
                    <li className="links-delimiter">|</li>
                    <li><Link className="login btn-small red accent-4" to="/login">Вход</Link></li>
                    <li><Link className="reg btn-small red accent-4" to="/reg">Регистрация</Link></li>
                </Navbar>
                <ul id="slide-out" className="sidenav grey darken-3 white-text">
                    <li>
                        <div className="user-view">
                            <h4>InfoScan</h4>
                        </div>
                    </li>
                    <li><Link to='/login'>Вход</Link></li>
                    <li><Link to='/reg'>Регистрация</Link></li>
                    <li>
                        <div className="divider"></div>
                    </li>
                    <li><Link to='/support'>Помощь</Link></li>
                </ul>
            </>
        );
    }

}

export default AnonymousHeader;