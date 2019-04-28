import {GET_ORDERS} from "js/store/actions/ordersActions";

const ordersFunctions = {
};

export const orders = (state = {}, action) =>
    ordersFunctions[action.type] ?
        ordersFunctions[action.type](state,  action.state)
        : state;