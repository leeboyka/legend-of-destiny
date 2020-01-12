import axios from "axios";
import qs from "qs";
//用于后面对接口进行统一处理，比如调接口的时候，显示loading等
import Vue from "../main.js";

/****** 创建axios实例 ******/
const service = axios.create({
    baseURL: 'http://',  // api的base_url
    timeout: 5000  // 请求超时时间
});

/****** request拦截器==>对请求参数做处理 ******/
service.interceptors.request.use(config => {
    Vue.$vux.loading.show({
        text: '数据加载中……'
    });
    config.method === 'post'
        ? config.data = qs.stringify({ ...config.data })
        : config.params = { ...config.params };
    config.headers['Content-Type'] = 'application/x-www-form-urlencoded';
    return config;
}, error => {  //请求错误处理
    Vue.$vux.toast.show({
        type: 'warn',
        text: error
    });
    Promise.reject(error)
});

/****** response拦截器==>对响应做处理 ******/
service.interceptors.response.use(response => {
    //成功请求到数据
    app.$vux.loading.hide();
    //这里根据后端提供的数据进行对应的处理
    if (response.data.result === 'TRUE') {
        return response.data;
    } else {
        app.$vux.toast.show({  //常规错误处理
            type: 'warn',
            text: response.data.data.msg
        });
    }
}, error => {  //响应错误处理
    console.log('error');
    console.log(error);
    console.log(JSON.stringify(error));
    let text = JSON.parse(JSON.stringify(error)).response.status === 404
        ? '404'
        : '网络异常，请重试';
    app.$vux.toast.show({
        type: 'warn',
        text: text
    });
    return Promise.reject(error)
});

export default service;
