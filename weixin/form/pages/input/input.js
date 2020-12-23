// pages/input/input.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        userName: "wang",
        pwd: '123',
        value: 30
    },
    mointer: function (evt) {
        console.log(evt);

        this.setData({
            userName: evt.detail.value
        });
        console.log(this.data);

        // this.data.userName=this.data.userName.replace('法轮','xxxxx');
        // console.log(this.data);
    }
})