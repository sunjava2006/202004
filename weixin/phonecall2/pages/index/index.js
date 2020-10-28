const app = getApp()

Page({
  data: {
  
  },

  call(event){
      
      var phoneNO = event.target.id;
      console.log(phoneNO);

      wx.makePhoneCall({
          phoneNumber: phoneNO,
      })
  }
  
})
