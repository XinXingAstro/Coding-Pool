1. 问题定位<br>
编译（javac）和执行（java）java 程序时，出现这种类型的错误：找不到或无法加载主类：
首先排除是否是环境变量配置不当造成的问题，只要保证，命令行界面能够识别 javac/java 命令，就说明环境变量配置没有问题。
出现这种问题，往往是因为，java 源文件中带有包名，如文件 C:\code\Hello.java：
```java
package com.example;

public class Hello{
    public static void main(String[]args){
        System.out.println("Hello");
    }
}
```
看上去似乎没什么问题，执行：
```shell script
C:\code>javac Hello.java
C:\code>java Hello
错误: 找不到或无法加载主类 Hello
```
2. 解决方案<br>
1) 源文件中删除包名（不提倡）；<br>
2) 在 code 下创建与包名相同的文件路径结构（C:\code\com\example\Hello.java）
```shell script
编译:C:\code>javac com/example/Hello.java
运行:C:\code>java com.example.Hello
```
**3) 系统环境变量里不要包含CLASSPATH**