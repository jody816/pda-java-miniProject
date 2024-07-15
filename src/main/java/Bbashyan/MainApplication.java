package Bbashyan;


import Bbashyan.controller.MainController;

import java.io.IOException;

public class MainApplication {

  public static void run() throws IOException {
    MainController controller = MainController.getMainController();
    try {
      controller.displayMainMenu();
    } catch (Exception e) {
      System.out.println("***** 알 수 없는 에러입니다. 처음부터 다시 시작해세요. *****");
      controller.displayMainMenu();
    }
  }
}
