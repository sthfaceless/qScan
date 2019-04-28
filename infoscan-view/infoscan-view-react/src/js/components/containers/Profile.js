import React, {Component} from 'react';
import Information from "js/profile/Information";
import ChangePassword from "js/profile/ChangePassword";
import ChangeEmail from "js/profile/ChangeEmail";
import 'css/profile.css';
import Sidebar from "js/profile/Sidebar";

class Profile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            window: 0
        }
    }

    sidebarElements = [
        {
            text: 'Информация',
            component: <Information/>
        },
        {
            text: 'Смена пароля',
            component: <ChangePassword/>
        },
        {
            text: 'Смена емайл',
            component: <ChangeEmail/>
        }
    ];

    updateWindow = (window) => {
        this.setState({window})
    };

    render() {
        return (
            <div className="profile">
                <div className="container">
                    <div className="row">
                        <div className="col s12 m4">
                            <Sidebar elements={this.sidebarElements} window={this.state.window} updateWindow={this.updateWindow}/>
                        </div>
                        <div className="col s12 m8 content">
                            {this.sidebarElements[this.state.window].component}
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Profile;