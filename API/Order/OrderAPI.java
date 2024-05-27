package API.Order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(description = "OrderAPI Test", urlPatterns = { "/OrderAPI/" }, initParams = {@WebInitParam(name="id",value="1"),@WebInitParam(name="name",value="ciao")})
public class OrderAPI extends HttpServlet {
    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";

    public OrderAPI() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Date date = new Date();
        out.println(HTML_START + "<h2>prova generazione dati "+date +"</h2>"+HTML_END);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
/*
java.lang.ClassCastException: class java.io.ObjectStreamClass$Caches$1 cannot be cast to class java.util.Map (java.io.ObjectStreamClass$Caches$1 and java.util.Map are in module java.base of loader 'bootstrap')
		at org.apache.catalina.loader.WebappClassLoaderBase.clearCache(WebappClassLoaderBase.java:2342)
		at org.apache.catalina.loader.WebappClassLoaderBase.clearReferencesObjectStreamClassCaches(WebappClassLoaderBase.java:2317)
		at org.apache.catalina.loader.WebappClassLoaderBase.clearReferences(WebappClassLoaderBase.java:1680)
		at org.apache.catalina.loader.WebappClassLoaderBase.stop(WebappClassLoaderBase.java:1610)
		at org.apache.catalina.loader.WebappLoader.stopInternal(WebappLoader.java:455)
		at org.apache.catalina.util.LifecycleBase.stop(LifecycleBase.java:257)
		at org.apache.catalina.core.StandardContext.stopInternal(StandardContext.java:5505)
		at org.apache.catalina.util.LifecycleBase.stop(LifecycleBase.java:257)
		at org.apache.catalina.core.ContainerBase.removeChild(ContainerBase.java:844)
		at org.apache.catalina.startup.HostConfig.unmanageApp(HostConfig.java:1804)
		at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:104)
		at java.base/java.lang.reflect.Method.invoke(Method.java:578)
		at org.apache.tomcat.util.modeler.BaseModelMBean.invoke(BaseModelMBean.java:291)
 */
}
