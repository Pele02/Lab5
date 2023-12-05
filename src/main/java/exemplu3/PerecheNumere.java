package exemplu3;

public class PerecheNumere {
    private int a;
    private int b;

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public PerecheNumere() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "PerecheNumere: " + "a=" + a + ", b=" + b;
    }

    static boolean isFibonacciPair(int a, int b) {
        int c = a + b;
        return isPerfectSquare(5 * c * c + 4) || isPerfectSquare(5 * c * c - 4);
    }

    static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }




    // Metoda pentru a calcula CMMMC a două numere folosind CMMDC
    static int calculeazaCMMMC(int a, int b) {
        return (a * b) / gasesteCMMDC(a, b);
    }

    // Metoda pentru a găsi CMMDC a două numere folosind algoritmul Euclid
    static int gasesteCMMDC(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
