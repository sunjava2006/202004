//index.js
//获取应用实例
const app = getApp()

Page({
    data: {
        items: [{name:"头条",type:"top"},
                {name:"社会",type:"shehui"}, 
                {name:"国内",type:"guonei"}, 
                {name:"娱乐",type:"yule"},
                {name:"体育",type:"tiyu"}, 
                {name:"军事",type:"junshi"},
                {name:"科技",type:"keji"}, 
                {name:"财经",type:"caijin"}, 
                {name:"时尚",type:"shishang"}],
        currentItem: 0,
        newsList:[]
        
    },
    selectItem: function (evt) {
        var curr = evt.target.id;
        this.setData({
            currentItem: curr
        });
        var type = this.data.items[curr].type;
        this.loadList(type);

    },
    slid: function(evt){
        var idx = evt.detail.current;
        this.setData({
            currentItem: idx
        })

        var type = this.data.items[idx].type;
        this.loadList(type);
    },

    showNews(evt){
        var url = evt.currentTarget.id;
        url=encodeURIComponent(url);
        console.log("encode: "+url);
        wx.navigateTo({
            url: '/pages/news/news?url='+url,
        })
    },
    //  定义一个根据类型，向后台请求该类型，新闻列表的方法。
    loadList(type){
        wx.request({
            url: 'https://v.juhe.cn/toutiao/index',
            method: 'GET',
            data: {
                type: type,
                key: '082153265794dc7a4bdb119e272319ee'
            },
            // success是回调方法，当请求成功返回时，该方法被调用。
            success: (res) => {
                console.log(res);
                this.setData({  // 取出返回的数据给newsList, 以供页面绑定显示 。
                    newsList:res.data.result.data

                });
            }

        })
    },

    // 生命周期方法，在页面加载时，取默认类型的新闻列表。
    onLoad:function(options){
        // 取出默认类型
        var type = this.data.items[this.data.currentItem].type;
        this.loadList(type); //调用自己定义的，加载新闻列表的方法。（指定默认类型）。
    }
})
