
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.*;
import java.net.*;

@WebServlet(urlPatterns = {"/signup5"})
public class sigservlet extends HttpServlet {

       Connection c;
      Statement st;
       String port1; 
       String ip;
     @Override
    protected void service(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
          port1 = req.getServerPort()+"";   
 try{
          
     
            String s1 = req.getParameter("txt1");
            String s2 = req.getParameter("txt2");
            String s3 = req.getParameter("txt3");
            String s4 = req.getParameter("txt4");
            String s5 = req.getParameter("txt5");
         //   Connection con = null;
         
          String tempid=getTempid();
          
           Class.forName("com.mysql.jdbc.Driver");
              c= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/petsdatabase",
                    "root", "password");
             c.setAutoCommit(false);
            st = c.createStatement();
             String path=getServletContext().getRealPath("/");
            path=path.replace("\\","\\\\");
          // System.out.println(path);
            st.executeUpdate(
                    "insert into userdetails values('" 
                    + s1 + "','" + s2 + "','" + s3
                    + "','" +s4 +"','" + s5 + "','N','"+tempid+"',LOAD_FILE('\"+path+\"\\\\female.png'))");
            
           boolean b = sendMail(s2,tempid);
           //PrintWriter pw = resp.getWriter();
            //pw.println(b); 
             //pw.println("jviviugvi");
            if (b) {
               resp.sendRedirect("success.html");
        } else {
                resp.sendRedirect("failure.html");
            //}
              st.close();
                c.close();
            
   }
 }
    catch (Exception e){
         System.out.println(e);
         // System.out.println(s1);
         //resp.sendRedirect("failure.html");
    }    
    }
    public String getTempid()
    {
        String res="";
        String req="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrestuvwxyz0123456789";
        int len=req.length();
        for(int i=1;i<=20;i++)
        {
           int index=(int)(len*Math.random());
           char ch=req.charAt(index);
           res+=ch;
        }
        return res;
    }
    
    
   public boolean sendMail(String email,String tempid) {
        try {
            
             InetAddress add  = InetAddress.getLocalHost();
           ip = add.getHostAddress();
            
            String host = "smtp.gmail.com";
            String user = "ankuglassfish7070";
            String pass = "ankit@123";
            String port = "465";
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", user);
            props.put("mail.smtp.password", pass);
            props.put("mail.smtp.port", port);
            props.put("mail.smtps.auth", true);
            Session ses = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(ses);
            message.setSubject("Confirmation Mail From Pet Kharido Becho Team");
            message.setFrom(new InternetAddress("ankuglassfish7070@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
           // message.setContent("Dear Sir/Ma'am,<br><br>Greetings from Kharido Becho Team!!!!<br><br><br>Please click on or copy paste below link to verify yourself and sell or purchase almost every pets on portal<br>http://localhost:8080/WebApp2/verify1?email="+email+"<br><br>Warms Regards, <br> Kharido Becho Team", "text/html");
          
        
        
         

           
           message.setContent("Dear Sir/Ma'am,<br><br>Greetings from Kharido Becho Team!!!!<br><br><br>Please click on or copy paste below link to verify yourself and sell or purchase almost every pets on portal<br>http://"+ip+":"+port1+"/WebApp2/verify1?email="+tempid+"<br><br>Warms Regards, <br> Kharido Becho Team", "text/html");
            Transport trans = ses.getTransport("smtps");
            trans.connect(host, user, pass);
            trans.sendMessage(message,
                    message.getAllRecipients());
            c.commit();
            st.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
            
            
            
            
            
            
            try {
                c.rollback();
                st.close();
                c.close();
            } catch (Exception e1) {
            }
            return false;
            
        }
        return true;
    }
 
}

