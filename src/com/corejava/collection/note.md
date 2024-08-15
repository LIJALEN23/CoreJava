# 集合
一个Java实现传统数据结构的类库

## Java集合框架
- 集合接口(interface)与实现(implement)分离
- Collection接口与Map接口
  - Collection接口
  - Map接口
- 迭代器(iterator)：Collection接口扩展了Iterable接口，所以任何标准库中的任何集合都可以使用“for each”循环
  1. 迭代器遍历
  2. for each遍历
  3. forEachRemaining遍历：调用forEachRemaining方法并提供一个lambda表达式
- 泛型实用方法：Collection和Iterator都是泛型接口

## 集合框架中的接口
- Iterable
  - Collection
    - List：有序元素
    - Set：无重复元素的集
      - SortedSet
        - NavigableSet
    - Queue：元素的进出有顺序
      - Deque
- Map
  - SortedMap
    - NavigableMap
- Iterator
  - ListIterator：提供在迭代器的前面增加一个元素的方法
- RandomAccess

## 具体集合
ArrayList, LinkedList, ArrayDeque, HashSet, TreeSet, EnumSet, LinkedHashSet, PriorityQueue, HashMap, TreeMap, EnumMap, LinkedHashMap, WeakHashMap, IdentityHashMap
- 链表
- 数组列表
- 散列集：无序集合
- 树集：有序集合
- 队列与双端队列
- 优先队列：按任意顺序插入，返回有序顺序

## 映射
存放键值对
- 基本映射操作
  - 散列映射：对键进行散列
  - 树映射：对键的顺序组织成一个搜索树
- 更新映射条目：处理映射的一个难点
- 映射视图：键集、值集、键值对集
- 弱散列映射：使用弱引用(weak reference)保存键
- 链接散列集与映射：记住插入元素项的顺序
- 枚举集与映射：一个枚举类型元素集的高效实现
- 标识散列映射：键的散列值不是通过hashCode函数计算的，而是System.identityHashCode

## 视图与包装器
视图(view)：可获取实现了Collection接口或Map接口的对象
- 小集合：Java9引入的一些静态方法，生成给定元素的集或者列表以及键值对的映射
- 子范围：为集合建立子范围(subrange)视图
- 不可修改视图：Collections类的几个可生成集合的不可修改视图(unmodifiable view)
- 同步视图：多线程访问集合，必须保护集合不会被意外破坏
- 检查型视图：对泛型类型可能出现的问题提供调试支持
- 可选说明

## 算法
- 泛型算法
- 排序与混排
- 二分查找
- 简单算法
- 批操纵
- 集合与数组转换
- 设计自己算法


## 遗留算法
- Hashtable类
- 枚举
- 属性映射
- 栈
- 位集