import java.util.ArrayList;

public class Pizza {
    private int price;
    private String size;
    private String crust;
    private String sauce;
    private boolean veg;

    private ArrayList<String> toppings;

    private int basePriceSmall=200;
    private int basePriceMedium=300;
    private int basePriceLarge=400;

    private int extraCheesePrice=100;
    private int extraToppingsPrice=150;
    private int backPackPrice=20;
    private int extraSaucePrice=50;

    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingsAdded = false;
    private boolean isOptedForTakeAway = false;


    public Pizza(boolean veg,String size,String crust,String sauce)
    {
        this.veg = veg;
        this.size=size;
        this.crust=crust;
        this.sauce=sauce;
        this.toppings=new ArrayList<>();

        if(size.equalsIgnoreCase("Small"))
        {
            this.price=basePriceSmall;
        } else if (size.equalsIgnoreCase("Medium"))
        {
            this.price=basePriceMedium;
        }
        else
        {
            this.price=basePriceLarge;
        }
        if(!veg)
        {
            this.price+=50;
        }
    }

    protected void addPrice(int amount)
    {
        this.price+=amount;
    }

    public void addExtraCheese()
    {
//        price+=extraCheesePrice;
        addPrice(extraCheesePrice);
    }

    public void addExtraToppings(String topping)
    {
        if(!isExtraToppingsAdded)
        {
            this.toppings.add(topping);
//            price+=extraToppingsPrice;
            addPrice(extraToppingsPrice);
            isExtraToppingsAdded=true;
        }
    }

    public void addSauce()
    {
//        this.price+=extraSaucePrice;
        addPrice(extraSaucePrice);
    }

    public void takeAway()
    {
        isOptedForTakeAway = true;
       addPrice(backPackPrice);
    }

    public int getPrice()
    {
        return price;
    }

    public String getBill()
    {
        StringBuilder bill = new StringBuilder();
        bill.append(size).append(veg ? " Veg Pizza ":" Non-Veg Pizza");
        bill.append("(Crust :").append(crust).append(", Sauce:").append(sauce).append(")\n");
        if(!toppings.isEmpty())
        {
            bill.append("Toppings :").append(String.join(",",toppings)).append("\n");
        }
        return bill.toString();
    }
}
