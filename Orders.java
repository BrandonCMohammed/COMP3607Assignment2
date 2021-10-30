import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Orders {

    private String ID;
    private String type;
    private ArrayList<String> SnacksByID = new ArrayList<String>();

    public Orders(String ID, String type, ArrayList<String> SnacksByID) {

        this.ID = ID;
        this.type = type;
        this.SnacksByID = SnacksByID;

    }

    public String getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public ArrayList<String> getSnacksByID() {
        return SnacksByID;
    }

    private String itemsCombosandPrice() throws FileNotFoundException {

        ArrayList<Item> items = FileOpener.ItemFileOpener();
        ArrayList<Combo> combos = FileOpener.ComboFileOpener();
        String toReturn = "";
        double price = 0;

        for (String s : getSnacksByID()) {
            if (s.length() == 3) {
                for (Item i : items) {
                    if (i.getID().equals(s)) {
                        toReturn = toReturn + " " + i.getID() + " ";
                        price = price + i.getPrice();
                    }
                }
            } else if (s.length() == 5) {
                for (Combo c : combos) {
                    if (c.getID().equals(s)) {
                        toReturn = toReturn + " " + c.getID() + " ";
                        price = price + c.getPrice();
                    }
                }

            }
        }

        return "$" + Double.toString(price) + toReturn;
    }

    public String toString() {

        String returnString = getID() + " " + getType() + " ";
        try {
            returnString = returnString + " " + itemsCombosandPrice();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return returnString;

    }
}
