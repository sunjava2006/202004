// pages/trail/trail.js
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
        
        // 1、打开页面，获取当前位置，并标注。
        wx.getLocation({
            type: "gcj02", // 使用国家测绘局的位置坐标。
            isHighAccuracy:true,
            success: (res)=> {  // 成功获取位置后的回调方法。返回的数据在res中。
                this.setData({  // 提供经、纬度和markers数据，以供map 组件使用。
                    longitude : res.longitude,   // 经度
                    latitude : res.latitude,     // 纬度
                    initMarker: {                 // 标注点的数组对象，每个marker如下：
                        id: 0,                                  // id
                        longitude: res.longitude,              // 标注点的经度、纬度  
                        latitude: res.latitude,
                        iconPath: "/imgs/location.png",        // 标注的图标
                        width: 50,                             // 图标的宽、高
                        height: 50
                    },
                    markers : [{                 // 标注点的数组对象，每个marker如下：
                        id:0,                                  // id
                        longitude: res.longitude,              // 标注点的经度、纬度  
                        latitude: res.latitude,
                        iconPath: "/imgs/location.png",        // 标注的图标
                        width: 50,                             // 图标的宽、高
                        height: 50
                    }],
                    polyline:[{                                // 画线的标注。
                        points: [{                            // 线的连线坐标，是一个数组。
                            longitude: res.longitude,         // 标注点的经度、纬度 
                            latitude: res.latitude},{                            // 线的连线坐标，是一个数组。
                            longitude: res.longitude,         // 标注点的经度、纬度 
                            latitude: res.latitude}],
                        color: '#0000ff',                     // 线的颜色 
                        width:1,                              // 线的宽度
                        dottedLine:true                     // 点点线
                    }]
                });
            },
        });

        // 2、设置对位置改变的监测
        wx.startLocationUpdate({
            success:(res)=>{
                console.log("-------------------------");
                console.log(res);
                console.log("-------------------------");
            }
        });

        wx.onLocationChange((res)=>{
            console.log(res.longitude + ","+ res.latitude);

            //1、  准备markers的数据。
            var markers = [];
            markers.push(this.data.initMarker);
            var newMarker = {
                id: 1,                                  // id
                longitude: res.longitude,              // 标注点的经度、纬度  
                latitude: res.latitude,
                iconPath: "/imgs/starton.png",        // 标注的图标
                width: 50,                             // 图标的宽、高
                height: 50
            };
            markers.push(newMarker);
            

            // 2、准备polyline中points数据
            var oldPolyline = this.data.polyline;
            oldPolyline[0].points.push({                  // points中添加新的坐标点。
                longitude: res.longitude,             
                latitude: res.latitude});
            
            console.log(this.data.polyline);   
            this.setData({
                markers: markers,
                polyline: oldPolyline,
                speed:res.speed
            });
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