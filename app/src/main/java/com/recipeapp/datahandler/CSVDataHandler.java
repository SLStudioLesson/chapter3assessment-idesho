package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    private String filePath;

    // デフォルトコンストラクタ
    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    // パスを引数で受け取るコンストラクタ
    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    // 現在のモードを返す
    @Override
    public String getMode() {
        return "CSV";
    }

    // レシピデータを読み込む
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        ArrayList<Recipe> recipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1) {
                    String name = parts[0].trim();
                    ArrayList<Ingredient> ingredients = new ArrayList<>();
                    for (int i = 1; i < parts.length; i++) {
                        ingredients.add(new Ingredient(parts[i].trim()));
                    }
                    recipes.add(new Recipe(name, ingredients));
                }
            }
        }
        return recipes;
    }

    // レシピデータを追加する
    @Override
    public void writeData(Recipe recipe) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            // レシピ名と材料をカンマ区切りの形式に変換
            StringBuilder line = new StringBuilder(recipe.getName());
            for (Ingredient ingredient : recipe.getIngredients()) {
                line.append(",").append(ingredient.getName());
            }
            line.append("\n");
            writer.write(line.toString());
        }
    }

    // レシピデータを検索する
    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null; // 処理未実装
    }
}
