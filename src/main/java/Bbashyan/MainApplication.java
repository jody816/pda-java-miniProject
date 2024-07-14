package Bbashyan;


import Bbashyan.controller.MainController;

import java.io.IOException;

public class MainApplication {

    public static void run() throws IOException {
        MainController controller = MainController.getInstance();
        try {
            controller.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
