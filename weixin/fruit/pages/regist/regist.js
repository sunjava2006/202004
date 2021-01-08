// pages/regist/regist.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        userName: null,
        pwd: null,
        pwd2: null,
        phoneNO: null,
        address: null
    },
    cancel(){
      wx.navigateBack();
    },
    regist(){

        var data = {userName:this.data.userName, 
                pwd: this.data.pwd,
                phoneNO: this.data.phoneNO, 
                address: this.data.address};
        console.log(data);
        wx.request({
          url: 'http://wr.free.idcfengye.com/userRegist',
          data: data,
          method: 'POST',
          success: res=>{
              console.log(res);
              if(res.data.regist=='ok'){

                wx.showModal({
                    title: '注册提示：',
                    content: '注册成功',
                    showCancel: false,
                    success: function(res){
                        wx.redirectTo({
                          url: '/pages/login/login'
                        })
                    }
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