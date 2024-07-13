package Bbashyan;

import Bbashyan.dao.CategoryDao;
import Bbashyan.dao.UserDao;
import Bbashyan.model.Bucket;
import Bbashyan.model.Category;
import Bbashyan.model.Menu;
import Bbashyan.model.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

public class MainApplication {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static final UserDao userDao = new UserDao();
  private static final CategoryDao categoryDao = new CategoryDao();
  private static User currentUser = null;

  public static void run() throws IOException {
    // Main로직
    System.out.println("Loading...");

    while (true) {
      System.out.println("***** 1. 로그인   *****");
      System.out.println("***** 2. 회원 가입 *****");

      String input = input();
      int select = Integer.parseInt(input);
      if (select == 1) {
        System.out.println("***** 아이디와 비밀번호를 공백으로 입력해주세요 ******");
        String[] inputs = input().split(" ");
        String id = inputs[0];
        String pw = inputs[1];
        User user = userDao.findUserById(id);
        if (user.getPassword().equals(pw)) {
          System.out.println("***** 로그인을 성공했습니다 *****");
          currentUser = user;
          break;
        }
        System.out.println("***** 로그인 실패 *****");
      } else if (select == 2) {
        // todo 회원 가입
        System.out.println("***** 아이디 / 이름 / 비밀번호 / 주소 순으로 공백을 두어 입력해주세요. *****");
        String[] inputs = input().split(" ");

        User user = User.builder()
            .id(inputs[0])
            .name(inputs[1])
            .bucket(new Bucket())
            .password(inputs[2])
            .credit(0)
            .build();

        userDao.save(user);

        System.out.println("***** 회원가입이 완료되었습니다. *****");
      }
    }

    // todo 로그인 후의 과정
    System.out.println("***** 메인 페이지 *****");
    System.out.println("***** 1. 유저 정보 확인 *****");
    System.out.println("***** 2. 음식 카테고리 선택 *****");
    System.out.println("***** 3. 장바구니 확인 *****");
    System.out.println("***** 0. 로그아웃 *****");

    int input = Integer.parseInt(input());

    // 유저 정보 페이지
    if (input == 1) {
      System.out.println("***** 유저 정보 페이지 *****");
      System.out.println("-----\n" + currentUser.toString() + "-----\n");

      System.out.println("***** 1. 주소 변경 *****");
      System.out.println("***** 2. 크레딧 충전 *****");
      System.out.println("***** 0. 로그아웃 *****");

      int userInput = Integer.parseInt(input());

      if (userInput == 1) {
        System.out.println("***** 주소 변경 *****");
        String inputAddress = input();

        currentUser.setAddress(inputAddress);

        System.out.println("*** 주소가 변경되었습니다. ***");
      } else if (userInput == 2) {
        System.out.println("***** 충전하실 금액을 입력해주세요. *****");

        int price = Integer.parseInt(input());
        currentUser.plusCredit(price);
        System.out.println("***** 충전이 완료되었습니다. *****");
        } else if(userInput == 0) {
        System.out.println("***** 로그아웃 되었습니다. *****");
        return;
      }
      // 카테고리 선택 페이지
    } else if (input == 2) {
      System.out.println("***** 카테고리 선택 *****");
      List<Category> categories = categoryDao.findAll();
      for(int i = 0; i < categories.size() ;i++) {
        Category category = categories.get(i);
        System.out.println("***** " + i+1 + ". " + category.getName() + " *****");
      }

      int categorySelect = Integer.parseInt(input());

      if (categorySelect == 1) {
        System.out.println("*** 한식 ***");

      } else if (categorySelect == 2) {
        System.out.println("*** 중식 ***");

      } else if (categorySelect == 3) {
        System.out.println("*** 양식 ***");

      } else {
        System.out.println("*** 일식 ***");

      }
      // 장바구니 확인
    } else if (input == 3) {
      System.out.println("***** 장바구니 페이지 *****");
      Bucket bucket = currentUser.getBucket();
      Map<Menu, Integer> orderMenu = bucket.getOrderMenu();
//      for (Menu menu : orderMenu) {
//
//      }
    } else {
      // todo 종료
    }
  }

  public static String input() throws IOException {

    System.out.print("입력 : ");
    return br.readLine();
  }
}
