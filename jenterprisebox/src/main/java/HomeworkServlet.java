import org.slf4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;

import static org.slf4j.LoggerFactory.*;

@WebServlet(name="homework-servlet", urlPatterns = "/homework")
public class HomeworkServlet extends HttpServlet {
    ConcurrentHashMap <String, String> remoteHost=new ConcurrentHashMap<>();
    private static final Logger log = getLogger(HomeworkServlet.class);

    @Override
    public void init() {
        log.info("Homework servlet initialized");
    }

   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       PrintWriter responseBody = resp.getWriter();
       String header= "User-Agent";
       remoteHost.put( req.getRemoteHost(),req.getHeader(header));
        resp.setContentType("text/html");
        responseBody.println("<h1 align=\"center\">Homework Servlet </h1>");
        responseBody.println("<h3 align=\"center\"> Request from:" +" </h3>");
          responseBody.println(remoteHost.entrySet());
       }

    @Override
    public void destroy() {
        log.info("Homework Servlet destroyed");
    }
}
