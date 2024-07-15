## 초기 설계도
초기에는 학습과 추상화를 통한 확장성을 고려하고자 Spring MVC를 참고하여 개발.<br><br>
초기에는 View와 Controller의 호출 관계를 고민하며 코드를 작성하고, View단 까지 백엔드에서 개발하다보니 원하는 View를 띄우기 위해서는 controller->view->controller->view->... 와 같은 방식으로
view를 보기 위한 사용자의 depth가 너무 깊은 이슈가 발생.<br><br>
또한 동적으로 page를 이동하거나 띄울 수 없고,정해진 순서로만 로직이 흐르는 이슈가 발생하여 각 View page를 url과 같은 형식으로 mapping하여 랜더링 하는 느낌으로 구현하도록 변경<br><br>


### Spring MVC 설계도
![image](https://github.com/user-attachments/assets/9001c724-e1f5-482c-bbb0-4afbb48d4589)
<br>
### 개선된 Bbsha의 MVC 설계도 & 패키지 구조<br>

<img src="https://github.com/user-attachments/assets/9d89b1e5-2590-4988-8928-16cd3d71f272" width="20%">
<br><br>


![우리 설계도 drawio](https://github.com/user-attachments/assets/6d0612bd-0527-4182-85e9-e33f42251e6d)<br><br>
앞선 문제의 해결 방안으로는 Spring MVC를 참고하여 설계하였으며 controller가 view 객체를 main으로 반환하여 main에서 처리하도록 변경하여 depth를 줄이는 방식으로 개발(view id를 get메소드로 받아와 main이 이에 맞는 view로 전달)

또한 dispatcher를 통해 controller mapping 및 호출하는 과정을 담당하도록 처리
<br>
## 한계점
하지만 이 역시 여러 한계점을 가지고 있었는 데, 한계점은 다음과 같았다.

- 동적인 View를 랜더링하지 못하는 설계 이슈
  - JSP와 같은 동적인 View 페이지를 만들어야 하는데 고려하지 못함
- Controller를 통일하지 못해 Dispatcher에서 Controller Mapping과 호출을 모두 담당하게 됨.
  - Dispatcher에 책임이 많이 부여됨.
- 과제 기간에 맞춰 개발하기에는 volume이 너무 크고 학습에 시간이 오래 걸리는 이슈

<br><br>
이러한 이슈 때문에 Spring MVC로 고려하여 설계하기 보다는 class diagram을 먼저 구상하고, User Flow를 통해 간단히 도식화 한 후 설계하는 식으로 코드를 구성하도록 변경<br><br><br>

## Class Diagram
<img src="https://github.com/user-attachments/assets/c8218701-b147-4a5d-bfd1-5132fbbaf667" width="40%">
<br><br>

카테고리를 객체를 분류하고 가게에서 카테고리 객체를 참조하여 값을 갖도록, 추후 서비스의 확장성을 고려하여 설계<br><br>
장바구니에서 동일한 가게의 주문만 받도록 처리하는 isOneRestaurant를 통해 유효성 검사. 메뉴가 존재한다면 기존 Map에 quantity만 추가하도록 설계<br><br>


우리는 최대한 **객체의 분리**를 가장 중요한 요소로 잡고, 기본적인 MVC패턴만 지키고 책임의 분리를 최대한 구현하는 방안으로 개발을 진행함.

구현의 용이성을 위해 하나의 파일로 코드를 구현 한 후 이를 MVC패턴에 따라 분리하는 식으로 처리하도록 함.

구현보다는 구조를 확실히 하는 데에 초점을 두고 개발을 진행함.


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


## Package

이후 메인 로직을 다음과 같이 분리함.
<br>
![Untitled (6)](https://github.com/user-attachments/assets/2f5c28b6-8e39-4d8a-865d-3715cb6a367f)
<br><br>
이전에 비해 훨씬 간단한 구조를 통해 이해하기 쉬운 코드를 작성할 수 있었음.

결과적으로 구현된 코드나 로직은 많지 않았지만 개발 구조를 여러번 바꾸는 데에 있어 JAVA/Spring에 관한 학습을 많이 진행할 수 있었다.
