import spock.lang.Specification
import spock.lang.Unroll

class ParseJsonTest extends Specification {


   def "should get breakfast menu for given xml file"(){
        given:
        def inputFileName = "menuTest.json"
        ParseJson parseJson = new ParseJson()

        when:
        def result = parseJson.getBreakfastMenuFromJsonInput(inputFileName)

        then:
        result instanceof BreakfastMenu
        result.food.size() == 5
        result.food[0].name.equalsIgnoreCase("Belgian Waffles")
        result.food[0].price.equalsIgnoreCase($/$5.95/$)
        result.food[0].calories == 650
   }

    @Unroll
    def "should get breakfast menu for with sorted list order by #sortOrder"(){
        given:
        def inputFileName = "menuTest.json"
        ParseJson parseJson = new ParseJson()
        BreakfastMenu menu = new BreakfastMenu()

        when:
        def result = menu.sortFoodListByNameAndOrder(parseJson.getBreakfastMenuFromJsonInput(inputFileName).food,sortOrder)

        then:
        result.size() == 5
        result[0].name == name

        where:
        sortOrder | name
        "asc"     | "Belgian Waffles"
        "desc"    | "Strawberry Belgian Waffles"
    }

   def "Should throw Exception for Invalid File"(){

       given:
       def inputFileName = "xxx"
       ParseJson parseJson = new ParseJson()

       when:
       parseJson.getBreakfastMenuFromJsonInput(inputFileName)

       then:
       thrown(Exception)
   }
}
