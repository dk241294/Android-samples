package com.deepak.customarrayadapter;

class Animal {
    private String Name;
    private int image;

    public Animal(String name, int image) {
        Name = name;
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
