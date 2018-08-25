
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Desc1"})
public class DescServlet extends HttpServlet {

    public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{ 
   PrintWriter pw=res.getWriter();
   pw.println("<div class=\"col-xs-3 thumbnail\" id=\"shift\">\n" +
"	<p>User Details</p>\n" +
"	<form name=\"third\">\n" +
"	<div class=\"form-group\">\n" +
"	 Name:\n" +
"   <div class=\"input-group\">\n" +
"<span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n" +
"<input type=\"text\" class=\"form-control\" placeholder=\"Enter Your Name\" name=\"txt2\"\n" +
"  />\n" +
"</div><!-- end of input-group -->\n" +
"  </div><!-- end of form-group -->  \n" +
"  <div class=\"form-group\">\n" +
"	 Address:\n" +
"   <div class=\"input-group\">\n" +
"<span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-home\"></i></span>\n" +
"<input type=\"text\" class=\"form-control\" placeholder=\"Enter Your Location\" name=\"txt3\"\n" +
"  />\n" +
"</div><!-- end of input-group -->\n" +
"  </div><!-- end of form-group --> <div class=\"form-group\">\n" +
"	 Contact:\n" +
"   <div class=\"input-group\">\n" +
"<span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-phone\"></i></span>\n" +
"<input type=\"text\" class=\"form-control\" placeholder=\"Enter Your Name\" name=\"txt4\"\n" +
"  />\n" +
"</div><!-- end of input-group -->\n" +
"  </div><!-- end of form-group --> \n" +
"<div class=\"form-group\">\n" +
"	 Image:\n" +
"   <div class=\"input-group\">\n" +
"<span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n" +
"<input type=\"file\" class=\"form-control\" placeholder=\"Upload Your Image\" name=\"txt5\"\n" +
"  />\n" +
"</div><!-- end of input-group -->\n" +
"  </div><!-- end of form-group -->    \n" +
"  <div class=\"form-group\">\n" +
"  <input type=\"submit\" value=\"submit\" class=\"btn btn-primary\" >\n" +
"  </div><!-- end of form-group -->\n" +
"</form>  \n" +
"	</div>\n" +
"	</div>");

}
}
