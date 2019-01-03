import spock.lang.Specification
import spock.lang.Unroll

class ParseXmlTest extends Specification {

    def "should get breakfast menu for given xml file"(){
        given:
        def inputFileName = "menuTest.xml"
        ParseXml parseXml = new ParseXml()

        when:
        def result = parseXml.getBreakfastMenuFromXml(inputFileName)

        then:
        result instanceof BreakfastMenu
        result.food instanceof List<Food>
        result.food.size() == 5
        result.food[0].name.equalsIgnoreCase("Belgian Waffles")
        result.food[0].price.equalsIgnoreCase($/$5.95/$)
        result.food[0].calories == 650
    }

    @Unroll
    def "should get breakfast menu for with sorted list order by #sortOrder"(){
        given:
        def inputFileName = "menuTest.xml"
        ParseXml parseXml = new ParseXml()
        BreakfastMenu menu = new BreakfastMenu()

        when:
        def result = menu.sortFoodListByNameAndOrder(parseXml.getBreakfastMenuFromXml(inputFileName).food,sortOrder)

        then:
        result.size() == 5
        result[0].name == name

        where:
        sortOrder | name
        "asc"     | "Belgian Waffles"
        "desc"    | "Strawberry Belgian Waffles"
    }

    def "Should throw Exception for Invalid File Name"(){

        given:
        def inputFileName = "xxx"
        ParseXml parseXml = new ParseXml()

        when:
        parseXml.getBreakfastMenuFromXml(inputFileName)

        then:
        thrown(Exception)
    }
}


