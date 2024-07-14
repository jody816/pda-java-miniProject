package Bbashyan.model;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
public class User {

    private String id;
    private String name;
    private Bucket bucket;
    private String password;
    private String address;
    private int credit;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("아이디: ").append(id).append("\n")
                .append("이름: ").append(name).append("\n")
                .append("잔액: ").append(credit).append(" ￦").append("\n");

        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void plusCredit(int credit) {
        this.credit += credit;
    }

    public void minusCredit(int credit) {
        this.credit -= credit;
    }
}
