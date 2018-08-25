import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/upload"})
public class UploadServlet extends HttpServlet 
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    { 
        try{
       int totalBytes=req.getContentLength();
       InputStream in=req.getInputStream();
      // System.out.println(totalBytes);
       byte b[]=new byte[totalBytes];
       int readBytes=0,bytes;
       while(readBytes<totalBytes){
           bytes=in.read(b, readBytes, totalBytes);
           readBytes+=bytes;
       }
       String file=new String(b);
       System.out.println(file);
       int pos=file.indexOf("filename=\"")+10;
       pos=file.indexOf("\n",pos)+1;
       pos=file.indexOf("\n",pos)+1;
       pos=file.indexOf("\n",pos)+1;
       String s=req.getContentType();
       int bl=s.lastIndexOf("=")+1;
       String boundry=s.substring(bl);
       int end=file.lastIndexOf(boundry)-4;
        Cookie ck[]=req.getCookies();
        String email="";
        for(Cookie c:ck){
            if(c.getName().equals("email")){
                email=c.getValue();
            }
        }
        System.out.print(email);
       Class.forName("com.mysql.jdbc.Driver");
       Connection c=DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/petsdatabase"
               ,"root","password");
       PreparedStatement pst=c.prepareStatement(
      "update userdetails set userimage=? where email=?");
       ByteArrayInputStream bin=new ByteArrayInputStream(b, pos, end-pos);
       pst.setBinaryStream(1, bin);
       pst.setString(2, email);
       pst.executeUpdate();
       pst.close();
       c.close();
       resp.sendRedirect("Welcome1");
       
       
       //FileOutputStream fout=new FileOutputStream(getServletContext().getRealPath("/")+"demo.png");
       //fout.write(b, pos, end-pos);
       //fout.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }  
}
