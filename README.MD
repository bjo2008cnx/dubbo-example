# dubbo-example

启动顺序：
1. 启动本地zookeeper（zkServer.cmd）
    配置本地tomcat，并部署dubbo-consumer
2. 启动dubbo-provider中的Application
3. 启动dubbo-consumer 
4. 访问http://localhost:8080/login/laolao

查看Application后台是否打印Loalao

大致步骤：
1，用户laolao登录 ：http://localhost:8080/login/laolao
2，前端处理后放入session，并跳转到用户新增页面
3，新增用户提交到springmvc 被interceptor截获，将session中的userName放入threadLocal
4, controller调用dubbo service时,被DubboFilter截获，将threadLocal中的userName传递给服务提供方，服务提供方得到username并打印


