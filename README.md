### Idealscorp


**Programming language:** 
* Java 


**Type of framework:** 
* Hybrid Driven Testing Framework 

**Test frameworks are used:** 
* TestNG
* WebDriver - Selenium


**Element locators are located:** 
* Page Object Pattern


**Property file:** 
* src/main/resources/env.property (URLs, Credentials)
* scr/test/resources/allure.properties (Allure settings)


**Patterns are used:** 
* Page Object Pattern
* Steps pattern
* Chain of invocation pattern
* WebDriver Factory pattern


**Logger:**
* Decorator pattern - Log4J


### How to run:
```sh
mvn clean test -Dbrowser=chrome -Dparallel=classes -DthreadCount=10
```
- -Dbrowser=chrome - variable could be equal ['chrome', 'firefox' or empty]
- -Dparallel=classes - parallel tests by java classes
- -DthreadCount=10 - count of threads

HOW TO GET REPORT
```sh
mvn io.qameta.allure:allure-maven:serve
```



