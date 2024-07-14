package Bbashyan.view;

import Bbashyan.controller.UserController;
import Bbashyan.model.Bucket;
import Bbashyan.model.Menu;
import Bbashyan.model.User;
import Bbashyan.validator.BasicValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class UserView {
    private  UserController controller;
    private  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public UserView(UserController controller) {
        this.controller = controller;
    }

    public void displayLogin() throws IOException {
        System.out.println("***** 아이디와 비밀번호를 공백으로 입력해주세요 ******");
        String[] inputs;
        while (true) {
            inputs = input().split(" ");
            if (inputs.length == 2) {
                break;
            } else {
                System.out.println("잘못된 입력입니다. 아이디와 비밀번호를 공백으로 구분하여 입력해주세요.");
            }
        }

        String id = inputs[0];
        String pw = inputs[1];

        controller.login(id, pw);
    }

    public void displaySignUp() throws IOException {
        System.out.println("***** 아이디 / 이름 / 비밀번호 / 주소 순으로 공백을 두어 입력해주세요. *****");
        String[] inputs = input().split(" ");

        while (true) {
            inputs = input().split(" ");
            if (inputs.length == 4) {
                break;
            } else {
                System.out.println("잘못된 입력입니다. 아이디 / 이름 / 비밀번호 / 주소 순으로 공백을 두어 입력해주세요.");
            }
        }

        User user = User.builder()
                .id(inputs[0])
                .name(inputs[1])
                .password(inputs[2])
                .address(inputs[3])
                .bucket(new Bucket())
                .credit(0)
                .build();

        controller.signUp(user);
        System.out.println("***** 회원가입이 완료되었습니다. *****");
    }
    public void displayReLogin() throws IOException {
        System.out.println("***** 1. 회원가입 *****");
        System.out.println("***** 2. 재입력 *****");
        int userInput = Integer.parseInt(input());
        BasicValidator.isValidateNumber(input());
        if (userInput == 1){
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
        BasicValidator.isValidateNumber(input());
        if (userInput == 1) {
            System.out.println("***** 주소 변경 *****");
            String inputAddress = input();
            controller.updateAddress(inputAddress);
        } else if (userInput == 2) {
            System.out.println("***** 충전하실 금액을 입력해주세요. *****");
            int price = Integer.parseInt(input());
            controller.addCredit(price);
        } else if (userInput == 0) {
            controller.logout();
        }
    }

    public void displayBucket(Bucket bucket) throws IOException {
        System.out.println("***** 장바구니 보기 *****");
        System.out.println(bucket.getRestaurant());
        System.out.println("Total Price: " + bucket.getTotalPrice());
        for (Map.Entry<Menu, Integer> entry : bucket.getOrderMenu().entrySet()) {
            System.out.println("Menu: " + entry.getKey().getName() + " Quantity: " + entry.getValue());
        }
    }

    private String input() throws IOException {
        System.out.print("입력 : ");
        return br.readLine();
    }
}
