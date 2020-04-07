/* 
Author: Karimu Mohammed
Title: Recipes for the End of the World
Description: An interactive Project for interactive menu design
*/


import java.util.Scanner;



public class Main {

    public static void foodFestival(){
        String orderResponse;
        Boolean validResponse = false;
        Scanner scnr = new Scanner(System.in);
        


        System.out.println("Welcome to the food festival");
        System.out.print("Would you like to place an order? (yes/no)");
        orderResponse = scnr.next();

        while (validResponse == false){

            if (orderResponse.equalsIgnoreCase("yes") ){
                validResponse = true;
                order(orderName());


            }
            else if(orderResponse.equalsIgnoreCase("no") ){
                System.out.println("Thank you for stopping by, maybe next time you'll sample our menu.");

                validResponse = true;
            }

            else {
                System.out.print("Please respond yes or no: ");
                orderResponse = scnr.next();
            }
        }

        


    }

    public static String orderName(){
        String orderName;
        Scanner scnr = new Scanner(System.in);
        System.out.print("What is your name for the order? ");
        orderName = scnr.next();

        
        return orderName;
        
    }

    public static void menuDisplay(String [] menuOption, String orderName){
        //Displays whole menu heading

        //Responsible for depth of tabs
        for (int i=0; i<5; i++){
            System.out.print(" ");
        }
        System.out.printf("Select from the menu, %s%n", orderName);
        //Responsible for displaying appetizer menu options
        for (int i=0; i<menuOption.length; i++){
            System.out.printf("%11d - %s%n", i, menuOption[i]);
        }
        for (int i=0; i<(5); i++){
            System.out.print(" ");
        }
        System.out.printf("Enter the number for your selection: ");
    }

    public static void menuDisplay(String [] menuOption, int depth, String menuName){
        //Displays whole menu heading

        //Responsible for depth of tabs
        for (int i=0; i<(5*depth); i++){
            System.out.print(" ");
        }

        System.out.printf("%s Menu: %n", menuName);
        //Responsible for displaying appetizer menu options
        for (int i=0; i<menuOption.length; i++){
            for (int j=0; (j<(5*depth) + 5) ; j++){
                System.out.print(" ");
            }
            System.out.printf("%d - %s%n", i, menuOption[i]);
        }
        for (int i=0; i<(5*depth); i++){
            System.out.print(" ");
        }
        System.out.printf("Enter the number for %s your selection: ", menuName.toLowerCase());
    }

    public static void order(String orderName){
        Scanner scnr = new Scanner(System.in);

        String appetizer = " ";
        String entree= " ";
        String dessert= " ";
        String [] menuOption = {"Done", "Appetizer", "Main Course", "Dessert"};

        /* //Displays whole menu heading
        System.out.printf("     Select from the menu, %s%n", orderName);
        //Responsible for displaying appetizer menu options
        for (int i=0; i<menuOption.length; i++){
            System.out.printf("%10d - %s%n", i, menuOption[i]);
        }

        System.out.printf("     Enter the number for your selection: "); */

        menuDisplay(menuOption,orderName);


        int choice = scnr.nextInt();
        while (choice != 0){
            if( choice == 1){
                appetizer = appetizer();
                menuDisplay(menuOption,orderName);
                choice = scnr.nextInt();
            }
            else if( choice == 2){
                entree = entree();
                menuDisplay(menuOption,orderName);
                choice = scnr.nextInt();
            }
            else if( choice == 3){
                dessert = dessert();
                menuDisplay(menuOption,orderName);
                choice = scnr.nextInt();
            }
            else{
                System.out.printf("We're sorry, but %d is not a valid option. Please enter a valid number for your selection: ", choice);
                choice = scnr.nextInt();
            }
        }
        
        System.out.printf("Here is your order %s:%n", orderName);
        System.out.printf("%s%n",appetizer);
        System.out.printf("%s%n",entree);
        System.out.printf("%s%n",dessert);
        System.out.println("");
        System.out.print("Enjoy your meal!");
    }

    public static String topping(int toppingSelection){

        //Array of the various topping options
        String toppingAppetizer[] = {"Done", "Plum Sauce", "Soy Sauce", "Peanut Sauce"};
        String toppingEntree[] = {"Done", "Veggies", "Tofu", "Mock Duck"};
        String toppingDessert[] = {"Done", "Banana", "Mango", "Strawberry"};
        String toppingMode[][] = { toppingAppetizer, toppingEntree, toppingDessert};


        Scanner scnr = new Scanner(System.in);
        
        String [] menuOption = toppingMode[toppingSelection]; //Select the mode of the topping menu items
        //String [] menuOption = {"Done", "Plum Sauce", "Soy Sauce", "Peanut Sauce"}; //Responsible for assigning topping choices
        String selection = ""; //holds the choices that have been made
        String [] menuTitle = {"Sauce Options", "Protein Choice", "Fruit Flavor"}; //Dynamically change the header for the menu



/*         //Displays topping menu heading
        System.out.printf("%s%n", menuTitle[toppingSelection]);

        //Responsible for displaying topping menu options
        for (int i=0; i<menuOption.length; i++){
            System.out.printf("%10d - %s%n", i, menuOption[i]);
        }

        System.out.printf("     Enter the number for your selection: "); */

        menuDisplay(menuOption, 3, menuTitle[toppingSelection]);
        int choice = scnr.nextInt();
        while (choice != 0){
            if( (choice < menuOption.length) && (choice >0) ){
                selection = selection + menuOption[choice];
                menuDisplay(menuOption, 3, menuTitle[toppingSelection]);
                //System.out.println(selection);
                choice = scnr.nextInt();
                    if( choice == 0 ){
                        selection = selection + " ]";
                    }
                    else if( (choice < menuOption.length) && (choice >0) ){
                        selection = selection + ", ";
                    }
                    else{
                        System.out.printf("We're sorry, but %d is not a valid option. Please enter a valid number for your selection: ", choice);
                        choice = scnr.nextInt();
                    }
            }
            else{
                System.out.printf("We're sorry, but %d is not a valid option. Please enter a valid number for your selection: ", choice);
                choice = scnr.nextInt();
                if( choice == 0 ){
                    selection = selection + " ]";
                }
                else if( (choice < menuOption.length) && (choice >0) ){
                    selection = selection + ", ";
                }
            }
        }
        

        return selection;
    }

    public static String appetizer(){
        Scanner scnr = new Scanner(System.in);
        String [] menuOption = {"Done", "Spring Rolls", "Veggie Dumplings", "Fried Tofu"};
        String appSelection = "Appetizer:[ ";

        /* //Displays appetizer menu heading
        System.out.printf("Appetizer Menu%n");
        //Responsible for displaying appetizer menu options
        for (int i=0; i<menuOption.length; i++){
            System.out.printf("%5d - %s%n", i, menuOption[i]);
        }

        System.out.printf("Enter the number for your selection: "); */
        menuDisplay(menuOption, 2, "Appetizer");
        int choice = scnr.nextInt();
        while (choice != 0){
            if( (choice < menuOption.length) && (choice >0) ){
                appSelection = appSelection + menuOption[choice] +  ": " + topping(0);
                /* System.out.println(appSelection); */
                menuDisplay(menuOption, 2, "Appetizer");
                choice = scnr.nextInt();
            }
            else{
                System.out.printf("We're sorry, but %d is not a valid option. Please enter a valid number for your selection: ", choice);
                choice = scnr.nextInt();
            }
        }
        
        
            return appSelection;

    }

    public static String entree(){
        Scanner scnr = new Scanner(System.in);
        String [] menuOption = {"Done", "Pad See Ew", "Drunken Noodles", "Pad Thai"};
        String entreeSelection = "Entree:[ ";

        menuDisplay(menuOption,2,"Entree");
        int choice = scnr.nextInt();
        while (choice != 0){
            if( (choice < menuOption.length) && (choice >0) ){
                entreeSelection = entreeSelection + menuOption[choice] +  ": " + topping(1);
                /* System.out.println(appSelection); */
                menuDisplay(menuOption,2,"Entree");
                choice = scnr.nextInt();
            }
            else{
                System.out.printf("We're sorry, but %d is not a valid option. Please enter a valid number for your selection: ", choice);
                choice = scnr.nextInt();
            }
        }
        
        

        return entreeSelection;

    }

    public static String dessert(){
        Scanner scnr = new Scanner(System.in);
        String [] menuOption = {"Done", "Fried Ice Cream", "Sweet Sticky Rice", "Ice Cream"};
        String dessertSelection = "Dessert:[ ";

        menuDisplay(menuOption,2,"Dessert");
        int choice = scnr.nextInt();
        while (choice != 0){
            if( (choice < menuOption.length) && (choice >0) ){
                dessertSelection = dessertSelection + menuOption[choice] +  ": " + topping(2);
                /* System.out.println(appSelection); */
                menuDisplay(menuOption,2,"Dessert");
                choice = scnr.nextInt();
            }
            else{
                System.out.printf("We're sorry, but %d is not a valid option. Please enter a valid number for your selection: ", choice);
                choice = scnr.nextInt();
            }
        }
        
        

        return dessertSelection;

    }

    

    public static void main(String [] args){
        
        foodFestival();

               

    }

}