package Bbashyan.controller;

import Bbashyan.dao.UserDao;
import Bbashyan.model.User;
import Bbashyan.view.UserView;
import lombok.Getter;

import java.io.IOException;

public class UserController {
    private UserDao userDao=new UserDao();
    private UserView view=new UserView(this);
    @Getter
    private User currentUser;

    public void login(String id, String password) throws IOException{
        User user=userDao.findUserById(id);
        if(user!=null && user.getPassword().equals(password)){
            System.out.println("***** 로그인을 성공했습니다 *****");
            currentUser = user;
        }
        else{
            System.out.println("***** 로그인 실패 *****");
            view.displayReLogin();
        }
    }



    public void signUp(User user) {
        userDao.save(user);
    }


    public void updateAddress(String address) throws IOException {
        currentUser.setAddress(address);
        System.out.println("*** 주소가 변경되었습니다. ***");

    }

    public void addCredit(int amount) throws IOException {
        currentUser.plusCredit(amount);
        System.out.println("***** 충전이 완료되었습니다. *****");

    }
    public void abstractCredit(int amount) throws IOException {
        currentUser.minusCredit(amount);
        System.out.println("***** 결제가 완료되었습니다. *****");
        view.displayUserInfo(currentUser);
    }

    public void logout() throws IOException {
        currentUser = null;
        System.out.println("***** 로그아웃 되었습니다. *****");
        MainController.getInstance().displayMainMenu();
    }


    public void displayUserInfo() throws IOException {
        view.displayUserInfo(currentUser);
    }
    public void displayLogin() throws IOException {
        view.displayLogin();
    }
    public void displaySignUp() throws IOException {
        view.displaySignUp();
    }
    public void displayBucket() throws IOException{
        view.displayBucket(currentUser.getBucket());
    }

}
