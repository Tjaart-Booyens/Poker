# Poker

A simple poker game simulater where you can draw cards and see what the highest ranking hand matches.

## Getting Started

To install the project onto your machine do the following.

### Prerequisites

Maven - be sure to have Maven installed by going to their website -> https://maven.apache.org/

Java  - you will also need to have Java installed on your machine -> https://adoptopenjdk.net/

### Installing the JAR

If you want to run the JAR only you can either download the jar or clone the project into a directory of your choice.

If you only downloaded the JAR go the step where you run the JAR.

Go to the directory you want to install the project.

Clone the git repo to the directory:

```
~$ git clone https://github.com/Tjaart-Booyens/Poker.git 
```

Now go to the poker directory inside of the Poker directory that was cloned:

```
~$ cd Poker/poker/
```

### Running the JAR

Run the JAR by executing the following command:

```
~$ java -jar path/to/poker-x.x-jar-with-dependencies.jar
```

Where -x.x- is the verion number of the JAR.

### Installing

Go to the directory you want to install the project.

Clone the git repo to the directory:

```
~$ git clone https://github.com/Tjaart-Booyens/Poker.git 
```

Now go to the poker directory inside of the Poker directory that was cloned:

```
~$ cd Poker/poker/
```

You will now be able to see the all the source files as well as all the test files.

If you want to run the program you will need to make sure that you run the Maven commands to clean and package the into a standalone jar file with all the required dependencies:

NOTE: Maven may take a while downloading resources for the commands and dependencies.

```
~$ mvn clean compile assembly:single
```

## Running the tests

If you want to run the tests for the project you can execute the following command:

```
~$ mvn test
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Acknowledgments

* Thank you for http://nsayer.blogspot.com/2007/07/algorithm-for-evaluating-poker-hands.html for the algorithm of the evaluator
