package com.recipeapp.model;

public class Ingredient {
    private String name;

    // コンストラクタ
    public Ingredient(String name) {
        this.name = name;
    }

    // nameフィールドを返す
    public String getName() {
        return name;
    }
}

