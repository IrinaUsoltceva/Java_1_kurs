package objectTask;

public class Rational {
    private long n;
    private long d;

    public static final Rational ONE = new Rational(1,1);
    public static final Rational ZERO = new Rational(0,1);

    public Rational(long n, long d) {
        this.n = n;
        this.d = d;
        normalize();
    }

    public Rational(long n) {
        this(n, 1);
    }

    public long getN() {
        return n;
    }

    public long getD() {
        return d;
    }

    public String toString() {
        //if (n.equals(0))
        if (n == 0)
            return "0";
        if (d == 1)
            return String.valueOf(n);
        if (d == 0)
            return "Ошибка";
        return String.valueOf(n) + "/" + String.valueOf(d);
    }

    public double toDouble() {
        if (d == 0)
            return 0;
        else
            return (double) n / (double) d;
    }

    public Rational add(Rational r2) {
        long a = n * r2.getD() + r2.getN() * d;
        long b = d * r2.getD();
        return new Rational(a,b);
        /*return new Rational(n * r2.getD() +
                r2.getN() * d,
                d * r2.getD());*/
    }

    public static Rational adds (Rational r1, Rational r2) {
        long a = r1.getN() * r2.getD() + r2.getN() * r1.getD();
        long b = r1.getD() * r2.getD();
        return new Rational(a,b);
    }

    public void addInPlace(Rational r2) {
        n = n * r2.d +
                r2.getN() * d;
        d = d * r2.getD();

        normalize();
    }

    public Rational sub(Rational r2) {
        return new Rational(n * r2.getD() -
                r2.getN() * d,
                d * r2.getD());
    }

    public static Rational subs(Rational r1, Rational r2) {
        return new Rational(r1.getN() * r2.getD() -
                r2.getN() * r1.getD(),
                r1.getD() * r2.getD());
    }

    public void subInPlace(Rational r2) {
        n = n * r2.getD() -
                r2.getN() * d;
        d = d * r2.getD();
        normalize();
    }

    public Rational mul(Rational r2) {
        return new Rational(n * r2.getN(), d * r2.getD());
    }

    public static Rational mul(Rational r1, Rational r2) {
//        return new Rational(r1.getN() * r2.getN(), r1.getD() * r2.getD());
        return r1.mul(r2);
    }

    public void mulInPlace(Rational r2) {
        n = n * r2.getN();
        d = d * r2.getD();
        normalize();
    }

    public Rational div(Rational r2) {
        return new Rational(n * r2.getD(), d * r2.getN());
    }

    public static Rational divs(Rational r1, Rational r2) {
        return new Rational(r1.getN() * r2.getD(), r1.getD() * r2.getN());
    }

    public void divInPlace(Rational r2) {
        n = n * r2.getD();
        d = d * r2.getN();
        normalize();
    }

    private void normalize() {
        long nod = bringNOD(n, d);
        n = n / nod;
        d = d / nod;
        if (d < 0) {
            n = -n;
            d = -d;
        }
    }

    private static long bringNOD(long n, long d) {
        long a = Math.abs(n);
        long b = Math.abs(d);
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;
    }
}
