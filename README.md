### 项目介绍
 ****
+ 本文主要集中于**高并发、高可用、高性能**相关的技术积累，抛去业务背景，仅关注三高项目的具体实现细节，寄于此建立相关知识结构体系，方便使用的时候查找。
+ 欢迎更多志同道合的朋友加入本项目，本文将持续更新，欢迎关注[我的博客](https://blog.csdn.net/ljfirst)、我的[Github](https://github.com/ljfirst)。

### 阅读方式
 ****
+ 首先通过[思维导图](https://www.processon.com/mindmap/5f5ec3a1f346fb47ca9fd147)选择感兴趣的模块。
+ 通过该模块上的链接跳转至[博客](https://blog.csdn.net/ljfirst/article/details/105731694)，查看具体内容。
+ 部分文章的源码实现都可以在[SourceCode]()文件夹下找到。
+ 该项目是本人学习三高相关知识的进阶笔记，随着难度增加分为三段，附庸风雅的运用王国维先生的三种境界来表述。

# 高可用
**第一境界**：昨夜西风凋碧树，独上高楼，望尽天涯路
 ****
+ <font color=#Af2233 size=4 >**高可用集群搭建**</font>
  + 【Redis集群搭建】
    + [Redis系列：搭建Redis集群(哨兵模式)](https://blog.csdn.net/ljfirst/article/details/107965120)
    + [Redis系列：搭建Redis集群(集群模式)](https://blog.csdn.net/ljfirst/article/details/108751883)
  + 【Rabbitmq集群搭建】
    + [HAProxy+Keepalived(VIP)搭建Rabbitmq高可用镜像队列](https://blog.csdn.net/ljfirst/article/details/106012709)
    + 使用federation搭建异地双活的mq集群
  + 【数据库集群搭建】
    + 搭建TiDB
    + 搭建SqlServer高可用
    + 数据库系列：搭建Mysql主从复制
  + [Keepalived(VIP)搭建Nginx高可用](https://blog.csdn.net/ljfirst/article/details/108573460)
  + 搭建K8S
+ <font color=#Af2233 size=4 > **高可用方案设计** </font>
  + [RabbitMQ实现消息100%投递的详细设计和测试方案](https://blog.csdn.net/ljfirst/article/details/106012727)

# 高并发
**第二境界**：衣带渐宽终不悔，为伊消得人憔悴
 ****
+ <font color=#Af2233 size=4 > **Java并发**</font> 
  + [Java进阶系列：ThreadLocal的用法和坑](https://blog.csdn.net/ljfirst/article/details/108635283)
+ <font color=#Af2233 size=4 >**数据库并发**</font> 
+ <font color=#Af2233 size=4 >**并行计算**</font> 
+ <font color=#Af2233 size=4 >**并发限流**</font> 
+ <font color=#Af2233 size=4 >**缓存专题**</font> 
+ <font color=#Af2233 size=4 >**高并发方案设计**</font>

# 高性能
**第三境界**：众里寻他千百度，蓦然回首，那人却在,灯火阑珊处
 ****
+ <font color=#Af2233 size=4 >**应用性能**</font> 
  + 【性能测试】
    + [Java进阶系列：使用JMH进行微基准测试](https://blog.csdn.net/ljfirst/article/details/106543981)
    + [Java进阶系列：使用Jmeter进行并发测试](https://blog.csdn.net/ljfirst/article/details/108786624)
+ <font color=#Af2233 size=4 >**数据库性能**</font> 
  + [数据库系列：索引及其优化](https://blog.csdn.net/ljfirst/article/details/108443059)
+ <font color=#Af2233 size=4 >**JVM性能**</font> 
+ <font color=#Af2233 size=4 >**监控专题**</font> 
+ <font color=#Af2233 size=4 >**中间件性能**</font> 
+ <font color=#Af2233 size=4 >**高性能方案设计**</font> 

# 框架专题
 ****
+ <font color=#Af2233 size=4 >**Netty专题**</font> 
  + 预备知识：NIO及网络模型分析
  + [Netty简单入门：获取请求、多客户端连接与通信、心跳检测、长链接](https://blog.csdn.net/ljfirst/article/details/107221532)
+ <font color=#Af2233 size=4 >**Tomcat专题**</font> 
+ <font color=#Af2233 size=4 >**微服务体系**</font> 