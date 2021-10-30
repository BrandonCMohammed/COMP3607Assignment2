public class Item implements Snack {

    private String ID = "";
    private String Name = "";
    private double price = 0.00;

    public Item(String ID, String Name, double price) {
        this.ID = ID;
        this.Name = Name;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return price;
    }

    public int getNumItems() {
        return 0;
    }

    public String toString() {
        return getID() + " " + getName() + " " + getPrice();
    }

}
