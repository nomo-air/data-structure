原创者地址：https://github.com/liuyubobobo

### 数组基础
```
定义：把数据码成一排进行存放
数组最大的优点：快速查询
数组最好应用于"索引有语义"的情况
```

### 数组简单的复杂度分析
```
大O描述的是算法的运行时间和输入数据之间的关系
增：O(n)
删：O(n)
改：已知索引O(1)，未知索引O(n)
查：已知索引O(1)，未知索引O(n)
```

### 均摊复杂度
```
resize：O(n)
addLast的均摊复杂度为O(1)
假设capacity = n, n+1次addLast，触发resize，总共进行了2n+1次基本操作，平均每次addLast操作，进行2次基本操作
```

### 复杂度震荡
```
出现问题的原因：removeLast时resizeguoyu着急（Eager）
解决方案：Lazy
当size == capacity / 4时，才将capacity减半
```

