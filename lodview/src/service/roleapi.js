
import service from './axios'

export const getPersonInfo = data => {
    return service({
        url: 'www.baidu.com',
        method: 'get',
        data
    })
}
