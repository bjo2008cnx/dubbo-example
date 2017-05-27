# dubbo-example

启动顺序：
1. 启动本地zookeeper
    配置本地tomcat，并部署dubbo-consumer
2. 启动dubbo-provider中的Application
3. 启动dubbo-consumer 
4. 访问http://localhost:8080/userAddView

分支说明 ：
feature/filter: 增加filter,解决传递context的问题，类似于ThreadLocal中传递用户信息