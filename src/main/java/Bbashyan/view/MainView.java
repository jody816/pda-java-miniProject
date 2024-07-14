package Bbashyan.view;

import Bbashyan.controller.MainController;
import Bbashyan.controller.UserController;
import Bbashyan.controller.CategoryController;
import Bbashyan.controller.BucketController;
import Bbashyan.model.Bucket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainView {
    private MainController controller;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public MainView(MainController controller) {
        this.controller = controller;
    }

    public void displayMainMenu() throws IOException {
        while(true) {
            System.out.println("Loading...");
            if (controller.getUserController().getCurrentUser()==null) {
                System.out.println("***** 1. 로그인   *****");
                System.out.println("***** 2. 회원 가입 *****");

                String input = input();
                int select = Integer.parseInt(input);
                if (select == 1) {
                    controller.getUserController().displayLogin();
                } else if (select == 2) {
                    controller.getUserController().displaySignUp();
                }
            }

            else {
                System.out.println("***** 메인 페이지 *****");
                System.out.println("***** 1. 유저 정보 확인 *****");
                System.out.println("***** 2. 음식 카테고리 선택 *****");
                System.out.println("***** 3. 장바구니 확인 *****");
                System.out.println("***** 0. 로그아웃 *****");

                int input = Integer.parseInt(input());

                if (input == 1) {
                    controller.getUserController().displayUserInfo();
                } else if (input == 2) {
                    controller.getCategoryController().displayCategories();
                } else if (input == 3) {
                    controller.getUserController().displayBucket();

                } else {
                    controller.getUserController().logout();
                }
            }
        }
    }

    private String input() throws IOException {
        System.out.print("입력 : ");
        return br.readLine();
    }
}
