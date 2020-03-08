
import service from './axios'

export const getPersonInfo = params => {
    return service({
        url: '/home_view/page',
        method: 'get',
        params
    })
}
