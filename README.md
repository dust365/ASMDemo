# ASM Demo

## 整体学习笔记
* 受到高手课启发  https://time.geekbang.org/column/article/82761?screen=full 
* AspectJ、ASM、ReDex 三种插桩方案，仅仅现在用到Asm 练习
* 核心就是编译期利用gradle plugin 获取类观察器，在AdviceAdapter 进行修改
* 便携式字节码文件 是难点 可以采用  ASM Bytecode Viewer Support Kotlin 插件辅助编写
*  插件发布到本地然后进行本地依赖调试，后期可以发布到maven



先在编译 asm-gradle-plugin 模块中的 buildAndPublishToLocalMaven

然后可以在ASMSample尝试效果，编译修改后的class文件在ASMSample/build/ASMTraceTransform/classes中

ASM的核心代码在ASMCode中，我们也可以尝试在里面增加一些其他的功能

例如
1. 给某个方法增加 try catch
2.直接替换方法的实现


# 最后如果复习到高手课  27 | 编译插桩的三种方法：AspectJ、ASM、ReDex 进行学习

