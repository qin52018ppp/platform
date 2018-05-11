# platform-parent
基于spring-boot dubbox搭建的java分布式系统
- 前后端分离
- 前端管理项目
- spring-security基于角色的权限管理
- 统一异常管理
- spring-data-redis整合
- 整合swagger-ui接口文档，访问地址 http://localhost:8081/swagger-ui.html
- 定时任务
- 爬虫
- 邮件发送
- rabbitmq示例
- 多profile管理
- maven项目管理
- Mybatis多数据源
- logback记录日志
- 客户端用户注册、登录、修改信息、上传头像、忘记密码接口
- 接口访问次数限制
- okhttp3第三方接口调用
- druid sql监控
- webmagic (http://webmagic.io/docs/zh/posts/ch4-basic-page-processor/pageprocessor.html)


- 项目依赖Mysql、Zookeeper、Redis
- platform-admin-web为管理平台接口
- platform-mobile-client为移动客户端接口
- platform-system为服务提供者
- platform-solr提供全文搜索的列子(配置solr服务（默认使用jetty部署）https://blog.csdn.net/pan_cras/article/details/52369505)https://blog.csdn.net/qq_28114645/article/details/77961998
-- platform-test提供测试学习的项目
- platform-generate内容生成器,一般的实验项目
- 在application.yml中配置数据库连接、Redis连接及web访问端口
- 执行db-script中的数据库初始化脚本
- 在pom.xml中配置zookeeper连接地址
- 启动SysProviderApplication后分别启动ClientMobileApplication和WebAdminApplication
http://localhost:8085/druid/  阿里的数据源



---  本项目主要思路搭建自己的框架，进入快速开发准备的












