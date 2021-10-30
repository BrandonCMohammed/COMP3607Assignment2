import java.io.FileNotFoundException;

public class Cafeteria {

    public static void main(String[] args) throws FileNotFoundException {

        VendingMachine v = new VendingMachine();
        System.out.println("ITEMS");
        v.ItemsList();
        System.out.println("\nCOMBO LIST");
        v.ComboList();
        System.out.println("\nORDERS");
        v.OrdersReceip();

        return;
    }

}
