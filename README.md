### 算法
### 数组
把数据码成一排存放
![数组](https://github.com/nomo-air/data-structure/blob/master/images/1-1.png)

```
数组最大的优点：快速查询，scores[2]
数组最好应用于“索引有语意”的情况，但并非所有有语意的情况都适用于数组，如身份证号，原因，太大
```
#### 向指定位置添加元素
![数组](https://github.com/nomo-air/data-structure/blob/master/images/1-2.png)

元素后移
![数组](https://github.com/nomo-air/data-structure/blob/master/images/1-3.png)

#### 删除指定位置元素
![数组](https://github.com/nomo-air/data-structure/blob/master/images/1-4.png)

这里的第二个100可以置空，可以不置空，不置空也是安全的，因为它无法被访问到
<img src="https://github.com/nomo-air/data-structure/blob/master/images/1-5.png"/>

#### 动态扩容
<img src="https://github.com/nomo-air/data-structure/blob/master/images/1-6.png"/>

<img src="https://github.com/nomo-air/data-structure/blob/master/images/1-7.png"/>

#### 数组简单的复杂度分析
添加操作
```
addLast(e)     O(1)
addFirst(e)    O(n)
add(index,e)   O(n/2) = O(n)
resize         O(n)
整体来讲添加操作复杂度 O(n)
```

删除操作
```
removeLast(e)	  O(1)
removeFirst(e)	  O(n)
remove(index,e)   O(n/2) = O(n)
resize            O(n)
整体来讲添删除操作复杂度 O(n)
```

修改操作
```
set(index, e)     O(1)  // 已知索引
```

查询操作
```
get(index)      O(1)
contains(e)     O(n)
find(e)         O(n)
```

均摊复杂度
```
假设当前capacity = 8，并且每一次添加操作都使用addLast，9次addLast操作，触发resize，总共进行了17次基本操作。
假设capacity = n, n+1次addLast，触发resize，总共进行2n+1次几本操作。
平均，每次addLast操作，进行2次基本操作，这样均摊计算，时间复杂度是O(1)的。
```
复杂度震荡
```
resize         O(n)
removeLast时resize过于着急（Eager）
解决方案：Lazy
当size == capacity / 4 时，才将capacity减半

```

### 栈 Stack
```
栈也是一种线性结构
相比数组，栈对应的操作是数组的子集
只能从一端添加元素，也只能从一端取出元素
这一端称为栈顶
```
<img src="https://github.com/nomo-air/data-structure/blob/master/images/2-1.png" height="10" width="10" />
栈是一种后进先出的数据结构<br>
Last In First Out（LIFO）

#### 常见应用
<img src="https://github.com/nomo-air/data-structure/blob/master/images/2-2.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/2-3.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/2-4.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/2-5.png" height="10" width="10" />

#### 栈的复杂度分析
```
ArrayStack<E>       
void push(E)        O(1) 均摊
E pop()             O(1) 均摊
E peek()            O(1)
int getSize()       O(1)
boolean isEmpty()   O(1)
```

###  队列 Queue
```
队列也是一种线性结构
相比数组，队列对应的操作是数组的子集
只能从一端（队尾）添加元素，只能从另一端（队首）取出元素
队列是一种先进先出的数据结构（先到先得），First In First Out（FIFO）
```
<img src="https://github.com/nomo-air/data-structure/blob/master/images/3-1.png" height="10" width="10" />

删除队首元素（a）
<img src="https://github.com/nomo-air/data-structure/blob/master/images/4-1.png" height="10" width="10" />

删除后
<img src="https://github.com/nomo-air/data-structure/blob/master/images/4-2.png" height="10" width="10" />

#### 数组队列的复杂度分析
```
ArrayQueue<E>       
void enqueue(E)     O(1) 均摊
E dequeue()         O(n) // 出队
E front()           O(1)
int getSize()       O(1)
boolean isEmpty()   O(1)
```

### 循环队列
front == tail 队列为空
<img src="https://github.com/nomo-air/data-structure/blob/master/images/5-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/5-2.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/5-3.png" height="10" width="10" />

(tail + 1) % c == front 队列满
capacity中，浪费了一个空间
<img src="https://github.com/nomo-air/data-structure/blob/master/images/5-4.png" height="10" width="10" />

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

```java
class Node {
    E e;
    Node next;
}
```

#### 在链表头添加元素
<img src="https://github.com/nomo-air/data-structure/blob/master/images/6-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/6-2.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/6-3.png" height="10" width="10" />

在索引为2的地方添加元素666
关键点在于找到要添加节点的前一个节点
<img src="https://github.com/nomo-air/data-structure/blob/master/images/6-4.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/6-5.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/6-6.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/6-7.png" height="10" width="10" />

顺序很重要
<img src="https://github.com/nomo-air/data-structure/blob/master/images/6-8.png" height="10" width="10" />

#### 链表(虚拟头节点)
<img src="https://github.com/nomo-air/data-structure/blob/master/images/7-1.png" height="10" width="10" />

#### 删除索引为2位置的元素
<img src="https://github.com/nomo-air/data-structure/blob/master/images/7-2.png" height="10" width="10" />

链表元素删除常见的错误
<img src="https://github.com/nomo-air/data-structure/blob/master/images/7-3.png" height="10" width="10" />

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
    find(e)             O(n) // 就算查到e，也不能拿e的索引直接访问，无需实现
```

什么情况下使用链表
<img src="https://github.com/nomo-air/data-structure/blob/master/images/7-4.png" height="10" width="10" />

使用链表实现栈

使用链表实现队列
<img src="https://github.com/nomo-air/data-structure/blob/master/images/8-1.png" height="10" width="10" />

#### 双链表
单链表删除末尾元素复杂度任然是O(n)，可以用双链表来解决
```java
class Node {
    E e;
    Node next, prev;
}
```
<img src="https://github.com/nomo-air/data-structure/blob/master/images/9-1.png" height="10" width="10" />

#### 循环链表
循环链表的好处是进一步把操作进行了统一，比如向链表结尾添加元素，不需要用tail一直指着结尾，我们用循环链表，直接在dummyHead前添加元素就是在链表末尾添加元素
<img src="https://github.com/nomo-air/data-structure/blob/master/images/11-1.png" height="10" width="10" />

#### 数组链表
```
class Node {
    E e;
    int next;
}
```
<img src="https://github.com/nomo-air/data-structure/blob/master/images/12-1.png" height="10" width="10" />



### 递归
```
本质上，将原来的问题，转化为更小的同一个问题
递归调用是有代价的：函数调用 + 系统栈空间
```
链表有天然的递归性质
<img src="https://github.com/nomo-air/data-structure/blob/master/images/10-1.png" height="10" width="10" />

#### 删除链表中元素
<img src="https://github.com/nomo-air/data-structure/blob/master/images/10-2.png" height="10" width="10" />

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
```java
class Node {
    E e;
    Node left;
    Node right;
}
```
<img src="https://github.com/nomo-air/data-structure/blob/master/images/13-1.png" height="10" width="10" />

#### 二分搜索树
Binary Search Tree
```
二分搜索树是二叉树
二分搜索树的每个节点的值：
    大于其左子树的所有节点的值
    小于其右子树的所有节点的值
每一棵子树也是二分搜索树
储存的元素必须有可比较性    
```
<img src="https://github.com/nomo-air/data-structure/blob/master/images/14-1.png" height="10" width="10" />

#### 二分搜索树添加元素
<img src="https://github.com/nomo-air/data-structure/blob/master/images/14-2.png" height="10" width="10" />
```
我们的二分搜索树不包含重复元素
如果想包含重复元素的话，只需要定义：
	左子树小于等于节点；或者右子树大于等于节点
注意：我们之前讲的数组和链表，可以有重复元素	
```

#### 二分搜索树的遍历
<img src="https://github.com/nomo-air/data-structure/blob/master/images/14-3.png" height="10" width="10" />

```
前序遍历 // 28，16，13，22，30，29，42
中序遍历，结果是顺序的 // 13，16，22，28，29，30，42
后序遍历 // 13，22，16，29，42，30，28
```

二分搜索树前序遍历的非递归实现
<img src="https://github.com/nomo-air/data-structure/blob/master/images/15-1.png" height="10" width="10" />
```
28入栈
28出栈
30，16入栈
16出栈
22，13入栈
13出栈
```

#### 二分搜索树的层序遍历
<img src="https://github.com/nomo-air/data-structure/blob/master/images/16-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/16-2.png" height="10" width="10" />

```
28入队
28出队
16，30入队
16出队
13，22入队
```

#### 深度优先和广度优先
二分搜索树的最小值和最大值
<img src="https://github.com/nomo-air/data-structure/blob/master/images/17-1.png" height="10" width="10" />

#### 二分搜索树删除节点
```
对于带删除的节点，左子树或右子树为空，好处理，较难的是删除一个左右子树都不为空的节点
1962年，Hibbard提出 - Hibbard Deletion
```
```
删除左右都有孩子的节点d
找到 s = min(d -> right)
s 是 d 的后继
s -> rigth = delMin(d -> right)
s -> left = d -> left
删除d，s是新的子树的根
```
<img src="https://github.com/nomo-air/data-structure/blob/master/images/18-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/18-2.png" height="10" width="10" />
或者找s的前驱
<img src="https://github.com/nomo-air/data-structure/blob/master/images/18-3.png" height="10" width="10" />

#### floor & ceil
```
二分搜索树的floor和ceil
floor // 比45小的最大的元素
ceil // 比45大的最小的元素
与前驱和后继不同的是floor和ceil可以不在二分搜索树中
```
<img src="https://github.com/nomo-air/data-structure/blob/master/images/19-1.png" height="10" width="10" />

#### rank & select
```
rank // 58是排名第几的元素？
select // 排名第10的元素是谁？
```
#### 维护size的二分搜索树
<img src="https://github.com/nomo-air/data-structure/blob/master/images/20-1.png" height="10" width="10" />

#### 维护depth的二分搜索树
<img src="https://github.com/nomo-air/data-structure/blob/master/images/21-1.png" height="10" width="10" />

#### 支持重复元素的二分搜索树
<img src="https://github.com/nomo-air/data-structure/blob/master/images/22-1.png" height="10" width="10" />

### 前驱 & 后继
```
前驱（successor）
后继（predecessor）
如果一个二叉树中序遍历顺序为1，2，3，4，5
3的前驱是2，3的后继是4
```

### 集合
set
```java
class Node {
    E e;
    Node left;
    Node right;
}

class Node {
    E e;
    Node next;
}
```
```java
Set<E>
void add(E)
void remove(E)
boolean contains(E)
int getSize()
boolean isEmpty()
```
h代表树的高度
```
                LinkedListSet       BSTSet  平均     最差
增add           O(n)                 O(h)   O(logn)  O(n)
查contains      O(n)                 O(h)   O(logn)  O(n)
删remove        O(n)                 O(h)   O(logn)  O(n)
```
#### 二分搜索树的复杂度分析
<img src="https://github.com/nomo-air/data-structure/blob/master/images/23-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/23-2.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/23-3.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/23-4.png" height="10" width="10" />

logn和n的差距
<img src="https://github.com/nomo-air/data-structure/blob/master/images/24-5.png" height="10" width="10" />

```
有序集合中的元素具有顺序性 // 基于搜索树的实现
无序集合中的元素没有顺序性 // 基于哈希表的实现
```

### 映射 | 字典
map，dict
```
储存（键，值）数据对的数据结构（Key，Value）
根据（Key），寻找（Value）
```

```java
class Node {
    K key;
    V value;
    Node left;
    Node right;
}

class Node {
    K key;
    V value;
    Node next;
}
```

```java
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

```
有序映射中的键具有有序性 // 基于搜索树的实现
无序映射中的键没有顺序性 // 基于哈希表的实现
```

### 堆
#### 优先队列
```
普通队列：先进先出，后进后出
优先队列：出队顺序和入队顺序无关，和优先级相关
```

```
                入队          出队(拿出最大元素)
普通线性结构      O(1)         O(n)
顺序线性结构      O(n)         O(1)
堆              O(logn)      O(logn)    
```

#### 完全二叉树
```
把元素顺序排成树的形状
```
<img src="https://github.com/nomo-air/data-structure/blob/master/images/25-1.png" height="10" width="10" />

### 二叉堆
```
堆中某个节点的值总是不大于其父节点的值
最大堆（相应的可以定义最小堆）
可以用数组来表示
```

用数组储存二叉堆
<img src="https://github.com/nomo-air/data-structure/blob/master/images/25-2.png" height="10" width="10" />
```
parent(i) = i/2
left child (i) = 2*i
right child (i) = 2*i + 1
```

偏移之后
<img src="https://github.com/nomo-air/data-structure/blob/master/images/25-3.png" height="10" width="10" />
```
parent(i) = （i - 1)/2
left child (i) = 2*i + 1
right child (i) = 2*i + 2
```

#### 向堆中添加元素
Sift Up // 数据上浮

添加元素52
<img src="https://github.com/nomo-air/data-structure/blob/master/images/26-1.png" height="10" width="10" />

16与52交换位置
<img src="https://github.com/nomo-air/data-structure/blob/master/images/26-2.png" height="10" width="10" />

41与52交换位置
<img src="https://github.com/nomo-air/data-structure/blob/master/images/26-3.png" height="10" width="10" />

#### 从堆中取出元素
Sift Down // 数据下沉

取出根节点62
<img src="https://github.com/nomo-air/data-structure/blob/master/images/27-1.png" height="10" width="10" />

从左向右的叶子节点16替换根节点62
<img src="https://github.com/nomo-air/data-structure/blob/master/images/27-2.png" height="10" width="10" />

根节点16与两个孩子节点比较，如果根节点比孩子节点中最大的节点还小，根节点16就和最大的孩子节点52交换位置
<img src="https://github.com/nomo-air/data-structure/blob/master/images/27-3.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/27-4.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/27-5.png" height="10" width="10" />

#### Replace
replace // 取出最大元素后，放入一个新元素
```
实现：可以先extractMax，在add，两次O(logn)的操作
实现：可以直接将对顶元素替换以后Sift Down，一次O(logn)的操作
```

####  Heapify 
heapify（堆化） // 将任意数组整理成堆的形状

```
将数组看成一个二叉堆，找到最后一个非叶子节点，也就是随后一个叶子节点的父亲节点，从这个节点到根节点，一次做Sift Down
```
<img src="https://github.com/nomo-air/data-structure/blob/master/images/28-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/28-2.png" height="10" width="10" />

```
将n个元素逐个插入到一个空堆中，算法复杂度是O(nlogn)
heapify的过程，算法复杂度为O(n)  // todo.这个有点复杂，我还没彻底搞懂
```

#### d插堆
d-ary heap
<img src="https://github.com/nomo-air/data-structure/blob/master/images/29-1.png" height="10" width="10" />

索引堆
二项堆
斐波那契堆

### 线段树 | 区间树
Segment Tree
<img src="https://github.com/nomo-air/data-structure/blob/master/images/30-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/30-2.png" height="10" width="10" />
```
线段树不是完全二叉树
线段树是平衡二叉树
堆也是平衡二叉树
依然可以用数组来表示，4倍足够
```
```
        使用数组实现          使用线段树
更新     O(n)                O(logn)
查询     O(n)                O(logn)  
```

懒惰更新
<img src="https://github.com/nomo-air/data-structure/blob/master/images/31-1.png" height="10" width="10" />

二维线段树
<img src="https://github.com/nomo-air/data-structure/blob/master/images/32-1.png" height="10" width="10" />

动态线段树
关注[5-16]
<img src="https://github.com/nomo-air/data-structure/blob/master/images/33-1-1.png" height="10" width="10" />

树状数组
Binary Index Tree

区间相关问题
RMQ（Range Minimum Query）


### 平衡二叉树
```
对于任意一个节点，左子树和右子树的高度差不能超过1
平衡二叉树的高度和节点数量之间的关系也是O(logn)的
```

### Trie
字典树or前缀树
```
查询每个条目的时间复杂度和字典中一共有多少条目无关
时间复杂度为 O(w)，w为查询单词的长度
每个节点有26个指向下个节点的指针，26个是因为英文字母的数量
```
<img src="https://github.com/nomo-air/data-structure/blob/master/images/34-1.png" height="10" width="10" />

```
class Node {
    char c;
    Node next[26]
}
```
每个节点有若干个指向下一个节点的指针
```
class Node 
	boolean isWord;
    Map<char, Node> next;
}
```
<img src="https://github.com/nomo-air/data-structure/blob/master/images/34-2.png" height="10" width="10" />

之所以叫前缀树，是在搜索每一个单词，都是在搜索这个单词的前缀

统计词频
<img src="https://github.com/nomo-air/data-structure/blob/master/images/34-3.png" height="10" width="10" />
// todo.Tire和映射 

#### 压缩字典树
Compressed Trie
Tire的局限性，最大问题：空间
<img src="https://github.com/nomo-air/data-structure/blob/master/images/35-1.png" height="10" width="10" />

#### 三分搜索树
Ternary Search Trie

查找dog
<img src="https://github.com/nomo-air/data-structure/blob/master/images/36-1.png" height="10" width="10" />
```
d = d
o > k，去k的右边找
o = o
g < i，去i的左边找
g = g
找到了dog
```

### 后缀树

子串查询（KMP，Boyer-Moore，Rabin-Karp）// todo
文件压缩（哈夫曼算法）// todo
模式匹配（正则表达式）// todo

### 并查集
Union Find
由孩子指向父亲的树形结构
解决 连接问题（Connectivity Problem）

```
对于一组数据，主要支持两个动作：
union(p, q) // 合并元素
isConnected(p, q) -> find(p) == find(q) // 两个元素是否相连
```
#### Quick Find
<img src="https://github.com/nomo-air/data-structure/blob/master/images/37-1.png" height="10" width="10" />

union(1, 4)
<img src="https://github.com/nomo-air/data-structure/blob/master/images/37-2.png" height="10" width="10" />

```
函数						时间复杂度
unionElements(p, q)      O(n) 
isConnected(p, q)		 O(1)	
```

#### Quick Union
标准实现
union(4, 3)
<img src="https://github.com/nomo-air/data-structure/blob/master/images/38-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/38-2.png" height="10" width="10" />

#### 基于size优化
每棵树节点个数少的指向节点多的
sz[i] // 记录每棵树节点个数的大小
union(4, 9)
<img src="https://github.com/nomo-air/data-structure/blob/master/images/39-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/39-2.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/39-3.png" height="10" width="10" />

#### 基于rank优化
深度低的指向深度高的
rank[i] // 表示根节点为i的树的高度
union(4, 2)
<img src="https://github.com/nomo-air/data-structure/blob/master/images/40-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/40-2.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/40-3.png" height="10" width="10" />

#### 路径压缩
Path Compression
find(4) // 在查询时执行压缩

<img src="https://github.com/nomo-air/data-structure/blob/master/images/41-2.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/41-3.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/41-4.png" height="10" width="10" />

### AVL 树
```
发明人：G.M.Adelson-Velsky 和 E.M.Landis
1962年的论文首次提出
最早的自平衡二分搜索树
```
平衡因子等于左子树减右子树的高度差
<img src="https://github.com/nomo-air/data-structure/blob/master/images/42-1.png" height="10" width="10" />
AVL树的左旋转和右旋转
```
加入节点后，沿着节点向上维护平衡性
```
右旋转
插入的节点在左孩子的左侧（LL）
<img src="https://github.com/nomo-air/data-structure/blob/master/images/43-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/43-2.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/43-3.png" height="10" width="10" />

左旋转
插入的节点在右孩子的右侧（RR）
<img src="https://github.com/nomo-air/data-structure/blob/master/images/44-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/44-2.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/44-3.png" height="10" width="10" />

插入的节点在左孩子的右侧（LR）
<img src="https://github.com/nomo-air/data-structure/blob/master/images/45-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/45-2.png" height="10" width="10" />

插入的节点在右孩子的左侧（RL）
<img src="https://github.com/nomo-air/data-structure/blob/master/images/46-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/46-2.png" height="10" width="10" />

### 2-3数
```
满足二分搜索树的基本性质
节点可以存放一个元素或者两个元素
每个节点有两个孩子或三个孩子 
```
如果插入3-节点
<img src="https://github.com/nomo-air/data-structure/blob/master/images/47-1.png" height="10" width="10" />

如果插入3-节点，父亲节点为2-节点
<img src="https://github.com/nomo-air/data-structure/blob/master/images/47-2.png" height="10" width="10" />

如果插入3-节点，父亲节点为3-节点
<img src="https://github.com/nomo-air/data-structure/blob/master/images/47-3.png" height="10" width="10" />

### 绝对平衡树
```
2-3树是一棵绝对平衡的树
对于任意一个节点，左右子树一定是相等的
```
### 红黑树
```
1.每个节点或者是红色的，或者是黑色的
2.根节点是黑色的
3.每一个叶子节点(最后的空节点)是黑色的
4.如果一个节点是红色的，那么他的孩子节点都是黑色的
5.从任意一个节点到叶子节点，经过的黑色节点是一样的
所有的红色节点都是向左倾斜的
红黑树是保持"黑平衡"的二叉树
严格意义上，不是平衡二叉树，最大高度：2logn，O(logn)
左倾红黑树
```
向红黑树添加元素
<img src="https://github.com/nomo-air/data-structure/blob/master/images/48-1.png" height="10" width="10" />
此时需要进行左旋转
<img src="https://github.com/nomo-air/data-structure/blob/master/images/48-2.png" height="10" width="10" />

向红黑树中的3-node添加元素
<img src="https://github.com/nomo-air/data-structure/blob/master/images/48-3.png" height="10" width="10" />
颜色反转（flipColors）
<img src="https://github.com/nomo-air/data-structure/blob/master/images/48-4.png" height="10" width="10" />

右旋转
<img src="https://github.com/nomo-air/data-structure/blob/master/images/48-5.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/48-6.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/48-7.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/48-8.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/48-9.png" height="10" width="10" />

颜色反转
<img src="https://github.com/nomo-air/data-structure/blob/master/images/48-10.png" height="10" width="10" />

红黑树与2-3树
<img src="https://github.com/nomo-air/data-structure/blob/master/images/49-1.png" height="10" width="10" />

左旋转
<img src="https://github.com/nomo-air/data-structure/blob/master/images/50-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/50-2.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/50-3.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/50-4.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/50-5.png" height="10" width="10" />

添加元素统一方法
<img src="https://github.com/nomo-air/data-structure/blob/master/images/51-1.png" height="10" width="10" />

#### 性能
```
对于完全随机的数据，普通的二分搜索树很好用
缺点：极端情况下退化成链表（或者高度不平衡）
对于查询较多的使用情况，AVL树很好用
红黑树牺牲了平衡性（2logn的高度）
统计性能更优（综合增删改查所有的操作）
```
右倾红黑树

#### 伸展树
Splay Tree
局部性原理：刚被访问的内容下次高概率被再次访问
### 哈希表
键转化为索引，空间换时间，牺牲了顺序性
```
原则：
1.一致性：如果 a==b，则hash(a) == hash(b)
2.高效性：计算高效简便
3.哈希值均匀分布
```
扩容M选择
https://planetmath.org/goodhashtableprimes
#### 链地址法
<img src="https://github.com/nomo-air/data-structure/blob/master/images/52-1.png" height="10" width="10" />

<img src="https://github.com/nomo-air/data-structure/blob/master/images/52-2.png" height="10" width="10" />

#### 复杂度分析
```
总共有M个地址
如果放入哈希表的元素为N
链表：O(N/M)
平衡树：O(log(N/M))

如果做到0(1)?，和静态数组一样，固定地址空间是不合理的，需要resize
平均每个地址承载的元素多过一定程度，即扩容，N/M >= upperTolerance
平均每个地址承载的元素少过一定程度，即缩容，，N/M < lowerTolerance
对于哈希表来说，元素数从N增加到upperTolerance * N，地址空间倍增，平均复杂度O(1)
每个操作在O(lowerTolerance) ~ O(upperTolerance) -> O(1)
缩容同理
```

#### 哈希冲突
开地址法 & 线性探测法
```
遇到哈希冲突 + 1
```

平方探测法
```
遇到哈希冲突 +1，+4，+9，+16
```

二次哈希
```
遇到哈希冲突 + hash2(key)
```

负载率
```
整个哈希表中存储的元素总数占整个地址数量的百分比
```

再哈希法（rehashing）
```
遇到哈希冲突 使用另一个哈希算法
```
Coalesced Hashing 综合了链地址法(Seperate Chaining) 和开放地址(Open Addressing)









