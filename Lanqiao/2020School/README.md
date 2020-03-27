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
> 问题描述  
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
// ^[^aeiou]+[aeiou]+[^aeiou]+[aeiou]+$

package lanqiao.school2020;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String stringIn = in.nextLine().trim();
        String pattern = "^[^aeiou]+[aeiou]+[^aeiou]+[aeiou]+$";
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

## 8、序列计数（DFS）【没做出来】
```
【问题描述】  
小明想知道，满足以下条件的正整数序列的数量：  
1. 第一项为 n；  
2. 第二项不超过 n；  
3. 从第三项开始，每一项小于前两项的差的绝对值。  
请计算，对于给定的 n，有多少种满足条件的序列。
【输入格式】
输入一行包含一个整数 n。
【输出格式】
输出一个整数，表示答案。答案可能很大，请输出答案除以10000的余数。
【样例输入】
4
【样例输出】
7
【样例说明】
以下是满足条件的序列：
4 1
4 1 1
4 1 2
4 2
4 2 1
4 3
4 4
【评测用例规模与约定】
对于 20% 的评测用例，1 <= n <= 5；
对于 50% 的评测用例，1 <= n <= 10；
对于 80% 的评测用例，1 <= n <= 100；
对于所有评测用例，1 <= n <= 1000。
```
   
题解：  
画画树就会很明了  
注意递归的终止条件：当前节点为0 或 当前加点与父节点差值为0 或 当前节点与父节点差值为1
```java
import java.util.Scanner;

public class Main8 {

    public static int tmp = 0;

    public static void dfs(int differ, int node) { //node为当前节点 differ为node节点与父节点的差值
        if (node == 0 || differ == 0 || differ == 1) {
            tmp++;
            return;
        }
        for (int i = 0; i < differ; i++) {
            dfs(Math.abs(node - i), i);
        }
    }

    public static void main(String[] args) {
        //输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            dfs(n - i, i);
        }
        System.out.println(tmp % 10000);
    }
}
```
但是时间超了

看一下标准答案
```java
思路：记忆型递归 O(N^3)
题干第三点，是一个递归定义，可以得到递归式：

1. f(pre,cur) = f(cur,1) + f(cur,2) + ... +f(cur,abs(pre-cur)-1) + 1
2. pre表示前一个数，cur代表当前的数，选定之后，序列种数等于以cur为前序，以1到abs-1为当前的序列数的总和再加1.
3. 如f(5,2) = f(2,1)+f(2,2).

但是暴力递归的复杂度是指数级，输入1000时，实测运行时间为1000~2000ms；

基本的优化方案是加状态记忆：

参考代码：记忆型递归
import java.util.Scanner;

public class _09_01 {
    static final int MOD = 10000;
    static int N;
    static long ans;
    static long[][] mem = new long[1001][1000];
    static Scanner sc;

    static long dfs(int pre, int cur) {
        // 询问状态
        if (mem[pre][cur] != 0)
            return mem[pre][cur];
        long ans = 1;
        for (int j = 1; j < Math.abs(pre - cur); j++) {
            ans = (ans + dfs(cur, j)) % MOD;
        }
        mem[pre][cur] = ans;
        return ans;
    }

    static void work() {
        ans = 0;
        N = sc.nextInt();
		long ago = System.currentTimeMillis();
        //    f(pre,cur) = sum(f(cur,_new))|_new from 1 to abs(pre-cur)-1
        for (int x = 1; x <= N; ++x) ans = (ans + dfs(N, x)) % MOD;
        System.out.println(ans);
		System.err.println(System.currentTimeMillis() - ago);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        while (true) {
            work();  
        }
    }
}	

进一步优化
至此，能通过80%的数据（在1000ms限制下）；

解空间是N的平方（详细为N*N）表格，但是每次都要循环加总，所以成了N的立方，在同样的解空间下，避免循环加总，即可优化到N的平方

重新考虑状态的转移：

如果我们用f(i,j)表示前一个数是i，当前数是1到j的合法序列的个数；有f(i,j) = 1 + f(i,j-1) + f(j,abs(i-j)-1)即分为两个部分1）i作为前一个数，从1j-1为当前数的合法序列的个数已经计算好，2）求以j为尾数，后面选择1abs(i-j)-1的合法序列的个数。

如 f(10,5)=f(10,4)+f(5,4);而不是枚举1到5；这样每次解答树只展开两个节点，相当于减少一层循环，虽然解答树的层次还是很深，但是由于记忆的存在，解空间仍然是N的平方。可在100ms内解决。

参考代码：
import java.util.Scanner;

public class _09_02 {
    static final int MOD = 10000;
    static int N;
    static long ans;
    static long[][] mem = new long[1001][1000];
    static Scanner sc;

    static long dfs(int pre, int cur) {
        if (cur <= 0) return 0;
        // 询问状态
        if (mem[pre][cur] != 0)
            return mem[pre][cur];
        mem[pre][cur] = (1 + dfs(pre, cur - 1) + dfs(cur, Math.abs(pre - cur) - 1)) % MOD;
        return mem[pre][cur];
    }

    static void work() {
        ans = 0;
        N = sc.nextInt();
        long ago = System.currentTimeMillis();
        System.out.println(dfs(N, N));
        System.err.println(System.currentTimeMillis() - ago);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        while (true) {
            work();
        }
    }
}
————————————————
版权声明：本文为CSDN博主「小9」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/zhengwei223/article/details/105065566
```


## 9、长草（BFS）
> 【问题描述】  
小明有一块空地，他将这块空地划分为 n 行 m 列的小块，每行和每列的长度都为1。  
小明选了其中的一些小块空地，种上了草，其他小块仍然保持是空地。这些草长得很快，每个月，草都会向外长出一些，如果一个小块种了草，则它将向自己的上、下、左、右四小块空地扩展，这四小块空地都将变为有草的小块。
请告诉小明，k 个月后空地上哪些地方有草。  
【输入格式】  
输入的第一行包含两个整数 n, m。  
接下来 n 行，每行包含 m 个字母，表示初始的空地状态，字母之间没有空格。如果为小数点，表示为空地，如果字母为 g，表示种了草。  
接下来包含一个整数 k。  
【输出格式】  
输出 n 行，每行包含 m 个字母，表示 k 个月后空地的状态。如果为小数点，表示为空地，如果字母为 g，表示长了草。  
【样例输入】  
4 5  
.g...  
.....  
..g..  
.....  
2  
【样例输出】  
gggg.  
gggg.  
ggggg  
.ggg.  
【评测用例规模与约定】  
对于 30% 的评测用例，2 <= n, m <= 20。  
对于 70% 的评测用例，2 <= n, m <= 100。  
对于所有评测用例，2 <= n, m <= 1000，1 <= k <= 1000。  
   
题解：O(N*M)  
```java
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main9 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int intN = in.nextInt();
        int intM = in.nextInt();
        boolean[][] di = new boolean[intN][intM];
        LinkedList<Block> mylist = new LinkedList<>();

        for (int i = 0; i < intN; i++) {
            char[] tmep = in.next().toCharArray();
            for (int j = 0; j < intM; j++) {
                if (tmep[j] == '.') di[i][j] = false;
                else {
                    di[i][j] = true;
                    mylist.add(new Block(i, j, 0));
                }
            }
        }
        int k = in.nextInt();
        long now = System.currentTimeMillis();

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        while (!mylist.isEmpty()) {
            Block block = mylist.removeFirst();
            if (block.k < k) {
                for (int i = 0; i <= 3; i++) {
                    int nx = block.i + dx[i];
                    int ny = block.j + dy[i];
                    if (0 <= nx && nx < intN && 0 <= ny && ny < intM && !di[nx][ny]) {
                        di[nx][ny] = true;
                        mylist.addLast(new Block(nx, ny, block.k + 1));
                    }
                }
            }
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < intN; i++) {
            for (int j = 0; j < intM; j++) {
                if (di[i][j]) writer.write('g');
                else writer.write('.');
            }
            writer.write('\n');
        }
        writer.flush();
        System.err.println(System.currentTimeMillis()-now);
    }

    private static class Block {
        int i;
        int j;
        int k;

        public Block(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
}
```

## 10、晚会节目单（区间最值查询）【做错了】
```
【问题描述】
小明要组织一台晚会，总共准备了 n 个节目。然后晚会的时间有限，他只能最终选择其中的 m 个节目。
这 n 个节目是按照小明设想的顺序给定的，顺序不能改变。
小明发现，观众对于晚会的喜欢程度与前几个节目的好看程度有非常大的关系，他希望选出的第一个节目尽可能好看，在此前提下希望第二个节目尽可能好看，依次类推。
小明给每个节目定义了一个好看值，请你帮助小明选择出 m 个节目，满足他的要求。
【输入格式】
输入的第一行包含两个整数 n, m ，表示节目的数量和要选择的数量。
第二行包含 n 个整数，依次为每个节目的好看值。
【输出格式】
输出一行包含 m 个整数，为选出的节目的好看值。
【样例输入】
5 3
3 1 2 5 4
【样例输出】
3 5 4
【样例说明】
选择了第1, 4, 5个节目。
【评测用例规模与约定】
对于 30% 的评测用例，1 <= n <= 20；
对于 60% 的评测用例，1 <= n <= 100；
对于所有评测用例，1 <= n <= 100000，0 <= 节目的好看值 <= 100000。
```

题解：
```java
错误思路
如果用两次排序求解，那就错了。因为并不是要选出的方案的好看值总和最大，而是要从前往后尽量好看。

思路 O(N^2)
此题关键在于“第一个节目尽可能好看”并希望“第二个节目尽可能好看”……那么我们选择的第一节目就是max(g[0]~g[n-m])闭区间，要选择的第二个节目是max(g[lastMax+1],g[n-m+1])及从上一个节目往下到n-m+1这个区间里面选最好看的，直到剩下的必须全部选择。

算法用尺取法，双指针移动。理论上的复杂度是O(M*(N-M))，极端情况是M=N/2，整体达到(N^2)/2。如果输入数据为：

100000 50000
100000 99999 ...
实测运行时间为：10秒以上

参考代码
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _10_1 {
    public static Scanner sc = new Scanner(System.in);
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = sc.nextInt();
        M = sc.nextInt();
        int[] games = new int[N];
        for (int i = 0; i < N; i++) {
            games[i] = sc.nextInt();
        }
        int pos_max = 0, pos_1 = 0, pos_2 = N - M;
        while (pos_1 < pos_2 && pos_2 < N) {
            while (pos_1 < pos_2)
                if (games[++pos_1] > games[pos_max]) pos_max = pos_1;
            bw.write(games[pos_max] + " ");
            pos_1 = pos_max + 1;
            pos_2++;
            pos_max = pos_1;
        }
        while (pos_2 != N) {
            bw.write(games[pos_2++] + " ");
        }
        bw.write('\n');
        bw.flush();
    }
}


优化：区间最值查询 O(NlogN)
while (pos_1 < pos_2)
	if (games[++pos_1] > games[pos_max])pos_max = pos_1;

这一段代码是区间内查询最大值，反复多次，且数据是静态的，所以选择ST做RMQ。

f[i][j]表示以 i 为起点，连续 2^j 个数中的最大值（的下标）；

转移方程就是：f[i][j] = data[f[i][j-1]] >= data[f[i+pow_2(j-1)][j-1]]?f[i][j-1]:f[i+pow_2(j-1)][j-1]; 注：比较原始数据，记录下标

由于预处理是O(nlogn)，M次查询是O(M)，每次查询是O(1)，所以整体复杂度为O(nlogn)。

下列代码实测运行时间100ms以内

参考代码
import java.io.*;
import java.util.Scanner;

public class _10_2 {
    public static Scanner sc;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    private static int[] data;

    /*===st rmq begin===*/
    private static int[][] st;
    private static int[] Log;

    private static int pow_2(int x) {
        return 1 << x;
    }

    private static void initLog() {
        Log = new int[N + 1];
        Log[1] = 0;
        for (int i = 2; i <= N; i++) {
            Log[i] = Log[i / 2] + 1;
        }
    }

    private static void initSt() {
        st = new int[N][Log[N]+1];
        for (int i = 0; i < N; i++) {
            st[i][0] = i;//注意此处记录索引
        }
        for (int j = 1; pow_2(j) < N; j++) {
            for (int i = 0; i + pow_2(j - 1) < N; i++) {
                int index1 = st[i][j - 1];
                int index2 = st[i + pow_2(j - 1)][j - 1];
                st[i][j] = data[index1] > data[index2] ? index1 : index2;
            }
        }
    }

    private static int query(int l, int r) {
        int len = r - l + 1;
        int k = Log[len];

        int index1 = st[l][k];
        int index2 = st[r - pow_2(k) + 1][k];

        return data[index1] > data[index2] ? index1 : index2;
    }
    /*===st rmq end===*/

    public static void main(String[] args) throws IOException {
        long ago = System.currentTimeMillis();
        System.setIn(new FileInputStream(new File("E:\\data\\my10_1.in")));
        sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = sc.nextInt();
        }
//        初始化st数据
        initLog();
        initSt();
        int pos_max = 0, pos_1 = 0, pos_2 = N - M;
        while (pos_1 < pos_2 && pos_2 < N) {
//            while (pos_1 < pos_2)
//                if (data[++pos_1] > data[pos_max]) pos_max = pos_1;
            pos_max = query(pos_1, pos_2);
            bw.write(data[pos_max] + " ");
            pos_1 = pos_max + 1;
            pos_2++;
//            pos_max = pos_1;
        }
        while (pos_2 != N) {
            bw.write(data[pos_2++] + " ");
        }
        bw.write('\n');
        bw.flush();
        System.err.println(System.currentTimeMillis() - ago);
    }
}
————————————————
版权声明：本文为CSDN博主「小9」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/zhengwei223/article/details/105065566
```

