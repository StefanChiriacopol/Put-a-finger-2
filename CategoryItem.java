package com.example.putafingerdown;

public class CategoryItem {
    private String title, details;
    private int background_nr;

    public CategoryItem(String title, String details, int background_nr){
        this.title = title;
        this.details = details;
        this.background_nr = background_nr;
    }

    public String getItemTitle(){return title;}
    public String getItemDetails(){return details;}
    public int getItemBackgroundNr (){return background_nr;}
}
