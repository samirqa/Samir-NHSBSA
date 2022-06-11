## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Scenario Outline](#scenario-outline)
* [Setup](#setup)
* [Browsers](#browsers)
* [Execution](#execution)
* [Report](#report)

## General info
This is automation Test project to Check the help you could get to pay for NHS costs
	
## Technologies
Project is created with:
* Java
* Maven
* BDD Framework

## Scenario-outline
Test Boundry value analysis:
* In the City Wales verify that valid age should get the free NHS dental check-ups Age under 16.
* In the City Wales verify that valid age should get the free NHS dental check-ups Age under 19.
* In the City Wales verify that valid age should get the free NHS dental check-ups Age Above 19.
* 
## Setup
To run this project, make sure Java and Maven should Installed and Java_Home and M2_Home system environment variable must be set in classpath

## Browsers
Test support Chrome and Firefox latest browser
* Default Browser set chrome in the Configuration.properties
* To run in the firefox browser uncomment '#browser=firefox' in the Configuration.properties
* Tested Chrome Browser 102.0.5005.63 (64-bit)
* Tested Firefox Browser 101.0 (64-bit)

## Execution
download the project
Open project directory in command prompt and run below command
```
$ mvn clean install
$ mvn exec:java -Dexec.classpathScope=test -Dexec.mainClass=io.cucumber.core.cli.Main -Dexec.args="src/test/resources/features --glue stepDefinitions
```
## Report
Open index.html in /target/cucumber-reports folders
