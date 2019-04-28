import React, {Component} from 'react';
import {Link} from "react-router-dom";
import 'css/accessDenied.css';

class AccessDenied extends Component{
    render() {
        return (
            <div className="access-denied">
                <div className="content container">
                    <div className="error-card white">
                        <h1 className="error-code red-text text-darken-1">
                            403
                        </h1>
                        <h4 className="describe red-text text-lighten-2">
                            Доступ запрещён
                        </h4>
                        <Link className='back grey darken-3 white-text' to='/'>На главную</Link>
                    </div>
                </div>
            </div>
        );
    }
}

export default AccessDenied;