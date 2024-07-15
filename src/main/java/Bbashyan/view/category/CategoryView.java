package Bbashyan.view.category;

import Bbashyan.controller.category.CategoryController;
import Bbashyan.model.category.Category;

import java.io.IOException;
import java.util.List;

import static Bbashyan.utils.InputUtil.input;

public class CategoryView {
    private final CategoryController categoryController;

    public CategoryView(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    public void displayCategories(List<Category> categories) throws IOException {
        System.out.println("***** 카테고리 선택 *****");
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            System.out.println("***** " + (i + 1) + ". " + category.getName() + " *****");
        }

        int categorySelect = Integer.parseInt(input());
        categoryController.getRestaurantController().displayRestaurantByCategoryId(categorySelect);

    }
}
