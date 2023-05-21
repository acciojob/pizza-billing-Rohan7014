package com.driver;

public class Pizza {

    private int price;
    private Boolean isVeg;
    private String bill;
    public static int vegBasePrice=300;
    public static int nonVegBasePrice = 400;
    private static boolean isCheeseAdded;
    public static int cheesePrice=80;
    public static int vegToppingPrice=70;
    public static int getNonVegToppingPrice=120;
    private boolean isToppingAdded;
    private boolean isTakeAwayAdded;
    public static int takeAwayPrice=20;
    private int myToppingPrice=0;
    private int basePrice=0;

    public Pizza(Boolean isVeg){
        this.isVeg = isVeg;
        this.basePrice=isVeg?vegBasePrice:nonVegBasePrice;
        this.price=basePrice;
        this.bill="";
        this.isCheeseAdded=false;
        this.isToppingAdded=false;
        this.isTakeAwayAdded=false;
        // your code goes here
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese(){
        // your code goes here
        if(!isCheeseAdded){
            isCheeseAdded=true;
            this.price+=cheesePrice;
        }
    }
    public void addExtraToppings(){
//        if(!isToppingAdded){
//            this.myToppingPrice=isVeg?vegToppingPrice:getNonVegToppingPrice;
//            isToppingAdded=true;
//        }
        if (isToppingAdded == false && isVeg == true) {
            isToppingAdded = true;
            this.myToppingPrice = vegToppingPrice;
            this.price = price + this.myToppingPrice;
        }
        if (isToppingAdded == false && isVeg == false) {
            isToppingAdded= true;
            this.myToppingPrice = getNonVegToppingPrice;
            this.price = price + this.myToppingPrice;
        }
    }

    public void addTakeaway(){
        if(!isTakeAwayAdded){
            isTakeAwayAdded=true;
            this.price+=takeAwayPrice;
        }
    }

    public String getBill(){
//        Base Price Of The Pizza: 300
//        Extra Cheese Added: 80
//        Extra Toppings Added: 70
//        Paperbag Added: 20
//        Total Price: 470
        String bill="Base Price Of The Pizza: "+this.basePrice+"\n";
        if(isCheeseAdded){
            bill+="Extra Cheese Added: "+cheesePrice+"\n";
        }
        if(isToppingAdded){
            bill+="Extra Toppings Added: "+myToppingPrice+"\n";
        }
        if (isTakeAwayAdded){
            bill+="Paperbag Added: "+takeAwayPrice+"\n";
        }
        bill+="Total Price: "+this.price+"\n";
        this.bill=bill;
        return this.bill;
    }
}
