原创者地址：https://github.com/liuyubobobo
6-13练习待完成
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
ArrayStack<E>       
void push(E)        O(1) 均摊
E pop()             O(1) 均摊
E peek()            O(1)
int getSize()       O(1)
boolean isEmpty()   O(1)
```

### 队列 Queue
```
队列也是一种线性结构，相比数组，队列对应的操作是数组的子集，只能从一端(队尾)添加元素，只能从另一端(队首)取出元素
队列是一种先进先出的数据结构（先到先得），First In First Out（FIFO）
```

#### 数组队列的复杂度分析
```
ArrayQueue<E>       
void enqueue(E)     O(1) 均摊
E dequeue()         O(n)
E front()           O(1)
int getSize()       O(1)
boolean isEmpty()   O(1)
```

#### 循环队列的复杂度分析
```
LoopQueue<E>        
void enqueue(E)     O(1) 均摊 
E dequeue()         O(1) 均摊 
E getFront()        O(1) 
int getSize()       O(1) 
boolean isEmpty()   O(1)
```

### 链表(Linked List)
```
数据存储在节点(Node)中
动态数组、栈、队列底层依托静态数组，靠resize解决固定容量问题
优点：真正的动态数据结构，不需要处理固定容量的问题
缺点：丧失了随机访问的能力
```

#### 链表的时间复杂度分析
```
添加操作                 O(n)
    addLast(e)          O(n)
    addFirst            O(1)
    add(index,e)        O(n/2) = O(n)
删除操作                 O(n)
    removeLast(e)       O(n)
    removeFirst(e)      O(1)
    remove(index,e)     O(n/2) = O(n)
修改操作                 O(n)
    set(index,e)        O(n)
查找操作                 O(n)
    get(e)              O(n)
    contains(e)         O(n)
```

### 二叉树
```
和链表一样，动态数据结构
二叉树具有唯一根节点
二叉树每个节点最多有两个孩子
二叉树每个节点最多有一个父亲
二叉树具有天然的递归结构
每个节点的左子树也是二叉树
每个节点的右子树也是二叉树
二叉树不一定是满的
一个节点也是二叉树
null也是二叉树
```

### 二分搜索树
```
二分搜索树是二叉树
二分搜索树的每个节点的值：
    大于其左子树的所有节点的值
    小于其右子树的所有节点的值
每一棵子树也是二分搜索树
储存的元素必须有可比较性    
```

### 完全二叉树
```
把元素顺序排成树的形状
```

### 平衡二叉树
```
最大深度与最小深度之间的差最多为1
```

#### 递归
```
本质上，将原来的问题，转化为更小的同一个问题
递归调用是有代价的：函数调用 + 系统栈空间
```

### 集合
```
Set<E>
void add(E)
void remove(E)
boolean contains(E)
int getSize()
boolean isEmpty
```
h代表树的高度
```
                LinkedListSet       BSTSet  平均     最差
增add           O(n)                 O(h)   O(logn)  O(n)
查contains      O(n)                 O(h)   O(logn)  O(n)
删remove        O(n)                 O(h)   O(logn)  O(n)
```

### 映射
```
Map<K,V>
void add(K,V)
V remove(K)
boolean contains(K)
V get(K)
void set(K,V)
int getSize()
boolean isEmpty()
```
```
                LinkedListMap       BSTMap  平均      最差
 增 add         O(n)                 O(h)    O(logn)  O(n)
 删 remove      O(n)                 O(h)    O(logn)  O(n)
 改 set         O(n)                 O(h)    O(logn)  O(n)
 查 get         O(n)                 O(h)    O(logn)  O(n)
 查 contains    O(n)                 O(h)    O(logn)  O(n)
```

### 优先队列
```
                入队          出队
普通线性结构      O(1)         O(n)
顺序线性结构      O(n)         O(1)
堆              O(logn)      O(logn)    
```

### 二叉堆的性质
```
堆中某个节点的值总是不大于其父节点的值
最大堆（相应的可以定义最小堆）
可以用数组来表示
```

### Heapify（堆化）
```
将n个元素插入到一个空堆中，算法复杂度是O(nlogn)
heapify的过程，算法复杂度为O(n)
```

### 线段树（区间树）Segment Tree
```
线段树不是完全二叉树
线段树是平衡二叉树
堆也是平衡二叉树
依然可以用数组来表示，4倍足够
``` 

### Trie (字典)
```
查询每个条目的时间复杂度，和字典中一共有多少条目无关。
时间复杂度为O(w)，w为查询单词的长度

```