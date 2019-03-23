# 1 Array.sort()
### 1.1 数字排序
    int[] num =newint[]{4,2,3,5,-8,5,2,3};  
    Arrays.sort(num); 
    for(int i = 0; i < 8;i++) 
          System.out.print(num[i]+”,”); 
    输出结果：-8,2,2,3,3,4,5,5,
    
### 1.2 字符串排序（先大写后小写原则）
    Sring[] s = new String[]{"Z", "a", "A", "z"};
    Array.sort(s);
    for(int i=0; i<4; i++)
        System.out.println(s[i] + ",");
    输出结果：A,Z,a,z,



--------------------- 
作者：残舞乱步 
来源：CSDN 
原文：https://blog.csdn.net/junwei_yu/article/details/17122981 
版权声明：本文为博主原创文章，转载请附上博文链接！   
