// pages/scroll/scroll.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        students: [{ name: '张明', age: 12 }, 
                   { name: '李亮', age: 13 }, 
                   { name: '赵四', age: 14 }, 
                   { name: '王五', age: 15 }, 
                   { name: '李六', age: 16 }, 
                   { name: '王八', age: 17}]
    },

    openNew: function(evt){
        var idx = evt.target.id;
        var stu = this.data.students[idx];
        var url = encodeURI('/pages/news/news?name=' + stu.name + '&age=' + stu.age);
        console.log(url);
        wx.redirectTo({
            url: url

        });
        // wx.navigateTo({
        //     url: '/pages/news/news?name='+stu.name+'&age='+stu.age
        // })
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