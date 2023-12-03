package com.MobSOL.Enigmatica.Models;

public class Cryptography {
    int ID;
    String Image, Tittle, BgColor,ImageColor, Description;

    public Cryptography(int ID, String image, String tittle, String bgColor, String imageColor, String description) {
        this.ID = ID;
        this.Image = image;
        this.Tittle = tittle;
        this.BgColor = bgColor;
        this.ImageColor = imageColor;
        this.Description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public String getBgColor() {
        return BgColor;
    }

    public void setBgColor(String bgColor) {
        BgColor = bgColor;
    }

    public String getImageColor() {
        return ImageColor;
    }

    public void setImageColor(String imageColor) {
        ImageColor = imageColor;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
