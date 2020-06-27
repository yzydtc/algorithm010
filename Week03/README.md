### Week03学习总结

#### 一、递归

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

