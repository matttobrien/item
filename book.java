/**
 * Java Assignment 2
 * book is a class that extends item which contains 3 variables
 * @author mattobrien
 * @date 02/11/2018
 * @version 1
 */

public class book extends item {
    private String author = "unknown";
    private String title = "unknown";
    private int year = 0;

    /**
     * constructor which calls the super when creating a book
     * @param a
     * @param t
     * @param y
     * @param p
     * @param q
     * @param id
     */
    public book(String a, String t, int y, double p, int q, int id){
        super(p, q, id);
        setAuthor(a);
        setTitle(t);
        setYear(y);
    }

    /**
     * setter for Author
     * @param a
     */
    private void setAuthor(String a) {
        if(a.length() > 0){
            this.author = a;
        }
        else{
            System.out.println("Invalid Author!");
        }
    }

    /**
     * setter for Title
     * @param t
     */
    private void setTitle(String t){
        if(t.length() > 0){
            this.title = t;
        }
        else{
            System.out.println("Invalid Title!");
        }
    }

    /**
     * setter for Year
     * @param y
     */
    private void setYear(int y){
        if(y > 0){
            this.year = y;
        }
        else{
            System.out.println("Invalid Year!");
        }
    }

    /**
     * getter for Author
     * @return author
     */
    public String getAuthor(){
        return author;
    }

    /**
     * getter for Title
     * @return title
     */
    private String getTitle(){
        return title;
    }

    /**
     * getter for Year
     * @return year
     */
    private int getYear(){
        return year;
    }

    /**
     * Displayed method to display info about the book to the screen
     * @return
     */
    protected String Displayed(){
        return "/Book/ Title: " + getTitle() + ", Author: " + getAuthor() + ", Year: " + getYear() +
                ", Quantity: " + super.getQuantity() + ", Price: " + super.getPrice() + ", and Item ID: "+
                super.getItem_id();
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
