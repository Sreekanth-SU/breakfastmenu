**Program to Parse Json / Xml File and sort by name of the food in the list. The files contains a menu with list of food.**

This program has two main Classes ParseJson and ParseXml and other domain classes

ParseJson uses the Jackson library to Deserialize and Convert into java Objects.

ParseXml uses unmarshaller to map the Xml to Java Objects.

This Program uses the Jackson library and internal java jaxb unmarshaller.

Please make sure Java 8 is installed in your computer.

Instructions to run the program:

java -jar menu.jar menu.xml desc  
java -jar menu.jar menu.json asc  

The program currently takes the filename as 1st argument and sortOrder as second argument.

