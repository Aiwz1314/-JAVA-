# 2020 蓝桥杯 校内模拟赛 

[TOC]


### 1、结果填空（签到题）
问题描述  
在计算机存储中，15.125GB是多少MB？  
答案提交  
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。 

答案： 15488    
题解：计算器算一下，15.125*1024即可


### 2、结果填空（签到题）
问题描述  
1200000有多少个约数（只计算正约数）。  
答案提交  
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。  
  
答案：96  
题解：
```java
public class Main2 {
    public static void main(String[] args) {
        int sum = 2;        //1和1200000本身
        for (int i = 2; i < 1200000; i++) {
            if (1200000 % i == 0) sum++;
        }
        System.out.println(sum);
    }
}
```


## 3、结果填空（签到题）
问题描述  
一棵包含有2019个结点的树，最多包含多少个叶结点？  
答案提交  
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。  
  
答案：2018  
题解：2018叉树，去掉1个根节点，全是叶节点


## 4、结果填空（签到题）
问题描述  
在1至2019中，有多少个数的数位中包含数字9？  
注意，有的数中的数位中包含多个9，这个数只算一次。例如，1999这个数包含数字9，在计算只是算一个数。  
答案提交  
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。   
   
答案：544  
题解：
```java
public class Main4 {
    private static boolean contain9(int num) {
        while (num != 0) {
            if (num % 10 == 9) {
                return true;
            } else {
                num /= 10;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 2019; i++) {
            if (contain9(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
```


## 5、递增三元组（遍历）
```
问题描述
在数列 a[1], a[2], ..., a[n] 中，如果对于下标 i, j, k 满足 0<i<j<k<n+1 且 a[i]<a[j]<a[k]，则称 a[i], a[j], a[k] 为一组递增三元组，a[j]为递增三元组的中心。  
给定一个数列，请问数列中有多少个元素可能是递增三元组的中心。  
输入格式  
输入的第一行包含一个整数 n。  
第二行包含 n 个整数 a[1], a[2], ..., a[n]，相邻的整数间用空格分隔，表示给定的数列。  
输出格式  
输出一行包含一个整数，表示答案。  
样例输入  
5
1 2 5 3 5  
样例输出  
2
样例说明
a[2] 和 a[4] 可能是三元组的中心。
评测用例规模与约定
对于 50% 的评测用例，2 <= n <= 100，0 <= 数列中的数 <= 1000。
对于所有评测用例，2 <= n <= 1000，0 <= 数列中的数 <= 10000。 
```

题解：
```java
public class Main4 {
    private static boolean contain9(int num) {
        while (num != 0) {
            if (num % 10 == 9) {
                return true;
            } else {
                num /= 10;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 2019; i++) {
            if (contain9(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
```

## 4、结果填空（签到题）
问题描述  
在1至2019中，有多少个数的数位中包含数字9？  
注意，有的数中的数位中包含多个9，这个数只算一次。例如，1999这个数包含数字9，在计算只是算一个数。  
答案提交  
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。   
   
答案：544  
题解：
```java
public class Main4 {
    private static boolean contain9(int num) {
        while (num != 0) {
            if (num % 10 == 9) {
                return true;
            } else {
                num /= 10;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 2019; i++) {
            if (contain9(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
```

## 4、结果填空（签到题）
问题描述  
在1至2019中，有多少个数的数位中包含数字9？  
注意，有的数中的数位中包含多个9，这个数只算一次。例如，1999这个数包含数字9，在计算只是算一个数。  
答案提交  
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。   
   
答案：544  
题解：
```java
public class Main4 {
    private static boolean contain9(int num) {
        while (num != 0) {
            if (num % 10 == 9) {
                return true;
            } else {
                num /= 10;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 2019; i++) {
            if (contain9(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
```



