export function getInitialState() {
    return {
        auth: auth(),
        support: support(),
        profile: profile(),
        coins: coins(),
        orders: orders()
    }
}

const auth = () => ({
   isAuth: false,
   username: 'admin'
});

const support = () => ({
   groups: [{
       name: 'Аккаунт',
       questions: [
           {
               id: '#forgot_password',
               question: 'Забыли пароль?',
               answer: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus accusantium atque distinctio dolor dolorum et id illum, impedit neque nesciunt, nostrum numquam porro recusandae repellat similique tempora vel voluptas voluptates?'
           },{
               id: '#forgot_email',
               question: 'Забыли емайл?',
               answer: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus accusantium atque distinctio dolor dolorum et id illum, impedit neque nesciunt, nostrum numquam porro recusandae repellat similique tempora vel voluptas voluptates?'
           }
       ]
   },{
       name: 'Коины',
       questions: [
           {
               id: '#whats_coins',
               question: 'Что такое коины?',
               answer: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus accusantium atque distinctio dolor dolorum et id illum, impedit neque nesciunt, nostrum numquam porro recusandae repellat similique tempora vel voluptas voluptates?'
           },{
               id: '#buy_coins',
               question: 'Как купить коины?',
               answer: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus accusantium atque distinctio dolor dolorum et id illum, impedit neque nesciunt, nostrum numquam porro recusandae repellat similique tempora vel voluptas voluptates?'
           }
       ]
   },{
       name: 'Заказы',
       questions: [
           {
               id: '#make_order',
               question: 'Как сделать заказ?',
               answer: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus accusantium atque distinctio dolor dolorum et id illum, impedit neque nesciunt, nostrum numquam porro recusandae repellat similique tempora vel voluptas voluptates?'
           },{
               id: '#longtime_order',
               question: 'Слишком долго выполняется заказ?',
               answer: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus accusantium atque distinctio dolor dolorum et id illum, impedit neque nesciunt, nostrum numquam porro recusandae repellat similique tempora vel voluptas voluptates?'
           }
       ]
   }
   ]
});

const profile = () => ({
   info: {
       infoCards: [{
           name: 'Личная информация',
           elements: [{
               name: 'Имя пользователя',
               value: 'admin'
           },{
               name: 'Емайл',
               value: 'zerodotax2@mail.ru'
           },{
               name: 'Дата регистрации',
               value: '15-11-2001'
           }]
       }]
   }
});

const coins = () => ({
    searchFilters: [{
        name: 'Дата',
        elements: ['Новые', 'Старые']
    }],
    balance: 13,
    payments: [{
        id: 234,
        system: 'qiwi',
        systemName: 'Qiwi Wallet',
        date: '13-12-2008',
        amount: 5
    }]
});

const orders = () => ({
    searchFilters: [{
        name: 'Дата',
        elements: ['Новые', 'Старые']
    },{
        name: 'Статус',
        elements: ['Принят', 'В обработке', 'Отклонён', 'Завершён']
    }],
    ordersStat: {
        'accepted': 5,
        'processing': 2,
        'cancelled': 3,
        'finished': 13
    },
    items: [{
        id: 1,
        name: 'Петя Иванов',
        createDate: '15-11-2001 18:01',
        status: 'Принят',
        networks: [{
            logo: 'vk',
            name: 'Ельцов Данил',
            path: 'vk.com'
        }],
        info: [{
            name: 'Емайл',
            items: ['gmailssx2@mail.ru', 'sridderter@gmail.com']
        },{
            name: 'Телефоны',
            items: ['+8800553535', '+79129992223']
        }]
    },{
        id: 2,
        name: 'Петя Миронов',
        createDate: '15-11-2003 18:01',
        status: 'В обработке',
        networks: [{
            logo: 'github',
            name: 'spaceouter',
            path: 'github..com'
        }]
    }]
});