public class FractionsTest {
    public static void main(String[] args) {
        Fractions frac = new Fractions(1,1); //initial fraction of 1/1

        System.out.println(frac); //print first fraction

        frac.setNum(5); //tests setting numerator
        System.out.println(frac.numerator); //should return 5
        frac.setDenom(6); //tests setting denominator
        System.out.println(frac.denominator); //should return 6

        //fraction is now 5/6
        System.out.println(frac.getNum() + "/" + frac.getDenom()); //prints new fraction which should be 5/6

        //tests if 5/6 is equal to 100/100
        System.out.println(frac.equals(new Fractions(100,100))); //should return false

        //tests adding 5/6 and 2/3
        System.out.println(frac.add(new Fractions(2,3))); //should return in reduced form, 27/18 -> 3/2
    }
}
