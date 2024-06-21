package polinom;

public class Polinom {
    //create a java app that calculates arithmetical operation on polinoms, like sum and difference. Polinoms will be defined by their elements coefficients and powers
//polinom1 = 3x^2 + 2x + 1  polinom2 = 2x^2 + 3x + 4
//sum = 5x^2 + 5x + 5
//difference = x^2 + x - 3
//use a class Polinom with a constructor that receives the coefficients and powers of the polinom   Polinom(int[] coef, int[] pow)
//use a method sum(Polinom p) that returns the sum of the current polinom with the one received as parameter
//use a method difference(Polinom p) that returns the difference of the current polinom with the one received as parameter
//use a method print() that prints the polinom in a human readable form
//use a class Main that creates two polinoms, calculates the sum and difference and prints the results
//write this classes in a package called polinom
    int[] coef;
    int[] pow;

    public Polinom(int[] coef, int[] pow) {
        this.coef = coef;
        this.pow = pow;
    }


    public Polinom sum(Polinom p) {
        int[] coefSum = new int[coef.length + p.coef.length];
        int[] powSum = new int[pow.length + p.pow.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < coef.length && j < p.coef.length) {
            if (pow[i] == p.pow[j]) {
                coefSum[k] = coef[i] + p.coef[j];
                powSum[k] = pow[i];
                i++;
                j++;
                k++;
            } else if (pow[i] > p.pow[j]) {
                coefSum[k] = coef[i];
                powSum[k] = pow[i];
                i++;
                k++;
            } else {
                coefSum[k] = p.coef[j];
                powSum[k] = p.pow[j];
                j++;
                k++;
            }
        }
        while (i < coef.length) {
            coefSum[k] = coef[i];
            powSum[k] = pow[i];
            i++;
            k++;
        }
        while (j < p.coef.length) {
            coefSum[k] = p.coef[j];
            powSum[k] = p.pow[j];
            j++;
            k++;
        }
        int[] coefSumFinal = new int[k];
        int[] powSumFinal = new int[k];
        for (i = 0; i < k; i++) {
            coefSumFinal[i] = coefSum[i];
            powSumFinal[i] = powSum[i];
        }
        return new Polinom(coefSumFinal, powSumFinal);
    }

    public Polinom difference(Polinom p) {
        int[] coefDiff = new int[coef.length + p.coef.length];
        int[] powDiff = new int[pow.length + p.pow.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < coef.length && j < p.coef.length) {
            if (pow[i] == p.pow[j]) {
                coefDiff[k] = coef[i] - p.coef[j];
                powDiff[k] = pow[i];
                i++;
                j++;
                k++;
            } else if (pow[i] > p.pow[j]) {
                coefDiff[k] = coef[i];
                powDiff[k] = pow[i];
                i++;
                k++;
            } else {
                coefDiff[k] = -p.coef[j];
                powDiff[k] = p.pow[j];
                j++;
                k++;
            }
        }
        while (i < coef.length) {
            coefDiff[k] = coef[i];
            powDiff[k] = pow[i];
            i++;
            k++;
        }
        while (j < p.coef.length) {
            coefDiff[k] = -p.coef[j];
            powDiff[k] = p.pow[j];
            j++;
            k++;
        }
        int[] coefDiffFinal = new int[k];
        int[] powDiffFinal = new int[k];
        for (i = 0; i < k; i++) {
            coefDiffFinal[i] = coefDiff[i];
            powDiffFinal[i] = powDiff[i];
        }
        return new Polinom(coefDiffFinal, powDiffFinal);
    }

    public void print() {
        for (int i = 0; i < coef.length; i++) {
            if (coef[i] > 0) {
                System.out.print(" + " + coef[i] + "x^" + pow[i]);
            } else if (coef[i] < 0) {
                System.out.print(" - " + (-coef[i]) + "x^" + pow[i]);
            }
        }
        System.out.println();
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < coef.length; i++) {
            if (coef[i] > 0) {
                s += " + " + coef[i] + "x^" + pow[i];
            } else if (coef[i] < 0) {
                s += " - " + (-coef[i]) + "x^" + pow[i];
            }
        }
        return s;
    }

    public Polinom multiply(Polinom p) {
        int[] coefMult = new int[coef.length * p.coef.length];
        int[] powMult = new int[pow.length * p.pow.length];
        int k = 0;
        for (int i = 0; i < coef.length; i++) {
            for (int j = 0; j < p.coef.length; j++) {
                coefMult[k] = coef[i] * p.coef[j];
                powMult[k] = pow[i] + p.pow[j];
                k++;
            }
        }
        return new Polinom(coefMult, powMult);
    }

    public Polinom divide(Polinom p) {
        int[] coefDiv = new int[coef.length * p.coef.length];
        int[] powDiv = new int[pow.length * p.pow.length];
        int k = 0;
        for (int i = 0; i < coef.length; i++) {
            for (int j = 0; j < p.coef.length; j++) {
                coefDiv[k] = coef[i] / p.coef[j];
                powDiv[k] = pow[i] - p.pow[j];
                k++;
            }
        }
        return new Polinom(coefDiv, powDiv);


    }

    public Polinom normalize() {
        int[] coefNorm = new int[coef.length];
        int[] powNorm = new int[pow.length];
        int k = 0;
        for (int i = 0; i < coef.length; i++) {
            if (coef[i] != 0) {
                coefNorm[k] = coef[i];
                powNorm[k] = pow[i];
                k++;
            }
        }
        int[] coefNormFinal = new int[k];
        int[] powNormFinal = new int[k];
        for (int i = 0; i < k; i++) {
            coefNormFinal[i] = coefNorm[i];
            powNormFinal[i] = powNorm[i];
        }
        return new Polinom(coefNormFinal, powNormFinal);
    }
}