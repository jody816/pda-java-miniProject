package Bbashyan.model.user;


import Bbashyan.model.bucket.Bucket;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class User {

    private String id;
    private String name;
    private Bucket bucket;
    private String password;
    @Setter
    private String address;
    private int credit;

    @Override
    public String toString() {
        StringBuilder userInfo = new StringBuilder();

        userInfo.append("아이디: ").append(id).append("\n")
                .append("이름: ").append(name).append("\n")
                .append("잔액: ").append(credit).append(" ￦").append("\n");

        return userInfo.toString();
    }

    public void plusCredit(int credit) {
        this.credit += credit;
    }

    public void minusCredit(int credit) {
        this.credit -= credit;
    }
}
