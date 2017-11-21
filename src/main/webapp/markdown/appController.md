# Application Controller

*A centralied control over screen navigation handling and processing of the application.*

It consists of several parts:

1. Input Controller, in our case is the front controller.
1. Application Controller
1. Domain command
1. View

We will mention this pattern together with front controller. The front controller will handle all incoming request for the web site. It will consolidate all requests by channelling them through the Application Controller.

## Implementation

We implement the pattern as mentioned in the text book. We will use front controller pattern and use front controller in-place of input controller.

<iframe src="uml/appController"></iframe>

* **ApplicationController**: Application controller where FrontController will delegate the running and view to.
* **FrontController**: Handles all of HTTP requests and responses from the user
* **Command**: Domain specific actions seperated out logically into commands
* **AppState**: Consolidation of all state objects into 1 single object as application state
* **AppView**: Application view that handles the viewing of the state

### How it works?

Firstly the front controller will handle all of the calls made to the web application. The front controller will deal with the HTTP post and get requests from the web serber. It will processes the request and hides the complexity of the HTTP handling from any of the other classes. In our implementation we will assume that the front controller will be handling dynamic web requests, where the user will be able to change the view of the web application by issuing HTTP requests. These requests will be translated by front controller to commands by delegating to the application controller.

The application controller will manage the commands and the view. The application controller will consolidate all the business logic to be done in one place, it will perform all the flow logic. The input controller will only translate the HTTP requests to some interface that the application controller understands. The application controller will decide the appropriate commands for execution against which model, depending on the request. The application controller must decide which domain logic to run and the view to use to display.

### When to use it?

When the flow and navigation is dynamic, the user can perform a number of actions on the model and they can affect the view in many ways. If the flow and navigation is simple and static, the appropriate pattern to use is page controller, not application controller. The benefit of using application controller when there is a particular page ordering and complicated processing of the views based on some rules or state of the objects.

We can use this pattern when page controller is no longer sufficient to implement the web application, which much code duplicated. Application controller + front controller will allow much of the code across pages to be shared. However, we note that there is a price to pay. Since all of the requests will go through the front controller, there is a performance tradeoff. However, we also note that if the web application is properly configured, then the performance dedegration will be managable.

## Real Application

Similar to page controller, it is heavily used in web frameworks:

1. Apache Struts
1. ASP.Net
1. Drupal
1. Yesod web framework

We also note that we can implement this pattern using page controller without problems.

## References

1. Patterns Of Enterprise Application Architecture: 
	1. Front Controller: Page 344
	1. Application Controller: Page 379
1. Martin Fowlder:
	1. [Front Controller](https://martinfowler.com/eaaCatalog/frontController.html)
	1. [Application Controller](https://martinfowler.com/eaaCatalog/applicationController.html)

