# gpxx
这是一个简单的股票监控model,设置好监控的价格，后台会自动监控你的股票价格并以邮箱的形式提醒你。
1.	git clone 下该项目，使用maven的方式导入eclipse
2.	本项目采用SSM框架，后台数据为mysql，安装好数据库，在gpxx/src/main/resources/tabsql/ 下为该项目所有的sql语句，如果要运行该项目需要建立jkgpxxzb、userinfo、email这3张表.
3.	数据库配置gpxx/src/main/resources/resources/jdbc.properties
4.	Spring 相关配置gpxx/src/main/resources/spring/
5.	用户注册：http://localhost:8080/gpxx/register
6.	用户登录：http://localhost:8080/gpxx/userlogin
