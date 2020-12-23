/**! __BUGME_START__ */ !function(){"use strict";var e=new Function("return this")();e.importScripts;var n,t,o,r,a,i,s,c,u,p;!function(){function e(e,n){var t=this;this.options={},this.messageQueue=[],this.opened=!1,this.options=n,this.socketTask=AFAppX.bridge.connectSocket({url:e,multiple:n.multiple,fail:function(e){t.onSocketError(e)}}),this.socketTask.onOpen((function(){t.opened=!0,t.messageQueue.length&&(t.messageQueue.forEach((function(e){t.send(e)})),t.messageQueue=[]),t.onSocketOpen()})),this.socketTask.onError((function(e){t.onSocketError(e.data)})),this.socketTask.onClose((function(){t.opened=!1,t.onSocketClose()})),this.socketTask.onMessage((function(e){t.onSocketMessage(e.data.data)}))}Object.defineProperty(e.prototype,"isSocketOpened",{get:function(){return this.opened},enumerable:!1,configurable:!0}),e.prototype.getOptions=function(){return this.options},e.prototype.send=function(e){var n=function(e){var n="string"==typeof e?e:JSON.stringify(e);return n.length>5e6?void console.warn("abort send websocket message due to size:",n.length):n}(e);null!=n&&(this.opened?this.socketTask.send({data:n,isBuffer:!1}):this.messageQueue.push(n))},e.prototype.close=function(){this.opened&&this.socketTask.close()},e.prototype.onSocketMessage=function(e){},e.prototype.onSocketOpen=function(){},e.prototype.onSocketError=function(e){},e.prototype.onSocketClose=function(){}}();!function(e){e.PageResume="pageResume",e.PagePause="pagePause",e.DebugPanelClick="tinyRemoteDebugPanelButtonClick",e.DebugConsole="onTinyDebugConsole",e.DebugNetworkRequest="tinyAppRemoteDebug_network_request",e.DebugNetworkResponse="tinyAppRemoteDebug_network_response",e.DebugNetworkError="tinyAppRemoteDebug_network_error",e.DebugStorageChanged="tinyAppRemoteDebug_storage",e.MessageFromVConsole="onMessageFromVConsole"}(n||(n={})),function(e){e.GetPagesData="Tiny.Data.getPageData",e.SetPageData="Tiny.Data.setPageData"}(t||(t={})),function(e){e.DataChanged="Tiny.Data.dataChanged"}(o||(o={})),function(e){e.GetStorageInfo="Tiny.Storage.getStorageInfo",e.ClearStorage="Tiny.Storage.clearStorage",e.RemoveStorage="Tiny.Storage.removeStorage",e.SetStorage="Tiny.Storage.setStorage"}(r||(r={})),function(e){e.StorageChanged="Tiny.Storage.storageChanged"}(a||(a={})),function(e){e.Enable="MiniAppLog.enable"}(i||(i={})),function(e){e.ApiSyncCall="MiniAppLog.onApiSyncCall",e.ApiSyncCallback="MiniAppLog.onApiSyncCallback",e.ApiCall="MiniAppLog.onApiCall",e.ApiCallback="MiniAppLog.onApiCallback",e.SetData="MiniAppLog.onSetData",e.SetDataCallback="MiniAppLog.onSetDataCallback",e.ShareAppMessage="MiniAppLog.onShareAppMessage"}(s||(s={})),function(e){e.consoleAPICalled="Runtime.consoleAPICalled",e.executionContextDestroyed="Runtime.executionContextDestroyed",e.executionContextsCleared="Runtime.executionContextsCleared",e.executionContextCreated="Runtime.executionContextCreated"}(c||(c={})),function(e){e.RequestWillBeSent="Network.requestWillBeSent",e.ResponseReceived="Network.responseReceived",e.LoadingFinished="Network.loadingFinished",e.LoadingFailed="Networkw.loadingFailed",e.GetResponseBody="Network.getResponseBody"}(u||(u={})),function(e){e.Data="data",e.Storage="storage",e.AppLog="applog"}(p||(p={}));var l="\\x"+("0"+"~".charCodeAt(0).toString(16)).slice(-2),g="\\"+l,f=new RegExp(l,"g"),d=new RegExp(g,"g"),h=new RegExp("(?:^|([^\\\\]))"+g),y=[].indexOf||function(e){for(var n=this.length;n--&&this[n]!==e;);return n},S=String;function k(e,n,t){return n instanceof Array?function(e,n,t){for(var o=0,r=n.length;o<r;o++)n[o]=k(e,n[o],t);return n}(e,n,t):n instanceof S?n.length?t.hasOwnProperty(n)?t[n]:t[n]=function(e,n){for(var t=0,o=n.length;t<o;e=e[n[t++].replace(d,"~")]);return e}(e,n.split("~")):e:n instanceof Object?function(e,n,t){for(var o in n)n.hasOwnProperty(o)&&(n[o]=k(e,n[o],t));return n}(e,n,t):n}var m={stringify:function(e,n,t,o){return m.parser.stringify(e,function(e,n,t){var o,r,a=!1,i=!!n,s=[],c=[e],u=[e],p=[t?"~":"[Circular]"],d=e,h=1;return i&&(r="object"==typeof n?function(e,t){return""!==e&&n.indexOf(e)<0?void 0:t}:n),function(e,n){return i&&(n=r.call(this,e,n)),a?(d!==this&&(o=h-y.call(c,this)-1,h-=o,c.splice(h,c.length),s.splice(h-1,s.length),d=this),"object"==typeof n&&n?(y.call(c,n)<0&&c.push(d=n),h=c.length,(o=y.call(u,n))<0?(o=u.push(n)-1,t?(s.push((""+e).replace(f,l)),p[o]="~"+s.join("~")):p[o]=p[0]):n=p[o]):"string"==typeof n&&t&&(n=n.replace(l,g).replace("~",l))):a=!0,n}}(e,n,!o),t)},parse:function(e,n){return m.parser.parse(e,function(e){return function(n,t){var o="string"==typeof t;return o&&"~"===t.charAt(0)?new S(t.slice(1)):(""===n&&(t=k(t,t,{})),o&&(t=t.replace(h,"$1~").replace(g,l)),e?e.call(this,n,t):t)}}(n))},parser:JSON},C=m.stringify,b=e.AlipayJSBridge&&e.AlipayJSBridge.call;function A(e,n){b&&b("internalAPI",{method:e,param:n})}function v(e,n){return void 0===n?"©undefined":null===n?"©null":n===-1/0?"©-Infinity":n===1/0?"©Infinity":"number"==typeof n&&isNaN(n)?"©NaN":"function"==typeof n?"©Function":n}var D=Function;function w(){e.document&&e.document.addEventListener("push",(function(e){var n=e.data;if(n&&"onMessageFromVConsole"===n.func){var t;try{var o=n.param.content||n.param.data.content;if(!o)return;t=JSON.parse(o)}catch(e){return}if(t.fromVConsoleToWorker&&"exec"===t.method)try{new D("requestId","sendBack","var res = "+t.script+";console.log(res);")(t.requestId,(function(e){return function(e,n){A("tinyDebugConsole",{type:"msgFromWorkerToVConsole",content:C({requestId:e,returnValue:n},v)})}(t.requestId,e)}))}catch(e){console.warn("bugme execute script error",e)}}}))}if(!e.__BUGME_ON__){e.__BUGME_ON__=!0;try{w(),Object.defineProperties(console,["log","info","error","debug","warn"].reduce((function(e,n){var t=console[n];return e[n]={value:function(){for(var e=[],o=0;o<arguments.length;o++)e[o]=arguments[o];t.apply(console,e);try{var r=C(e.map((function(e){return e instanceof Error?e.name+": "+e.message:e})),v);A("tinyDebugConsole",{content:r,type:"console_"+n})}catch(e){t("bugme console error",e)}},configurable:!0,writable:!0,enumerable:!0},e}),{}))}catch(e){console.warn("bugme init error",e)}}}();
 /**! __BUGME_END__ */
if(!self.__appxInited) {
self.__appxInited = 1;


require('./config$');
require('./importScripts$');

var AFAppX = self.AFAppX;
self.getCurrentPages = AFAppX.getCurrentPages;
self.getApp = AFAppX.getApp;
self.Page = AFAppX.Page;
self.App = AFAppX.App;
self.my = AFAppX.bridge || AFAppX.abridge;
self.abridge = self.my;
self.Component = AFAppX.WorkerComponent || function(){};
self.$global = AFAppX.$global;
self.requirePlugin = AFAppX.requirePlugin;


if(AFAppX.registerApp) {
  AFAppX.registerApp({
    appJSON: appXAppJson,
  });
}



function success() {
require('../../app');
require('../../pages/my/my?hash=32d7d2807ed4e666ef03b4b3fe8c38ecf2e34e68');
require('../../pages/index/index?hash=5158fa18297db3fbaac119609b168d20fcdf1eea');
}
self.bootstrapApp ? self.bootstrapApp({ success }) : success();
}