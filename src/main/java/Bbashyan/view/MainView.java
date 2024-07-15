package Bbashyan.view;

import static Bbashyan.utils.InputUtil.input;
import static Bbashyan.validator.MainValidator.*;

import Bbashyan.controller.MainController;

import java.io.IOException;

public class MainView {
    private final MainController mainController;

    public MainView(MainController mainController) {
        this.mainController = mainController;
    }

    public void displayMainMenu() throws IOException {
        while (true) {
            System.out.println("Loading...");
            if (mainController.getUserController().getCurrentUser() == null) {
                System.out.println("***** 1. 로그인   *****");
                System.out.println("***** 2. 회원 가입 *****");

                String userInput = input();

                isValidateNumber(userInput);

                int select = Integer.parseInt(userInput);
                if (select == 1) {
                    mainController.getUserController().displayLogin();
                } else if (select == 2) {
                    mainController.getUserController().displaySignUp();
                }
            } else {
                System.out.println("***** 메인 페이지 *****");
                System.out.println("***** 1. 유저 정보 확인 *****");
                System.out.println("***** 2. 음식 카테고리 선택 *****");
                System.out.println("***** 3. 장바구니 확인 *****");
                System.out.println("***** 0. 로그아웃 *****");

                String MainInput = input();

                isValidateNumber(MainInput);

                int select = Integer.parseInt(MainInput);

                if (select == 1) {
                    mainController.getUserController().displayUserInfo();
                } else if (select == 2) {
                    mainController.getCategoryController().displayCategories();
                } else if (select == 3) {
                    mainController.getUserController().displayBucket();
                } else if (select == 4) {
                    mainController.getUserController().logout();
                } else {
                    System.out.println("제시된 숫자는 1~4까지입니다.");
                    System.exit(0);
                }
            }
        }
    }

}
