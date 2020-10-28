// pages/phone/phone.js
Page({

    /**
     * 页面的初始数据
     */
    "data": {
        currentPhone:null
    },
  
    "call": function(evt){
        console.log(this);

        console.warn(this.data.currentPhone);//--取data中数据的方式。这里是一个测试，没有用处。
        var phontNumber = evt.target.id; // 取出图片 id中包含的电话号码 
        console.log(phontNumber);
        this.setData(    // 用来设置 data中的数据。将当前拨打的号码，设置为选择的号码。
            {
                currentPhone: phontNumber
            }
        );

        var _this = this; //------------------------为在回调方法complete中，访问当前对象设置一个引用。

        wx.makePhoneCall({    // 调用小程的开放功能。拨打电话。
            
            phoneNumber: phontNumber,  // 要设置将拨打的电话号码 
            success:function(){
                console.log('打电话成功');
            },
            fail:function(){
                console.log('取消电话');
            },
            complete:function(){     // 电话结束，都将当前号码，设置为空。
                console.log("complete this: "+this);
                console.log("电话结束");
                _this.setData( //----------------------------------
                    {
                        currentPhone: null
                    }
                );
            }
        })
    }
})