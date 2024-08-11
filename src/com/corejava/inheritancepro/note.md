# 接口、lambda表达式与内部类
- **接口(interface)**：描述类应该做什么，而不是指定怎么做
- **lambda表达式**：创建在将来某个时间点执行的代码块。简洁地实现回调或可变行为的代码
- **内部类(inner class)**：在一个类内部的类。设计相互协作关系的类集合石佛很有用
- **代理(proxy)**：实现任意接口的对象。是一种非常专业的构造工具，可用来构造系统级的工具


## 接口
- 接口概念：接口不是类，而是对符合这个接口类的一组需求
  - 所有方法都自动是`public`，所有字段都自动是`public static final`
  - `implement`的原因：Java是一种强类型语言(strongly typed)，在调用方法时，编译器需要检查该方法是否存在
  - `Comparable`注意：和equals一样需要注意对称性 即要检测比较对象的所属类 
- 接口属性
  - 接口不能构造对象，但能声明接口变量
- 接口与抽象类：通过接口可实现多继承的很多优点且避免多继承的复杂性和低效性
- 静态和私有方法：可在接口中实现一些实用工具，而不是提供一个伴随类。如Collection和Collections、Path和Paths
- 默认方法(`default`修饰)：提供了源码兼容性(source compatible)
- 解决默认方法冲突：超类优先，接口冲突编译器报错(程序员解决二义性)。不要让默认方法重新定义Object类中的方法，因为超类优先
- 接口与回调：这两种机制通常一起使用，特别是在需要定义某种行为但不确定具体实现细节的情况下。
- `Comparator`接口：比较器是一个实现了`Comparable`接口的类的实例。利用lambda表达式可以更容易的使用Comparator
- 对象克隆：Cloneable接口(是Java中少数的标记接口(tagging interface)之一)。
  - 浅拷贝：Object中有一个protected的clone方法。拷贝数值和基本类型可以，但是涉及到其他对象只能进行浅拷贝
  - 深拷贝(deep copy)：需要重新定义clone方法。较少使用


## lambda表达式
- 引入lambda表达式：是一个可传递的代码块，可在以后执行一次或者多次
- 语法：参数 + 箭头 + 表达式
- 函数式接口(functional interface)：对于只有一个抽象方法的接口，需要这种接口的对象时，可以提供一个lambda表达式
  - `java.util.function`中定义了很多通用的函数式接口
- 方法引用(method reference)：只有当lambda表达式的体只调用一个方法而不做其他操作时，才能把表达式写为方法引用
  1. object::instanceMethod：等价于lambda表达式(`System.out::println`对象是System.out等价于`x -> System.out.println(x)`)
  2. Class::instanceMethod：`String::compareToIgnoreCase`等价于`(x, y) -> x.comareToIgnoreCase(y)`
  3. Class::staticMethod：`Math::pow`等价于`(x, y) -> Math.pow(x, y)`
- 构造器引用：例如`int[]::new`是一个构造器引用等价于`x -> new int[x]`
- 变量作用域：lambda表达式访问外围方法或类中变量。通过捕获(capture)变量(事实最变量effective final)
- 处理lambda表达式：延迟执行(deferred execution)
  1. 一个单独线程中运行的代码
  2. 多次运行代码
  3. 在算法的适当位置运行代码
  4. 发生某种情况时执行代码
  5. 在必要时才运行的代码

## 内部类
内部类(inner class)：定义在另一个类中的类：1.内部类可以对同一个包中的其他类进行隐藏 2.内部类方法可以访问定义这个类的作用域的数据和私有数据

- 访问对象状态
- 特殊语法规则：对外围类的引用
- 内部类的使用问题：内部类是一个编译器现象，与虚拟机无关
- 局部内部类：只用了一次，则可以**局部定义**这个类
- 外部方法访问变量：局部变量必须是事实最终变量
- 匿名内部类(anonymous inner class)：只创建一个类的对象，可以不需要为类指定名字
- 静态内部类：内部类不访问外围类的对象，就可以使用静态内部类。有些程序员使用嵌套类表示静态内部类 

## 服务加载器
开发采用一个服务架构的应用
- `ServiceLoader`类可以加载一个公共的服务接口
.......

## 代理
代理(proxy)：在编译时期无法确定需要实现哪种接口时才有必要使用代理。
.......