import java.text.SimpleDateFormat;
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        ArrayList<Pizza> pizzas=new ArrayList<>();
        boolean addMore = true;
        System.out.println("Welcome to the Pizza Bill Generator! ");
        while (addMore)
        {
            System.out.println("Select Pizza  Type (1 for Regular Pizza , 2 for Delux Pizza):");
            int pizzaType=sc.nextInt();
            sc.nextLine();

            System.out.println("Is It veg? (yes/no)");
            boolean veg=sc.nextLine().equalsIgnoreCase("yes");

            System.out.println("Select Pizza Size(Small,Medium, Large)");
            String size=sc.nextLine();

            String crust="";
            String sauce="";
            if(pizzaType ==1)
            {
                System.out.println("Choose Crust (Thin, Pan,Stuffed):");
                 crust=sc.nextLine();

                System.out.println("choose sauce (Marinara, Alfredo, BBQ):");
                 sauce=sc.nextLine();
            }

            Pizza pizza=(pizzaType==1) ? new Pizza(veg,size,crust,sauce): new DeluxPizza(veg,size,crust,sauce);
            if(pizzaType == 1)
            {
                System.out.println("Add extra cheese? (yes/no): ");
                if(sc.nextLine().equalsIgnoreCase("yes"))
                {
                    pizza.addExtraCheese();
                }
                System.out.println("Add toppings? Enter them one by one (type 'done' to finish): ");
                while (true)
                {
                    String topping=sc.nextLine();
                    if(topping.equalsIgnoreCase("done"))
                    {
                        break;
                    }
                    pizza.addExtraToppings(topping);
                }
                System.out.println("Add extra sauce? (yes/no): ");
                if(sc.nextLine().equalsIgnoreCase("yes"))
                {
                    pizza.addSauce();
                }
            }

            System.out.println("Do you want takeaway? (yes/no): ");
            if (sc.nextLine().equalsIgnoreCase("yes"))
            {
                pizza.takeAway(); // Apply takeaway charge
            }
            pizzas.add(pizza);

            System.out.println("do you want to add another pizza? (yes/no): ");
            addMore=sc.nextLine().equalsIgnoreCase("yes");
        }
        //total bill

        int total=0;
        System.out.println("\n--- Bill Details ---");
        String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("Date: "+date+"\n");

        for(Pizza pizza:pizzas)
        {
            System.out.println(pizza.getBill());
            System.out.printf(" Price : $%.2f%n%n",(double)pizza.getPrice());
            total+= pizza.getPrice();
        }
        System.out.println("===============================================================");
        System.out.printf("Total Price: $%.2f%n",(double) total);
        System.out.println("===============================================================");

        System.out.println("Thank you for ordering");
        sc.close();
    }
}