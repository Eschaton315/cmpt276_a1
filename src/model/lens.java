package model;

public class lens {

    private String name;
    private double maxAperture;
    private int focalLength;
    private int itemNum;

    public lens(String Name,double maxApe,int fLength,int itemNum){
        this.name = Name;
        this.maxAperture = maxApe;
        this.focalLength = fLength;
        this.itemNum = itemNum;
    }

    public String getName() {
        return name;
    }

    public double getMaxAperture(){
        return maxAperture;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public int getItemNum(){
        return itemNum;
    }
}
