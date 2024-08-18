# 输入与输出
本章介绍输入输出的API
- 访问和使用文件和目录
- 以二进制和文本格式读写数据
- 对象序列化机制
- 正则表达式

## IO Stream
输入/出流：从其中读入/写入的一个字节序列的**对象**(文件、网络连接、内存块......)

- 流家族
  - 读写字节：抽象类InputStream和OutputStream读取单个字节或字节数组
  - 读写文本(Unicode)：抽象类Reader和Writer
- 组合输入/输出流过滤器：通过嵌套过滤器来实现多重功能
  - 中介输入流(intermediate input stream)：当多个输入流链接到一起时，需要跟踪。
```java
var din = new DataInputStream(new BufferedInputStream(new FileInputStream("file.txt")));
```
- 文本的输入与输出
  - 字符编码(character encoding)：Java默认的是UTF-16，`StandardCharsets.UTF8`。默认使用主机系统的编码模式
  - 输出：`PrintWriter`
  > 自动冲刷模式
  - 输入：`Scanner`、直接读入到一个字符串......

## 读写二进制数据
文本数据利于人类阅读，二进制文件利于计算机计算

- DataInput和DataOutput接口：以二进制读写数据
> 储存方式根据平台的不同有大端法(MSB)和小端法(LSM)，Java中是高位在前与处理器无关
- 随机访问文件RandomAccessFile：在文件的任意位置读写查数据(通过文件指针)
  - 通过一个数据块的大小计算读写数据的位置
- ZIP文档：压缩格式储存了多个文件。有一个文件头，包含文件名、压缩方法。可用ZipInputStream来读入一个zip文档

## 对象IOStream与序列化
对象序列化(object serialization)：将任何对象写入到输出流，并可将其读回
- 保存和加载序列化对象：打开一个ObjectOutputStream，该类必须实现Serializable接口
- 理解对象序列化的文件格式：.........
- 修改默认的序列化机制：某些数据域不能序列化(需标记成`transient`)
- 序列化单例和类型安全的枚举
- 版本管理
- 为克隆使用序列化：`SerialCloneable`
## 操作文件

- Path
- 读写文件
- 创建文件和目录
- 复制移动删除文件
- 获取文件信息
- 访问文件中的项
- 使用目录流
- ZIP文件系统
## 内存映射文件

- 内存映射文件性能
- 缓冲区数据结构


## 文件锁机制

## 正则表达式
正则表达式(regular expression)：即指定字符串的模式。可用定位匹配某些特定模式的字符串

- 语法：比较复杂，可单独作为学习部分
- 匹配字符串：测试特定的字符串是否匹配
- 找出多个匹配
- 分隔符分割
- 替换匹配