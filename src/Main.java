import UI.lensTextUI;
import model.lens;
import model.lensManager;

public class Main {
    public static void main(String args[]) {

                System.out.println("initial test.\n");

                lensManager manager = new lensManager();


        manager.add(new lens("Canon", 1.8, 50));
        manager.add(new lens("Tamron", 2.8, 90));
        manager.add(new lens("Sigma", 2.8, 200));
        manager.add(new lens("Nikon", 4, 200));

        lensTextUI ui = new lensTextUI(manager);
        ui.show();




    }

}

