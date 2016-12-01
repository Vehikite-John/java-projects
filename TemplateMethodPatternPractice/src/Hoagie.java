// followed this tutorial: https://www.youtube.com/watch?v=aR1B8MlwbRI&t=21s

public abstract class Hoagie {

    final void makeSandwich() {
        boolean afterFirstIngredient = false;
        cutBun();

        if (customerWantsMeat()) {
            addMeat();
            afterFirstIngredient = true;
        }
        if (customerWantsCheese()) {
            if (afterFirstIngredient) {
                System.out.println();
            }
            addCheese();
            afterFirstIngredient = true;
        }
        if (customerWantsVegetables()) {
            if (afterFirstIngredient) {
                System.out.println();
            }
            addVegetables();
            afterFirstIngredient = true;
        }
        if (customerWantsCondiments()) {
            if (afterFirstIngredient) {
                System.out.println();
            }
            addCondiments();
            afterFirstIngredient = true;
        }

        wrapTheHoagie();
    }

    public void cutBun() {
        System.out.println("The Hoagie is cut");
    }

    abstract void addMeat();

    abstract void addCheese();

    abstract void addVegetables();

    abstract void addCondiments();

    boolean customerWantsMeat() {
        return true;
    }

    boolean customerWantsCheese() {
        return true;
    }

    boolean customerWantsVegetables() {
        return true;
    }

    boolean customerWantsCondiments() {
        return true;
    }

    public void wrapTheHoagie() {
        System.out.println("Wrap the hoagie");
    }
}
