import React, {Component} from 'react';
import 'css/notFound.css';
import {Link} from "react-router-dom";

class NotFound extends Component{

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="not-found">
                <div className="content container">
                    <div className="error-card white">
                        <h1 className="error-code blue-text text-lighten-2">
                            404
                        </h1>
                        <h4 className="describe blue-text text-lighten-2">
                            Страница не найдена
                        </h4>
                        <Link className='back grey darken-3 white-text' to='/'>На главную</Link>
                    </div>
                </div>
            </div>
        );
    }

}

export default NotFound;