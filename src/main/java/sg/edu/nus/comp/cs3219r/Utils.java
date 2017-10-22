package sg.edu.nus.comp.cs3219r;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.comp.cs3219r.diagram.Diagram;
import sg.edu.nus.comp.cs3219r.diagram.Link;
import sg.edu.nus.comp.cs3219r.diagram.Method;
import sg.edu.nus.comp.cs3219r.diagram.Node;
import sg.edu.nus.comp.cs3219r.diagram.Parameter;
import sg.edu.nus.comp.cs3219r.diagram.Property;
import sg.edu.nus.comp.cs3219r.diagram.Relationship;
import sg.edu.nus.comp.cs3219r.diagram.Visibility;
import sg.edu.nus.comp.cs3219r.pageController.Uml;
import sg.edu.nus.comp.cs3219r.pageController.UmlController;
import sg.edu.nus.comp.cs3219r.pageController.UmlHtmlView;
import sg.edu.nus.comp.cs3219r.transform.HtmlTransformer;
import sg.edu.nus.comp.cs3219r.transform.RegisterData;

public class Utils {

  private static boolean isWebapp = false;
  private static ClassLoader classLoader = ClassLoader.getSystemClassLoader();

  private static String appDir = System.getProperty("user.dir");

  public static String resourcesDir = "/src/main/webapp/";

  // The types of resources avaliable
  public static String markdownBasePath = "markdown/";
  public static String templatesBasePath = "templates/";
  public static String umlBasePath = "uml/";

  // Extension types
  public static String templateExtension = ".html";
  public static String htmlExtension = ".html";
  public static String markdownExtension = ".md";
  public static String umlExtension = ".json";

  /**
   * Converts a resource to its contents, return as string.
   * 
   * @param resourceBasePath
   * @param fileName
   * @return
   * @throws IOException
   */
  public static String resourceToString(String resourceBasePath,
      String fileName) throws IOException {
    return new String(Files.readAllBytes(
        Paths.get(sysGetResource(resourceBasePath + fileName).getPath())));
  }

  public static String getResourcePath(String resourceBasePath) {
    return resourcesDir + resourceBasePath;
  }

  public static String getAbsResourcePath(String resourceBasePath) {
    return appDir + Utils.getResourcePath(resourceBasePath);
  }

  public static URL sysGetResource(String resourcePath)
      throws MalformedURLException {
    if (Utils.isWebapp) {
      return ListenerServlet.context.getResource("/" + resourcePath);
    } else {
      return Paths.get(Utils.getAbsResourcePath(resourcePath)).toUri().toURL();
    }
  }

  public static void setWebapp(boolean isWebapp) {
    Utils.isWebapp = isWebapp;
  }

  private static List<Class<?>> getAllClassesInPackageContaining(Class<?> clazz)
      throws IOException {

    String clazzPackageName = clazz.getPackage().getName();

    String clazzPath = clazz.getResource(".").getPath();
    Path packagePath = Paths.get(clazzPath).getParent();

    final List<Class<?>> packageClasses = new ArrayList<>();

    Files.walkFileTree(packagePath, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
          throws IOException {
        String filename = file.getName(file.getNameCount() - 1).toString();

        if (filename.endsWith(".class")) {
          String className = filename.replace(".class", "");

          try {
            Class<?> loadedClazz =
                Class.forName(clazzPackageName + "." + className);

            packageClasses.add(loadedClazz);
          } catch (ClassNotFoundException e) {
            // System.err.println("class not found: " + e.getMessage());
          }
        }

        return super.visitFile(file, attrs);
      }
    });

    return packageClasses;
  }

  public static void init() {

    try {
      List<Class<?>> packageClasses =
          getAllClassesInPackageContaining(HtmlTransformer.class);

      // List<RunAtStartupData> registrations = new ArrayList<>();

      for (Class<?> clazz : packageClasses) {
        RegisterData register = clazz.getAnnotation(RegisterData.class);
        if (register == null)
          continue;

        HtmlTransformer.register(register.clazz(), clazz);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public static List<AppDesignPlane> listAppViews() {
    List<AppDesignPlane> l = new ArrayList<>();
    l.add(new AppDesignPlane("pageController", Uml.class, UmlController.class,
        UmlHtmlView.class));
    l.add(new AppDesignPlane("uml", Diagram.class, Link.class, Method.class,
        Node.class, Parameter.class, Property.class, Relationship.class,
        Visibility.class));
    return l;
  }

}
