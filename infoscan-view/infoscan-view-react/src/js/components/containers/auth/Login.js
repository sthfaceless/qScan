import React, {Component} from 'react';
import 'css/auth/login.css';
import {Link, Redirect} from "react-router-dom";
import FormField from "js/components/simple/forms/FormField";
import AuthForm from "js/components/simple/forms/AuthForm";
import {auth} from "js/store/actions/authActions";
import {connect} from "react-redux";

class Login extends Component{
    constructor(props) {
        super(props);
        this.state = {
            redirect: false
        }
    }

    onSubmit = () => {
        this.setState({redirect: true});
        this.props.login();
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

const mapDispatchToProps = dispatch => {
    return {
        login: () => dispatch(auth())
    }
};

export default connect(null, mapDispatchToProps) (Login);