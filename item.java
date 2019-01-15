/**
 * Java Assignment 2
 * Item is an Abstract class that contains 3 variables and two abstract methods
 * @author mattobrien
 * @date 02/11/2018
 * @version 1
 */

public abstract class item {
    protected int item_id;
    protected double price;
    protected int quantity;

    /**
     * abstract methods which must be implemented in other classes
     * @return
     */
    abstract String Displayed();
    abstract void Purchased(int q);

    /**
     * default constructor
     */
    public item(){
        item_id = 0;
        price = 0;
        quantity = 0;
    }

    /**
     * overloaded constructor
     * @param p
     * @param q
     * @param id
     */
    public item(double p, int q, int id){
        this();
        setPrice(p);
        setQuantity(q);
        setID(id);
    }

    /**
     * setter for Price
     * checks if price entered is > 0
     * @param p
     */
    private void setPrice(double p) {
        if(p > 0){
            this.price = p;
        }
        else{
            System.out.println("Invalid Price!");
        }
    }

    /**
     * setter for Quantity
     * @param q
     */
    private void setQuantity(int q) {
        if(q > 0){
            this.quantity = q;
        }
        else{
            System.out.println("Invalid Quantity!");
        }
    }

    /**
     * setter for item_id
     * @param id
     */
    public void setID(int id){
        if(price > 0 && quantity > 0){
            this.item_id = ++id;
        }
        else{
            System.out.println("Please fix input!");
        }
    }

    /**
     * getter for price
     * @return price
     */
    public double getPrice(){
        return price;
    }

    /**
     * getter for quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * getter for item_id
     * @return item_id
     */
    public int getItem_id() {
        return item_id;
    }
}
