# GUETWuShu
武术学习网站的JAVA后台项目

## 项目中运用的技术栈

- 整个项目是以SpringBoot多模块形式进行搭建的

- 数据库采用的是MySQL，数据库连接池为阿里巴巴的Druid

- Controller层接收和发送的数据都为JSON格式

- 自定义了全局异常捕获

- 通过JWT 生成token

- 利用SpringAOP记录Controller层的日志并以文件的形式输出

- 采用了热部署

- 所需的环境为JDK8,Maven3.x,MySQL 5.7.x

## 实现的功能

1 用户的登录与注册，个人信息的完善

2 管理员的登录，个人信息的完善，能够查看所有用户信息，修改武术学习中的内容

3 主页轮播图的选择、添加和删除

4 武术学习页面有武术文化、武术精髓、武术种类、武术介绍四大板块

5 设置了热搜榜单

6 对后台部分传送的数据进行了Redis缓存，提高用户读取速度

# 注意
需要导入的sql文件在该路径下

GUETWuShu\controller\src\main\resources

data文件夹存放的为Controller层的日志

前端vue项目还在开发中，敬请期待。
