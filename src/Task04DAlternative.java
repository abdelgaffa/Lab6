public class Task04DAlternative {
    public static void main(String[] args) {

        MyFunction funcObject = (x) -> {
            double sum = 0.0;
            for (int k = 1; k <= 100; k++) {
                sum += Math.pow(x / (Math.PI * k) - 1.0, 2.0);
            }
            return sum;
        };

        MyFunction[] functionArray = {
                Math::cos,
                Task04DAlternative::funcB,
                (x) -> (-Math.pow(x / Math.PI, 2.0) - 2.0 * x + 5.0 * Math.PI),
                funcObject,
                new MyFunction() {
                    @Override
                    public double func(double x) {
                        if (x < 0) {
                            return 0.25 * Math.sin(x) * Math.sin(x) + 1.0;
                        }
                        return 0.5 * Math.cos(x) - 1.0;
                    }
                }
        };

        for (int i = 0; i < functionArray.length; i++) {
            int count = countFunctionValues(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, functionArray[i], x -> x < 0);
            System.out.println("---------------");
            System.out.println(" for f[" + i + "] kal = " + count);
            System.out.println("==========================");
        }

        for (int i = 0; i < functionArray.length; i++) {
            int count = countFunctionValues(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, functionArray[i], x -> (x >= -1.0 && x <= 1.0));
            System.out.println("---------------");
            System.out.println(" for f[" + i + "] kal[1 , -1] = " + count);
            System.out.println("==========================");
        }
    }

    public static double funcB(double x){
        return 2.0*Math.sqrt(Math.abs(x-1.0))+1.0;
    }

    public static int countFunctionValues(double a, double b, double dx, MyFunction f, MyPredicate p) {
        int k = 0;
        for (double x = a; x < b + dx; x += dx) {
            double y = f.func(x);
            System.out.println(" x = " + x + "\t f(x) = " + y);
            if (p.check(y)) k++;
        }
        return k;
    }

    public static void printFunctionValues(double a, double b, double dx, MyFunction f){
        for (double x = a; x < b + dx; x += dx) {
            System.out.println(" x = " + x + "\t f(x) = " + f.func(x));
        }
    }
}

public interface MyFunction {
    double func(double x);
}

public interface MyPredicate {
    boolean check(double x);
}
