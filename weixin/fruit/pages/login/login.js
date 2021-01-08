// pages/login/login.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        userName: '李二狗',
        password: '123456'
    },
    openRegist(){
        wx.navigateTo({
          url: '/pages/regist/regist',
        })
    },
    toLogin(){
        wx.request({
          url: 'http://wr.free.idcfengye.com/userLogin',
          data: {"userName": this.data.userName,
                 "pwd": this.data.password},
          method: 'POST',
          success: res=>{
              console.log(res);
              if(res.data.login=="ok"){
                  wx.setStorageSync('userInfo', res.data.userInfo);
                  wx.switchTab({
                    url: '/pages/index/index'
                  })
              }else{
                  wx.showToast({
                    title: '登录失败',
                    duration: 5000
                
                  })
              }
          }
        })
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {

    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    }
})