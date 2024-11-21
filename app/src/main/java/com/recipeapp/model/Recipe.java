package com.recipeapp.model;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<Ingredient> ingredients;

    // コンストラクタ
    public Recipe(String name, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    // nameフィールドを返す
    public String getName() {
        return name;
    }

    // ingredientsフィールドを返す
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
}
