public class DeluxPizza extends Pizza
{
    private int premiumToppings=200;
    private int premiumSauce=75;
    private int premiumCrust=150;

    public DeluxPizza(boolean veg,String size,String crust,String sauce) {
        super(veg,size,"Premium Crust","Special Sauce");
        addPremiumCrust();
        addPremiumToppings();
        addPremiumSauce();
        addExtraCheese();
    }

    private void addPremiumCrust()
    {
        addPrice(premiumCrust);
    }

    private void addPremiumToppings()
    {
        addPrice(premiumToppings);
    }
    private void addPremiumSauce()
    {
        addPrice(premiumSauce);
    }

    @Override
    public String getBill() {
        return super.getBill() + "Delux Features: Premium Crust, Premium Toppings, and Special Sauce\n";
    }
}
