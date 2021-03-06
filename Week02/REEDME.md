### Week02学习总结:

#### 一、解决问题思路

1.理解题意

2.想尽可能多的解法

3.估算时间空间复杂度，并优化

4.测试案例

5.编写代码



#### 二、哈希表

##### 一、简述hashmap的实现

先由一个8个长度的数组存放hash值对应的值，如果存放的值大于8则转换为链表，如果链表不够则转化为红黑树。

##### 二、时间复杂度

| 增加 | 删除 | 查询 |
| ---- | ---- | ---- |
| O(1) | O(1) | O(1) |



#### 三、树、二叉树、二叉搜索树

#### <u>*重点*：对于树的前中后序的遍历，需要记住代码实现方式！</u>

##### 一、二叉树遍历

前：根-左-右

中：左-根-右

后：左-右-根

##### 二、特殊情况

左倾斜和右倾斜时退化为链表。

##### 三、为什么树的遍历都用递归，而不用循环？

树不存在后继结构用于循环，在遍历左子树和右子树时调用相同的函数更为简便。

##### 四、时间复杂度

| 增加     | 删除             | 查询 |
| -------- | ---------------- | ---- |
| O(log n) | O(log n)O(log n) |      |



#### 四、堆、二叉堆、图

##### 一、堆:在一堆数据中快速找到最大值或者最小值

##### 二、二叉堆:1.完全二叉树

​			2.父节点大于子节点

##### 三、时间复杂度(以二叉堆，大顶堆为例)

| 增加             | 删除     | 查询 |
| ---------------- | -------- | ---- |
| O(1) or O(log n) | O(log n) | O(1) |

##### 四、常见算法题:最小K个数，topN,滑动窗口问题



### 四、图

1.点

​	入度，出度

​	是否相连

2.边

​	权重

​	有向

3.实现

​	邻接矩阵

​	邻接图