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
