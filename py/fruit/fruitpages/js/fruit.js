const host="http://localhost:5500/api";
axios.interceptors.response.use(response => {
    console.log(response);
    console.log("-----------------------------axios.interceptors.response.use---------------------");
    if(response.headers["session-status"]=="invalide"){
        if(-1 == response.config.url.indexOf("/login")){
             window.open("http://localhost:5500", "_top");
        // return;
        }
        
    }
return response;
},error => {
// Do something with response error
return Promise.reject(error);
});