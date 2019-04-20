import React, {Component} from 'react';
import '../../css/support.css';

class Support extends Component{
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="support">
                <div className="container">
                    <div className="row">
                        <h2 className="grey-text text-darken-2">Помощь по проекту</h2>
                    </div>
                    <div className="row">
                        <h4 className="grey-text text-darken-2">Содержание</h4>
                        <div className="content_list">
                            <div className="list-item">
                                <span>Аккаунт</span>
                                <a href="#forgot_password">Забыли пароль?</a>
                                <a href="#">Потеряли доступ к почте?</a>
                            </div>
                            <div className="list-item">
                                <span>Покупка</span>
                                <a href="#">Что такое коины?</a>
                                <a href="#">Как купить коины?</a>
                            </div>
                            <div className="list-item">
                                <span>Заказы</span>
                                <a href="#">Как сделать заказ?</a>
                                <a href="#">Слишком долго выполняется заказ?</a>
                            </div>
                        </div>
                    </div>
                    <div className="row">
                        <h4 className="grey-text text-darken-2">Ответы на вопросы</h4>
                        <div className="support_content">
                            <div className="question">
                                <h6 className="grey-text" id="forgot_password">Забыли пароль?</h6>
                                <div className="help grey-text text-darken-2">
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci alias aliquid amet animi asperiores assumenda dignissimos distinctio dolor dolores earum, est illo incidunt ipsam iure labore modi molestias nam, nobis non nostrum, nulla odio officiis optio pariatur perferendis porro provident quo recusandae reiciendis sapiente similique tempora temporibus tenetur vero vitae voluptas voluptatibus. Iste laborum, laudantium magnam nulla possimus quibusdam soluta. Adipisci architecto blanditiis consectetur corporis doloremque ea exercitationem facilis ipsam laudantium neque nesciunt obcaecati optio placeat porro quaerat quam quis quo recusandae repellat, rerum suscipit tempore ut voluptas. Ab aliquid corporis deserunt et illum impedit maxime obcaecati odit possimus quo.
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="row back-connect">
                        <h4 className="grey-text text-darken-2">Обратная связь</h4>
                        <div className="connect_suggestion grey-text text-darken-1">
                            Остались вопросы? Задайте вопрос и ответ придёт к вам на почту.
                        </div>
                        <div className="btn blue">Задать вопрос</div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Support;