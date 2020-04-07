/* 
Author: Karimu Mohammed
Title: Recipes for the End of the World
Description: An interactive Project for interactive menu design
Github: https://github.com/KabdulDev/foodfest-project.git
Youtube runthrough: https://youtu.be/O9W3hYpSSaQ
*/


import java.util.Scanner;



public class Main {

    public static void foodFestival(){
        String orderResponse;
        Boolean validResponse = false;
        Scanner scnr1 = new Scanner(System.in);
        


        System.out.println("Welcome to the food festival");
        System.out.print("Would you like to place an order?");
        orderResponse = scnr1.next();

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
                System.out.print("Would you like to place an order?");
                orderResponse = scnr1.next();
            }
        }
    }

    public static String orderName(){
        String orderName;
        Scanner scnr2 = new Scanner(System.in);
        System.out.print("What is your name for the order? ");
        orderName = scnr2.next();

        
        return orderName;
        
        
    }

    public static void menuDisplay(String [] menuOption, String orderName){
        //Displays whole menu heading

        //Responsible for depth of tabs
        for (int i=0; i<5; i++){
            System.out.print(" ");
        }
        System.out.printf("Select from the menu, %s%n", orderName);
        //Responsible for displaying  menu options
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
        System.out.printf("Enter the number of your %s selection: ", menuName.toLowerCase());
    }

    public static void order(String orderName){
        Scanner scnr3 = new Scanner(System.in);

        String appetizer = " ";
        String entree= " ";
        String dessert= " ";
        String [] menuOption = {"Done", "Appetizer", "Main Course", "Dessert"};

        
        menuDisplay(menuOption,orderName);

        int choice = scnr3.nextInt();
        System.out.println("");
        while (choice != 0){
            if( choice == 1){
                appetizer = appetizer();
                menuDisplay(menuOption,orderName);
                choice = scnr3.nextInt();
                System.out.println("");
            }
            else if( choice == 2){
                entree = entree();
                menuDisplay(menuOption,orderName);
                choice = scnr3.nextInt();
                System.out.println("");
            }
            else if( choice == 3){
                dessert = dessert();
                menuDisplay(menuOption,orderName);
                choice = scnr3.nextInt();
                System.out.println("");
            }
            else{
                System.out.printf("We're sorry, but %d is not a valid option. Please enter a valid number for your selection: ", choice);
                choice = scnr3.nextInt();
            }
        }

       
        System.out.printf("Here is your order %s:%n", orderName);
        System.out.printf("%s%n",appetizer);
        System.out.printf("%s%n",entree);
        System.out.printf("%s%n",dessert);
        System.out.println("");
        System.out.println("Enjoy your meal!");

        
    }

    public static String topping(int toppingSelection){

        //Array of the various topping options
        String toppingAppetizer[] = {"Done", "Plum Sauce", "Soy Sauce", "Peanut Sauce"};
        String toppingEntree[] = {"Done", "Veggies", "Tofu", "Mock Duck"};
        String toppingDessert[] = {"Done", "Banana", "Mango", "Strawberry"};
        String toppingMode[][] = { toppingAppetizer, toppingEntree, toppingDessert};


        Scanner scnr4 = new Scanner(System.in);
        
        String [] menuOption = toppingMode[toppingSelection]; //Select the mode of the topping menu items
        String selection = ""; //holds the choices that have been made
        String [] menuTitle = {"Sauce Options", "Protein Choice", "Fruit Flavor"}; //Dynamically change the header for the menu


        menuDisplay(menuOption, 3, menuTitle[toppingSelection]);
        int choice = scnr4.nextInt();
        System.out.println("");
        while (choice != 0){
            if( (choice < menuOption.length) && (choice >0) ){
                selection = selection + menuOption[choice];
                menuDisplay(menuOption, 3, menuTitle[toppingSelection]);
                choice = scnr4.nextInt();
                System.out.println("");

                    if( choice == 0 ){
                        break;
                    }
                    else if( (choice < menuOption.length) && (choice >0) ){
                        selection = selection + ", ";
                    }
                    else{
                        System.out.printf("We're sorry, but %d is not a valid option. Please enter a valid number for your selection: ", choice);
                        choice = scnr4.nextInt();
                        System.out.println("");
                        if( choice == 0 ){
                            break;
                        }
                        else if( (choice < menuOption.length) && (choice >0) ){
                            selection = selection + ", ";
                        }
                    }
            }
            else{
                System.out.printf("We're sorry, but %d is not a valid option. Please enter a valid number for your selection: ", choice);
                choice = scnr4.nextInt();
                System.out.println("");
                if( (choice < menuOption.length) && (choice >0) ){
                    selection = selection + ", ";
                }
            }
        }
        
        
        return selection;
    }

    public static String appetizer(){
        Scanner scnr5 = new Scanner(System.in);
        String [] menuOption = {"Done", "Spring Rolls", "Veggie Dumplings", "Fried Tofu"};
        String appSelection = "Appetizer:[ ";

        menuDisplay(menuOption, 2, "Appetizer");
        int choice = scnr5.nextInt();
        System.out.println("");
        while (choice != 0){
            if( (choice < menuOption.length) && (choice >0) ){
                appSelection = appSelection + menuOption[choice] +  ": " + topping(0) +"] ";
               
                menuDisplay(menuOption, 2, "Appetizer");

                choice = scnr5.nextInt();
                System.out.println("");
                if( choice != 0 ){
                    
                    appSelection = appSelection+ "Appetizer:[ ";
                }

            }
            else{
                System.out.printf("We're sorry, but %d is not a valid option. Please enter a valid number for your selection: ", choice);
                choice = scnr5.nextInt();
                System.out.println("");
                if( choice == 0 ){
                    appSelection = appSelection + "]";
                }
            }
        }
        
        return appSelection;

    }

    public static String entree(){
        Scanner scnr6 = new Scanner(System.in);
        String [] menuOption = {"Done", "Pad See Ew", "Drunken Noodles", "Pad Thai"};
        String entreeSelection = "Entree:[ ";

        menuDisplay(menuOption,2,"Entree");
        int choice = scnr6.nextInt();
        System.out.println("");
        while (choice != 0){
            if( (choice < menuOption.length) && (choice >0) ){
                entreeSelection = entreeSelection + menuOption[choice] +  ": " + topping(1) +"]";
               
                menuDisplay(menuOption,2,"Entree");
                choice = scnr6.nextInt();
                System.out.println("");
                if( choice != 0 ){
                    entreeSelection = entreeSelection + "Entree:[";
                }
            }
            else{
                System.out.printf("We're sorry, but %d is not a valid option. Please enter a valid number for your selection: ", choice);
                choice = scnr6.nextInt();
                System.out.println("");
                if( choice == 0 ){
                    entreeSelection = entreeSelection + "]";
                }
            }
        }
        
        return entreeSelection;

    }

    public static String dessert(){
        Scanner scnr7 = new Scanner(System.in);
        String [] menuOption = {"Done", "Fried Ice Cream", "Sweet Sticky Rice", "Ice Cream"};
        String dessertSelection = "Dessert:[ ";

        menuDisplay(menuOption,2,"Dessert");
        int choice = scnr7.nextInt();
        System.out.println("");
        while (choice != 0){
            if( (choice < menuOption.length) && (choice >0) ){
                dessertSelection = dessertSelection + menuOption[choice] +  ": " + topping(2) + "]";
                
                menuDisplay(menuOption,2,"Dessert");
                choice = scnr7.nextInt();
                System.out.println("");
                if( choice != 0 ){
                    dessertSelection = dessertSelection + "Dessert:[";
                }
            }
            else{
                System.out.printf("We're sorry, but %d is not a valid option. Please enter a valid number for your selection: ", choice);
                choice = scnr7.nextInt();
                System.out.println("");
                if( choice == 0 ){
                    dessertSelection = dessertSelection + "]";
                }
            }
        }
        
        return dessertSelection;

    }

    

    public static void main(String [] args){
        
        foodFestival();

               

    }

}