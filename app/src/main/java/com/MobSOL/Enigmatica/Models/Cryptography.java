package com.MobSOL.Enigmatica.Models;

/** @noinspection raw-types*/
public class Cryptography {
    int ID;
    String Image, QR;
    String Tittle;
    String BgColor;
    String ImageColor;
    String TittleColor;
    String DescriptionColor;
    String Description;
    boolean IsClickable;
    Class aClass;

    public Cryptography(int ID, String image, String QR, String tittle, String bgColor, String imageColor, String tittleColor,
                        String descriptionColor, String description, boolean isClickable, Class a_class) {
        this.ID = ID;
        this.Image = image;
        this.QR = QR;
        this.Tittle = tittle;
        this.BgColor = bgColor;
        this.ImageColor = imageColor;
        this.TittleColor = tittleColor;
        this.DescriptionColor = descriptionColor;
        this.Description = description;
        this.IsClickable = isClickable;
        this.aClass = a_class;
    }

    public Class getaClass() {
        return aClass;
    }
    public String getTittleColor() {
        return TittleColor;
    }
    public String getDescriptionColor() {
        return DescriptionColor;
    }
    public String getQR() {
        return QR;
    }
    public int getID() {
        return ID;
    }
    public String getImage() {
        return Image;
    }
    public String getTittle() {
        return Tittle;
    }
    public String getBgColor() {
        return BgColor;
    }
    public String getImageColor() {
        return ImageColor;
    }
    public String getDescription() {
        return Description;
    }
}
