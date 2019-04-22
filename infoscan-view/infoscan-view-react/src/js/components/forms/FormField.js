import React, {Component} from 'react';
import '../../../css/form_field.css';

class FormField extends Component{
    render() {
        return (
            <div className="form_field">
                <span className="input-label">{this.props.label}</span>
                <input placeholder={this.props.placeholder} name={this.props.name} type={this.props.type}/>
            </div>
        );
    }
}

export default FormField;