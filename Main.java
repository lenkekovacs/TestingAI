import polinom.Polinom;

public class Main {

    //write a code that tests Polinom class
    public static void main(String[] args) {
        int[] coef1 = {1, 2, 3};
        int[] pow1 = {1, 2, 3};
        Polinom p1 = new Polinom(coef1, pow1);
        int[] coef2 = {4, 6, 8};
        int[] pow2 = {1, 2, 3};
        Polinom p2 = new Polinom(coef2, pow2);
        Polinom sum = p1.sum(p2);
        Polinom difference = p1.difference(p2);
        System.out.println("Sum: " + sum.toString());
        System.out.println("Difference: " + difference.toString());
    }
}
