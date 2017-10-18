package sg.edu.nus.comp.cs3219r;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
  
  private static ClassLoader classLoader = ClassLoader.getSystemClassLoader();
  private static String appDir = System.getProperty("user.dir");
  
  public static String resourcesDir = "/src/main/resources/";
  
  // The types of resources avaliable
  public static String markdownBasePath = "markdown/";
  public static String templatesBasePath = "templates/";
  public static String umlBasePath = "uml/";
  
  // Extension types
  public static String templateExtension = ".html";
  public static String umlExtension = ".json";
  
  /**
   * Converts a resource to its contents, return as string.
   * @param resourceBasePath
   * @param fileName
   * @return
   * @throws IOException
   */
  public static String resourceToString(String resourceBasePath, String fileName) throws IOException {
    return new String(Files.readAllBytes(Paths.get(sysGetResource(resourceBasePath + fileName).getPath())));
  }

  public static String getResourcePath(String resourceBasePath) {
    return resourcesDir + resourceBasePath;
  }
  
  public static String getAbsResourcePath(String resourceBasePath) {
    return appDir + Utils.getResourcePath(resourceBasePath);
  }
  
  public static URL sysGetResource(String resourcePath) throws MalformedURLException {
    return ListenerServlet.context.getResource("/" + resourcePath);
  }
  
}
