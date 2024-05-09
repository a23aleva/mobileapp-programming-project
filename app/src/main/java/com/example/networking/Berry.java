package com.example.networking;

@SuppressWarnings("WeakerAccess")
public class Berry {

    private String name;
    private String latin;
    private String color;

    private String genus;

    public Berry() {
        this.name = "Saknar namn";
        this.latin = "Saknar plats";
        this.color = "Saknar färg";
        this.genus = "Saknar släkte";
    }

    public Berry(String name, String latin, String color, String genus) {
        this.name = name;
        this.latin = latin;
        this.color = color;
        this.genus = genus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(int height) {
        this.color = color;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(int height) {
        this.genus = genus;
    }

    @Override
    public String toString() {
        return name;
    }
}
