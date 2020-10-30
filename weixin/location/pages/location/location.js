// pages/location/location.js
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
        // 获取当前位置。
        wx.getLocation({
            type:'gcj02',
            // 在获取了位置信息后，被调用
            success: (res)=> {
                this.setData({
                    longitude:res.longitude,
                    latitude:res.latitude,
                    markers:[{ // 标注
                                id:0,
                                longitude: res.longitude,
                                latitude: res.latitude,
                                iconPath: '/imgs/location.png',
                                width: 50,
                                height: 50,
                                title: '我的位置'},
                            {
                                id: 1,
                                longitude: 118.7268,
                                latitude: 32.12645,
                                iconPath: '/imgs/home.png',
                                width: 50,
                                height: 50,
                                title: '家的位置'

                            }
                    ],
                    circles:[{   // 画圈
                        longitude: 118.7268,
                        latitude: 32.12645,
                        color: '#ff0000',
                        fillColor: '#ffffff00',
                        radius: 100,
                        strokeWidth:1
                    }],
                    polyline:[{  // 画线
                        points: [{
                            longitude: res.longitude,
                            latitude: res.latitude}, 
                            {longitude: 118.7268,
                            latitude: 32.12645}],
                        color: "#0000ff",
                        width:1
                
                        
                    }]
                });
            },
            fail:()=>{
                wx.showToast({
                    title: '位置加载失败',
                    icon: 'loading'
                });
            }
        })
    },

   
})