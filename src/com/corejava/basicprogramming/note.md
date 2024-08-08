# Java基本程序设计

## Java概述
- Java是一个完整的平台，有庞大的库
- Java的11个关键术语
  1. 简单性
  2. 面向对象
  3. 分布式
  4. 健壮性
  5. 安全性
  6. 体系结构中立
  7. 可移植性
  8. 解释性
  9. 高性能
  10. 多线程
  11. 动态性
- Java applet与Internet
  - applet：在网页中运行的Java程序。逐渐衰败后Java成为服务器端应用的首选平台
- Java发展史
  - JavaME(Micro Edition)
  - JavaSE(Standard Edition)
  - JavaEE(Enterprise Edition)
- Java的误解
  1. Java是程序设计语言。HTML是一种描述网页的方式
  2. Java是程序设计语言。XML是一种描述数据的方式。可以使用任何程序设计语言处理XML数据。而Java API对XML支持很好
  3. Java API繁杂，所以Java并不易学习
  4. Java是一种很好的程序设计语言。Java库很强大、减少指针错误，利于用于网络连接、Web开发和并发
  5. Java在服务器端编程和跨平台客户端领域很有优势
  6. Java不是完全免费
  7. 早期Java是解释性的，但现在的Java虚拟机使用的是**即时编译器**。甚至媲美C++
  8. 大多数Java程序运行在Web浏览器之外的独立应用程序。
  9. Java的安全性还是能保证
  10. JavaScript是网页中的脚本语言与Java无任何关系。Java是一种**强类型语言**，编译器能捕获很多错误
  11. 学习Java是利于对Android程序开发的


## Java环境配置
- Java开发工具包(JDK - Java Development Kit)
  - JRE：Java程序运行的环境(只包含虚拟机)
  - SDK：软件开发工具包(过时)
  - OpenJDK：JavaSE的开源实现
- Java命令行指令：
```shell
# 编译源文件文件
javac Main.java
# 编译后生成Main.class文件，运行程序
java Main
```

- JShell：一个类似java语法的shell
```shell
# 进入JShell程序
jshell
```

## Java编程基础

### 简单的Java程序
- 访问修饰符(access modifier)：关键字public
- 驼峰命名法
- 类名与类文件名的一致性
- 代码块：用两个大括号{}括起来的代码。

### 注释
1. //
2. /**/
3. /** */(可生成文档)

### 数据类型
Java是一种强类型语言(每个变量必须声明为一种类型)。
- Java的类型
  - 8种基本类型(primitive type)：`int`, `byte`, `short`, `long`, `float`, `double`, `boolean`, `char`。且无unsigned类型，如果需要用到，则要用对应的包装器进行操作。
  - 引用类型(reference type)
- 整型：无小数部分。范围与平台无关
  1. long的字面值要加后缀l或者L
  2. 十六进制的字面值要用0X或者0x为前缀
  3. 八进制的字面值以0为前缀
  4. 二进制的字面值用0b或者0B为前缀
  5. 为了可读性，可以以如1_000_000的方式
- 浮点型：遵循IEEE754规范
  1. 单精度6-7位且不常用，双精度15位很常用
  2. 正无穷大(Double.POSITIVE_INFINITY)，负无穷大(Double.NEGATIVE_INFINITY)，NaN(Double.NaN)。实际应用很少用到
- char类型：原本表示单个字符，字面值用单引号括起来。现在的Unicode发生了一些变化
    - **转义字符**
    - 不建议在程序中使用char类型，除非要用到UTF-16代码单元
    - Unicode编码机制
      - 码点(code point)：编码表中某个字符的代码值。Unicode中码点采用16进制
      - 代码平面(code plane)：Unicode分为17个代码平面。
        1. 第一个称为`基本多语言平面(basic multilingual plane)`：包含经典的Unicode代码（U+0000 - U+FFFF）
        2. 其他的包括`辅助字符(supplementary)`（U+10000 - U+10FFFF）
    - UTF-16采用不同长度的编码表示所有Unicode码点
      - 基本多语言平面中，每个字符用16位表示，称为`代码单元(code unit)`
      - 辅助字符编码为一对连续的代码单元
- boolean类型
  1. 只有true和false。C++中可以用0代表false，Java不行
  2. 整型和布尔值不能进行转换

### 变量与常量
- 变量(variable)
  1. var声明局部变量：可以推导出类型
  2. 变量的初始化尽可能在变量的声明附近
- 常量(constant)：使用关键字`final`
  1. final变量只能赋值一次
  2. 类常量(定义于main方法外)：static final
  3. 枚举类型：
  ```Java
  enum Size {SMALL, MEDIUM, LARGE};
  ```
  
### 运算符
- 严格浮点运算
```java
class Solution {
    public static strictfp void main(String[] args) {
        
    }
}
```
- **java.util.Math类**中都是数学相关的静态方法。性能高，精度相对于StrictMath类更低
- 数值类型转换：注意精度丢失问题
  - 强制类型转换(cast)。Math.round()可以将double类型进行舍入运算，得到最接近的整数
- 逻辑运算符

### 字符串
概念上Java字符串是Unicode字符序列，用String类型，是一个预定义类
- String：不可变字符串(immutable)，编译器让字符串共享
  - StringAPI
  - 空串与null
  - **码点与代码单元**：常用的Unicode可以用一个代码单元表示，辅助字符需要一对
  - CharSequence：所有字符串的接口
- StringBuilder(单线程)：前身是StringBuffer(效率稍低，用于多线程)


### 输入与输出
- Scanner类实现输入
- Console类看可以处理密码输入
- 格式化字符串
- 文件输入输出与字符编码，IOException

### 大数
用于处理大数


### 数组
- 数组创建之后无法需修改大小
- for each循环：定义一个变量**暂存**集合中的每一个元素。用于数组或者collection中实现Iterable接口的类对象
- 数组拷贝问题
- 数组排序：使用的优化的快速排序
- 多维数组问题