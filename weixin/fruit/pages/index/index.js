//index.js
//获取应用实例
const app = getApp()

Page({
    data: {
        colorList: ['#ea986c', '#eeb173', '#f3ca7e',
            '#e16531', '#e98f36', '#efb336',
            '#dd6572', '#e0620d', '#ea9518',
            '#ea986c', '#eeb173', '#f3ca7e',
            '#e16531', '#e98f36', '#efb336',
            '#dd6572', '#e0620d', '#ea9518'],
        fruitTypeList: [],
        currentTypeIndex: 0,
        currentPage: 1,
        totalPage: 1,
        fruitList: [],
        nextFlag: true,
        currentSelectedFruit: null,
        modalClass: 'hide-modal',
        count: 1,
        amount: 0
    },
    tapSelectType: function (e) {
        console.log(e);
        this.setData({ currentTypeIndex: Number(e.currentTarget.id), currentPage:1 });
        this.listFruitByType(this.data.fruitTypeList[this.data.currentTypeIndex].ID, 1);
    },
    slideSelectType: function (e) {
        console.log(e);
        this.setData({ currentTypeIndex: e.detail.current , currentPage:1 });
        this.listFruitByType(this.data.fruitTypeList[this.data.currentTypeIndex].ID, 1);
    },
    onLoad: function () {
        wx.request({
            url: 'http://wr.free.idcfengye.com/getTypeList',
            success: res => {
                console.log(res);
                this.setData({
                    fruitTypeList: res.data
                });

                // 取默认第一个类型中的水果
                this.listFruitByType(this.data.fruitTypeList[this.data.currentTypeIndex].ID, this.data.currentPage);
            }
        })
    },
    nextPage:function (e) {
        console.log('滑到屏幕底部了.....................');
       
        if(this.data.currentPage<this.data.totalPage){
            if(this.data.nextFlag){
                this.data.nextFlag = false;
               this.listFruitByType(this.data.fruitTypeList[this.data.currentTypeIndex].ID, this.data.currentPage+1);
            }
        }else{
            wx.showToast({
              title: '没有更多的商品了',
            })
        }
        
    },
    // previousPage:function(){
    //     if(this.data.currentPage>=2){
    //         this.listFruitByType(this.data.fruitTypeList[this.data.currentTypeIndex].ID, this.data.currentPage-1);
    //     }else{
    //         wx.showToast({
    //           title: '没有更多的商品了',
    //         })
    //     }
    // },
    listFruitByType: function (typeID, page) {
        console.log(typeID);
        console.log(page);
        console.log("**********************************************************")
        wx.request({
          url: 'http://wr.free.idcfengye.com//listFruitByType?typeID='+typeID+'&page='+page,
          
          header: {
            'content-type': 'application/json' // 默认值
          },
          success:(res)=> {
            console.log(res.data);
            

            
            if(page==1){
                this.setData({
                    totalPage : res.data.totalPage,
                    currentPage: res.data.currentPage,
                    fruitList: res.data.fruitList,
                    nextFlag:true
                });
            }else{
                var list = [];
                for(var i of this.data.fruitList){
                    list.push(i);
                }
                for(var i of res.data.fruitList){
                    list.push(i);
                }
                this.setData({
                    totalPage : res.data.totalPage,
                    currentPage: res.data.currentPage,
                    fruitList: list,
                    nextFlag:true
                });

            }
            

          }
        })
    },

    addToCarts(e){
        var idx = e.target.id;
        var fruit = this.data.fruitList[idx];
        console.log(fruit);
        this.setData({
            currentSelectedFruit: fruit,
            amount: fruit.PRICE,
            count: 1,
            modalClass: 'show-modal'
        });
        console.log(this.data.currentSelectedFruit)
    },
    cancelAddToCarts (e) {
        this.setData({
            modalClass: 'hide-modal'
        });
    },
    minusCount (e) {
        if(this.data.count>1){
            this.setData({
                count: this.data.count-1,
                amount: this.data.currentSelectedFruit.PRICE* (this.data.count-1)
            })
        }
        
    },
    addCount (e) {
        this.setData({
            count: this.data.count+1,
            amount: this.data.currentSelectedFruit.PRICE* (this.data.count+1)
        })
    },
    confirmAddToCarts (e) {
        var data  = wx.getStorageSync('carts');
        var carts = [];
        var currentFruit = {fruit: this.data.currentSelectedFruit, count:this.data.count};
        if (data){
            carts = data;
        }
        var haveNotFlag = true;
        for(var i of carts){
            if(currentFruit.fruit.ID == i.fruit.ID){
                i.count=i.count+1;
                haveNotFlag = false;
            }
        }
        if (haveNotFlag){
            carts.push(currentFruit);
        }
        
        wx.setStorageSync('carts', carts);
        this.setData({
            modalClass: 'hide-modal'
        });
    }
})
