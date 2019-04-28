export const GET_ORDERS = 'GET_ORDERS';

export function getOrders(id) {
    return {
        type: GET_ORDERS,
        state: {
            id: id
        }
    }
}