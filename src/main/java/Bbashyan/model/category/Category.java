package Bbashyan.model.category;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Category {
  private int id;
  private String name;
}
