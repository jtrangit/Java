public class Fractions {
    int numerator;
    int denominator;

    //Constructor for class Fractions
    public Fractions(int n, int d) {
        if (d == 0) {
        throw new ArithmeticException();
        }
        else {
            this.numerator = n;
            this.denominator = d;
        }
    }

    //returns numerator
    public int getNum() {
        return this.numerator;
    }

    //returns denominator
    public int getDenom() {
        return this.denominator;
    }

    //Sets numerator to n
    public void setNum(int n) {
        this.numerator = n;
    }
    
    //Sets denominator to d
    public void setDenom(int d) {
        this.denominator = d;

        if (denominator == 0) {
            throw new ArithmeticException();
            }
    }
    
    //greatest common divisor for euclidean algorithm given by TA
    private int gcd(int a, int b) {
        int factor = b;
        while (b != 0) {
           factor = b;
           b = a % b;
           a = factor;
        }
        return a;
     }

     //function to reduce fractions given by TA
     private Fractions reduce() {
		int common = 0;
		
		// get absolute values for numerator and denominator
		int num = Math.abs(numerator);
		int den = Math.abs(denominator);
		
		// figure out which is less, numerator or denominator
		if(num > den) {
			common = gcd(num, den);
		}
		else if(num < den) {
			common = gcd(den, num);
		}
		else {
			common = num; // if both are the same, don't need to call gcd
		}
		
		// set result based on common factor derived from gcd
		int newNumerator = numerator / common;
		int newDenominator = denominator / common;
		Fractions result = new Fractions(newNumerator, newDenominator);
		
		return result;
		
	}
    //returns sum of Fraction a and subject Fractions
    public Fractions add(Fractions a) {
        int newNum = numerator * a.getDenom() + denominator * a.getNum();
        int newDenom = denominator * a.getDenom();

        Fractions sum = new Fractions(newNum,newDenom);

        sum = sum.reduce();

        return sum;
    }

    public boolean equals(Fractions a) {
        return numerator == a.getNum() && denominator == a.getDenom();
    }

    //String representation of fraction
    public String toString() {
        return numerator + "/" + denominator;
    }
}
