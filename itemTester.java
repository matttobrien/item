/**
 * Java Assignment 2
 * tester class for item
 * @author mattobrien
 * @date 02/11/2018
 * @version 1
 */

import java.util.*;
public class itemTester {
    /**
     * static variables which are available in any method
     */
    private static int itemCount = 0;
    private static int idCount = 0;

    /**
     * main to run the program
     * @param args
     */
    public static void main(String[] args) {
        boolean loop = true;
        item Array[] = new item[100];
        System.out.println("Welcome");
        while(loop) {
            System.out.println();
            System.out.println("Please select an option:");
            System.out.println("1. Add item to the inventory");
            System.out.println("2. Display all items");
            System.out.println("3. Display only books sorted by author name");
            System.out.println("4. Display only gifts sorted by label");
            System.out.println("5. Delete an item by item_id");
            System.out.println("6. Purchase an item by removing the purchased quantity from the inventory");
            System.out.println("7. Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Which kind of item would you like to add?");
                    System.out.println("1. Book");
                    System.out.println("2. Gift");
                    int c = sc.nextInt();
                    if (c == 1) {
                        addItem(Array, c, idCount);
                    } else {
                        addItem(Array, c, idCount);
                    }
                    break;
                case 2:
                    if (itemCount != 0) {
                        displayItem(Array);
                    } else {
                        System.out.println("There are no items in the inventory!");
                    }
                    break;
                case 3:
                    if(itemCount != 0){
                        int j = 0;
                        book[] bookArray = new book[itemCount];
                        for (int i = 0; i < itemCount; i++) {
                            if(Array[i] != null) {
                                if ((Array[i].getClass().getSimpleName()).equals("book")) {
                                    bookArray[j] = (book) Array[i];
                                    j++;
                                }
                            }
                        }
                        sortAuthor(bookArray);
                    }
                    break;
                case 4:
                    if(itemCount != 0){
                        int j = 0;
                        gift[] giftArray = new gift[itemCount];
                        for (int i = 0; i < itemCount; i++) {
                            if(Array[i] != null) {
                                if ((Array[i].getClass().getSimpleName()).equals("gift")) {
                                    giftArray[j] = (gift) Array[i];
                                    j++;
                                }
                            }
                        }
                        sortLabel(giftArray);
                    }
                    break;
                case 5:
                    if(itemCount != 0){
                        removeItem(Array);
                    }
                    break;
                case 6:
                    if(itemCount != 0){
                        purchaseItem(Array);
                    }
                    break;
                case 7:
                    loop = false;
                    System.out.println("Thank you!");
                    System.out.println("Goodbye!");
                    break;
            }
        }

    }

    /**
     * asks the user for item id and how many items to purchase
     * @param array
     */
    private static void purchaseItem(item[] array) {
        Scanner ps = new Scanner(System.in);
        System.out.println("Please enter item id to purchase:");
        int id = ps.nextInt();
        System.out.println("Please enter quantity of items:");
        int qtty = ps.nextInt();
        array[--id].Purchased(qtty);
    }

    /**
     * calls the displayed method in the corresponding classes
     * @param array
     */
    private static void displayItem(item[] array) {
        for (int i = 0; i < itemCount; i++) {
            System.out.println(array[i].Displayed());
        }
    }

    /**
     * removed a item based on the item id provided by the user
     * @param array
     */
    private static void removeItem(item[] array) {
        Scanner rs = new Scanner(System.in);
        System.out.println("Please enter item id to remove(Starts at 1):");
        int removeIdx = rs.nextInt();
        if(removeIdx > itemCount){
            System.out.println("Invalid id!");
        }
        else{
            --removeIdx;
            System.arraycopy(array, removeIdx + 1, array, removeIdx, array.length - 1 - removeIdx);
        }
        System.out.println("Updated inventory:");
        itemCount--;
        displayItem(array);
    }

    /**
     * sorts the array of books by Author name lexicographically
     * then prints the sorted array to the screen
     * @param bookArray
     */
    private static void sortAuthor(book[] bookArray) {
        book temp;
        for(int i = 0; i < itemCount; i++){
            for (int j = i + 1; j < itemCount; j++){
                if(bookArray[i] != null && bookArray[j] != null) {
                    if (((bookArray[i].getAuthor()).compareToIgnoreCase((bookArray[j].getAuthor()))) > 0) {
                        temp = bookArray[i];
                        bookArray[i] = bookArray[j];
                        bookArray[j] = temp;
                    }
                }
            }
        }

        System.out.println("Books sorted by Author:");
        for(int x = 0; x < itemCount; x++){
            if(bookArray[x] != null) {
                System.out.println(bookArray[x].Displayed());
            }
        }
    }

    /**
     * sorts the array of gifts by Label lexicographically
     * then prints the sorted array to the screen
     * @param giftArray
     */
    private static void sortLabel(gift[] giftArray){
        gift temp;
        for(int i = 0; i < itemCount; i++){
            for (int j = i + 1; j < itemCount; j++){
                if(giftArray[i] != null && giftArray[j] != null) {
                    if (((giftArray[i].getLabel()).compareToIgnoreCase((giftArray[j].getLabel()))) > 0) {
                        temp = giftArray[i];
                        giftArray[i] = giftArray[j];
                        giftArray[j] = temp;
                    }
                }
            }
        }
        System.out.println("Gifts sorted by Label:");
        for(int x = 0; x < itemCount; x++){
            if(giftArray[x] != null) {
                System.out.println(giftArray[x].Displayed());
            }
        }
    }

    /**
     * adds a item to the Array using user entered input
     * @param Array
     * @param choice
     * @param id
     */
    private static void addItem(item[] Array, int choice, int id) {
        if(choice == 1) {
            Scanner sb = new Scanner(System.in);
            System.out.println("Please enter Author:");
            String a = sb.nextLine();
            System.out.println("Please enter Title:");
            String t = sb.nextLine();
            System.out.println("Please enter Year:");
            int y = sb.nextInt();
            System.out.println("Please enter Price:");
            double p = sb.nextDouble();
            System.out.println("Please enter Quantity:");
            int q = sb.nextInt();
            Array[itemCount] = new book(a, t, y, p, q, id);
            itemCount++;
            idCount++;
        }
        else{
            Scanner sg = new Scanner(System.in);
            System.out.println("Please enter Label:");
            String l = sg.nextLine();
            System.out.println("Please enter Manufacturer:");
            String m = sg.nextLine();
            System.out.println("Please enter Price:");
            double p = sg.nextDouble();
            System.out.println("Please enter Quantity:");
            int q = sg.nextInt();
            Array[itemCount] = new gift(l, m, p, q, id);
            itemCount++;
            idCount++;
        }
    }
}

