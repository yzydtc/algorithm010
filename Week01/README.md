### Week01学习总结:

#### 一、算法解决思路

​	1.是否可以暴力破解
​	2.从简单例子分析
​	3.找最近可重复单元

#### 二、数组、链表、栈、队列

##### 数组

​	原理:由一块连续的内存组成的数据结构。

​	常用算法解题办法:快慢指针，指针对撞

##### 链表

###### 普通链表

​	原理:每个数据在内存中不一定连续，有一个后继节点指向下一块数据内存区。

双向链表:

​	原理:在普通链表的基础上，增加头节点指向上一个数据内存区。

循环链表:

​	原理:在普通链表的基础上，尾节点的后续节点指向头部数据内存区。

​	常用算法解题办法:学会链表的增删写法。

###### 跳表:

​	原理:在双向链表的基础上，在向上拓展层级。

##### 数组、链表、跳表空间复杂度和时间复杂度对比

| 数据结构         | 数组 | 链表 | 跳表     |
| ---------------- | ---- | ---- | -------- |
| 空间复杂度       | O(1) | O(n) | O(n)     |
| 时间复杂度(新增) | O(n) | O(1) | O(log n) |
| 时间复杂度(删除) | O(n) | O(1) | O(log n) |
| 时间复杂度(查询) | O(1) | O(n) | O(log n) |



##### 栈

​	先进后出

##### 队列

​	先进先出

| 数据结构         | 栈   | 队列 | 优先队列 |
| ---------------- | ---- | ---- | -------- |
| 时间复杂度(新增) | O(1) | O(1) | O(1)     |
| 时间复杂度(删除) | O(1) | O(1) | O(1)     |
| 时间复杂度(查询) | O(n) | O(n) | O(log n) |

