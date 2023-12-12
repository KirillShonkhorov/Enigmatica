package com.MobSOL.Enigmatica.Models;

public class Cryptography {
    int ID;
    String Image, QR;
    String Tittle;
    String BgColor;
    String ImageColor;
    String Description;

    public Cryptography(int ID, String image, String qr, String tittle, String bgColor, String imageColor, String description) {
        this.ID = ID;
        this.Image = image;
        this.QR = qr;
        this.Tittle = tittle;
        this.BgColor = bgColor;
        this.ImageColor = imageColor;
        this.Description = description;
    }

    public String getQR() {
        return QR;
    }

    public void setQR(String QR) {
        this.QR = QR;
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
