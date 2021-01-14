# 类加载作业的字节码

    Classfile /E:/02_workspace/JAVA-01/Week_01/lesson_0106/target/classes/training/classloader/HelloClassLoader.class
    Last modified 2021-1-10; size 2494 bytes
    MD5 checksum 1fe9f35a0e59883adb9dfacb750caabd
    Compiled from "HelloClassLoader.java"
    public class training.classloader.HelloClassLoader extends java.lang.ClassLoader
    minor version: 0
    major version: 52
    flags: ACC_PUBLIC, ACC_SUPER          //访问标识
    Constant pool:                        //常量池
    #1 = Methodref          #22.#76       // java/lang/ClassLoader."<init>":()V
    #2 = Class              #77           // training/classloader/HelloClassLoader
    #3 = Methodref          #2.#76        // training/classloader/HelloClassLoader."<init>":()V
    #4 = String             #78           // Hello
    #5 = Methodref          #2.#79        // training/classloader/HelloClassLoader.findClass:(Ljava/lang/String;)Ljava/lang/Class;
    #6 = Methodref          #80.#81       // java/lang/Class.newInstance:()Ljava/lang/Object;
    #7 = String             #34           // hello
    #8 = Methodref          #80.#82       // java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    #9 = Methodref          #83.#84       // java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    #10 = Methodref          #85.#86       // java/lang/Object.getClass:()Ljava/lang/Class;
    #11 = Methodref          #80.#87       // java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
    #12 = String             #88           // Hello.xlass
    #13 = Methodref          #22.#89       // java/lang/ClassLoader.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
    #14 = Class              #90           // java/io/ByteArrayOutputStream
    #15 = Methodref          #14.#76       // java/io/ByteArrayOutputStream."<init>":()V
    #16 = Methodref          #91.#92       // java/io/InputStream.read:([B)I
    #17 = Methodref          #14.#93       // java/io/ByteArrayOutputStream.write:([BII)V
    #18 = Methodref          #14.#94       // java/io/ByteArrayOutputStream.toByteArray:()[B
    #19 = Methodref          #2.#95        // training/classloader/HelloClassLoader.defineClass:(Ljava/lang/String;[BII)Ljava/lang/Class;
    #20 = Class              #96           // java/lang/Throwable
    #21 = Methodref          #97.#98       // lombok/Lombok.sneakyThrow:(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    #22 = Class              #99           // java/lang/ClassLoader
    #23 = Utf8               <init>
    #24 = Utf8               ()V
    #25 = Utf8               Code
    #26 = Utf8               LineNumberTable
    #27 = Utf8               LocalVariableTable
    #28 = Utf8               this
    #29 = Utf8               Ltraining/classloader/HelloClassLoader;
    #30 = Utf8               main
    #31 = Utf8               ([Ljava/lang/String;)V
    #32 = Utf8               args
    #33 = Utf8               [Ljava/lang/String;
    #34 = Utf8               hello
    #35 = Utf8               Ljava/lang/Class;
    #36 = Utf8               o
    #37 = Utf8               Ljava/lang/Object;
    #38 = Utf8               declaredMethod
    #39 = Utf8               Ljava/lang/reflect/Method;
    #40 = Utf8               LocalVariableTypeTable
    #41 = Utf8               Ljava/lang/Class<*>;
    #42 = Utf8               Exceptions
    #43 = Class              #100          // java/io/IOException
    #44 = Class              #101          // java/lang/IllegalAccessException
    #45 = Class              #102          // java/lang/InstantiationException
    #46 = Class              #103          // java/lang/reflect/InvocationTargetException
    #47 = Class              #104          // java/lang/NoSuchMethodException
    #48 = Utf8               MethodParameters
    #49 = Utf8               findClass
    #50 = Utf8               (Ljava/lang/String;)Ljava/lang/Class;
    #51 = Utf8               i
    #52 = Utf8               I
    #53 = Utf8               resourceAsStream
    #54 = Utf8               Ljava/io/InputStream;
    #55 = Utf8               out
    #56 = Utf8               Ljava/io/ByteArrayOutputStream;
    #57 = Utf8               buffer
    #58 = Utf8               [B
    #59 = Utf8               n
    #60 = Utf8               bytes
    #61 = Utf8               $ex
    #62 = Utf8               Ljava/lang/Throwable;
    #63 = Utf8               name
    #64 = Utf8               Ljava/lang/String;
    #65 = Utf8               StackMapTable
    #66 = Class              #77           // training/classloader/HelloClassLoader
    #67 = Class              #105          // java/lang/String
    #68 = Class              #106          // java/io/InputStream
    #69 = Class              #90           // java/io/ByteArrayOutputStream
    #70 = Class              #58           // "[B"
    #71 = Class              #96           // java/lang/Throwable
    #72 = Utf8               Signature
    #73 = Utf8               (Ljava/lang/String;)Ljava/lang/Class<*>;
    #74 = Utf8               SourceFile
    #75 = Utf8               HelloClassLoader.java
    #76 = NameAndType        #23:#24       // "<init>":()V
    #77 = Utf8               training/classloader/HelloClassLoader
    #78 = Utf8               Hello
    #79 = NameAndType        #49:#50       // findClass:(Ljava/lang/String;)Ljava/lang/Class;
    #80 = Class              #107          // java/lang/Class
    #81 = NameAndType        #108:#109     // newInstance:()Ljava/lang/Object;
    #82 = NameAndType        #110:#111     // getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    #83 = Class              #112          // java/lang/reflect/Method
    #84 = NameAndType        #113:#114     // invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    #85 = Class              #115          // java/lang/Object
    #86 = NameAndType        #116:#117     // getClass:()Ljava/lang/Class;
    #87 = NameAndType        #118:#119     // getClassLoader:()Ljava/lang/ClassLoader;
    #88 = Utf8               Hello.xlass
    #89 = NameAndType        #120:#121     // getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
    #90 = Utf8               java/io/ByteArrayOutputStream
    #91 = Class              #106          // java/io/InputStream
    #92 = NameAndType        #122:#123     // read:([B)I
    #93 = NameAndType        #124:#125     // write:([BII)V
    #94 = NameAndType        #126:#127     // toByteArray:()[B
    #95 = NameAndType        #128:#129     // defineClass:(Ljava/lang/String;[BII)Ljava/lang/Class;
    #96 = Utf8               java/lang/Throwable
    #97 = Class              #130          // lombok/Lombok
    #98 = NameAndType        #131:#132     // sneakyThrow:(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    #99 = Utf8               java/lang/ClassLoader
    #100 = Utf8               java/io/IOException
    #101 = Utf8               java/lang/IllegalAccessException
    #102 = Utf8               java/lang/InstantiationException
    #103 = Utf8               java/lang/reflect/InvocationTargetException
    #104 = Utf8               java/lang/NoSuchMethodException
    #105 = Utf8               java/lang/String
    #106 = Utf8               java/io/InputStream
    #107 = Utf8               java/lang/Class
    #108 = Utf8               newInstance
    #109 = Utf8               ()Ljava/lang/Object;
    #110 = Utf8               getDeclaredMethod
    #111 = Utf8               (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    #112 = Utf8               java/lang/reflect/Method
    #113 = Utf8               invoke
    #114 = Utf8               (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    #115 = Utf8               java/lang/Object
    #116 = Utf8               getClass
    #117 = Utf8               ()Ljava/lang/Class;
    #118 = Utf8               getClassLoader
    #119 = Utf8               ()Ljava/lang/ClassLoader;
    #120 = Utf8               getResourceAsStream
    #121 = Utf8               (Ljava/lang/String;)Ljava/io/InputStream;
    #122 = Utf8               read
    #123 = Utf8               ([B)I
    #124 = Utf8               write
    #125 = Utf8               ([BII)V
    #126 = Utf8               toByteArray
    #127 = Utf8               ()[B
    #128 = Utf8               defineClass
    #129 = Utf8               (Ljava/lang/String;[BII)Ljava/lang/Class;
    #130 = Utf8               lombok/Lombok
    #131 = Utf8               sneakyThrow
    #132 = Utf8               (Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    {
    public training.classloader.HelloClassLoader();   //类的无参构造器
    descriptor: ()V 
    flags: ACC_PUBLIC
    Code:
    stack=1, locals=1, args_size=1       //arg_size = 1 构造器讲this作为参数
    0: aload_0                           //this 入栈
    1: invokespecial #1                  // Method java/lang/ClassLoader."<init>":()V //调用构造方法
    4: return                            //
    LineNumberTable:
    line 14: 0
    LocalVariableTable:
    Start  Length  Slot  Name   Signature
    0       5     0  this   Ltraining/classloader/HelloClassLoader;
    
    public static void main(java.lang.String[]) throws java.io.IOException, java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException;
    descriptor: ([Ljava/lang/String;)V    //[Ljava/lang/String string 数组参数
    flags: ACC_PUBLIC, ACC_STATIC         //访问标识 公共的 静态的
    Code:
    stack=3, locals=4, args_size=1        //stack 操作数栈深度3 locals局部变量表slot为4 arg_size 参数一个 
    0: new           #66                 // class training/classloader/HelloClassLoader //new创建对象并将对象引用入栈 #66 标识对应着常量池中索引为66的常量
    3: dup                               //复制栈顶的对象引用并压入栈顶
    4: invokespecial #3                  // Method training/classloader/HelloClassLoader."<init>":()V //调用对象的HelloClassLoader的构造方法
    7: ldc           #4                  // String Hello  //将常量池索引#4 压入栈顶
    9: invokevirtual #5                  // Method training/classloader/HelloClassLoader.findClass:(Ljava/lang/String;)Ljava/lang/Class; //执行HelloClassLoader的findClass参数为序号7指令的常量
    12: astore_1                         // 将findClass的返回值出栈放入局部变量slot 为1的槽位
    13: aload_1                          //局部变量slot 为1的值压入栈顶
    14: invokevirtual #6                  // Method java/lang/Class.newInstance:()Ljava/lang/Object; //调用常量#6对应的方法即newInstance
    17: astore_2                          //将newInstance的返回值出栈放入局部变量Slot为2的槽位
    18: aload_1                           //局部变量slot 为1的值压入栈顶
    19: ldc           #7                  // String hello  //将常量池索引#7  压入栈顶
    21: aconst_null                       //将null压入栈顶
    22: invokevirtual #8                  // Method java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;//调用常量池索引#8的方法即getDeclaredMethod
    25: astore_3                          //将getDeclaredMethod返回值出栈放入局部变量slot 为3的槽位
    26: aload_3                           //局部变量slot 为3的值压入栈顶（）
    27: aload_2                           //局部变量slot 为2的值压入栈顶
    28: aconst_null                       //将null压入栈顶
    29: invokevirtual #9                  // Method java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object; //调用常量池索引 #9的方法即invoke
    32: pop                               //将栈顶的值弹出
    33: return
    LineNumberTable:
    line 18: 0                            //行号18对应字节码序号0
    line 19: 13
    line 20: 18
    line 21: 26
    line 22: 33
    LocalVariableTable:
    Start  Length  Slot  Name   Signature  
    0      34     0  args   [Ljava/lang/String; //参数arg作用域为序号0到33 范围：start到 start+length-1
    13      21     1 hello   Ljava/lang/Class;  //参数hello作用域为序号13到33
    18      16     2     o   Ljava/lang/Object;
    26       8     3 declaredMethod   Ljava/lang/reflect/Method;
    LocalVariableTypeTable:
    Start  Length  Slot  Name   Signature
    13      21     1 hello   Ljava/lang/Class<*>;
    Exceptions:
    throws java.io.IOException, java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException
    MethodParameters:
    Name                           Flags
    args
    
    protected java.lang.Class<?> findClass(java.lang.String);
    descriptor: (Ljava/lang/String;)Ljava/lang/Class;
    flags: ACC_PROTECTED
    Code:
    stack=5, locals=8, args_size=2
    0: aload_0
    1: invokevirtual #10                 // Method java/lang/Object.getClass:()Ljava/lang/Class;
    4: invokevirtual #11                 // Method java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
    7: ldc           #12                 // String Hello.xlass
    9: invokevirtual #13                 // Method java/lang/ClassLoader.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
    12: astore_2
    13: new           #69                 // class java/io/ByteArrayOutputStream
    16: dup
    17: invokespecial #15                 // Method java/io/ByteArrayOutputStream."<init>":()V
    20: astore_3
    21: sipush        4096                //将常量值4096压入栈顶
    24: newarray       byte               //创建一个byte的数组
    26: astore        4                   //将byte数组出栈放入slot为4的槽位
    28: iconst_0                          //将常量值0压入栈顶
    29: istore        5                   //将int值为slot为5的槽位
    31: aload_2
    32: aload         4
    34: invokevirtual #16                 // Method java/io/InputStream.read:([B)I
    37: dup
    38: istore        5
    40: iconst_m1                         //将int值为-1压入栈顶
    41: if_icmpeq     56                  //比较两个int值大小 结果等于0 跳转到序号56
    44: aload_3
    45: aload         4
    47: iconst_0
    48: iload         5
    50: invokevirtual #17                 // Method java/io/ByteArrayOutputStream.write:([BII)V
    53: goto          31                  //无条件跳转到序号31
    56: aload_3
    57: invokevirtual #18                 // Method java/io/ByteArrayOutputStream.toByteArray:()[B
    60: astore        6
    62: iconst_0
    63: istore        7
    65: iload         7
    67: aload         6
    69: arraylength                       //获取数组的长度压入栈顶
    70: if_icmpge     94                  //比较两个int值大小 结果大于或等于0 跳转到序号94
    73: aload         6
    75: iload         7
    77: sipush        255
    80: aload         6
    82: iload         7
    84: baload                            //获取byte数组指定的索引即代码的i的压入栈顶
    85: isub                              //两个int 相减并将结果压入栈顶 代码处：255 - bytes[i]
    86: i2b                               //int转byte 
    87: bastore                           //将栈顶值存入指定的byte数组索引
    88: iinc          7, 1                //slot 7 的值自增1
    91: goto          65
    94: aload_0
    95: aload_1
    96: aload         6
    98: iconst_0
    99: aload         6
    101: arraylength
    102: invokevirtual #19                 // Method training/classloader/HelloClassLoader.defineClass:(Ljava/lang/String;[BII)Ljava/lang/Class;
    105: areturn                         //返回当前方法的引用
    106: astore_2
    107: aload_2
    108: athrow                          //将栈顶的异常抛出
    Exception table:
    from    to  target type
    0   105   106   Class java/lang/Throwable   //异常范围偏移量0 到偏移量105 出现异常跳转值106
    StackMapTable: number_of_entries = 5
    frame_type = 255 /* full_frame */
    offset_delta = 31
    locals = [ class training/classloader/HelloClassLoader, class java/lang/String, class java/io/InputStream, class java/io/ByteArrayOutputStream, class "[B", int ]
    stack = []
    frame_type = 24 /* same */
    frame_type = 253 /* append */
    offset_delta = 8
    locals = [ class "[B", int ]
    frame_type = 250 /* chop */
    offset_delta = 28
    frame_type = 255 /* full_frame */
    offset_delta = 11
    locals = [ class training/classloader/HelloClassLoader, class java/lang/String ]
    stack = [ class java/lang/Throwable ]
    LineNumberTable:
    line 27: 0
    line 28: 13
    line 29: 21
    line 30: 28
    line 31: 31
    line 32: 44
    line 34: 56
    line 35: 62
    line 36: 73
    line 35: 88
    line 38: 94
    line 24: 106
    LocalVariableTable:
    Start  Length  Slot  Name   Signature
    65      29     7     i   I
    13      93     2 resourceAsStream   Ljava/io/InputStream;
    21      85     3   out   Ljava/io/ByteArrayOutputStream;
    28      78     4 buffer   [B
    31      75     5     n   I
    62      44     6 bytes   [B
    107       2     2   $ex   Ljava/lang/Throwable;    //  $ex 异常变量
    0     109     0  this   Ltraining/classloader/HelloClassLoader;
    0     109     1  name   Ljava/lang/String;
    Signature: #73                          // (Ljava/lang/String;)Ljava/lang/Class<*>; //方法签名
    MethodParameters:
    Name                           Flags
    name
    }
    SourceFile: "HelloClassLoader.java"