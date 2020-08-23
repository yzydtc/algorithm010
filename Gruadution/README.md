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

#### 三、哈希表

##### 一、简述hashmap的实现

先由一个8个长度的数组存放hash值对应的值，如果存放的值大于8则转换为链表，如果链表不够则转化为红黑树。

##### 二、时间复杂度

| 增加 | 删除 | 查询 |
| ---- | ---- | ---- |
| O(1) | O(1) | O(1) |



#### 四、树、二叉树、二叉搜索树

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



#### 五、堆、二叉堆、图

##### 一、堆:在一堆数据中快速找到最大值或者最小值

##### 二、二叉堆:1.完全二叉树

​			2.父节点大于子节点

##### 三、时间复杂度(以二叉堆，大顶堆为例)

| 增加             | 删除     | 查询 |
| ---------------- | -------- | ---- |
| O(1) or O(log n) | O(log n) | O(1) |

##### 四、常见算法题:最小K个数，topN,滑动窗口问题



#### 六、递归

#### 1.递归的结构

​	递归终止条件

​	当前层需要处理的函数

​	下一层处理的函数

​	清理当层

#### 2.递归的思路

​	不要人肉递归

​	找最近重复问题

​	数学归纳法

#### 3.java版代码模板

```java
public void recur(int level,int param) {
    //terminator
    if(level>MAX_LEVEL) {
        return;
    }
    //current logic
    process(level,param);
    //drill down
    recur(level,level+1);
    //restore current status
}
```



#### 二、分治

分治代码模板

```java
public void divide_recur(problem,param1.param2) {
    //terminator
    if(problem == null) {
        return;
    }
    //prepare data
    data = prepare_data(problem);
    //conquer subproblems
    subresult1 = divide_recur(subproblem[0],p1,...);
    subresult1 = divide_recur(subproblem[0],p1,...);
    subresult1 = divide_recur(subproblem[0],p1,...);
    //final result
    result = process_result(subresult1,subresult2,subresult3);
    //reserve status
}
```



#### 三、回溯

采用试错思想，分布解决问题。(8皇后，数独)

### .深度优先搜索，广度优先搜索

​	深度优先

​	depth first search

​	递归写法

```python
visited = set() 
def dfs(node, visited): 
if node in visited: # terminator 
# already visited 
return 
 visited.add(node) 
# process current node here. 
...
for next_node in node.children(): 
 if not next_node in visited: 
 dfs(next_node, visited)
```

非递归写法

```python
def DFS(self, tree): 
if tree.root is None: 
 return [] 
 visited, stack = [], [tree.root] 
while stack: 
 node = stack.pop() 
 visited.add(node) 
 process (node) 
 nodes = generate_related_nodes(node) 
 stack.push(nodes) 
# other processing work 
...
```

​	广度优先

​	breadth first search

​	递归写法

```python
visited = set() 
 
def dfs(node, visited): 
 visited.add(node) 
# process current node here. 
...
for next_node in node.children(): 
 if not next_node in visited: 
 dfs(next node, visited)
```



### 2.贪心算法

​	贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。

​	贪心可以解决一些最优化问题，求最小生成树，求哈夫曼编码。

​	贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。

简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。

### 3.二分查找

二分查找的前提

1. 目标函数单调性（单调递增或者递减）

2. 存在上下界（bounded）

3. 能够通过索引访问（index accessible）

代码模板

```python
left, right = 0, len(array) - 1 
while left <= right: 
 mid = (left + right) / 2 
 if array[mid] == target: 
 # find the target!! 
 break or return result 
 elif array[mid] < target: 
 left = mid + 1 
 else: 
 right = mid - 1
```

### 八、动态规划

分治+最优子结构

动态规划=递归 or 分治

共性:寻找最优子问题

差异性：最优子结构、中途可以淘汰次优解

总结:

1. 打破自己的思维惯性，形成机器思维

2. 理解复杂逻辑的关键

3. 也是职业进阶的要点要领

### 九、字典树和并查集

### 1.字典树Trie

#### 	数据结构

​	单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于

字符串），所以经常被搜索引擎系统用于文本词频统计。 

它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

#### 	核心思想

Trie 树的核心思想是空间换时间。

利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的

#### 	基本性质

1. 结点本身不存完整单词；

2. 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的

字符串；

3. 每个结点的所有子结点路径代表的字符都不相同。

#### 代码模板

```python
class Trie(object): 
def __init__(self): 
 self.root = {} 
 self.end_of_word = "#" 
def insert(self, word): 
 node = self.root 
 for char in word: 
 node = node.setdefault(char, {}) 
 node[self.end_of_word] = self.end_of_word 
def search(self, word): 
 node = self.root 
 for char in word: 
 if char not in node: 
 return False 
 node = node[char] 
 return self.end_of_word in node 
def startsWith(self, prefix): 
 node = self.root 
 for char in prefix: 
 if char not in node: 
 return False 
 node = node[char] 
 return True
```



### 2.并查集

#### 适用场景

 组团、配对问题

 Group or not ? 

#### 基本操作

makeSet(s)：建立一个新的并查集，其中包含 s 个单元素集合。

unionSet(x, y)：把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在

的集合不相交，如果相交则不合并。

fifind(x)：找到元素 x 所在的集合的代表，该操作也可以用于判断两个元

素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。

```java
class UnionFind { 
private int count = 0; 
private int[] parent; 
public UnionFind(int n) { 
 count = n; 
 parent = new int[n]; 
 for (int i = 0; i < n; i++) { 
 parent[i] = i;
 } } 
public int find(int p) { 
 while (p != parent[p]) { 
 parent[p] = parent[parent[p]]; 
 p = parent[p]; 
 }
 return p; 
}
public void union(int p, int q) { 
 int rootP = find(p); 
 int rootQ = find(q); 
 if (rootP == rootQ) return; 
 parent[rootP] = rootQ; 
 count--;
} }
```

### 高级搜索

### 1.剪枝

### 2.双向BFS

### 3.启发式搜索

```python
def AstarSearch(graph, start, end): 
 pq = collections.priority_queue() # 优先级 —> 估价函数
 pq.append([start]) 
 visited.add(start) 
while pq: 
 node = pq.pop() # can we add more intelligence here ? 
 visited.add(node) 
 process(node) 
 nodes = generate_related_nodes(node) 
 unvisited = [node for node in nodes if node not in visited] 
 pq.push(unvisited)
```

#### 估价函数

启发式函数： h(n)，它用来评价哪些结点最有希望的是一个我们要找的结点，h(n) 会返回一个非负实数,也可以认为是从结点n的目标结点路径的估计成本。

启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标。

### 高级树，AVL树，红黑树

#### 1.AVL树

1. 发明者 G. M. Adelson-Velsky和 Evgenii Landis

2. Balance Factor（平衡因子）：

是它的左子树的高度减去它的右子树的高度（有时相反）。

balance factor = {-1, 0, 1}

3. 通过旋转操作来进行平衡（四种）

不足：结点需要存储额外信息、且调整次数频繁

#### 2.红黑树

红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能够确保任何一个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树： 

• 每个结点要么是红色，要么是黑色

• 根结点是黑色

• 每个叶结点（NIL结点，空结点）是黑色的。 

• 不能有相邻接的两个红色结点 

• 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。



### 十、位运算	

十进制和二进制互转

00011>>十进制 2的0次幂开始相加

50 /2 >>二进制 十进制数对2取余再取反

左移乘2

右移除2

按位或 有1为1

按位与 有0为0

按位取反 取反

按位异或 相反为1相同为0

x ^ 0 = x

x ^ 1s = ~x // **注意 1s = ~0**

x ^ (~x) = 1s

x ^ x = 0

c = a ^ b => a ^ c = b, b ^ c = a // 交换两个数

a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c // associative 

#### 指定位置的位运算

1. 将 x 最右边的 n 位清零：x& (~0 << n)
2. 获取 x 的第 n 位值（0 或者 1）： (x >> n) & 1
3. 获取 x 的第 n 位的幂值：x& (1 <<n)
4. 仅将第 n 位置为 1：x | (1 << n)
5. 仅将第 n 位置为 0：x & (~ (1 << n))
6. 将 x 最高位至第 n 位（含）清零：x& ((1 << n) -1)
7. 将第 n 位至第 0 位（含）清零：x& (~ ((1 << (n + 1)) -1))

#### 实战位运算要点

判断奇偶：

x % 2 == 1 —> (x & 1) == 1

x % 2 == 0 —> (x & 1) == 0

x >> 1 —> x / 2. 

即： x = x / 2; —> x = x >> 1;

mid = (left + right) / 2; —> mid = (left + right) >> 1;

X = X & (X-1) 清零最低位的 1 

X & -X => 得到最低位的 1 

X & ~X => 0

### 二、布隆过滤器、LRU缓存

一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。 

优点：是空间效率和查询时间都远远超过一般的算法

缺点：是有一定的误识别率和删除困难

```python
from bitarray import bitarray 
import mmh3 
class BloomFilter: 
def __init__(self, size, hash_num): 
self.size = size 
self.hash_num = hash_num 
self.bit_array = bitarray(size) 
self.bit_array.setall(0) 
def add(self, s): 
for seed in range(self.hash_num): 
result = mmh3.hash(s, seed) % self.size 
self.bit_array[result] = 1
def lookup(self, s): 
for seed in range(self.hash_num): 
result = mmh3.hash(s, seed) % self.size 
if self.bit_array[result] == 0: 
return "Nope"
return "Probably"
bf = BloomFilter(500000, 7) 
bf.add("dantezhao") 
print (bf.lookup("dantezhao")) 
print (bf.lookup("yyj"))
```



### 三、排序

1. **比较类排序：** 

通过比较来决定元素间的相对次序，由于其时间复杂度不能突破 O(nlogn)，因此也称为非线性时间比较类排序。 

2. **非比较类排序**： 

不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。

![image-20200802235632667](E:/git/ssh/algorithm010/algorithm010/Week08/2.png)

#### 初级排序 - O(n^2)

1. 选择排序（Selection Sort） 

每次找最小值，然后放到待排序数组的起始位置。

2. 插入排序（Insertion Sort） 

从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后

向前扫描，找到相应位置并插入。

3. 冒泡排序（Bubble Sort） 

嵌套循环，每次查看相邻的元素如果逆序，则交换。

#### 高级排序 - O(N*LogN)

快速排序（Quick Sort） 

数组取标杆 pivot，将小元素放 pivot左边，大元素放右侧，然后依次

对右边和右边的子数组继续快排；以达到整个序列有序。

```java
public static void quickSort(int[] array, int begin, int end) {
 if (end <= begin) return;
 int pivot = partition(array, begin, end);
 quickSort(array, begin, pivot - 1);
 quickSort(array, pivot + 1, end);
}
static int partition(int[] a, int begin, int end) {
 // pivot: 标杆位置，counter: ⼩于pivot的元素的个数
 int pivot = end, counter = begin;
 for (int i = begin; i < end; i++) {
 if (a[i] < a[pivot]) {
 int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
 counter++;
 }
 }
 int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
 return counter; }
```

归并排序（Merge Sort）— 分治   

1. 把长度为n的输入序列分成两个长度为n/2的子序列；   

2. 对这两个子序列分别采用归并排序；   

3. 将两个排序好的子序列合并成一个最终的排序序列。 

```java
public static void mergeSort(int[] array, int left, int right) {
 if (right <= left) return;
 int mid = (left + right) >> 1; // (left + right) / 2
 mergeSort(array, left, mid);
 mergeSort(array, mid + 1, right);
 merge(array, left, mid, right);
}
public static void merge(int[] arr, int left, int mid, int right) {
 int[] temp = new int[right - left + 1]; // 中间数组
 int i = left, j = mid + 1, k = 0;
 while (i <= mid && j <= right) {
 temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
 }
 while (i <= mid) temp[k++] = arr[i++];
 while (j <= right) temp[k++] = arr[j++];
 for (int p = 0; p < temp.length; p++) {
 arr[left + p] = temp[p];
 }
 // 也可以⽤ System.arraycopy(a, start1, b, start2, length)
 }
```

归并 和 快排 具有相似性，但步骤顺序相反

归并：先排序左右子数组，然后合并两个有序子数组 

快排：先调配出左右子数组，然后对于左右子数组进行排序



堆排序（Heap Sort） — 堆插入 O(logN)，取最大/小值 O(1)   

1. 数组元素依次建立小顶堆 

2. 依次取堆顶元素，并删除
3. 

特殊排序 - O(n)

• 计数排序（Counting Sort） 

计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存

储在额外开辟的数组空间中；然后依次把计数大于 1 的填充回原数组

• 桶排序（Bucket Sort） 

桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有

限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式

继续使用桶排序进行排）。

• 基数排序（Radix Sort） 

基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类

推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按

高优先级排序

## 十二、字符串

遍历字符串

```java
String x = “abbc”; 
for (int i = 0; i < x.size(); ++i) { 
 char ch = x.charAt(i); 
} 
for ch in x.toCharArray() { 
 System.out.println(ch); 
}
```

字符串比较

```java
String x = “abb”;

String y = “abb”;

x == y —-> false

x.equals(y) —-> true

x.equalsIgnoreCase(y) —-> true
```

字符串算法

Atoi 

```java
public int myAtoi(String str) {
 int index = 0, sign = 1, total = 0;
 //1. Empty string

 if(str.length() == 0) return 0;
 //2. Remove Spaces

 while(str.charAt(index) == ' ' && index < str.length())
 index ++;
 //3. Handle signs

 if(str.charAt(index) == '+' || str.charAt(index) == '-'){
 sign = str.charAt(index) == '+' ? 1 : -1;
 index ++;
 }
 

 //4. Convert number and avoid overflow

 while(index < str.length()){
 int digit = str.charAt(index) - '0';
 if(digit < 0 || digit > 9) break;
 //check if total will be overflow after 10 times and add digit

 if(Integer.MAX_VALUE/10 < total || 

 	 Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
 return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
 total = 10 * total + digit;
 index ++;
 }
 return total * sign; }
```

```
class Solution(object):

 def myAtoi(self, s):

 if len(s) == 0 : return 0
 ls = list(s.strip())

 

 sign = -1 if ls[0] == '-' else 1
 if ls[0] in ['-'
,'+'] : del ls[0]

 ret, i = 0, 0
 while i < len(ls) and ls[i].isdigit() :

 ret = ret*10 + ord(ls[i]) - ord('0')

 i += 1
 return max(-2**31, min(sign * ret,2**31-1))
```

高级字符串算法

最长子串、子序列

字符串匹配算法

1. 暴力法（brute force） - O(mn)

   ```java
   public static int forceSearch(String txt, String pat) {
    int M = txt.length();
    int N = pat.length();
    for (int i = 0; i <= M - N; i++) {
    int j;
    for (j = 0; j < N; j++) {
    if (txt.charAt(i + j) != pat.charAt(j))
    break;
    }
    if (j == N) {
    return i;
    }
    // 更加聪明？
    // 1. 预先判断– hash(txt.substring(i, M)) == hash(pat)
    // 2. KMP 
    }
    return -1; }
   ```

   

2. Rabin-Karp 算法

   在朴素算法中，我们需要挨个比较所有字符，才知道目标字符串中是否包含

   子串。那么， 是否有别的方法可以用来判断目标字符串是否包含子串呢？

   答案是肯定的，确实存在一种更快的方法。为了避免挨个字符对目标字符串

   和子串进行比较， 我们可以尝试一次性判断两者是否相等。因此，我们需

   要一个好的哈希函数（hash function）。 通过哈希函数，我们可以算出子

   串的哈希值，然后将它和目标字符串中的子串的哈希值进行比较。 这个新

   方法在速度上比暴力法有显著提升。

   Rabin-Karp 算法的思想：

   1. 假设子串的长度为 M (pat)，目标字符串的长度为 N (txt)

   2. 计算子串的 hash 值 hash_pat

   3. 计算目标字符串txt中每个长度为 M 的子串的 hash 值（共需要计算 N-M+1

   次）

   4. 比较 hash 值：如果 hash 值不同，字符串必然不匹配; 如果 hash 值相同，

   还需要使用朴素算法再次判断

   ```java
   public final static int D = 256;
   
   public final static int Q = 9997;
   
   static int RabinKarpSerach(String txt, String pat) {
    int M = pat.length();
    int N = txt.length();
    int i, j;
    int patHash = 0, txtHash = 0;
    for (i = 0; i < M; i++) {
    patHash = (D * patHash + pat.charAt(i)) % Q;
    txtHash = (D * txtHash + txt.charAt(i)) % Q;
    }
    int highestPow = 1; // pow(256, M-1)
    for (i = 0; i < M - 1; i++) 
    highestPow = (highestPow * D) % Q;
    for (i = 0; i <= N - M; i++) { // 枚举起点
   
    if (patHash == txtHash) {
    for (j = 0; j < M; j++) {
    if (txt.charAt(i + j) != pat.charAt(j))
    break;
    }
    if (j == M)
    return i;
    }
    if (i < N - M) {
    txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q;
    if (txtHash < 0)
    txtHash += Q;
    }
    }
    return -1; }
   ```

   

3. KMP 算法

   KMP算法（Knuth-Morris-Pratt）的思想就是，当子串与目标字符串不匹配时，

   其实你已经知道了前面已经匹配成功那 一部分的字符（包括子串与目标字符

   串）。以阮一峰的文章为例，当空格与 D 不匹配时，你其实 知道前面六个字符是

   “ABCDAB”。KMP 算法的想法是，设法利用这个已知信息，不要把“搜索位

   置” 移回已经比较过的位置，继续把它向后移，这样就提高了效率。

