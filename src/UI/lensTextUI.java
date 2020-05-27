package UI;
import java.text.DecimalFormat;
import model.lens;
import model.lensManager;

import java.util.Scanner;

public class lensTextUI {
    private lensManager manager;

    public lensTextUI(lensManager manager) {
        this.manager = manager;
    }
    public void show() {
        boolean finish = false;
        boolean pass = false;
        while (!finish) {
            System.out.println(" Set Lens:\n");
            int choice = 1;
            for(lens Lens : manager) {
                System.out.println(" "+choice+":"+Lens.getName()+"\t"+Lens.getMaxAperture()+"mm\tF"+Lens.getFocalLength());
                choice++;
            }
            System.out.println("\n-1:Quit");
            Scanner in = new Scanner (System.in);
            int userChoice = in.nextInt();

            if (userChoice>=1&&userChoice<=choice){
                for(lens Lens: manager){
                    if(Lens.getItemNum()==userChoice){
                        //set aperture using the pass boolean to see whether a correct value was inputted
                        while (!pass) {
                            System.out.println("Set Aperture:\nMax = " + Lens.getMaxAperture());
                            double aperture = in.nextDouble();
                            System.out.println("aperture = " + aperture + "Dead End");
                            if (aperture > Lens.getMaxAperture()) {
                                System.out.println("CANNOT EXCEED MAX VALUE");
                            }else if(aperture < 0){
                                System.out.println("INVALID VALUE");
                            }else{
                                pass=true;
                            }
                        }
                        //set distance using pass boolean to  check whether a correct value was inputted
                        pass = false;


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

