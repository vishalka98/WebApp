

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Header1"})
public class HeaderSevlet extends HttpServlet {
    
    public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{ 
   PrintWriter pw=res.getWriter();
   pw.println("<div class=\"row thumbnail\">\n" +
"	<div class=\"col-xs-5\">\n" +
"	<p class=\"my\"> Welcome To MyPetShop!</p></div>\n" +
"	<br/>	<div class=\"col-xs-4\"><form name=\"first\" class=\"form-horizontal\"><div class=\"form-group\">\n" +
"   <div class=\"input-group\">\n" +
"<span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-search\"></i></span>\n" +
"<input type=\"text\" class=\"form-control\" placeholder=\"Search Here\" name=\"txt1\"\n" +
" />\n" +
"</div><!-- end of input-group --> \n" +
"  <input type=\"submit\" value=\"submit\" class=\"btn btn-primary\"  id=\"move3\">\n" +
"  </div><!-- end of form-group -->      \n" +
"	</form>\n" +
"	</div><div class=\"col-xs-1\"></div>\n" +
"	<div class=\"col-xs-2\">\n" +
"	<i class=\"glyphicon glyphicon-envelope\"></i>\n" +
"	&nbsp;&nbsp;<a href=\"\">Notifications</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;\n" +
"	<a href=\"login.html\">Logout</a>\n" +
"	</div>\n" +
"</div>\n" +
"	<hr/>");
}  
}

