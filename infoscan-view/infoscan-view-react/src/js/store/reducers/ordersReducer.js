import {GET_ORDERS} from "../actions/ordersActions";

const ordersFunctions = {
    GET_ORDERS: (store, state) => {

    }
};

export const ordersReducer
    = (state = {}, action) => ordersFunctions[action.type] ? ordersFunctions[action.type](state,  action.state) : state;