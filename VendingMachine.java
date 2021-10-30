import java.io.FileNotFoundException;
import java.util.ArrayList;

public class VendingMachine {

    public VendingMachine() throws FileNotFoundException {

    }

    public void OrdersReceip() throws FileNotFoundException {
        ArrayList<Orders> orders = FileOpener.OrdersFileOpener();

        for (Orders o : orders) {
            System.out.println(o.toString());
        }
    }

    public void ItemsList() throws FileNotFoundException {

        ArrayList<Item> items = FileOpener.ItemFileOpener();

        for (Item i : items) {
            System.out.println(i.toString());
        }
    }

    public void ComboList() throws FileNotFoundException {

        ArrayList<Combo> combos = FileOpener.ComboFileOpener();

        for (Combo c : combos) {
            System.out.println(c.toString());
        }

    }

}
