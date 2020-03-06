demo 介绍：
1、本demo是一个spring cloud项目，包含eureka config getaway
2、uc是用户管理中心，provide 包含string 和 array 两个工具类，将引入log4j 日志框架
3、bpm是consumer，通过restTemplate 工具类 以restful接口的形势调用uc
4、还将引入消息中间件