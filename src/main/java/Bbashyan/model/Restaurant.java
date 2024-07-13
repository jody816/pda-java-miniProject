package Bbashyan.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Restaurant {
    private String name;
    private List<Menu> menuList;
    private String address;
    private int categoryId;
    private String description;
}
