import React, {Component} from 'react';
import 'css/support.css';

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
                                <a href="#lost_email">Потеряли доступ к почте?</a>
                            </div>
                            <div className="list-item">
                                <span>Покупка</span>
                                <a href="#whats_coins">Что такое коины?</a>
                                <a href="#buy_coins">Как купить коины?</a>
                            </div>
                            <div className="list-item">
                                <span>Заказы</span>
                                <a href="#make_order">Как сделать заказ?</a>
                                <a href="#longtime_order">Слишком долго выполняется заказ?</a>
                            </div>
                        </div>
                    </div>
                    <div className="row">
                        <h4 className="grey-text text-darken-2">Ответы на вопросы</h4>
                        <div className="support_content">
                            <div className="question-group">
                                <span className="head grey-text text-darken-2">Аккаунт</span>
                                <div className="question">
                                    <h6 className="grey-text" id="forgot_password">Забыли пароль?</h6>
                                    <div className="help grey-text text-darken-2">
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dignissimos, repellat voluptatibus. Accusamus adipisci aliquam aperiam aspernatur at atque autem consequuntur delectus deleniti deserunt distinctio dolores ea et exercitationem expedita, explicabo fuga hic itaque laudantium libero magni molestiae necessitatibus neque optio perferendis, provident quasi quis repellendus sapiente soluta, tempora veritatis voluptatem.
                                    </div>
                                </div>
                                <div className="question">
                                    <h6 className="grey-text" id="lost_email">Потеряли доступ к почте?</h6>
                                    <div className="help grey-text text-darken-2">
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab architecto cumque dicta id incidunt minus molestias, nesciunt nulla odio odit optio quo reiciendis suscipit vel voluptatum. Aliquam assumenda delectus odio, pariatur saepe sit. Aperiam architecto at dolorem, earum esse eveniet incidunt labore laborum maxime officiis placeat quasi ut voluptas, voluptate?
                                    </div>
                                </div>
                            </div>
                            <div className="question-group">
                                <span className="head grey-text text-darken-2">Покупка</span>
                                <div className="question">
                                    <h6 className="grey-text" id="whats_coins">Что такое коины?</h6>
                                    <div className="help grey-text text-darken-2">
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dignissimos, repellat voluptatibus. Accusamus adipisci aliquam aperiam aspernatur at atque autem consequuntur delectus deleniti deserunt distinctio dolores ea et exercitationem expedita, explicabo fuga hic itaque laudantium libero magni molestiae necessitatibus neque optio perferendis, provident quasi quis repellendus sapiente soluta, tempora veritatis voluptatem.
                                    </div>
                                </div>
                                <div className="question">
                                    <h6 className="grey-text" id="buy_coins">Как купить коины?</h6>
                                    <div className="help grey-text text-darken-2">
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab architecto cumque dicta id incidunt minus molestias, nesciunt nulla odio odit optio quo reiciendis suscipit vel voluptatum. Aliquam assumenda delectus odio, pariatur saepe sit. Aperiam architecto at dolorem, earum esse eveniet incidunt labore laborum maxime officiis placeat quasi ut voluptas, voluptate?
                                    </div>
                                </div>
                            </div>
                            <div className="question-group">
                                <span className="head grey-text text-darken-2">Заказы</span>
                                <div className="question">
                                    <h6 className="grey-text" id="make_order">Как сделать заказ?</h6>
                                    <div className="help grey-text text-darken-2">
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dignissimos, repellat voluptatibus. Accusamus adipisci aliquam aperiam aspernatur at atque autem consequuntur delectus deleniti deserunt distinctio dolores ea et exercitationem expedita, explicabo fuga hic itaque laudantium libero magni molestiae necessitatibus neque optio perferendis, provident quasi quis repellendus sapiente soluta, tempora veritatis voluptatem.
                                    </div>
                                </div>
                                <div className="question">
                                    <h6 className="grey-text" id="longtime_order">Слишком долго выполняется заказ?</h6>
                                    <div className="help grey-text text-darken-2">
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab architecto cumque dicta id incidunt minus molestias, nesciunt nulla odio odit optio quo reiciendis suscipit vel voluptatum. Aliquam assumenda delectus odio, pariatur saepe sit. Aperiam architecto at dolorem, earum esse eveniet incidunt labore laborum maxime officiis placeat quasi ut voluptas, voluptate?
                                    </div>
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