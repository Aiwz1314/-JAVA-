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