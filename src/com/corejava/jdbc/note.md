# 数据库编程

Java数据库连接API使程序员可与数据进行通信，并使用SQL对数据库进行查找与更新

## 1JDBC基础

### 1JDBC设计

通过API编写程序与驱动管理器进行通信，驱动管理器通过驱动程序与实际数据库进行通信

- **驱动程序类型**
  1. JDBC翻译成ODBC
  2. Java程序和部分本地代码组成
  3. 纯Java客户端类库
  4. 纯Java类库
- **实际用法**
  1. 两层：在服务器部署数据库，客户端安装JDBC驱动程序
  2. 三层：客户端调用服务器上的中间件层，由中间件层完成数据库查询操作。使可视化表示从业务逻辑和原始数据中分离出来

### 2JDBC配置

1. 数据库URL：主机名+端口号+数据库名
2. 驱动程序Jar文件：下载/构建驱动程序的Jar包
3. 启动数据库：即将数据库的服务器打开
4. 注册驱动器类：(包括METE-INF/services/java.sql.Driver的自动注册驱动器类)，手动注册：1. `Class.forName("com.mysql.cj.Driver");` 2. 命令行参数注册
5. 连接数据库：`Connection conn = DriverManager.getConnection(url, username, password);` 

### 3JDBC语句

1. 通过Connection对象创建Statement对象，调用DriverManager.getConnection方法获得Connection对象
2. 使用Statement对象使用SQL语句
3. 用ResultSet对象(只能打开一个Statement)接收查询结果，再进行遍历结果
4. SQLException异常分析
5. 通过.sql文件进行大量操作


## 执行查询操作

## 可滚动和可更新的结果集

## 行集

## 元数据

## 事务

##