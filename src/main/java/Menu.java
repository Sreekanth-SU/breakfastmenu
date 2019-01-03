import java.util.List;

public class Menu {
    public static void main(String args[]) {
        try {
            String inputFileName = args[0];
            String sortOrder = args[1];
            BreakfastMenu menu;
            if (inputFileName != null && inputFileName.endsWith("xml")) {
                menu = new ParseXml().getBreakfastMenuFromXml(inputFileName);
            } else if(inputFileName != null && inputFileName.endsWith("json")) {
                menu = new ParseJson().getBreakfastMenuFromJsonInput(inputFileName);
            } else {
                throw new Exception("We Support only xml/json files");
            }

            List<Food> foodList = menu.sortFoodListByNameAndOrder(menu.getFood(), sortOrder);

            System.out.println("Here is the Menu");
            System.out.println("-----------------------------------------");

            for (Food food : foodList) {
                System.out.println("Name : " + food.getName());
                System.out.println("Description : " + food.getDescription());
                System.out.println("Price : " + food.getPrice());
                System.out.println("Calories : " + food.getCalories());
                System.out.println("-----------------------------------------");
            }
        } catch (Exception e) {
            String message = e.getMessage();
            if (e instanceof ArrayIndexOutOfBoundsException) {
                message = "Invalid number of arguments passed";
            }
            System.out.println(message);
        }
    }
}
