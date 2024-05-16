package com.example.networking;

@SuppressWarnings("WeakerAccess")
public class Berry {

    private String name;
    private String company;
    private String location;
    private String category;
    private String auxdata;

    public Berry() {
        this.name = "Saknar namn";
        this.company = "Saknar plats";
        this.location = "Saknar färg";
        this.category = "Saknar släkte";
        this.auxdata = "Saknar URL";
    }

    public Berry(String name, String company, String location, String category, String auxData) {
        this.name = name;
        this.company = company;
        this.location = location;
        this.category = category;
        this.auxdata = auxData;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public String getAuxData() {
        return auxdata;
    }

    @Override
    public String toString() {
        return name;
    }
}
