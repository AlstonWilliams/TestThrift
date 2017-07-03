# README

This demo is created because the code snippet in official websiteis not complete.

The steps to write this demo:
- Create a maven project
- Write thrift file, which is placed in src/main/java/thrift
- Generate Java Source code by the thrift file, run this command: **thrift --gen java shared.thrift && thrift --gen java tutorial.thrift**
- Ok, you will see some folders generated newly in src/main/java/thrift, here I have removed it
- Copy the thrift and tutorial folder generated newly to src/main/java, and remove the generated folder in src/main/java/thrift newly
- Import the shared and tutorial package in others source code and write logical code.

All right, this is just a demo which helps you to understand how operate thrift. You should deep in official documentation for more details.
