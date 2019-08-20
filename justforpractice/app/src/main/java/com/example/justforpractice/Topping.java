package com.example.justforpractice;

public class Topping {
    String toppingName;
    int toppingPrice;
    boolean isSelected;





    public Topping(String toppingName,int toppingPrice) {
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
    }

    public String getToppingName() {
        return toppingName;
    }

   public int getToppingPrice() {
        return toppingPrice;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
