# Page Controller

*Page controller pattern allows us to logically seperate every request for a specific page or action on a website.*

It consists of 3 parts:

1. Page Controller: Controls the request and also the response, processes the business logic
1. Model: Type of object that will be served
1. View: How the object will be served

We also note that this is also an implementation of the MVC pattern, in the context of pages.

## Implementation 

We have used this pattern in the uml diagram generation part of the web application. When one request for a uml diagram, like when [http://0.0.0.0:8080/uml/pageController](http://0.0.0.0:8080/uml/pageController) is requested, then the page request will be sent to the appropriate page controller that handles the particular path. In our example the path is `/uml`.

<iframe src="uml/pageController"></iframe>

* **UmlController**: Recieves the request for the particular type of diagram and invokes other components to display the UML diagram.
* **Uml**: The UML diagram to be served, ie. the model to be served to the user.
* **UmlHtmlView**: Specifies the view that will be served to the user, internally using template view.

### How it works?

Every page will have a module on the web server and each of them will handle the request/response for that particular resource. Your web application may have dynamic information and the views may not map one to one with the page controllers. Hence, we can say that every page controller will be tied to every action that the user performs. The basic responsibility of the page controller are:

1. Extract any information from the HTTP request
1. Invoke any model objects or any relevant business logic to process the request
1. Determine the view and send the HTTP response

### When to use it?

We can use this pattern when actions are logically separable and they can be handled seperate from the rest of the actions. This method can potentially scale as each action is handled by only 1 page controller, especially when the processing done is simple. We contrast this pattern to front controller which adds a lot of overhead as all the request will come to the front controller first before delegated to other classes.

We can use this pattern when we are building any graphical application(also web application) where the application is logically divided into pages.

## Real Application

This pattern is very popular in web frameworks:

1. JavaServer Pages
1. AngularJs
1. PHP

This pattern is also used in desktop/mobile applications:

1. [Apple iOS](https://developer.apple.com/library/content/documentation/WindowsViews/Conceptual/ViewControllerCatalog/Chapters/PageViewControllers.html)

## References

1. Patterns Of Enterprise Application Architecture: Page 333
1. [Martin Fowler](https://martinfowler.com/eaaCatalog/pageController.html)
