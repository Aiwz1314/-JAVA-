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
一棵包含有2019个结点的二叉树，最多包含多少个叶结点？  
答案提交  
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。  
  
答案：1010  
题解：  
n=n0+n1+n2，为使叶子节点数（n0）最多，必须n1最小，设为0，而n0=n2+1  
得n2=(n-1)/2 = (2019-1)/2 = 1009  
所以n0=1010


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

## 5、小明的hello（水题 循环|正则表达式）
```
问题描述
小明对类似于 hello 这种单词非常感兴趣，这种单词可以正好分为四段，第一段由一个或多个辅音字母组成，第二段由一个或多个元音字母组成，第三段由一个或多个辅音字母组成，第四段由一个或多个元音字母组成。
给定一个单词，请判断这个单词是否也是这种单词，如果是请输出yes，否则请输出no。
元音字母包括 a, e, i, o, u，共五个，其他均为辅音字母。
输入格式
输入一行，包含一个单词，单词中只包含小写英文字母。
输出格式
输出答案，或者为yes，或者为no。
样例输入
lanqiao
样例输出
yes
样例输入
world
样例输出
no
评测用例规模与约定
对于所有评测用例，单词中的字母个数不超过100。
```

题解：  
```java
import java.util.Scanner;

public class Main5 {

    private static boolean isflag(char inputChar) {
        char[] flag = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < 5; i++) {
            if (inputChar == flag[i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String stringIn = in.nextLine().trim();
        char[] tmepIn = stringIn.toCharArray();
        int i = 0;
        try {
            if (isflag(tmepIn[i])) {
                int a = tmepIn[-1];
            } else {
                while (!isflag(tmepIn[i])) i++;
                while (isflag(tmepIn[i])) i++;
                while (!isflag(tmepIn[i])) i++;
                while (isflag(tmepIn[i])) {
                    i++;
                    if (i == tmepIn.length) break;
                }
            }
        } catch (Exception e) {
            System.out.print("no");
            System.exit(0);
        }
        System.out.print("yes");
    }
}
```

本以为，我无视越界无脑循环已经够简洁了，然鹅网上发现了一个更简洁的做法。  

```java
// 正则表达式：
// ^([bcdfghjklmnpqrstvwxyz]+)([aeiou]+)([bcdfghjklmnpqrstvwxyz]+)([aeiou]+)$

package lanqiao.school2020;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String stringIn = in.nextLine().trim();
        String pattern = "^([bcdfghjklmnpqrstvwxyz]+)([aeiou]+)([bcdfghjklmnpqrstvwxyz]+)([aeiou]+)$";
        boolean isMatch = Pattern.matches(pattern, stringIn);
        if (isMatch) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
```


## 6、递增三元组（水题 遍历）
> 问题描述
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

题解：
```java
import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] shuzu = new int[n];
        for (int i = 0; i < n; i++) {
            shuzu[i] = in.nextInt();
        }

        if (n < 3) {
            System.out.print(0);
        } else {
            int jishu = 0;
            for (int i = 1; i < n - 1; i++) {
                boolean flag1 = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (shuzu[j] < shuzu[i]) {
                        flag1 = true;
                        break;
                    }
                }
                if (!flag1) continue;

                boolean flag2 = false;
                for (int j = i + 1; j < n; j++) {
                    if (shuzu[j] > shuzu[i]) {
                        flag2 = true;
                        break;
                    }
                }
                if (!flag2) continue;

                jishu++;
            }
            System.out.print(jishu);
        }
    }
}
```

## 7、数位递增（dp）
```
问题描述
一个正整数如果任何一个数位不大于右边相邻的数位，则称为一个数位递增的数，例如1135是一个数位递增的数，而1024不是一个数位递增的数。
给定正整数 n，请问在整数 1 至 n 中有多少个数位递增的数？
输入格式
输入的第一行包含一个整数 n。
输出格式
输出一行包含一个整数，表示答案。
样例输入
30
样例输出
26
评测用例规模与约定
对于 40% 的评测用例，1 <= n <= 1000。
对于 80% 的评测用例，1 <= n <= 100000。
对于所有评测用例，1 <= n <= 1000000。
```

题解：  
迭代字符串的每一位，判断是否满足要求
```java
import java.util.Scanner;

public class Main7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int n = in.nextInt();
            int ans = 0;
            for (int i = 1; i <= n; ++i) {
                String s = "" + i;
                boolean flag = true;
                for (int j = 1; j < s.length(); ++j) {
                    if (s.charAt(j - 1) > s.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    ans++;
            }
            System.out.println(ans);
        }

    }
}

```

## 8、结果填空（签到题）
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


## 9、结果填空（签到题）
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

## 10、结果填空（签到题）
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

