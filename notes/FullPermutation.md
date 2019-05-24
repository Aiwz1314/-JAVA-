
    public class FullPermutation {

      public static int total = 0;

      public static void swap(String[] str, int i, int j) {
        String temp = new String();
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
      }

      public static void arrange(String[] str, int st, int len) {
        if (st == len - 1) {
          for (int i = 0; i < len; i++) {
            System.out.print(str[i] + "  ");
          }
          System.out.println();
          total++;
        } else {
          for (int i = st; i < len; i++) {
            swap(str, st, i);
            arrange(str, st + 1, len);
            swap(str, st, i);
          }
        }

      }


      public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str[] = { "a", "b", "c" };
        arrange(str, 0, str.length);


        System.out.println(total);

      }
    }
    
关键的就是arrange方法的else里面的内容，我的理解是（以求str[] = {"a","b","c"}的排列为例子）：

用i从str[st]做一遍循环：

每一次循环中，都要将str[st]与str[i]互相调换位置：

第一次，开始  "a"与自己换，递归调用arrange[str, st + 1, len]这是在求取{"b", "c"}的排列；

第二次，"a"与"b"互相调换，递归调用arrange[str, str + 1, len]就是在求取{"a", "c"}的排列。

第三次，"a"与"c"互相调换，递归调用arrange[str, str + 1, len]就是在求取{"b", "a"}的排列。

--------------------- 
作者：randyjiawenjie  
来源：CSDN   
原文：https://blog.csdn.net/randyjiawenjie/article/details/6313729   
版权声明：本文为博主原创文章，转载请附上博文链接！  
