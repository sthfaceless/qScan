const coinsFunctions = {
};

export const coins = (state = {}, action) =>
    coinsFunctions[action.type] ?
        coinsFunctions[action.type](state,  action.state)
        : state;