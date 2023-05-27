public class Task01Alternate {
    public static void main(String[] args) {
        computeTable(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, Math::cos);
        System.out.println("---------------");

        computeTable(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, Task01Alternate::fb);
        System.out.println("---------------");

        computeTable(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, (x) -> (-Math.pow(x / Math.PI, 2.0) - 2.0 * x + 5.0 * Math.PI));
        System.out.println("---------------");

        MyFunction1 function = (x) -> {
            double s = 0.0;
            for (int k = 1; k <= 100; k++) {
                s += Math.pow(x / (Math.PI * k) - 1.0, 2.0);
            }
            return s;
        };

        computeTable(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, function);
        System.out.println("---------------");

        computeTable(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, new MyFunction1() {
            @Override
            public double func(double x) {
                if (x < 0) {
                    return 0.25 * Math.sin(x) * Math.sin(x) + 1.0;
                }

                return 0.5 * Math.cos(x) - 1.0;
            }
        });
        System.out.println("---------------");
    }

    public static double fb(double x) {
        return 2.0 * Math.sqrt(Math.abs(x - 1.0)) + 1.0;
    }

    public static void computeTable(double a, double b, double dx, MyFunction1 function) {
        for (double x = a; x < b + dx; x += dx) {
            System.out.println(" x = " + x + "\t f(x) = " + function.func(x));
        }
    }
}

interface MyFunction {
    double func(double x);
}
