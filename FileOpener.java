import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileOpener {

    public static ArrayList<Item> ItemFileOpener() throws FileNotFoundException {

        ArrayList<Item> items = new ArrayList<Item>();
        String ID = "";
        String Name = "";
        double price = 0.00;

        File file = new File("items.txt");
        Scanner scan = new Scanner(file);

        // Put in loop
        while (scan.hasNextLine()) {

            ID = scan.next();
            Name = scan.next();
            price = Double.parseDouble(scan.next().replace("$", ""));

            Item item = new Item(ID, Name, price);
            items.add(item);
            // ends here

        }

        scan.close();

        return items;
    }

    public static ArrayList<Combo> ComboFileOpener() throws FileNotFoundException {

        String ID = "";
        String Name = "";
        ArrayList<Combo> combos = new ArrayList<Combo>();

        File file = new File("combos.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {

            ArrayList<String> Snacks = new ArrayList<String>();
            String line = scan.nextLine();
            Scanner lineScanner = new Scanner(line);

            while (lineScanner.hasNext()) {

                ID = lineScanner.next();
                Name = lineScanner.next();
                // test is its 3 or 5, if not, split string

                while (lineScanner.hasNext()) {

                    String s = lineScanner.next();

                    if (s.length() == 3 || s.length() == 5) {
                        Snacks.add(s);
                    } else {

                        String[] sArray = s.split(",");
                        List list1 = Arrays.asList(sArray);
                        Snacks.addAll(list1);
                    }

                }

                Combo combo = new Combo(ID, Name, Snacks);
                combos.add(combo);
            }

            lineScanner.close();

        }

        scan.close();
        return combos;

    }

    public static ArrayList<Orders> OrdersFileOpener() throws FileNotFoundException {

        String ID;
        String type;
        ArrayList<Orders> AllOrders = new ArrayList<Orders>();

        File file = new File("orders.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            Scanner lineScanner = new Scanner(scan.nextLine());

            ID = lineScanner.next();
            type = lineScanner.next();
            ArrayList<String> SnacksByID = new ArrayList<String>();

            // test is its 3 or 5, if not, split string
            while (lineScanner.hasNext()) {

                String s = lineScanner.next();
                if (s.length() == 3 || s.length() == 5) {
                    SnacksByID.add(s);
                } else {
                    String[] sArray = s.split(",");
                    List list1 = Arrays.asList(sArray);
                    SnacksByID.addAll(list1);

                }

            }

            Orders order = new Orders(ID, type, SnacksByID);
            AllOrders.add(order);

            lineScanner.close();

        }

        scan.close();
        return AllOrders;
    }

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Orders> order = OrdersFileOpener();
        System.out.println(order.get(0));

        // ArrayList<Combo> combos = ComboFileOpener();
        // System.out.println(combos.get(2).toString());
    }
}