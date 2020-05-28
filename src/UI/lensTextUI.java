package UI;
import java.text.DecimalFormat;
import model.lens;
import model.lensManager;

import java.util.Scanner;

public class lensTextUI {
    private lensManager manager;
    double aperture;
    double distance;

    public lensTextUI(lensManager manager) {
        this.manager = manager;
    }
    public void show() {
        boolean finish = false;
        while (!finish) {
            boolean pass = false;
            System.out.println(" Set Lens:\n");
            int choice = 1;
            for(lens Lens : manager) {
                System.out.println(" "+choice+":"+Lens.getName()+"\tF"+Lens.getMaxAperture()+"\t"+Lens.getFocalLength()+"mm");
                choice++;
            }

            System.out.println("\n-1:Quit");
            Scanner in = new Scanner (System.in);
            int userChoice = in.nextInt();

            if (userChoice>=1&&userChoice<=choice){
                for(lens Lens: manager){
                    if(Lens.getItemNum()==userChoice){
                        //set aperture using the pass boolean to see whether a correct value was inputted
                            System.out.println("Set Aperture (F Number):\nMax = F" + Lens.getMaxAperture());
                            aperture = in.nextDouble();
                            if (aperture < Lens.getMaxAperture()) {
                                System.out.println("CANNOT EXCEED MAX F VALUE");
                            }else if(aperture > 22){
                                System.out.printf("INVALID VALUE\n\n.............\n\n");
                            }else{
                                //set distance n  check whether a correct value was inputted
                                System.out.println("Set Distance To Subject(m):");
                                distance = in.nextDouble();
                                if (distance <= 0) {
                                    System.out.printf("INVALID DISTANCE\n\n.............\n\n");
                                } else {
                                    //calculating DoF
                                    double hyperFocalDist=((Math.pow(Lens.getFocalLength(),2))/(0.029 * aperture));
                                    double nearFocalPoint=((hyperFocalDist*(distance*1000))/(hyperFocalDist+((distance*1000)-Lens.getFocalLength())));
                                    double farFocalPoint;
                                    if((distance*1000)>hyperFocalDist) farFocalPoint = Double.POSITIVE_INFINITY;
                                    else  farFocalPoint=((hyperFocalDist*(distance*1000))/(hyperFocalDist-((distance*1000)-Lens.getFocalLength())));
                                    double depthField=farFocalPoint-nearFocalPoint;
                                    //output text
                                    System.out.println(" In Focus: "+formatM(nearFocalPoint/1000)+"m ~ "+formatM(farFocalPoint/1000)+"m [DoF = "+formatM(depthField/1000)+"m]");
                                    System.out.println(" Hyperfocal point: "+(formatM(hyperFocalDist/1000))+"m");
                                }
                            }
                    }
                }

            }else if (userChoice==-1){
                System.out.println("Exiting...");
                finish=true;
            }else{
                System.out.printf("INVALID VALUE\n\n.............\n\n");
            }

        }
    }
    private String formatM(double distanceInM) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }


}

