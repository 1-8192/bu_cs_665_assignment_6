
| CS-665        | Software Design & Patterns |
|---------------|----------------------------|
| Name          | ALESSANDRO ALLEGRANZI      |
| Date          | 04/18/2024                 |
| Course        | CS 665 Spring              |
| Assignment #  | 6                          |

# Assignment Overview

The objective of this assignment is to refactor an older project using the strategies learned in class. I chose the initial
assignment 1 (Beverage Vending Machine) to refactor, as it featured less design patterns than successive assignments.
I originally went a little above and beyond by implementing a strategy design pattern, which in retrospect was premature, 
since I played myself out of a great refactoring opportunity for this assignment. I was still able to find 3 significant refactors 
to the older code, which improve the original project's design and maintainability.

I refactored the original code by implementing the Factory method pattern in two situations, for Condiments and Beverages. I also 
cleaned up the Main class and moved the prompt and machine logic into the BeverageMachine class, which I believe is better design.
The application still runs the same way as it previously did, with one exception being a simplified order "menu" presented to the user. In line
with refactoring practices I did not introduce new features or change original functionality. Please see more below.

# GitHub Repository Link:
https://github.com/1-8192/bu_cs_665_assignment_6_allegranzi

# Implementation Description 

## Assignment 6 Refactoring Changes

### Refactoring 1: Adding Factory Method Pattern to Condiment class

The main justification for this refactoring is to eliminate code duplication and improve maintainability. 
In the original addCondiments method, there is duplicated code for adding milk and sugar inside a manual conditional check
against a string value for condiment type. This duplication can make the code harder to maintain, prone to errors, 
and more difficult to extend. To add a new condiment, the developer would need to find the method in the BeverageMachine class
and manually update new options. By using a factory to create the condiments, we can eliminate the duplication and 
centralize the creation logic in one place. This makes the code cleaner and easier to maintain. The Factory Method pattern 
is a creational design pattern that provides an interface for creating objects, but allows subclasses to alter the type of 
objects that will be created.

Original Code inside BeverageVendorMachine class:

![Original Code](/images/condiment_mess.png)

New code calling Factory:

![New code calling factory](/images/condiment_factory.png)

The implementation involves creating a CondimentFactory class with a createCondiment method that extends a 
CondimentFactoryInterface. The factory method takes a string as input and returns a Condiment object based on the input 
string. The addCondiments method in the BeverageVendingMachine class is then modified to use the CondimentFactory. The 
factory method also throws an IllegalArgumentException if the input string does not match any known condiment types, as a defensive
measure against erroneous user input. This approach adheres to the Factory Method design pattern, which provides a way 
to delegate the instantiation logic to child classes. Unit tests for the factory class were also created. 
Please see the new UML for assignment 6 for details on class relationships.

### Refactoring 2: Adding Factory Method Pattern to Beverage Class

Similar to refactoring 1, Beverage creation is another great case for using the Factory Method pattern. It encapsulates 
the logic for creating Beverage objects in one place, making the code easier to maintain and extend. 
If a new type of Beverage needs to be added in the future, only modifying the BeverageFactory class is necessary, 
rather than searching through the entire codebase for places where Beverage objects are created. Additionally, the original
code for beverage creation was a repetitive, long switch statement that required various user prompts located in the
BeverageVendingMachine class.

Original Code:

```
// Setting up switch statements based on user input to set the right kind of
    // beverage as the beverage variable.
    if (order.equalsIgnoreCase("tea")) {
      System.out.println(FullyAutomatedBeverageMachineConstants.TEA_OPTIONS);
      String teaChoice = inputScanner.nextLine();

      switch (teaChoice.toLowerCase()) {
        case "black tea":
          selectedBeverage = new BlackTea();
          break;
        case "green tea":
          selectedBeverage = new GreenTea();
          break;
        case "yellow tea":
          selectedBeverage = new YellowTea();
          break;
        default:
          System.out.println(FullyAutomatedBeverageMachineConstants.TEA_ERROR);
          selectedBeverage = new BlackTea();
          break;
      }
    } else if (order.equalsIgnoreCase("coffee")) {
      System.out.println(FullyAutomatedBeverageMachineConstants.COFFEE_OPTIONS);
      String coffeeChoice = inputScanner.nextLine();

      switch (coffeeChoice.toLowerCase()) {
        case "americano":
          selectedBeverage = new Americano();
          break;
        case "espresso":
          selectedBeverage = new Espresso();
          break;
        case "latte macchiato":
          selectedBeverage = new LatteMacchiato();
          break;
        default:
          System.out.println(FullyAutomatedBeverageMachineConstants.COFFEE_ERROR);
          selectedBeverage = new Espresso();
          break;
      }
    }
```

The implementation of the Factory Method pattern in the BeverageFactory class involves a createBeverage method 
(implemented from the interface class) that takes a string as input and returns a Beverage object. The string input 
determines the type of Beverage object that is created. This is done using a switch statement that checks the input 
string and returns a new instance of the appropriate Beverage subclass. If the input string does not match any of the 
known beverage types, an IllegalArgumentException is thrown. This approach ensures that Beverage objects are always 
created in a valid state, and provides a clear and consistent way to create new Beverage objects throughout the application.

New code using factory:

```
do {
      System.out.println(FullyAutomatedBeverageMachineConstants.OPTIONS);
      order = inputScanner.nextLine();
      try {
        selectedBeverage = beverageFactory.createBeverage(order.toLowerCase());
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        success = false;
      }
    } while (!success);
```

The above new code is much less verbose and is much clearer in intention. The switch statement still exists in the Factory class,
but it is centralized and abstracted away from the vending machine class. I have also added additional unit tests to cover the
new factory class, and updated the new UML diagram to reflect the new factory classes. 

### Refactoring 3: Simplifying Main Class and Moving Logic to BeverageVendingMachine

The justification for moving code out of the Main class and into a new runMachine() method in the BeverageVendingMachine class is primarily to adhere to the principle of separation of concerns. This principle states that each part of a program should handle a specific task and be independent from the rest of the system. The Main class should ideally be kept as clean as possible, serving as an entry point to the application and delegating the actual work to other classes. By moving the logic to the BeverageVendingMachine class, you are encapsulating the behavior related to the vending machine within the class that represents it, making the code more modular, easier to read, and maintain.
New Main Class:

``` 
public static void main(String[] args) {
    // Instantiating the beverage machine.
    VendingMachine bevMachine = new BeverageVendingMachine();
    // Running the machine.
    bevMachine.runMachine();
  }
}
```

Method in BeverageVendingMachine:
```
public void runMachine() {
    // Guiding user through CLI inputs to place an order.
    System.out.println(FullyAutomatedBeverageMachineConstants.WELCOME_MESSAGE);
    registerOrder();
    System.out.println(FullyAutomatedBeverageMachineConstants.ORDER_TAKEN);

    // Preparing order with condiments.
    prepareOrder();

    // Calculating order total and completing interaction.
    double total = calculateOrderTotal();
    if (total != 0.00) {
      System.out.println(FullyAutomatedBeverageMachineConstants.TOTAL_MESSAGE + total);
    }
    System.out.println(FullyAutomatedBeverageMachineConstants.BYE_MESSAGE);
  }
```

The implementation of this refactoring involved creating a new runMachine() method in the BeverageVendingMachine class. This method now contains the logic that was previously in the Main class. It guides the user through the command-line inputs to place an order, prepares the order with condiments, calculates the order total, and completes the interaction. The Main class now simply instantiates the BeverageVendingMachine and calls the runMachine() method. This makes the Main class much simpler and more readable, and it's immediately clear what its purpose is. The logic related to the operation of the vending machine is now appropriately located within the BeverageVendingMachine class.

## Original Assignment 1 description (for context):

- Explain the level of flexibility in your implementation, including how new object types can
be easily added or removed in the future.

My implementation is not perfect, but it still allows for a decent amount in flexibility for adding new features to the application. I created an interface for vending machines 
that can me implemented by various vending machine types. Right now the application only serves coffee from a beverage vending machine, but if food or snack vending machines needed to be added,
they could simply extend the public interface and the Main class could interact with the new machine using the same methods as before.

Similarly, condiments right now are very simple classes. In fact, they're probably too simple to really be separate classes for this implementation, but setting up Milk and Sugar as different classes that 
implement the condiment interface makes flexibility and extensibility in the long term easier. The methods by which other classes interact with condiments can be managed by the interface, and future condiment classes are easy to implement following that template.

The beverage package features a lot of classes already, but adding new object types is also very easy. A new beverage would need to extend the Beverage superclass, and just requires the appropriate brew method to be included.

- Discuss the simplicity and understandability of your implementation, ensuring that it is
easy for others to read and maintain.

The main advantage of my implementation lies in the use of interfaces to define public contracts between classes. 
Interfaces provide clear names and return values for methods that make the code readable and clear. My application involves some wordy CLI interactions and 
conditional chains, but those are all provided via class methods, and are not hanging around in the Main executable class. The interfaces and superclasses included also make
building out new objects very straightforward and clear.

I also used built-in type and data structure methods when possible, to reduce the amount of custom code and use industry-known functionality.
For example, instead of manually comparing 2 integer values to determine the lower one, I used the Math.min() method.

- Describe how you have avoided duplicated code and why it is important.

Avoiding duplicate code is important to reduce lines of redundant code and increase readability. Maintenance and triaging bugs is much easier is less-verbose code.
The Beverage superclass and the strategy pattern implemented for the brew method greatly reduced the amount of repetitive code I would have had to write out for the 
6 individual beverage classes, since I didn't have to rewrite the brew method for every individual class.

Another example is the addCondiment() method in the BeverageVendingMachine class, where I wrote out a reusable method instead
of adding condiments to the class variable array manually each time within the prepareOrder() method.

There is still some opportunity to reduce repetitive code, but I opted for extensibility and flexibility with classes and interfaces at this stage, and as a result some of the simpler classes
do still repeat some code.

- If applicable, mention any design patterns you have used and explain why they were
chosen.

I used the Strategy design pattern we discussed in the second module. Building out the beverage superclass and coffee and teas subclasses, I thought it would be a good opportunity to practice the pattern.
Since I was creating various specific coffee and tea classes, but brewing methods would be shared among those coffee and tea types, it seemed a good opportunity. By using the Strategy design pattern, I used an interface for brew method that
I extended in 2 classes, to represent steeping tea and pulling coffee. This way I could insert those two brew methods instead of repeating the same string values for every coffee and tea class.

## Diagrams

The UML diagram for the application was created on draw.io. A PDF copy of the original diagram is available ![here](./diagrams/cs_665_assignment_1.drawio.pdf).
The updated UML diagram post-refactoring is available ![here](./diagrams/cs_665_assignment_6.drawio.pdf).

# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system. 

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line: 

```bash
mvn clean compile
```



## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs 

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


## Checkstyle 

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser. 

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`

## Running the Application

### From an IDE
Open the Main.java class file, and using your IDE UI run the class. In IntelliJ there is a "play" button.



