Calculate Taxes
A set of classes that manipulates Item objects to produce an output that includes the quantity of each item, the item
name, and the item price including tax which is rounded up to the nearest .05 cents

Getting Started
Please unzip the source files and run TestEnvironment class from your favorite IDE or command line with the items of
your choosing. Each item requires the item name, the quantity of items being purchased, the item price (represented as
a BigDecimal object), true/false if it is imported, and the item type (please choose one of the four accepted item
types, i.e. MISC, FOOD, BOOKS, MEDICAL). The TestEnvironment class already has a few items created within but additional
custom ones can be freely created.

In order to test your own, please create the Item objects and input them into an array of type Item. Next, a
CalculateTax object should be created and passed to it should the be item array. And finally, run the outputCalculation()
method from within a System.out.println() method so the result can be displayed to the console.

Prerequisites
Other than the IDE, additional software is not required. The application can be run through terminal and/or command
prompt.

Installing
Installation is not required, all that needs to be done is to open the project with your favorite IDE or run the
application through terminal/command prompt.

Testing
There is only one unit test for calculateSale() method using JUnit5. The user would need to manually calculate the
result which would be fed into an assertion with the input data.

Additional Information
The primary class, CalculateTax, inherits functionality from the abstract class ConfigAccountingSettings.
ConfigAccountingSettings was created as an abstract class so that it could be inherited by various other classes that
make some sort of financial calculation. This allows for flexibility down the road for future classes to inherit from.
The reason an abstract class was chosen over an interface was due to that fact that there existed multiple methods that
would need to be implemented each type so an interface did not seem adequate. The code from the abstract class is
closely tied to its subclasses so an abstract class provided a closer association. Also, the abstract class has
variables that are necessary to its subclass. The abstract class, ConfigAccountingSettings, has one abstract method that
allows the subclass to define the behavior of its output. The subclass is free to choose how to style and setup the
output within the limits of strings.

