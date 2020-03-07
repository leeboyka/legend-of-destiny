
import service from './axios'

export const getPersonInfo = data => {
    return service({
        url: '/home_view/page',
        method: 'get',
        data
    })
}
