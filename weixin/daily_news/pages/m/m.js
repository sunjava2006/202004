// pages/m/m.js
Page({

    /**
     * 页面的初始数据
     */
    data: {

    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        wx.getLocation({
            type:"gcj02",
            success: (res)=> {
                console.log(res);
                this.setData({
                    longitude:res.longitude,
                    latitude:res.latitude,
                    markers:[{  id:0,
                                longitude: res.longitude,
                                latitude: res.latitude,
                                iconPath:'/imgs/location.png',
                                width:50,
                                height:50
                            }]
                });
            }
        });
    
        wx.onLocationChange((res)=>{
            console.log(res);
            this.setData({
                longitude: res.longitude,
                latitude: res.latitude,
                markers: [{
                    id: 0,
                    longitude: res.longitude,
                    latitude: res.latitude,
                    iconPath: '/imgs/location.png',
                    width: 50,
                    height: 50
                }],
                speed:res.speed
            });
        });

        wx.startLocationUpdate({
            success: (res) => {
                console.log('-----------------------------------');
                console.log(res);
                this.setData({
                    longitude: res.longitude,
                    latitude: res.latitude,
                    markers: [{
                        id: 0,
                        longitude: res.longitude,
                        latitude: res.latitude,
                        iconPath: '/imgs/location.png',
                        width: 50,
                        height: 50
                    }]
                });
            }
        });
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