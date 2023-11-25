package com.example.l4_m3__recyclerview;

public class CountryModel {
    private String flag;
    private String name;
    private String capital;

    public CountryModel(String flag, String name, String capital) {
        this.flag = flag;
        this.name = name;
        this.capital = capital;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFlag() {
        return flag;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }
}
