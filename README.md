# CS3219R - Collection of Software Patterns

Accompanying Module: NUS CS3219 Software Engineering Principles & Patterns
Author: Han Liang Wee, Eric

In this repository, we will showcase several of the patterns in a single webapp. The litany of patterns is listed below.

1. Template View
1. Transform View
1. Front Controller
1. Page Controller
1. Command Processor/Pattern
1. Data Transfer Object
1. Application Controller
1. Observer

The objective of this repository is to aid learning of software patterns through an interactive, interesting manner. The motivation of this project came from the lack of modern examples of patterns in teaching materials. The author has learnt much from implementing these patterns and hope that you will too by exploring this repository and even extending it.

## Installation

We have packaged the web application using maven and it also relies on Java. A summary of the software tools this application depend on and their respective versions are listed below:

 * Apache Maven 3.3.9: [Install Maven](https://maven.apache.org/install.html)
 * javac 1.8.0\_144: [Install Java](https://www.java.com/en/download/help/download_options.xml)

Detailed instructions on how to install the respective tools are given in the links above. To install these tools on [Fedora Linux](https://getfedora.org/en/workstation/download/), is simply `# dnf install maven`

### Running the application

We have packed the webapp with an embedded webserver plugin in maven. The diagram below shows the build process in our project. Maven will pack the code into a WAR file and then by running the [Jetty Maven Plugin](https://www.eclipse.org/jetty/documentation/9.4.x/jetty-maven-plugin.html), we are able to 'deploy' our WAR file into a temporary webserver([Jetty](https://www.eclipse.org/jetty/)). 

> **WAR: Web Application Resource**
> WAR files are a special kind of JAR file that is tailored for the purposes of web service. In short, it is like JAR but for webservers!


