import React, {Component} from 'react';
import Information from "../components/profile/Information";
import ChangePassword from "../components/profile/ChangePassword";
import ChangeEmail from "../components/profile/ChangeEmail";
import '../../css/profile.css';
import Sidebar from "../components/profile/Sidebar";

class Profile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            window: 1
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
                        <div className="col s4">
                            <Sidebar elements={this.sidebarElements} window={this.state.window} updateWindow={this.updateWindow}/>
                        </div>
                        <div className="col s7 offset-s1">
                            {this.sidebarElements[this.state.window].component}
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Profile;