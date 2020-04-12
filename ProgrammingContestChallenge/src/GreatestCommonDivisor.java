import java.util.Scanner;

/*
* 最大公约数
* 欧几里德算法（辗转相除法） gcd(a, b) = gcb(b, a%b)
* 时间复杂度小于O(log(max(a,b)))
* */
public class GreatestCommonDivisor {
    public static int a;
    public static int b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println(new GreatestCommonDivisor().gcd(a, b));
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
