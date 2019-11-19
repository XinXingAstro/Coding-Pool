public class Sqrt {
    public static double sqrt(double c) {
        if (c < 0) return Double.NaN;
        double err = 1e-15; //err表示误差
        double x = c; //x初始值可以随便设置
        while (Math.abs(c - x*x) > err)
            x = (c/x + x) / 2.0;
        return x;
    }
}