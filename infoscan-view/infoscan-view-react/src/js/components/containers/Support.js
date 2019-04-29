import React, {Component} from 'react';
import {connect} from "react-redux";
import Answers from "js/components/simple/support/Answers";
import Feedback from "js/components/simple/support/Feedback";
import Content from "js/components/simple/support/Content";
import 'css/support/support.css';

class Support extends Component{
    render() {
        return (
            <div className="support">
                <div className="container">
                    <div className="row">
                        <h2 className="grey-text text-darken-2">Помощь по проекту</h2>
                    </div>
                    <Content items={this.props.items}/>
                    <Answers items={this.props.items}/>
                    <Feedback/>
                </div>
            </div>
        );
    }
}

const mapStateToProps = state => ({
   items: state.support.groups
});

export default connect(mapStateToProps) (Support);