# Command Pattern

*Command Pattern distinguishes a request from its execution. It models user actions as command objects, allowing the execution to be performed logically in an executor and the request handling to done seperately.*

The pattern consists of:

1. Controller for the main flow
1. Abstract Command so that the request handling and execution can be performed with information hiding, the details of specific commands are hidden
1. Derived Commands, each of the specific commands
1. Supplier, to fulfill the actions of the command

## Implementation 

We implement the pattern to handle user requests, coded as HTTP requests to the web server.

<iframe src="uml/command"></iframe>

* **Command**: The abstract command class that all the other commands will inherit from, provides some common functionalities
	* **GotoCommand**: Do not follow the tutorial sequence, but allows the user to skip over certain tutorial pages, to the page that he/she wants to go.
	* **LoginCommand**: Allows the user to login.
	* **LogoutCommand**: Allows the user to logout.
	* **NextCommand**: Go on to the next tutorial page.
	* **PrevCommand**: Go back to the previous tutorial page.
* **ApplicationController**: Application Controller is the object that is controlling and provide the flow of the application.

### How it works?

We seperate the logic that performs the actions, implementing the logic in the derived command classes. In our implementation, the code performing the actions are stored in: GotoCommand, ..., PrevCommand. The controller will not interact with any of the derived commands, but interact only on the abstract interface provided by the Command super class. It encapsulates the function request. In this manner, we can easily implement undo and redo using the momento pattern. Moreover, we can easily log user's actions by implementing the logging functions in the Command class.

### When to use it?

This pattern is appropriate when there are many user actions and the problem does not require a predefined execution flow. The command pattern allows the application to not follow a pre-defined execution flow and hence does not restrict how users work and interact with the application. In addition, for applications that will have enhancements, developers can easily extend the functionality of the program by creating more derived commands and using the abstract interace to perform aggregate actions on all of the commands. This allows the application to be very extensible.

## Real Application

There are countless applications for the command pattern, we will present some of them:

1. GUI, the buttons and menus will trigger commands
1. Web application, as demostrated in this application
1. Parallel processing, each task is encapsulated as command and meted out to each process
1. Networking, each action performed by the user is a command

There are many possible applications and it is easy to dream up some applications that use this pattern.

## References

1. Pattern-Oriented Software Architecture: page 277

