import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "breakfast_menu")
@XmlAccessorType(XmlAccessType.FIELD)
public class BreakfastMenu {

    @XmlElement(name = "food")
    private List<Food> food;

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    public List<Food> sortFoodListByNameAndOrder(List<Food> food, String sortOrder) {
        List<Food> foodList = food.stream()
                .sorted(Comparator.comparing(Food::getName))
                .collect(Collectors.toList());

        if (sortOrder != null && sortOrder.equalsIgnoreCase("desc")) {
            Collections.reverse(foodList);
        }
        return foodList;
    }
}
