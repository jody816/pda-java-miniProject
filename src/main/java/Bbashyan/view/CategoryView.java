package Bbashyan.view;

import Bbashyan.controller.CategoryController;
import Bbashyan.model.Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CategoryView {
    private CategoryController controller;

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public CategoryView(CategoryController controller) {
        this.controller = controller;
    }

    public void displayCategories(List<Category> categories) throws IOException {
        System.out.println("***** 카테고리 선택 *****");
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            System.out.println("***** " + (i + 1) + ". " + category.getName() + " *****");
        }

        int categorySelect = Integer.parseInt(input());
        controller.getRestaurantController().displayRestaurantByCategoryId(categorySelect);

    }

    private String input() throws IOException {
        System.out.print("입력 : ");
        return br.readLine();
    }
}
