
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/verify1"})
public class VerefyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String e = req.getParameter("email");
            PrintWriter pw  = resp.getWriter();
            pw.print(e);
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/petsdatabase",
                    "root", "password");
            Statement st = c.createStatement();
           st.executeUpdate(
             "update userdetails set verified='Y' where tempid='" + e + "'");
            st.close();
            c.close();
            resp.sendRedirect("verified.html");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
