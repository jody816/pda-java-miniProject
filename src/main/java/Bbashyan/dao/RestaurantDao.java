package Bbashyan.dao;

import Bbashyan.model.Menu;
import Bbashyan.model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantDao {

    private static final Map<String, Restaurant> map = new HashMap<>();

    public RestaurantDao(){
        map.put("밥플러스", Restaurant.builder()
                .name("밥플러스")
                .categoryId(1)
                .address("서울특별시 성동구 성수동2가 315-61번지 202 203호")
                .description("누구나 아는 그곳. 밥플러스 입니다.")
                .menuList(List.of(
                        new Menu("어제의 메뉴",700),
                        new Menu("오늘의 메뉴", 800),
                        new Menu("내일의 메뉴", 900)
                ))
                .build());

        map.put("담미온", Restaurant.builder()
                .name("담미온")
                .categoryId(1)
                .address("서울특별시 성동구 성수동2가 성수이로 118")
                .description("얼큰 국밥 한번 드셔보세요")
                .menuList(List.of(
                        new Menu("얼큰 국밥", 10000),
                        new Menu("순두부 국밥", 10000),
                        new Menu("부대국밥", 12000)
                ))
                .build());

        map.put("제주국수", Restaurant.builder()
                .name("제주국수")
                .categoryId(1)
                .address("서울특별시 성동구 성수동2가 277-17")
                .description("제주도 가고 싶은데 국수도 먹고 싶을때 오세요")
                .menuList(List.of(
                        new Menu("고기 국수", 9500),
                        new Menu("얼큰 고기 국수", 10500),
                        new Menu("맹맹한 고기 국수", 11000)
                ))
                .build());

        map.put("착한짜장", Restaurant.builder()
                .name("착한짜장")
                .categoryId(2)
                .address("서울특별시 성동구 아차산로7길 17-1")
                .description("특별 이벤트로 가격을 10배로 올렸습니다! 많이 이용해주세요.")
                .menuList(List.of(
                        new Menu("잡채밥", 60000),
                        new Menu("탕짬(짜)면", 70000),
                        new Menu("볶짬(짜)면", 85000)
                ))
                .build());

        map.put("이가네 양꼬치", Restaurant.builder()
                .name("이가네 양꼬치")
                .categoryId(2)
                .address("서울특별시 성동구 아차산로 116")
                .description("양꼬치에 이과두주 한잔 드셔보세요. 눈뜨면 아침입니다.")
                .menuList(List.of(
                        new Menu("이과두주", 5000),
                        new Menu("빅양꼬치 4개", 20000)
                ))
                .build());

        map.put("고투웤", Restaurant.builder()
                .name("고투웤")
                .categoryId(2)
                .address("서울특별시 성동구 성수동2가 314-13")
                .description("직접 골라 먹는 재미가 가득한 미국식 중식 전문점")
                .menuList(List.of(
                        new Menu("계란볶음밥", 8000),
                        new Menu("마파두부", 18000),
                        new Menu("칠리새우", 35000)
                ))
                .build());

        map.put("호랭이 초밥", Restaurant.builder()
                .name("호랭이 초밥")
                .categoryId(3)
                .address("초밥이 먹고 싶을 때, 호랭이 초밥")
                .description("")
                .menuList(List.of(
                        new Menu("호랑이 초밥", 8000),
                        new Menu("사자 초밥", 9000),
                        new Menu("고라니 초밥", 10000)
                ))
                .build());

        map.put("도죠", Restaurant.builder()
                .name("도죠")
                .categoryId(3)
                .address("서울특별시 성동구 성수이로 126")
                .description("도죠 요로시쿠 오네가이시마스")
                .menuList(List.of(
                        new Menu("가츠동", 9000),
                        new Menu("규동", 9500),
                        new Menu("우동", 13000)
                ))
                .build());

        map.put("교대 일층집", Restaurant.builder()
                .name("교대 일층집")
                .categoryId(3)
                .address("교대 이층집 아래")
                .description("이층까지 올라가기 다리 아파서 만들었습니다.")
                .menuList(List.of(
                        new Menu("돈가스 정식", 25500),
                        new Menu("냉모밀 정식", 28000),
                        new Menu("><커플세트", 77000)
                ))
                .build());

        // 양식
        map.put("미도인 성수", Restaurant.builder()
                .name("미도인 성수")
                .categoryId(4)
                .address("서울특별시 성동구 연무장7가길 3")
                .description("덮밥 맛있는 미도인 성수")
                .menuList(List.of(
                        new Menu("명란크림파스타", 12800),
                        new Menu("미도인 구첩 반상", 15900),
                        new Menu("빠샤빠샤 파스타", 16900)
                ))
                .build());

        map.put("캥거루고깃집", Restaurant.builder()
                .name("캥거루고깃집")
                .categoryId(4)
                .address("Australia 어딘가")
                .description("캥거루 본적도 없는 사람들이 만듭니다.")
                .menuList(List.of(
                        new Menu("뒷다리 스테이크", 22000),
                        new Menu("앞다리 스테이크", 33000),
                        new Menu("뱃살 스테이크", 55000)
                ))
                .build());

        map.put("자바와 신희을", Restaurant.builder()
                .name("자바와 신희을")
                .categoryId(4)
                .address("서울특별시 성동구 성수일로8길 59 평화빌딩 B동 2층")
                .description("GOD희을의 생일은 7월15일 이라는 사실 알고 계신가요?")
                .menuList(List.of(
                        new Menu("자바를 자바라", 13500),
                        new Menu("백엔드의 신", 14000),
                        new Menu("을의 반란", 15000)
                ))
                .build());
    }

    public List<Restaurant> findAll() {
        return new ArrayList<>(map.values());
    }

}
