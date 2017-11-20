# Welcome to CS3219's Patterns Demostration! 

In this demo, we will demostrate the following patterns, by building a web application framework from scratch:

1. Application Controller
1. Command Pattern
1. Page Controller
1. Template View
1. Transformer

We have used the aforementioned patterns in our implementation of this web application framework. In addition, to make learning interactive we have designed a tutorial using our web application fraomework and used the web application to document itself!

The tutorial web application consists of several pages. The first page is the home page and it will give a high level documentation of the design of our framework. In the subsequent pages, we will document each of the pattern(s) in the subsequent pages. In each of the pages, we will discuss the pattern, any relevant historical notes about the pattern, show and discuss our implementation(with UML diagram), some real life application that uses the pattern and lastly any textbook references to the pattern.

## ReadMe

In this section, we will provide some details on how to execute our web application:

1. Ensure that all the required dependencies(Java and Maven) are installed on your machine
1. Navigate to the web application's root directory and simply execute `mvn jetty:run`. Maven will download all the required software dependencies and start the web application using Jetty as the web server.
1. Navigate to [http://0.0.0.0:8080/](http://0.0.0.0:8080/) and you should see the home page!

### Software Dependencies

Please ensure that the following is installed on your machine:

1. Maven 3.3.9
1. Java/Javac OpenJDK 1.8.0_151

#### Maven Dependencies

Our program is managed by Maven. It is a software dependency tool that allows us to easily manage our software dependencies. The maven dependencies(compile) and their corresponding versions(`$ mvn dependency:tree`) are listed below, they are accurate at the time of writing. We have included `junit` for the purpose of unit testing, however there are no test cases at the time of writing. The `javax.servlet` is a J2EE library that will be provided by the web server and it is not shipped with the war file. The `gson` library is used to marshall and unmarshall json objects, we will use that in the UML generation task, we will discuss more below. Lastly, we have chosen `commonmark` to convert markdown to html.

```bash
[INFO] sg.edu.nus.comp.cs3219r:software-patterns-example:war:0.0
[INFO] +- junit:junit:jar:3.8.1:test
[INFO] +- javax.servlet:javax.servlet-api:jar:3.1.0:provided
[INFO] +- com.google.code.gson:gson:jar:2.8.2:compile
[INFO] \- com.atlassian.commonmark:commonmark:jar:0.10.0:compile
```

#### Web Server Dependencies
We have chosen to use Jetty to be the web server to run the web application, as specified in our `pom.xml`. The web application should still run fine using any other web server that follows the JavaEE 3.0 Specifications as we did not rely on any Jetty specific libraries. We chose Jetty as it is convenient, allowing us to start our web application using maven directly.

```xml
<plugin>
	<groupId>org.eclipse.jetty</groupId>
	<artifactId>jetty-maven-plugin</artifactId>
	<version>${jettyVersion}</version>
	<configuration>
		<scanIntervalSeconds>2</scanIntervalSeconds>
	</configuration>
</plugin>
```

#### Frontend Dependencies

We have used several Html/Javascript/Css libraries to hasten development. These dependencies are common and are widely used in the industry. We have used the following:

1. Bootstrap: Used UI elements and CSS wireframe
	1. jquery
1. Go.js: Javascipt charting framework to draw the UML diagrams
	1. popper.js

The dependencies are already packaged into the web application and there is no need to install them.

## Web Application Architecture

In our framework and tutorial application, we have 3 independent parts as shown below. We can implement a web application using 2 different mechanisms, either page controller or application controller. In our implementation, page controller is used primariliy for resources that does not have state. application controller is used for applications that will require state management.

1. Standalone:
	1. UML Generator - Generates the UML diagram from code.
1. Web Applications:
	1. UML App - Shows the UML diagrams
	1. Tutorial App - Self-documenting the patterns used
	
### UML Generator

The code related to this component is located in the package `sg.edu.nus.comp.cs3219r.diagram`. We have designed a framework to read Java source code using Java Generics to produce UML diagrams. The motivation for this is that we want the web application to be a self-documenting tool for learning patterns. With that in mind, we want to allow users to modify code(pokeing around some patterns) and observe the effects of the code. We have designed the generation to be recursive and in levels:

1. `Diagram.java`: Starting point to parse a bunch of classes.
1. `Node.java`: Representing a class.
	1. `Method.java`: Generate the UML's methods
	1. `Parameter.java`: 
	1. `Property.java`
	1. `Visibility.java`
1. `Link.java`: Representing class relationship.
	1. `Relationship.java`

Utils.java DiagramDirectory.java

## Web Application Structure

The web application framework is built ontop of JavaEE version 3.0. In this section, we will discuss how our web application is organized. Our framework is JavaEE 3.0 compliant, so the folder structure will follow JavaEE specifications. In addition, we used maven to manage our dependencies and we will also follow the Maven conventions for folder sturcture. The web application is found at the path `/src/main/webapp`. We have adopted a typical web application structure:

1. `css`: Stores all the web application's CSS files
1. `js`: Stores all the JS files
1. `markdown`: Markdown files, each file signify a page
1. `templates`: Templates for the webapplication
1. `uml`: Statically generated uml json
1. `WEB-INF`: J2EE specifications

```bash
.
├── css
│   ├── app.css
│   ├── bootstrap.css
│   ├── ...
│   └── bootstrap-reboot.min.css.map
├── js
│   ├── bootstrap.bundle.js
│   ├── ...
│   ├── bootstrap.min.js.map
│   ├── go-debug.d.ts
│   ├── ...
│   ├── go.js
│   ├── jquery-slim.min.js
│   └── popper.min.js
├── markdown
│   ├── appController.md
│   ├── ...
│   └── transform.md
├── templates
│   ├── tutorial.html
│   └── uml.html
├── uml
│   ├── pageController.json
│   ├── ...
│   └── uml.json
└── WEB-INF
    └── web.xml
```

## Code Structure

## Further Work
