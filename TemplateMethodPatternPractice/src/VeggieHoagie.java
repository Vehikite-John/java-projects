// followed this tutorial: https://www.youtube.com/watch?v=aR1B8MlwbRI&t=21s
public class VeggieHoagie extends Hoagie {

    String[] veggiesUsed = {"Lettuce", "Tomatoes", "Onions", "Sweet Peppers"};
    String[] condimentsUsed = {"Oil", "Vinegar"};

    @Override
    boolean customerWantsMeat() {
        return false;
    }

    @Override
    boolean customerWantsCheese() {
        return false;
    }

    @Override
    void addMeat() {
    }

    @Override
    void addCheese() {
    }

    @Override
    void addVegetables() {
        System.out.print("Adding the veggies: ");
        for (String veg : veggiesUsed) {
            System.out.print(veg + " ");
        }
    }

    @Override
    void addCondiments() {
        System.out.print("Adding the condiments: ");
        for (String condiment : condimentsUsed) {
            System.out.print(condiment + " ");
        }
    }
}
