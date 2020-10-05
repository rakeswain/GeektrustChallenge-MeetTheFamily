# Tame Of Thrones - Geektrust coding challenge
[![Generic badge](https://img.shields.io/badge/build-passing-any.svg)](https://shields.io/)
[![Generic badge](https://img.shields.io/badge/version-v0.0.1-blue.svg)](https://shields.io/)
[![Generic badge](https://img.shields.io/badge/built%20wth-maven-red.svg)](https://shields.io/)
## Summary
This is a solution repo to the coding problem <a href="https://www.geektrust.in/coding-problem/backend/family">Meet The Family</a>. It is a maven console project.
## System Requirments
1. Java 1.8 or above
2. Maven 3.6 or above
## Steps to build
1. Clone the repository
```
$ git clone https://github.com/rakeswain/GeektrustChallenge-MeetTheFamily.git
```
2. Go to the root directory and install dependencies
```
$ mvn clean  install -DskipTests
```
3. Go to the root directory and run the program
```
$ java -jar target/geektrust.jar <path-to-input-file>
```
example :
```
$ java -jar target/geektrust.jar documents/testfiles/input.txt
```
## Run tests
All the test files are under src/test/java folder. To run the tests execute the following command in root directory
```
$ mvn test
```
To run particular tests , execute the following command in the root directory
```
$ mvn -Dtest=<TestFileName> test
```
example : 
```
$ mvn clean  install -DskipTests
```
