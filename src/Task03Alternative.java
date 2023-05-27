public class Task03Alternative {
    public static void main(String[] args) {

        MyFunction1 funcObject = (x) -> {
            double sum = 0.0;
            for (int k = 1; k <= 100; k++) {
                sum += Math.pow(x / (Math.PI * k) - 1.0, 2.0);
            }
            return sum;
        };

        MyFunction1[] functionArray = {
                Math::cos,
                Task03Alternative::funcB,
                (x) -> (-Math.pow(x / Math.PI, 2.0) - 2.0 * x + 5.0 * Math.PI),
                funcObject,
                new MyFunction1() {
                    @Override
                    public double func(double x) {
                        if (x < 0) {
                            return 0.25 * Math.sin(x) * Math.sin(x) + 1.0;
                        }
                        return 0.5 * Math.cos(x) - 1.0;
                    }
                }
        };

        for (MyFunction1 function : functionArray) {
            printFunctionValues(-2.0 * Math.PI, 2.0 * Math.PI, Math.PI / 6.0, function);
            System.out.println("---------------");
        }
    }

    public static double funcB(double x){
        return 2.0*Math.sqrt(Math.abs(x-1.0))+1.0;
    }

    public static void printFunctionValues(double a, double b, double dx, MyFunction1 f){
        for (double x = a; x < b + dx; x += dx) {
            System.out.println(" x = " + x + "\t f(x) = " + f.func(x));
        }
    }
}

interface MyFunc {
    double func(double x);
}
