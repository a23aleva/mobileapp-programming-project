package com.example.networking;

@SuppressWarnings("WeakerAccess")
public class Berry {

    private String name;
    private String company;
    private String location;

    private String category;

    public Berry() {
        this.name = "Saknar namn";
        this.company = "Saknar plats";
        this.location = "Saknar färg";
        this.category = "Saknar släkte";
    }

    public Berry(String name, String company, String location, String category) {
        this.name = name;
        this.company = company;
        this.location = location;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(int height) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(int height) {
        this.category = category;
    }

    @Override
    public String toString() {
        return name;
    }
}
