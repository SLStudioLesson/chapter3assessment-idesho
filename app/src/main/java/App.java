import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;

public class App {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // ファイル形式選択メニューを表示
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();

            // データハンドラーの選択
            DataHandler dataHandler;
            if ("1".equals(choice)) {
                dataHandler = new CSVDataHandler(); // CSVハンドラーを生成
            } else if ("2".equals(choice)) {
                dataHandler = new JSONDataHandler(); // JSONハンドラーを生成
            } else {
                System.out.println("Invalid input. Defaulting to CSV.");
                dataHandler = new CSVDataHandler(); // デフォルトはCSV
            }

            // RecipeUIに渡してメニューを表示
            RecipeUI ui = new RecipeUI(dataHandler);
            ui.displayMenu();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
