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

We have packed the webapp with an embedded webserver plugin in maven. The <diagram> below shows the build process in our project. Maven will pack the code into a WAR file and then by running the [Jetty Maven Plugin](https://www.eclipse.org/jetty/documentation/9.4.x/jetty-maven-plugin.html), we are able to 'deploy' our WAR file into a temporary webserver([Jetty](https://www.eclipse.org/jetty/)). 

> **WAR: Web Application Resource**
> WAR files are a special kind of JAR file that is tailored for the purposes of web service. In short, it is like JAR but for webservers!

With the plugin, we are able to quickly run our webapp without installing a server, by simply running:

```bash
$ mvn jetty:run
```

You should see an output similar to this when it stops. The output below is truncated for clarity.

```
[INFO] --- jetty-maven-plugin:9.4.7.v20170914:run (default-cli) @ software-patterns-example ---
[INFO] Configuring Jetty for project: software-patterns-example Webapp
[INFO] webAppSourceDirectory not set. Trying src/main/webapp
[INFO] Reload Mechanic: automatic
[INFO] nonBlocking:false
[INFO] Classes = /home/Eric_Vader/workspace/cs3219r/target/classes
[INFO] Logging initialized @2499ms to org.eclipse.jetty.util.log.Slf4jLog
[INFO] Context path = /
[INFO] Tmp directory = /home/Eric_Vader/workspace/cs3219r/target/tmp
[INFO] Web defaults = org/eclipse/jetty/webapp/webdefault.xml
[INFO] Web overrides =  none
[INFO] web.xml file = file:///home/Eric_Vader/workspace/cs3219r/src/main/webapp/WEB-INF/web.xml
[INFO] Webapp directory = /home/Eric_Vader/workspace/cs3219r/src/main/webapp
[INFO] jetty-9.4.7.v20170914
[INFO] Scanning elapsed time=83ms
[INFO] DefaultSessionIdManager workerName=node0
[INFO] No SessionScavenger set, using defaults
[INFO] Scavenging every 660000ms
[INFO] Started o.e.j.m.p.JettyWebAppContext@460b6d54{/,file:///home/Eric_Vader/workspace/cs3219r/src/main/webapp/,AVAILABLE}{file:///home/Eric_Vader/workspace/cs3219r/src/main/webapp/}
[INFO] Started ServerConnector@2e388f7b{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
[INFO] Started @3594ms
[INFO] Started Jetty Server
```

You now see that the server has started at `0.0.0.0:8080`, visit [http://0.0.0.0:8080/](http://0.0.0.0:8080/) to view the page! If you can see the page, then congratulations! You have successfully run a webserver!

## Tutorial

We will begin our journey to understand the webapp and also the frameworks that are used! We will go through the webapp as it is built and introduce patterns as we build the webapp. We believe that, it is the most natural way to understand the webapp and the patterns behind the code. At the end of the tutorial, we would have a functioning webapp.

Hence, we will first introduce the architecture of the server, and we will iteratively add more functions to the web app.

### 

## Dependencies

In this section, we will list the dependencies of this project.
