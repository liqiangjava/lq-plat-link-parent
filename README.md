# lq-plat-link-parent
经过多年工作经验的积累，自己开发出一套基于springboot的项目平台架构。
该平台架构以Restful方式提供服务的平台结构，便于前后分离，逻辑分离及项目分工，开发的产品符合平台模块化的设计模式及高内聚低耦合的组件化开发方式并提供结构层次清晰的API，主要由基础平台模块构成。

业务平台模板主要是基于基础平台模块进行搭建。

lq-plat-model平台模型模块	平台的通用业务模型定义及接口模型定义

lq-plat-entity 平台实体模块	平台通用的业务实体定义

lq-plat-base 平台基本模块	包含平台基本的配置，接口服务父类，业务服务父类，通用的数据服务父类，平台常量，异常定义及统一的异常处理

lq-plat-cache 平台缓存管理模块	平台通用的缓存管理

lq-plat-mail平台邮件发送模块	按通用的模板发送邮件

lq-plat-mq平台异步通信模块	提供平台间，平台模块间的异步通信能力支持

lq-plat-elasticsearch平台搜索模块	提供全局搜索服务（中英文，添加IK中文分词）

lq-plat-security平台安全模块	平台通用的安全管理模块

lq-plat-config平台配置模块	CORS配置，请求成功/失败后的处理等有平台配置方面的类

lq-plat-file平台文件模块	文件上传，下载FASTDFS

lq-plat-rongcloud平台融云模块	即时通讯相关

lq-plat-user平台用户模块	用户登录，注册，查询，忘记密码等用户相关功能，日后将spring社交技术引入，满足第三方登录

希望大家能多向我提提意见与建议，我更好的维护这个平台架构

联系方式：904490352@qq.com   李强

微信订阅号： IT李强club 里面有我自己写的关于elasticsearch相关的文章
 
 

