package Bbashyan.view.user;

import Bbashyan.controller.user.UserController;
import Bbashyan.model.bucket.Bucket;
import Bbashyan.model.menu.Menu;
import Bbashyan.model.user.User;

import java.io.IOException;
import java.util.Map;

import static Bbashyan.utils.InputUtil.input;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void displayLogin() throws IOException {
        System.out.println("***** 아이디와 비밀번호를 공백으로 입력해주세요 ******");
        String[] userInputs;
        while (true) {
            userInputs = input().split(" ");
            if (userInputs.length == 2) {
                break;
            } else {
                System.out.println("잘못된 입력입니다. 아이디와 비밀번호를 공백으로 구분하여 입력해주세요.");
            }
        }

        String id = userInputs[0];
        String pw = userInputs[1];

        userController.login(id, pw);
    }

    public void displaySignUp() throws IOException {
        System.out.println("***** 아이디 / 이름 / 비밀번호 / 주소 순으로 공백을 두어 입력해주세요. *****");
        String[] userInputs;
        while (true) {
            userInputs = input().split(" ");
            if (userInputs.length == 4) {
                break;
            } else {
                System.out.println("잘못된 입력입니다. 아이디 / 이름 / 비밀번호 / 주소 순으로 공백을 두어 입력해주세요.");
            }
        }
        userController.signUp(userInputs[0], userInputs[1], userInputs[2], userInputs[3]);
    }

    public void displayReLogin() throws IOException {
        System.out.println("***** 1. 회원가입 *****");
        System.out.println("***** 2. 재입력 *****");
        int userInput = Integer.parseInt(input());
        if (userInput == 1) {
            displaySignUp();
        } else if (userInput == 2) {
            displayLogin();
        }
    }

    public void displayUserInfo(User user) throws IOException {
        System.out.println("***** 유저 정보 페이지 *****");
        System.out.println("-----\n" + user.toString() + "-----\n");

        System.out.println("***** 1. 주소 변경 *****");
        System.out.println("***** 2. 크레딧 충전 *****");
        System.out.println("***** 0. 로그아웃 *****");

        int userInput = Integer.parseInt(input());
        if (userInput == 1) {
            System.out.println("***** 주소 변경 *****");
            String inputAddress = input();
            userController.updateAddress(inputAddress);
        } else if (userInput == 2) {
            System.out.println("***** 충전하실 금액을 입력해주세요. *****");
            int price = Integer.parseInt(input());
            userController.addCredit(price);
        } else if (userInput == 0) {
            userController.logout();
        }
    }

    public void displayBucket(Bucket bucket) {
        System.out.println("***** 장바구니 보기 *****");
        System.out.println(bucket.getRestaurant());
        System.out.println("Total Price: " + bucket.getTotalPrice());
        for (Map.Entry<Menu, Integer> entry : bucket.getOrderMenus().entrySet()) {
            System.out.println("Menu: " + entry.getKey().getName() + " Quantity: " + entry.getValue());
        }
    }
}
