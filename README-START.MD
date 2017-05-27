# dubbo-example

启动顺序：
1. 启动本地zookeeper
    配置本地tomcat，并部署dubbo-consumer
2. 启动dubbo-provider中的Application
3. 启动dubbo-consumer 
4. 访问http://localhost:8080/userAddView
