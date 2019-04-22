import React, {Component} from 'react';
import './../../css/login.css';
import {Link, Redirect} from "react-router-dom";
import FormField from "../components/forms/FormField";
import AuthForm from "../components/forms/AuthForm";

class Login extends Component{
    constructor(props) {
        super(props);
        this.state = {
            redirect: false
        }
    }

    onSubmit = () => {
        this.setState({rendering: true});
    };

    render() {
        if(this.state.redirect)
            return <Redirect to='/profile'/>;

        return (
            <div className="login-panel grey lighten-3">
                <div className="container">
                    <div className="row">
                        <AuthForm title="Вход">
                            <FormField label="Логин" placeholder="Введите логин" name="login" type="text"/>
                            <FormField label="Пароль" placeholder="Введите пароль" name="password" type="password"/>
                            <div className="submit-wrapper">
                                <button onClick={this.onSubmit} className="submit btn blue" type="submit">Войти</button>
                                <input type="checkbox" value="Запомнить"/>
                            </div>
                            <Link className="forgot-password blue-text text-lighten-3" to='/restore'>Забыли пароль?</Link>
                        </AuthForm>
                    </div>
                </div>
            </div>
        );
    }

}

export default Login;