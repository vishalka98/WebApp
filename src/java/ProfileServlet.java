import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import javax.servlet.http.Cookie;
@WebServlet(urlPatterns = {"/Profile1"})
public class ProfileServlet extends HttpServlet {

    public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{ 
     //String s=req.getParameter("name");
        //String e=req.getParameter("email");
        Cookie ck[]=req.getCookies();
        String name="";
        for(Cookie c:ck){
            if(c.getName().equals(
                    "username")){
                name=c.getValue();
                break;
            }
        }
        PrintWriter pw = res.getWriter();
        InetAddress address = InetAddress.getLocalHost();
        String ip = address.getHostAddress();
        String port = req.getServerPort() + "";
  // String s=req.getParameter("name");
   //PrintWriter pw=res.getWriter();
   pw.println("<div class=\"row\">\n" +
"	<div class=\"col-xs-3\" id=\"move\">\n" +
"	<br/>\n" +
"	 \n" +
"	 <img src=\\\"http://\" + ip + \":\" + port + \"/WebApp2/img\" height=200 width=200/>\n" +
"	 <p id=\"name\">Welcome "+name+"</p><br>\n" +
"	 <form name=\"second\" action=\"upload\" method=\"post\" enctype=\"multipart/form-data\">\n" +
"	 <div class=\"form-group\">\n" +
"   <div class=\"input-group\">\n" +
"<span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n" +
"<input type=\"file\" class=\"form-control\" placeholder=\"Select Your Profile\" name=\"txt6\"\n" +
"  />\n" +
"</div><!-- end of input-group -->\n" +
"  </div><!-- end of form-group -->\n" +
"  <div class=\"form-group\">\n" +
"  <input type=\"submit\" value=\"upload\" class=\"btn btn-primary\" >\n" +
"  </div><!-- end of form-group -->\n" +
"	 </form>\n" +
"	 </div>");
}
}
