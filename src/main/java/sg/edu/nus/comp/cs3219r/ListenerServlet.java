package sg.edu.nus.comp.cs3219r;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerServlet implements ServletContextListener {

    public static ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        Utils.setWebapp(true);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context = null;
    }

}