//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
      userName:'wang',
      pwd:'123456'
  },
  myrequest: function(evt){
      var userName = evt.detail.value.userName;
      var pwd = evt.detail.value.pwd;

      wx.request({
          url: 'http://www.qq.com',
          method:'get',
          data:{
              userName,
              pwd
          }
      })
  }
  
})
