# 芾医疗

基于SpringCloud+Vue的医院挂号系统

## 后端 https://github.com/mifuCN/mifu_guahao/tree/backend
## 前端 https://github.com/mifuCN/mifu_guahao/tree/frontend

本项目是一个完整的微服务预约挂号平台，包含 3 个系统：

1. 预约挂号系统前台
2. 预约挂号系统管理员后台
3. 外部医院管理后台

## 技术栈

#### 前端

1. Vue
2. vue-admin-template 管理员模板
3. VueQriously 二维码生成库
4. babel
5. webpack
6. nuxt 服务端渲染
7. element ui

#### 后端

微服务：

1. Spring Cloud Alibaba 框架
2. Nacos 注册中心
3. Spring Cloud Feign 远程调用
4. Spring Cloud Gateway 微服务网关
5. Maven 子父多模块
6. Docker（部署项目、安装服务）

数据存储：

1. MongoDB：负责存医院基本信息（性能更高）
2. MySQL：存储用户、订单、预约等关系信息

中间件：

1. Redis：缓存、存储验证码
2. RabbitMQ：应用解耦、消息通知
3. Nginx：部署项目

工具库：

1. easy excel：读写 Excel 文件
2. Json Web Token：生成 jwt token
3. Joda Time：日期时间操作

## 重点知识总结

1. 微服务的思想、划分以及实现方式，以及相关技术的用法：
2. 注册中心以及配置中心
3. 客户端调用
4. 微服务网关
5. 熟悉一个完整的业务流程（信息发布 => 信息展示 => 购买 => 下单支付 => 统计管理）
6. 登录认证机制，包括手机号登录、微信扫码登录、OAuth、JWT 等知识
7. 如何运用合适的数据库来解决问题？比如 MySQL 存储关系型数据、Redis 用于缓存、MongoDB 存储一些非关系型的数据（提高访问速度）、RabbitMQ 来实现异步通知和应用解耦。
8. 调用第三方 API 来解决实际问题，比如微信接口、OSS、SMS
9. 项目的目录结构及编码规范，比如通用返回对象、全局异常处理器、ContextHolder 等
10. 提升前端开发的经验，比如 Nuxt 框架的使用，了解服务端渲染

## 经验总结

1. 已经学完 SpringBoot、微服务的大致的知识，比较适合把这个项目作为第一个微服务的练手项目比较合适，学习技术的整合运用、接触更多的业务场景。
2. 项目非常真实完整、贴合实际，学完这个项目后，也能搞懂电商平台的业务流程了，可以不用再做类似业务的项目。
3. 项目的坑那是非常非常多啊，通过这个项目直接升华了自己的debug 能力（狗头）。
4. 项目用到了微信登录和支付，适合入门学习。但由于只有企业账号才能使用这些微信接口，所以学习时主要是了解流程，实际开发中再看文档就好了，不用花很多时间折腾。
5. 时间原因，有些功能的实现并不完美（比如下单功能没有考虑并发安全问题，可能导致超卖）。此外，项目也没有用到并发编程、设计模式和自定义的 SQL 查询，这些有时间的话再来后期优化。

## 简历重点

1. 基于 Spring Cloud + Nacos 实现项目的微服务化，划分项目为公共、用户、订单等服务，提高项目的可扩展性和容错性。
2. 使用 Spring Data 注解实现自动 Redis 缓存，并通过自定义 Redis Key Generator 来根据类和方法自动生成 key，降低开发成本、避免 key 冲突。
3. 使用 Spring Cloud Gateway 实现微服务请求转发，并在网关层全局解决跨域、用户鉴权、黑白名单、内网服务保护等问题，降低开发成本、提高安全性。
4. 提供 Restful API 供外部系统接入并上报数据，并通过 API 签名认证保障了接口的安全性。
5. 使用 JWT 实现单点登录，并支持手机验证码、OAuth2 微信扫码登录，提高用户真实性和登录安全性
6. 对接微信支付 API 实现预约付款，并通过全局唯一 id 以及支付 / 退款记录表的设计保证了支付操作的幂等性
7. 使用 MongoDB 代替 MySQL 存储读多写少的半结构化数据（如医院信息），实测查询性能提高 xx%。（还没用JMeter 测试）
8. 基于 Docker 快速搭建项目依赖服务（如 RabbitMQ），并通过 Docker log 命令查看日志，降低本地开发运维成本。
9. 为应对流量高峰，使用 RabbitMQ 将下单减库存等耗时操作异步化，提升下单接口单机 QPS（xx 至 xx）
10. 使用 Spring Scheduler 实现定时预约提醒功能，并使用 RabbitMQ 实现定时服务和通知服务的解耦，提高服务可维护性。
11. 使用 Nuxt 框架实现服务端渲染，提高网页首屏加载速度（xx 秒至 xx 秒）。
