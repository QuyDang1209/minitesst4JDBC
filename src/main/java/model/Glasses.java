package model;

public class Glasses {
    int id;
    String code;
    int price;
    String color;
    String decription;
    String img;

    public Glasses(int id, String code, int price, String color, String decription, String img) {
        this.id = id;
        this.code = code;
        this.price = price;
        this.color = color;
        this.decription = decription;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
