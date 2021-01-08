// pages/carts/carts.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        carts: null,
        amount: 0
    },
    toPay (e){
        let userInfo = wx.getStorageSync('userInfo');
        if(userInfo){ // 已经登录

            wx.request({
              url: 'http://wr.free.idcfengye.com/order',
              method: 'POST',
              data: {carts: this.data.carts, userInfo:userInfo},
              success: res=>{
                if(res.data.order=='ok'){
                    wx.removeStorageSync('carts');
                    wx.showToast({
                      title: '下单成功',
                      duration: 5000
                    })
                }else{
                    wx.showToast({
                        title: '下单失败',
                        duration: 5000
                      })
                }
              }
            })

        }else{  // 没有登录
           wx.navigateTo({
             url: '/pages/login/login',
           })
        }
    },
    delFromCarts:function(e){
        let index = e.target.id;
        this.data.carts.splice(index, 1);
        this.setData({
            carts: this.data.carts
        });
    },
    minusCount (e) {
        let index = e.target.id;
        let item = this.data.carts[index];
        if(item.count>1){
            item.count -= 1;
        }
        this.setData({
            carts: this.data.carts
        })
        this.amount();
        
    },
    addCount (e) {
        let index = e.target.id;
        let item = this.data.carts[index];
        
            item.count += 1;
        
        this.setData({
            carts: this.data.carts
        })

        this.amount();
    },

    amount(){
       let amount = 0;
       for(var i of this.data.carts){
           amount += i.fruit.PRICE * i.count;
       }
       this.setData({
           amount: amount
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
        console.log("------------------------------onShow-----------------------------");
        let carts = wx.getStorageSync('carts');
        console.log(carts);
        this.setData({
            carts:carts
        });
       
        this.amount();
    },
    

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {
        console.log("===================onHide======================")
        wx.setStorageSync( "carts", this.data.carts);
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