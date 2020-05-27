package model;

public class lens {

    private String name;
    private double maxAperture;
    private int focalLength;

    public lens(String Name,double maxApe,int fLength){
        this.name = Name;
        this.maxAperture = maxApe;
        this.focalLength = fLength;

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
}
