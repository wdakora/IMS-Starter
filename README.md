Coverage: 70%
# Inventory Management System

This is an Inventory Management System project used to create customers, items and orders. 

Stored in an SQL database and coded in java

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
Tools you will need:

 - Java jdk1.8.0_271 [Guide to installation](https://docs.oracle.com/en/java/javase/15/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)
 - Maven 
 - MySQL Workbench
 - IDE (integrated development environment) for using Java such as [Eclipse](https://www.oracle.com/java/technologies/javase-downloads.html) or [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows)

### Installing


**Java**

Add these environment variables on your machine:

```
- Variable name: JAVA_HOME
- Variable Value: C:\Program Files\Java\jdk1.8.0_271

Append to PATH: %JAVA_HOME%\bin
```
**Maven**

unzip apache-maven-3.6.3-bin.zip into your program files

Add these environment variables on your machine: 
```
- Variable name: MAVEN_HOME
- Variable Value: C:\Program Files\apache-maven-3.6.3\bin

- Variable name: M2
- Variable Value: C:\Program Files\apache-maven-3.6.3\bin

Append to PATH: %MAVEN_HOME%\bin
```
**SQL** 
[Guide to installing mySQL](https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/)

Jar file
Here is a handy tutorial to create a fat.jar with maven [Here](http://tutorials.jenkov.com/maven/maven-build-fat-jar.html)

## Running the tests

![Testing Coverage](https://github.com/wdakora/IMS-Starter/blob/development/images/Coverage.PNG)

To run this, right click on your project in eclipse and run covereage as a jUnit test
The DAO tests will make sure the code written will actually work with my sql database
The Controller tests will check if the fake data I provide will run

### Unit Tests 

Unit testing is a testing approach that targets the very fundamental building blocks of an application, the idea is to prove that each 'unit' of the application is functioning as expected.

The code below will test if it can create an item
```
@Test
	public void testCreate() {
		final Item created = new Item(3L, "Milk", 2.99);
		assertEquals(created, itemdao.create(created));
	}
```

### Integration Tests 
Integration Testing is usually the next step after unit testing, once the functionality of the individual components is confirmed.
The code below will test if this is correct
```
	@Test
	public void testCreate() {
		String item_name = "bread" ;
		Double price = 2.50;
		Item itemCreate = new Item(item_name, price);
		
		when(utils.getString()).thenReturn(item_name);
		when(utils.getDouble()).thenReturn(price);
		when(itemdao.create(itemCreate)).thenReturn(itemCreate);
		
		assertEquals(itemCreate, controller.create());
		
		verify(utils,times(1)).getString();
		verify(utils,times(1)).getDouble();
		verify(itemdao,times(1)).create(itemCreate);
	}
```


## Deployment

On command line (CMD) run this:

```
java -jar [YOUR PATH NAME]\ims-0.0.1-jar-with-dependencies.jar
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* Eclipse
* mySQL

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Winifred Dakora** - *Finished work*

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

- Aswene Sivaraj and Piers Barber for all the help recieved for this projects 
