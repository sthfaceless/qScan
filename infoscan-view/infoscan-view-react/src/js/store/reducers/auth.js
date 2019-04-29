import {AUTH, LOGOUT} from "js/store/actions/authActions";

const authFunctions = {
    AUTH: (state, action) => {
       return {...state, isAuth: true};
    },
    LOGOUT: (state, action) => {
        return {...state, isAuth: false}
    }
};

export const auth = (state = {}, action) =>
    authFunctions[action.type] ?
        authFunctions[action.type](state, action) : state;
