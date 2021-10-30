import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Combo implements Snack {

    private String ID = "";
    private String Name = "";
    private ArrayList<String> Snacks = new ArrayList<String>();

    public Combo(String ID, String Name, ArrayList<String> Snacks) {
        this.ID = ID;
        this.Name = Name;
        this.Snacks = Snacks;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public ArrayList<String> getSnacksList() {
        return Snacks;
    }

    private String listOfSnacks() {

        ArrayList<String> snacksList = getSnacksList();
        String st = "";

        for (String s : snacksList) {
            st = st + s + " ";
        }

        return st;
    }

    private double getItemPrice(String itemID) throws FileNotFoundException {

        ArrayList<Item> items = FileOpener.ItemFileOpener();
        double price = 0;

        for (Item i : items) {
            if (i.getID().equals(itemID)) {
                price = i.getPrice();

            }
        }

        return price;
    }

    private double snacksPrice() throws FileNotFoundException {
        ArrayList<String> snacksList2 = getSnacksList();
        double price = 0;

        for (String s : snacksList2) {
            if (s.length() == 3) {
                price = price + getItemPrice(s);

            } else if (s.length() == 5) {

                price = price + individualComboPrice(s);
            }
        }

        return price;
    }

    private double individualComboPrice(String c) throws FileNotFoundException {

        ArrayList<Combo> combos = FileOpener.ComboFileOpener();
        ArrayList<String> snacksList = new ArrayList<>();
        double price = 0;

        for (Combo co : combos) {
            if (co.getID().equals(c)) {
                snacksList = co.getSnacksList();
            }

            for (String s : snacksList) {
                if (s.length() == 3) {
                    price = price + getItemPrice(s);
                } else if (s.length() == 5) {
                    price = price + individualComboPrice(s);
                }
            }
        }

        return price - (price * 0.2);
    }

    public double getPrice() {

        double price = 0;
        try {
            price = snacksPrice();
            price = price - (price * 0.2);
            return price;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;

    }

    public void addSnacks(String snack) {
        Snacks.add(snack);
    }

    public int getNumItems() {
        return Snacks.size();
    }

    public String toString() {
        String returnString = getID() + " " + getName() + " $" + getPrice() + " " + listOfSnacks();
        return returnString;
    }

}
