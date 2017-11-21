# Transform View

*Transforms domain models into html directly*

This pattern is very simple, there are only 2 actors:

1. Model, provides for the domain specific data
1. Transformer, the code that performs the transformation

## Implementation 

We note that we will aid the template view by producing the html for the cmd directory in a transform view fashion. We have created a hierachy for the items that needs to be transformed. For instance, CmdDir is the navigation bar and it will contain CmdOption objects for which it will use to transform children as it does not know the underlying implementation of the children. In this manner, we design the transform view pattern to be very configurable and managable. Each model that can be transformed will have a transformer, instead of the design presented in Martin Fowler's book. The rationale is that we can have seperation of concerns of the different models. The transformer will be registered to the models by the `RegisterData` interface by tags.

In the UML diagram below, we will omit all the model classes, we will only display the transformers. We also make a note that one transformer can be used to transform several similar objects.

<iframe src="uml/transform"></iframe>

* **HtmlTransformer**: The base class for all transformers that consolidate all the common transformer functions
	* **CmdDirTransformer**: The navigation bar, that shows the commands for the web application
	* **CommandParamTransformer**: Command with parameters, will need to have a drop down to show the options
	* **CommandTransformer**: Command without parameters, just a static element on the nav bar
	* **LoginCommandTransformer**: Login command with a login box to key in the name
* **RegisterData**: Enum for each of the model to register their data with the transformer

### How it works?

This pattern is data-centric. It looks at the domain data and converts it into html. The base render will look at all of its child objects and determine how to produce the html output. Comparing this pattern to template view, one will see that it is organized around the transform and the data. This pattern is a very functional way to look at the data.

### When to use it?

This pattern can be used in partnership with the template view where the template view can either transform view like how we had implemented or the other way around. This gives us complete flexibility in designing our web application. This pattern is appropriate to be used when transformers can be layered to perform multiple transformations ontop of the model. The transformations can then be layered for different application requirements.

## Real Application

There are several examples of this pattern in use and one prominent example is:

1. eXtensible Stylesheet Language(XSLT)

## References

1. Patterns Of Enterprise Application Architecture: Page 361
1. [Martin Fowler](https://martinfowler.com/eaaCatalog/transformView.html)
1. Pattern-Oriented Software Architecture: page 335
