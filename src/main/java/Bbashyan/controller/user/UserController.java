package Bbashyan.controller.user;

import Bbashyan.controller.MainController;
import Bbashyan.model.user.User;
import Bbashyan.service.user.UserService;
import Bbashyan.view.user.UserView;
import lombok.Getter;

import java.io.IOException;
import java.util.NoSuchElementException;

@Getter
public class UserController {
    private final UserView userView = new UserView(this);
    private final UserService userService = new UserService();
    private User currentUser;

    public void login(String id, String password) throws IOException {
        try {
            currentUser = userService.login(id, password);
            System.out.println("***** 로그인을 성공했습니다 *****");
        } catch(NoSuchElementException e) {
            System.out.println("***** 로그인 실패 *****");
            userView.displayReLogin();
        }
    }

    public void logout() throws IOException {
        currentUser = null;
        System.out.println("***** 로그아웃 되었습니다. *****");
        MainController.getMainController().displayMainMenu();
    }

    public void signUp(String id, String name, String password, String address) throws IOException {
        try {
            userService.signUp(id, name, password, address);
            System.out.println("***** 회원가입이 완료되었습니다. *****");
        } catch(NoSuchElementException e) {
            System.out.println("***** User가 이미 있습니다. *****");
            userView.displaySignUp();
        }
    }

    public void updateAddress(String address) {
        currentUser.setAddress(address);
        userService.update(currentUser);
        System.out.println("*** 주소가 변경되었습니다. ***");

    }

    public void addCredit(int amount) {
        currentUser.plusCredit(amount);
        userService.update(currentUser);
        System.out.println("***** 충전이 완료되었습니다. *****");

    }

    public void payingCredit(int amount) throws IOException {
        currentUser.minusCredit(amount);
        userService.update(currentUser);
        System.out.println("***** 결제가 완료되었습니다. *****");
        userView.displayUserInfo(currentUser);
    }

    public void displayUserInfo() throws IOException {
        userView.displayUserInfo(currentUser);
    }

    public void displayLogin() throws IOException {
        userView.displayLogin();
    }

    public void displaySignUp() throws IOException {
        userView.displaySignUp();
    }

    public void displayBucket() {
        userView.displayBucket(currentUser.getBucket());
    }

}
