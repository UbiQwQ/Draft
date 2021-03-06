# 反射 Java Reflection

## 反射基本概念
反射机制允许程序在执行期借助于 Reflection API 取得任何类的内部信息(比如成员变量，构造器，成员方法等等)，并能操作对象的属性及方法。
反射在设计模式和框架底层都会用到。

加载完类之后，在堆中就产生了一个 Class类型的对象 (一个类只有一个Class对象)，这个对象包含了类的完整结构信息。
通过这个对象得到类的结构。这个对象就像一面镜子，透过这个镜子看到类的结构,所以,形象的称之为:反射


## 反射原理

src\main\java\reflect\reflect1.png

## 反射可以做什么？
- 在运行时判断任意一个对象所属的类
- 在运行时构造任意一个类的对象
- 在运行时得到任意一个类所具有的成员变量和方法
- 在运行时调用任意一个对象的成员变量和方法
- 生成动态代理


## 反射相关的主要类
java.lang.Class:                代表一个类, Class对象表示某个类加载后在堆中的对象

java.lang.reflect.Method:       代表类的方法

java.lang.reflect.Field:        代表类的成员变量

java.lang.reflect.Constructor:  代表类的构造方法

这些类在 java.lang.reflection 包下

## 反射的优缺点
### 优点
可以动态的创建和使用对象(也是框架底层核心),使用灵活。没有反射机制，框架技术就失去底层支撑。
### 缺点
使用反射基本是解释执行,对执行速度有影响。


## 反射调用优化-关闭访问检查
Method、Field和Constructor对象都有setAccessible()方法。
三个Class都间接或直接继承了AccessibleObject类。

setAccessible作用是启动和禁用访问安全检查的开关。
参数值为true表示反射的对象在使用时取消访问检查,提高反射的效率。
参数值为false则表示反射的对象执行访问检查。




