import React from 'react';
import {Datepicker} from "materialize-css";

class DatePicker extends React.Component{
    componentDidMount(){
        Datepicker.init(document.getElementById(this.props.id),{
            format: 'dd-mm-yyyy',
            i18n:{
                cancel: 'Отмена',
                clear: 'Очистить',
                done: 'Ок',
                months: ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Ноябрь', 'Декабрь'],
                weekdays: ['Понедельник', 'Вторник', 'Среда', 'Четверг', 'Пятница', 'Суббота', 'Воскресенье'],
                weekdaysAbbrev:	['Пн','Вт','Ср','Чт','Пт','Сб','Вс'],
                weekdaysShort: ['Пн','Вт','Ср','Чт','Пт','Сб','Вс'],
                monthsShort: ['Янв', 'Февр', 'Март', 'Апр', 'Май', 'Июнь', 'Июль', 'Авг', 'Сент', 'Нояб', 'Дек']
            },
            showClearBtn: true
        });
    }
    render() {
        return (
            <input className="content-field" id={this.props.id} placeholder={this.props.placeholder} type="text"/>
        );
    }
}

export default DatePicker;