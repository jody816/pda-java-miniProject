#Bbasha Project

## 초기 설계도
초기에는 학습과 추상화를 통한 확장성을 고려하고자 Spring MVC를 참고하여 개발.

### Spring MVC 설계도
![image](https://github.com/user-attachments/assets/9001c724-e1f5-482c-bbb0-4afbb48d4589)
<br>
### Bbsha의 MVC 설계도<br>
![우리 설계도 drawio](https://github.com/user-attachments/assets/6d0612bd-0527-4182-85e9-e33f42251e6d)

<br>

## 한계점
- 동적인 View를 랜더링하지 못하는 설계 이슈
  - JSP와 같은 동적인 View 페이지를 만들어야 하는데 고려하지 못함
- Controller를 통일하지 못해 Dispatcher에서 Controller Mapping과 호출을 모두 담당하게 됨.
  - Dispatcher에 책임이 많이 부여됨.
- 과제 기간에 맞춰 개발하기에는 volume이 너무 크고 학습에 시간이 오래 걸리는 이슈

<br><br>
이러한 한계점 이슈 때문에 Spring MVC로 고려하여 설계하기 보다는 class diagram을 먼저 구상하고, User Flow를 통해 간단히 도식화 한 후 설계하는 식으로 코드를 구성하도록 변경<br><br><br>

## Class Diagram
<img src="https://github.com/user-attachments/assets/c8218701-b147-4a5d-bfd1-5132fbbaf667" width="40%">
<br><br>

카테고리를 객체를 분류하고 가게에서 카테고리 객체를 참조하여 값을 갖도록, 추후 서비스의 확장성을 고려하여 설계<br><br>
장바구니에서 동일한 가게의 주문만 받도록 처리하는 isOneRestaurant를 통해 유효성 검사. 메뉴가 존재한다면 기존 Map에 quantity만 추가하도록 설계<br><br>


## User Flow
![UserFlow](https://github.com/user-attachments/assets/e470f8e4-e95e-44fc-8e08-f4955ea0ad67)


1. 회원 여부 확인<br>
  1-1. 회원가입<br>
  1-2. 로그인<br>
2. 메인 페이지<br>
  2-1. 유저 정보 확인<br>
  2-2. 카테고리 선택<br>
  2-3. 장바구니 확인<br>
3. 가게 선택<br>
  3-1. 메뉴 선택<br>
  3-2. 장바구니 확인<br>

<br>

1. 회원 여부 확인 :서비스를 사용하기 전에 사용자의 정보를 확인함으로써 각 유저의 고유의 data의 무결성을 보장하고 보안성을 높이도록 설계<br><br>
2. 메인 페이지 : 메인 페이지에도 장바구니를 확인할 수 있게 처리해서 data의 접근성을 늘렸고, 유저 데이터를 고정 된 값이 아닌 업데이트 할 수 있도록 설계<br><br>
