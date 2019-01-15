/**
 * Java Assignment 2
 * gift is a class that extends item which contains 2 variables
 * @author mattobrien
 * @date 02/11/2018
 * @version 1
 */

public class gift extends item {
    private String label = "unknown";
    private String manufacturer = "unknown";

    /**
     * constructor which calls the super when creating a gift
     * @param l
     * @param m
     * @param p
     * @param q
     * @param id
     */
    gift(String l, String m, double p, int q, int id){
        super(p,q,id);
        setLabel(l);
        setManufacturer(m);
    }

    /**
     * setter for Label
     * @param l
     */
    private void setLabel(String l) {
        if(!l.equals("unknown")){
            this.label = l;
        }
        else{
            System.out.println("Invalid Label!");
        }
    }

    /**
     * setter for Manufacturer
     * @param m
     */
    private void setManufacturer(String m) {
        if(!m.equals("unknown")){
            this.manufacturer = m;
        }
        else{
            System.out.println("Invalid Manufacturer!");
        }
    }

    /**
     * getter for Label
     * @return label
     */
    public String getLabel(){
        return label;
    }

    /**
     * getter for Manufacturer
     * @return manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Displayed method to display info about the gift to the screen
     * @return
     */
    public String Displayed(){
            return "/Gift/ Label: " + getLabel() + ", Manufacturer: " + getManufacturer() +
                    ", Quantity: " + super.getQuantity() + ", Price: " + super.getPrice() +
                    ", and Item ID: "+ super.getItem_id();
    }

    /**
     * Purchased method to remove user entered quantity from the item
     * @param q
     */
    public void Purchased(int q){
        if(quantity >= q){
            quantity -= q;
            System.out.println("Updated Inventory:");
            System.out.println(Displayed());
        }
        else{
            System.out.println("Inventory only contains " + quantity + "items!");
        }
    }
}
