
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Welcome1"})
public class WelcomServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter pw = res.getWriter();
        pw.println("<html>\n"
                + "<head>\n"
                + "    <meta charset=\"utf-8\" />  \n"
                + "    <link href=\"bootstrap-3.3.7-dist/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\" />\n"
                + "       <link href=\"welcome3.css\" rel=\"stylesheet\" type=\"text/css\" />\n"
                + "	   <script src=\"jquery-3.1.1.js\"></script>\n"
                + "    <script src=\"bootstrap-3.3.7-dist/js/bootstrap.js\"></script>\n"
                + "	<script src=\"function1.js\"></script>\n"
                + "	</head>\n"
                + "	<body>\n"
                + "	<div class=\"container-fluid\">");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Header1");
        rd.include(req, res);
        RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/Profile1");
        rd2.include(req, res);
        RequestDispatcher rd3 = getServletContext().getRequestDispatcher("/Wall1");
        rd3.include(req, res);
        RequestDispatcher rd4 = getServletContext().getRequestDispatcher("/Desc1");
        rd4.include(req, res);
        pw.println("</div>\n"
                + "	</body>\n"
                + "	</html>");

    }
}
