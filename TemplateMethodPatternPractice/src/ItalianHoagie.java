// followed this tutorial: https://www.youtube.com/watch?v=aR1B8MlwbRI&t=21s

public class ItalianHoagie extends Hoagie {

    String[] meatUsed = {"Salami", "Pepperoni", "Capicola Ham"};
    String[] cheeseUsed = {"Provolone"};
    String[] veggiesUsed = {"Lettuce", "Tomatoes", "Onions", "Sweet Peppers"};
    String[] condimentsUsed = {"Oil", "Vinegar"};

    @Override
    void addMeat() {
        System.out.print("Adding the meat: ");
        for (String meat : meatUsed) {
            System.out.print(meat + " ");
        }
    }

    @Override
    void addCheese() {
        System.out.print("Adding the cheese: ");
        for (String cheese : cheeseUsed) {
            System.out.print(cheese + " ");
        }
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
