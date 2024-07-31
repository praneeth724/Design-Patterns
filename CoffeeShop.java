interface AddingIngredientsBehaviour {
    void addingIngredients();
}

interface ServeBehaviour {
    void serve();
}

// Implement the AddingIngredientsBehaviour strategies
class AddNothing implements AddingIngredientsBehaviour {
    public void addingIngredients() {
        System.out.println("Adding nothing...");
    }
}

class AddMilk implements AddingIngredientsBehaviour {
    public void addingIngredients() {
        System.out.println("Adding milk...");
    }
}

class AddIce implements AddingIngredientsBehaviour {
    public void addingIngredients() {
        System.out.println("Adding ice...");
    }
}

// Implement the ServeBehaviour strategies
class ServeInSmallCup implements ServeBehaviour {
    public void serve() {
        System.out.println("Serving in small cup...");
    }
}

class ServeInMediumCup implements ServeBehaviour {
    public void serve() {
        System.out.println("Serving in medium cup...");
    }
}

class ServeInTallGlass implements ServeBehaviour {
    public void serve() {
        System.out.println("Serving in tall glass...");
    }
}

class ServeInTallMug implements ServeBehaviour {
    public void serve() {
        System.out.println("Serving in tall mug...");
    }
}

// The Coffee class that uses the strategy interfaces
abstract class Coffee {
    AddingIngredientsBehaviour addingIngredientsBehaviour;
    ServeBehaviour serveBehaviour;

    public void setAddingIngredientsBehaviour(AddingIngredientsBehaviour aib) {
        addingIngredientsBehaviour = aib;
    }

    public void setServeBehaviour(ServeBehaviour sb) {
        serveBehaviour = sb;
    }

    public void performBrew() {
        System.out.println("Brewing coffee...");
    }

    public void performAddIngredients() {
        addingIngredientsBehaviour.addingIngredients();
    }

    public void performServe() {
        serveBehaviour.serve();
    }

    public abstract void display();
}

// Concrete Coffee classes
class Espresso extends Coffee {
    public Espresso() {
        addingIngredientsBehaviour = new AddNothing();
        serveBehaviour = new ServeInSmallCup();
    }

    public void display() {
        System.out.println("This is an Espresso.");
    }
}

class Americano extends Coffee {
    public Americano() {
        addingIngredientsBehaviour = new AddNothing();
        serveBehaviour = new ServeInMediumCup();
    }

    public void display() {
        System.out.println("This is an Americano.");
    }
}

class IceCoffee extends Coffee {
    public IceCoffee() {
        addingIngredientsBehaviour = new AddIce();
        serveBehaviour = new ServeInTallGlass();
    }

    public void display() {
        System.out.println("This is an Ice Coffee.");
    }
}

class MilkCoffee extends Coffee {
    public MilkCoffee() {
        addingIngredientsBehaviour = new AddMilk();
        serveBehaviour = new ServeInTallMug();
    }

    public void display() {
        System.out.println("This is a Milk Coffee.");
    }
}

// Test the strategy pattern
public class CoffeeShop {
    public static void main(String[] args) {
        Coffee espresso = new Espresso();
        espresso.display();
        espresso.performBrew();
        espresso.performAddIngredients();
        espresso.performServe();

//        System.out.println();
//
//        Coffee americano = new Americano();
//        americano.display();
//        americano.performBrew();
//        americano.performAddIngredients();
//        americano.performServe();
//
//        System.out.println();
//
//        Coffee iceCoffee = new IceCoffee();
//        iceCoffee.display();
//        iceCoffee.performBrew();
//        iceCoffee.performAddIngredients();
//        iceCoffee.performServe();
//
//        System.out.println();
//
//        Coffee milkCoffee = new MilkCoffee();
//        milkCoffee.display();
//        milkCoffee.performBrew();
//        milkCoffee.performAddIngredients();
//        milkCoffee.performServe();
    }
}
