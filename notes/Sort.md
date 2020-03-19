# 1 Array.sort()
### 1.1 数字排序
    int[] num =newint[]{4,2,3,5,-8,5,2,3};  
    Arrays.sort(num); 
    for(int i = 0; i < 8;i++) 
          System.out.print(num[i]+”,”); 
    输出结果：-8,2,2,3,3,4,5,5,
    
    Comparator<Integer> cmp = new Comparator<Integer>() {
		public int compare(Integer i1, Integer i2) {
			return i2-i1;
		}
	};
	Arrays.sort(arr, cmp);
    输出结果：5,5,4,3,3,2,2,-8,

    
### 1.2 字符串排序（先大写后小写原则）
    Sring[] s = new String[]{"Z", "a", "A", "z"};
    Array.sort(s);
    for(int i=0; i<4; i++)
        System.out.println(s[i] + ",");
    输出结果：A,Z,a,z,
    
### 1.3 严格按照字母表排序（即忽略大小写）
    String[] s = new String[]{"Z","a","A","z"};
    Arrays.sort(s,String.CASE_INSENSITIVE_ORDER);
    for(int i = 0; i < 4;i++)
        System.out.print(s[i] +",");
    输出结果：a,A,Z,z,
    
### 1.4 忽略大小写反向排序
注意： Collections.reverse仅**反转**，不是**降序** 

    String[] s = new String[]{"Z","a","A","z"};
    Arrays.sort(s,String.CASE_INSENSITIVE_ORDER);
    Collections.reverse(Arrays.asList(s));
    for(int i = 0; i < 4;i++)
        System.out.print(s[i] +",");
    输出结果：z,Z,A,a,

### 1.5 对象的排序（类似于C中的结构体的排序）
    import java.util.Arrays;
    import java.util.Comparator;
    public class Main
    {
       public static void main(String[] args)
       {
          Dogd1 = new Dog("dog1",1);
          Dogd2 = new Dog("dog2",2);
          Dogd3 = new Dog("dog3",3);
          Dogd4 = new Dog("dog4",4);
          Dogd5 = new Dog("dog5",5);
          Dog[]dogs = new Dog[] {d1,d2,d3,d4,d5};
          Arrays.sort(dogs,new ByWeightComparator());
          for(int i = 0; i <dogs.length; i++)
          {
              Dog dog = dogs[i];
              System.out.print(dog.getName()+",");
          }
       }
    }
    class Dog //定义一个“狗类”
    {
        private String name;
        private int weight;
        public Dog(String name, int weight)
        {
            this.setName(name);
            this.weight = weight;
        }
        public int getWeight()
        {
            return weight;
        }
    public void setWeight(int weight)
    {this.weight = weight;}
    public void setName(Stringname)
    {this.name = name;}
    public String getName()
    {return name;}
    }
    class ByWeightComparator implements Comparator
    {
    public final int compare(Object pFirst, Object pSecond)
    {
      int aFirstWeight = ((Dog)pFirst).getWeight();
      int aSecondWeight = ((Dog)pSecond).getWeight();
      int diff = aFirstWeight - aSecondWeight;
      if(diff >= 0)
          return -1;
      else if(diff < 0)
          return 1;
      return 0;
    }
    }
    输出结果：dog5,dog4,dog3,dog2,dog1,




--------------------- 
作者：残舞乱步  
来源：CSDN  
原文：https://blog.csdn.net/junwei_yu/article/details/17122981  
版权声明：本文为博主原创文章，转载请附上博文链接！  
