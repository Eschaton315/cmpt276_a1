package UI;

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
        while (finish=false) {
            System.out.println("Set Lens:\n");
            int choice = 1;
            for(lens Lens : manager) {
                System.out.println(choice+":"+Lens.getName()+" "+Lens.getMaxAperture()+"mm F"+Lens.getFocalLength()+"\n");
            }
            Scanner in = new Scanner (System.in);
            int userChoice = in.nextInt();

            if (userChoice>=1&&userChoice<=choice){

            }else if (userChoice==0){
                System.out.println("Exiting~");
                finish=true;
            }else{
                System.out.printf("INVALID VALUE");
            }

        }
    }

}

