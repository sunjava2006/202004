//index.js
//获取应用实例
const app = getApp()

Page({
    data: {
        duration:0,
        currentTime: '0:0',
        currentState: 0 // 0表示暂停状态，1表示播放状态
    },
    onLoad(options) {
        // 创建音频对象
        this.myAudio = wx.createInnerAudioContext();
        // 设置音乐源
        this.myAudio.src = 'https://aod.cos.tx.xmcdn.com/storages/ff2f-audiofreehighqps/65/FB/CMCoOSADR7cLACtWRwBYtVWW.m4a';
        var _this = this;
        


        // 设置一个回调，高播放时间更新时执行的内容。
        this.myAudio.onTimeUpdate(()=> {         // function(){....}
            var second = this.myAudio.currentTime;  // 当前播放进度以秒为单位
            var s = second;
            second = Math.floor(second); // 我们想获取 分:秒 格式的数据。
            var min = Math.floor(second / 60);
            second = second % 60;
            this.setData({
                currentTime: min + ":" + second,
                currentSecondTime: s,
                duration: this.myAudio.duration  // 音乐的长度，秒为单位。
            });
        });


        // 在音乐播放前，获取音乐的播放时长。
        this.myAudio.onCanplay(function () {
            // 因为不确定加载音乐的时长。所以要在interval中，多测试几次，取得数据后退出。
            var i = setInterval(() => { 
                               var dur =  _this.myAudio.duration;
                               console.log("::::::::"+dur);
                               if(dur){
                                   clearInterval(i);
                                   _this.setData({
                                       duration:dur
                                   });
                               }
             }, 1000);
        });
    },

    togger() {
        this.setData({
            currentState: this.data.currentState ? 0 : 1
        });

        if (this.data.currentState) {
            this.myAudio.play(); //播放音乐

        } else {
            this.myAudio.pause();//暂停音乐
        }
    },
    slide(e){
        console.log(e);
        this.myAudio.seek(e.detail.value);
    },
    onUnload(){
        this.myAudio.destroy();
    }

})
