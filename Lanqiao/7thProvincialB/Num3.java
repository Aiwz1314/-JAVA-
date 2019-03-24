package lanqiao.provincialB.num7;

// 29
public class Num3 {

    // 检查是否重复 true代表有重复
    private static boolean check(int[] temp) {
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (temp[i] == temp[j])
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = new int[9];
        int sum = 0;
        for (num[0] = 1; num[0] < 10; num[0]++) {
            for (num[1] = 1; num[1] < 10; num[1]++) {
                for (num[2] = 1; num[2] < 10; num[2]++) {
                    for (num[3] = 1; num[3] < 10; num[3]++) {
                        for (num[4] = 1; num[4] < 10; num[4]++) {
                            for (num[5] = 1; num[5] < 10; num[5]++) {
                                for (num[6] = 1; num[6] < 10; num[6]++) {
                                    for (num[7] = 1; num[7] < 10; num[7]++) {
                                        for (num[8] = 1; num[8] < 10; num[8]++) {
                                            if (check(num)) {
                                                continue;
                                            }
                                            float a = num[0];
                                            float b = num[1];
                                            float c = num[2];
                                            if (c == 0) {
                                                continue;
                                            }
                                            float def = num[3]*100+num[4]*10+num[5];
                                            float ghi = num[6]*100+num[7]*10+num[8];
                                            if (ghi == 0) {
                                                continue;
                                            }
                                            if (a + b/c + def/ghi == 10) {
                                                System.out.println(a + " " + b + "/" + c + " " + num[3]+""+num[4]+""+num[5]+"/"+num[6]+""+num[7]+""+num[8]);
                                                sum++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sum);
    }


}
