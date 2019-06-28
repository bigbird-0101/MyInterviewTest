package com.annotation.chapter1;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
/*
 * RetentionPolicy为java api枚举类,
 * 看其 @Retention源码知道 这个注解有一个属性为RetentionPolicy 它有3个值   SOURCE,CLASS,RUNTIME
 * 
 *  SOURCE:在源码中的注释->Annotations are to be discarded by the compiler
 *  翻译过来说就是：注解将被编译器丢弃
 *  意思就是讲：这个注解的意思是让MyFirstAnntation注解只在java源文件中存在，编译成.class文件后注解就不存在了
 *  这个值几乎很少用到
 *  
 *  CLASS:在源码中的注释->Annotations are to be recorded in the class file by the compiler
 *  but need not be retained by the VM at run time.  This is the default
 *  behavior.
 *  翻译过来说：注解由编译器记录在类文件中，但是不需要在运行时被VM保留。这是默认的行为。
 *  意思就是讲：在编译后的class文件中存在，但是在运行时是不存在的
 *  这个值也是比较少用到的
 *  
 *  RUNTIME:在源码中的注释->Annotations are to be recorded in the class file by the compiler and
 *  retained by the VM at run time, so they may be read reflectively.
 *  翻译过来说：注解由编译器记录在类文件中，并且在jvm中也会被保存的，所以它可以用反射来读取
 *  意思就是讲：在编译后的class文件中存在，但是在运行时是存在的
 *  
 *  由于他只能加在注解类型上，所以网上都叫他元注解，那我们也叫它元注解，好像高大上一点哈哈哈哈。
 */

@Target(ElementType.FIELD)
/*
 * ElementType为java api枚举类,
 *  看其 @Target源码知道 这个注解有一个属性为ElementType
 *  看其源码：特么有8个值吊了，难怪这么注解这么好用，特么哪里都可以用注解
 *  TYPE->可以用在类上面
 *  FIELD->用在字段属性上面
 *  METHOD->用在方法上面
 *  PARAMETER->用在方法参数上
 *  CONSTRUCTOR->用在构造函数上  卧槽吊了
 *  LOCAL_VARIABLE->用在局部变量上 我的天
 *  ANNOTATION_TYPE->用在注解上面
 *  PACKAGE->用在包上面   膜拜
 *  
 *  到这里就知道了这个注解是规定自定义注解的在java文件中的使用范围
 *  
 *  由于他只能加在注解类型上，所以网上都叫他元注解，那我们也叫它元注解，好像高大上一点哈哈哈哈。
 */

@Documented
/**
 *  注解表明这个是由 javadoc记录的，在默认情况下也有类似的记录工具。
 *  如果一个类型声明被注释了文档化，它的注释成为公共API的一部分。
 */
/**
 * 这个注解
 * @author corget
 *
 */
public @interface MyFirstAnntation {

}
//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     