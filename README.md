# EasyStep打工換宿平臺

## 專案架構  

後端採用SpringBoot框架做開發，透過Hibernate與資料庫溝通存取資料，採用AXIOS與前端界面交換資料。  

前端基於Vue3框架開發結合HTML5技術讓畫面更流暢簡潔  

其他應用API:  
Cloudinary API  
GOOGLE API  
BootStarp API    

## 專案使用步驟  
Vue-easy為Vue專案，請先開啟PowerShell界面先行安裝依賴    

如使用node.js 請輸入 npm install  
開啟vue-easy\src main.js  
輸入您Google API使用者資訊  
輸入 npm run dev開啟專案  

easystep2須設定用戶使用資料  
開啟easystep2\src\main\resources application.properties  
第9、10行請使用您資料庫的使用者  
第25、26請使用您Gmail API的使用者  

開啟easystep2\src\main\java\com\work\easystep2\handler CloudinaryConfig.java  
第13、14、15行請使用您的使用者金鑰資訊  

### 資策會 EEIT71_JAVA跨域專班第三組 制
