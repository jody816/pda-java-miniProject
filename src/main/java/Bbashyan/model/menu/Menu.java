package Bbashyan.model.menu;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Menu {
    private String name;
    private int price;

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
