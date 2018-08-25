
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/img"})
public class ImageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Cookie ck[]=req.getCookies();
            String email="";
            for(Cookie c1:ck)
            {
                if(c1.getName().equals("email")){
                    email=c1.getValue();
                    break;
                }
            }
            //String email = req.getParameter("email");
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/petsdatabase", "root", "password");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(
                    "select userimage from userdetails where email='"
                    + email + "'");
            if (rs.next()) {
                InputStream in = rs.getBinaryStream(1);
                BufferedImage img = ImageIO.read(in);
                ImageIO.write(img, "PNG",
                        resp.getOutputStream());
            }
            rs.close();
            st.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
