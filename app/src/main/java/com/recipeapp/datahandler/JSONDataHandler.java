package com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public class JSONDataHandler implements DataHandler {

    // 現在のモードを返す
    @Override
    public String getMode() {
        return "JSON";
    }

    // レシピデータを読み込む
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        return null; // 処理未実装
    }

    // レシピデータを追加する
    @Override
    public void writeData(Recipe recipe) throws IOException {
        // 処理未実装
    }

    // レシピデータを検索する
    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null; // 処理未実装
    }
}
