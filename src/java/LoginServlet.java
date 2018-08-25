import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import javax.servlet.http.Cookie;
@WebServlet(urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

     Connection c;
    Statement st;
    
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         try{
             
             String s1 = req.getParameter("txt1");
              String s2 = req.getParameter("txt2");
              Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/petsdatabase",
                    "root", "password");
            //st = c.createStatement();
            
            PreparedStatement pst=c.prepareStatement("select * from userdetails where email=?and password=?");
            
            //ResultSet rs = st.executeQuery("select * from userdetails where email='" + s1 + "'and password='" + s2 + "'");
            //PrintWriter pw=resp.getWriter();
            // pw.println(rs.next());
            //pw.println(rs.getString("verify"));
            // pw.println(rs.getString("email_id"));
            pst.setString(1, s1);
            pst.setString(2,s2);
            ResultSet rs = pst.executeQuery();
            
             if (rs.next()) {
                String v = rs.getString("verified");

                if (v.equals("Y")) {
                  
                      /*resp.sendRedirect("Welcome?name="+
                            rs.getString("username")+
                            "&email="+s1);*/
                       Cookie ck1=new Cookie("username", 
                            rs.getString("username"));
                    Cookie ck2=new Cookie("email",s1);
                    resp.addCookie(ck1);
                    resp.addCookie(ck2);
                     resp.sendRedirect("Welcome1");

                } else {
                    resp.sendRedirect("unverified.html");

                }
            } else {
                resp.sendRedirect("loginfailed.html");
            }
         }
         catch(Exception e){
            System.out.println(e);
         }
   
   }   
    

   

}
