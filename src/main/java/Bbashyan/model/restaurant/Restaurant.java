package Bbashyan.model.restaurant;

import java.util.List;

import Bbashyan.model.menu.Menu;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Restaurant {
    private int id;
    private String name;
    private List<Menu> menuList;
    private String address;
    private int categoryId;
    private String description;
}
