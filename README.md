# Charles' first Java script for testing
## Description
I can use this script as a template for all my automation test script in Java.
## Before running
### Make sure Maven is correctly downloaded and configured before we run the scripts
- First we need to set the path for Java JDK and Maven in system variables;
  - Click [here](https://stackoverflow.com/questions/19090928/mvn-command-is-not-recognized-as-an-internal-or-external-command) to find more details
- Then we need to go to the directory that contains our pom.xml file and Run `mvn` install;
  - Click [here](https://docs.microsoft.com/en-us/azure/devops/artifacts/maven/install?view=azure-devops) to find more details

### Important update notes on 2019/08/16
Update the <groupId> and <artifactId> in "pom.xml" file, as incorrect value for those XML elements will lead to failure.

Click [here](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html) to find more about POM.