## 一、高级动态规划

### 递归、分治、回溯、动态规划复习

#### 递归

```java
public void recur(int level, int param) { 
 // terminator 
 if (level > MAX_LEVEL) { 
 // process result 
 return; 
 } 
 // process current logic 
 process(level, param); 
 // drill down 
 recur(level: level + 1, newParam); 
 // restore current status 
 
}
```

分而治之

```python
def divide_conquer(problem, param1, param2, ...): 
# recursion terminator 
if problem is None: 
 print_result 
 return 
# prepare data 
 data = prepare_data(problem) 
 subproblems = split_problem(problem, data) 
# conquer subproblems 
 subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
 subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
 subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
… 
# process and generate the final result 
 result = process_result(subresult1, subresult2, subresult3, …) 
 
 # revert the current level states
```

动态规划 Dynamic Programming

1.Simplifying a complicated problem by breaking it down into simpler sub-problems”

(in a recursive manner)

2. Divide & Conquer + Optimal substructure 

 分治 + 最优子结构

3. 顺推形式： 动态递推

#### DP 顺推模板

```python
function DP(): 

 dp = [][] # ⼆维情况 

 for i = 0 .. M { 

 for j = 0 .. N { 

 dp[i][j] = _Function(dp[i’][j’]…) 

 } 

 } 

 return dp[M][N]; 
```

爬楼梯

递归公式：

f(n) = f(n - 1) + f(n - 2) , f(1) = 1, f(0) = 0

不同路径

递归公式：

f(x, y) = f(x-1, y) + f(x, y-1)

打家劫舍

dp[i]状态的定义： max $ of robbing A[0 -> i]

dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])

dp[i][0]状态定义：max $ of robbing A[0 -> i] 且没偷 nums[i]

dp[i][1]状态定义：max $ of robbing A[0 -> i] 且偷了 nums[i]

dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]);

dp[i][1] = dp[i - 1][0] + nums[i];

最小路径和

dp[i][j]状态的定义： minPath(A[1 -> i][1 -> j])

dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + A[i][j]

股票买卖

**dp[i][k][0 or 1]** (0 <= i <= n-1, 1 <= k <= K)

• i 为天数

• k 为最多交易次数

• [0,1] 为是否持有股票

总状态数： n * K * 2 种状态

for 0 <= i < n:

 for 1 <= k <= K:

 for s in {0, 1}:

 dp[i][k][s] = max(buy, sell, rest)

dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])

 max( 选择 rest , 选择 sell )

解释：今天我没有持有股票，有两种可能：

\- 我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；

\- 我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。

dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

 max( 选择 rest , 选择 buy )

解释：今天我持有着股票，有两种可能：

\- 我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；

\- 我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。

## 二、字符串

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

