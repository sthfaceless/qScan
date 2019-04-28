import React, {Component} from 'react';
import {Link} from "react-router-dom";
import Navbar from "js/header/Navbar";
import ProfileMenu from "js/header/ProfileMenu";
import {Sidenav} from "materialize-css";
import {connect} from "react-redux";
import {logout} from "js/actions/authActions";

class AuthorizedHeader extends Component{
    componentDidMount(){
        Sidenav.init(document.getElementById('slide-out'), {});
    }
    render() {
        return (
            <>
                <Navbar>
                    <li><Link className="support-header" to="/support">Помощь</Link></li>
                    <li><Link className="orders-header" to="/orders">Заказы</Link></li>
                    <li><Link className="coins-header" to="/coins">Купить</Link></li>
                    <li className="links-delimiter">|</li>
                    <ProfileMenu username={this.props.username} logout={this.props.logout}/>
                </Navbar>
                <ul id="slide-out" className="sidenav grey darken-3 white-text">
                    <li>
                        <div className="user-view">
                            <h4>InfoScan</h4>
                        </div>
                    </li>
                    <li><Link to='/support'>Помощь</Link></li>
                    <li><Link to='/orders'>Заказы</Link></li>
                    <li><Link to='/coins'>Купить</Link></li>
                    <li>
                        <div className="divider"></div>
                    </li>
                    <li><Link to='/profile' className="profile-link">Профиль</Link></li>
                    <li>
                        <a onClick={() => this.props.logout()} href='#' className="logout">Выход</a>
                    </li>
                </ul>
            </>
        );
    }
}
const mapDispatchToProps = dispatch => ({
    logout: () => dispatch(logout())
});
export default connect(null, mapDispatchToProps) (AuthorizedHeader);