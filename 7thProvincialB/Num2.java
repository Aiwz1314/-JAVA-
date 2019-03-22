package lanqiao.provincialB.num7;

// 26
public class Num2 {

    public static void main(String[] args) {

        int sum;
        for (int i = 0; i < 100; i++) {
            sum = 0;
            for (int j = i; j < 100; j++) {
                sum += j;
                if (sum == 236) {
                    System.out.println(i);
                } else if (sum > 236) {
                    continue;
                }
            }
        }
    }
}
