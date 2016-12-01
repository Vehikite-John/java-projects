// followed this tutorial: https://www.youtube.com/watch?v=aR1B8MlwbRI&t=21s
public class SandwichSculptor {

    public static void main(String[] args) {
        Hoagie cust12Hoagie = new ItalianHoagie();
        cust12Hoagie.makeSandwich();
        System.out.println();
        Hoagie cust13Hoagie = new VeggieHoagie();
        cust13Hoagie.makeSandwich();
    }
}
