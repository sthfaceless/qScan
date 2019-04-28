import React, {Component} from 'react';
import {Link} from "react-router-dom";
import 'css/badRequest.css';

class BadRequest extends Component{
    constructor(props) {
        super(props);

    }

    render() {
        return (
            <div className="bad-request">
                <div className="content container">
                    <div className="error-card white">
                        <h1 className="error-code orange-text text-darken-2">
                            400
                        </h1>
                        <h4 className="describe orange-text text-lighten-2">
                            Неправильный запрос
                        </h4>
                        <Link className='back grey darken-3 white-text' to='/'>На главную</Link>
                    </div>
                </div>
            </div>
        );
    }

}

export default BadRequest;