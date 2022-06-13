## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Scenario Outline](#scenario-outline)
* [Setup](#setup)
* [Browsers](#browsers)
* [Execution](#execution)
* [Report](#report)

## General info
This is automation Test project to verify to get the Free NHS Costs to Wales
	
## Technologies
Project is created with:
* Java
* Maven
* BDD Framework

## Scenario-outline
  Teset Scenario Cover for Wales City only
* Using checker tool verify that in the City Wales valid age user should get the free NHS help or not - Age under 16.
* Using checker tool verify that in the City Wales valid age user should get the free NHS help or not - Age under 19.
* Using checker tool verify that in the City Wales valid age user should get the free NHS help or not - Age above 19.

## Test-Case
* Attached TestCase to validate scenario. attached in TestCase folder

## Setup
To run this project, make sure Java and Maven should Installed and Java_Home and M2_Home system environment variable must be set in classpath

## Browsers
each test run in Chrome and Firefox browser.
Make sure Chrome and Firefox browser are setup into the local machine where source is clone.
* Tested Chrome Browser 102.0.5005.63 (64-bit)
* Tested Firefox Browser 101.0 (64-bit)

## Execution
download or clone the project
Open project directory in command prompt and run below command
```
$ mvn clean install
$ mvn exec:java -Dexec.classpathScope=test -Dexec.mainClass=io.cucumber.core.cli.Main -Dexec.args="src/test/resources/features --glue stepDefinitions
```
## Report
* Open index.html in /target/cucumber-reports folders
* Capability of extent report. Added required class and dependency for it. But not has implemented.
