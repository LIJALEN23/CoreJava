# 异常、断言和日志
- **异常(exception)**：Java通过异常处理机制捕获错误，使程序具有健壮性
- **断言(assert)**：测试程序
- **日志(log)**：记录出现的错误

## 处理错误
某个方法不能采用正确的途径完成它的任务，可以通过另一个路径退出方法。这种情况下，方法不返回任何值，而是抛出`throw`一个封装了异常的对象

- 异常分类：异常对象都是派生于一个Throwable类实例
  - Error(非检查型unchecked)：描述了Java运行时系统的内部错误和资源耗尽错误。程序不应该抛出这样的对象，除了通知用户并尽量妥善中止程序外，无其他办法
  - Exception：异常
    - IOException(检查型checked。编译器会检查是否为该型异常提供了异常处理器exception handler)：其他异常
    - RuntimeException(非检查型unchecked)：编程错误导致的异常
- 声明检查型异常：在方法首部`throws`所有可能出现的检查型异常(不然无异常处理器处理，当前线程就会中止)
  - 捕获异常：捕获异常了就没有必要使用`throws`了 
  - 子类重写父类方法时，所能抛出的异常不能比父类更具通用性
- 抛出异常：
  1. 尽可能的具体声明非检查型异常类
  2. 通过判断语句`throw new IOException();`抛出异常
- 创建异常类：遇到标准类无法描述的问题，继承Exception来创建自己的异常类
  1. 默认构造器
  2. 包含详细描述信息的构造器

## 捕获异常
有些代码必须捕获抛出的异常
- 捕获异常：`try-catch`语句块
  - 传播异常：在方法首部添加`throws`，提醒调用者该方法可能会抛出的异常(要捕获知道该如何处理的异常，而传播不知道怎么处理的异常)
- 捕获多个异常：为每一个异常类型使用一个单独的`catch`子句(捕获异常类之间不存在子类关系时，可在一个子句中捕获多个类型的异常)
- 再次抛出和异常链：
```java
    try {
        //access the database
    } catch (SQLException e) {
        throw new ServletException("database error: " + e.getMessage());
        }
```
```java
    try {
        //access the database
    } catch (SQLException original) {
        var e = new ServletException("database error: ");
        e.initCause(original)
        throw new e;
        }
```

- finally子句：代码抛出一个异常时就会停止处理剩余代码。但`finally`中的代码可以被执行
  1. 代码没有抛出异常
  2. 代码抛出一个异常后，被捕获
  3. 代码抛出一个异常，未捕获
- try-with-Resource语句：只需要关闭资源就要尽可能用这种语句。可以跟`catch`语句
```java
    try(var in = Scanner(......)) {
        .......
        }
```
- 堆栈轨迹(stack trace)：是程序执行过程中某个特定点上挂起的方法调用列表

## 使用异常技巧
1. 异常处理不能代替简单的测试
2. 不要过分细化异常
3. 充分利用异常层次结构
4. 不要压制异常
5. 检测错误时，苛刻比放任好
6. 不要羞于传递异常
> 早抛出，晚捕获

## 断言
创建具有自我保护能力的程序
- 断言(`assert`)概念：允许在代码测试期间向代码中插入一些检查，而生产代码会自动删除这些检查
- 使用断言：默认情况下断言是禁用的通过`-enableassertions`启动
- 使用断言检查参数：在Java中处理系统错误机制(1. 抛出一个异常 2. 日志 3. 使用断言 )

## 日志
日志：用来帮助观察程序的行为
- 基本日志：用全局日志记录器(global logger)并调用info方法
- 高级日志
  - 层次性
- 修改日志管理器配置
- 本地化
- 过滤器
- 日志技巧

## 调试技巧
1. 打印变量的值
2. 单元测试
3. JUnit是一个流行的单元测试框架
4. 日志代理(logging proxy)
5. 利用Throwable类的printStackTrace方法
6. 记录或显示堆栈轨迹，可将其捕获到一个字符串中
7. 将程序错误记录到一个文件中
........