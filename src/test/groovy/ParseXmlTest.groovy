import spock.lang.Specification

class ParseXmlTest extends Specification {

    def "should get brekfast menu for given xml file"(){
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


