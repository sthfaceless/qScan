export const LOGOUT = 'LOGOUT';
export const AUTH = 'AUTH';

export function logout() {
    return {
        type: LOGOUT
    }
}

export function auth() {
    return {
        type: AUTH
    }
}