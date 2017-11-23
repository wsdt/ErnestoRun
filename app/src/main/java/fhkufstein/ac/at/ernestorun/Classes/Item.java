package fhkufstein.ac.at.ernestorun.Classes;

/**
 * Created by Martin on 23.11.2017.
 */

public class Item {
    private String name;
    private int image;
    private int length;
    private int width;
    private float points;

    public Item (String name, int image, int length, int width, float points){
        this.name = name;
        this.image = image;
        this.length = length;
        this.width = width;
        this.points = points;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }
}
