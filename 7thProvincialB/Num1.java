package lanqiao.provincialB.num7;

// 171700
public class TianKong1 {

    public static void main(String[] args) {
        int a = 1;  // 层
        int b = 2;  // 每层比上层加了多少
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += a;
            a += b;
            b++;
        }
        System.out.println(sum);
    }
}
