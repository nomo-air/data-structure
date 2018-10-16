原创者地址：https://github.com/liuyubobobo

### 数组基础
```
定义：把数据码成一排进行存放
数组最大的优点：快速查询
数组最好应用于"索引有语义"的情况
```

#### 数组简单的复杂度分析
```
大O描述的是算法的运行时间和输入数据之间的关系
增：O(n)
删：O(n)
改：已知索引O(1)，未知索引O(n)
查：已知索引O(1)，未知索引O(n)
```

#### 均摊复杂度
```
resize：O(n)
addLast的均摊复杂度为O(1)
假设capacity = n, n+1次addLast，触发resize，总共进行了2n+1次基本操作，平均每次addLast操作，进行2次基本操作
```

#### 复杂度震荡
```
出现问题的原因：removeLast时resizeguoyu着急（Eager）
解决方案：Lazy
当size == capacity / 4时，才将capacity减半
```

### 栈 Stack
```
栈也是一种线性结构，相比数组，栈对应的操作是数组的子集，只能从一端添加元素，也只能从一端取出元素，这一端成为栈顶，
栈是一种后进先出的数据机构，Last In First Out(FIFO)
```

#### 栈的应用
```
无处不在的Undo操作（撤销）
程序调用的系统栈，调用子函数 
```

#### 栈的复杂度分析
```
ArrayStack<E>       O(1) 均摊
void push(E)        O(1) 均摊
E pop()             O(1)
E peek()            O(1)
int getSize()       O(1)
boolean isEmpty()   O(1)
```