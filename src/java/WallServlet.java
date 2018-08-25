

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Wall1"})
public class WallServlet extends HttpServlet {

public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{ 
   PrintWriter pw=res.getWriter();
   pw.println("<div class=\"col-xs-5\" id=\"move2\">\n" +
"	<nav class=\"navbar-default\">\n" +
"\n" +
"                    <div class=\"navbar-header\">\n" +
"                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#my\">\n" +
"                            <span class=\"icon-bar\"></span>\n" +
"                            <span class=\"icon-bar\"></span>\n" +
"                            <span class=\"icon-bar\"></span>\n" +
"                        </button>\n" +
"                    </div>\n" +
"					<div class=\" collapse navbar-collapse\" id=\"my\">\n" +
"                        <ul class=\" nav navbar-nav\">\n" +
"                            <li class=\"dropdown\">\n" +
"                                <a href=\"Welcome\">&nbsp;&nbsp;&nbsp;&nbsp;Home</a></li><li class=\"dropdown\">\n" +
"                                <a href=\"#\" class=\"dropdown-toggle\"\n" +
"                                   data-toggle=\"dropdown\">Pets Category</a>\n" +
"                                <ul class=\"dropdown-menu\">\n" +
"                                    <li><a href=\"#\">Dogs</a></li>\n" +
"                                    <li><a href=\"#\">Rabbits</a></li>\n" +
"                                    <li><a href=\"#\">Mice</a></li>\n" +
"                                    <li><a href=\"#\">Cats</a></li>\n" +
"                                    <li><a href=\"#\">parrots</a></li>\n" +
"                                    <li><a href=\"#\">fish</a></li>\n" +
"\n" +
"                                </ul>\n" +
"                            </li>\n" +
"							<li class=\"dropdown\">\n" +
"                                <a href=\"contact.html\">Contact</a></li>\n" +
"								   <li class=\"dropdown\">\n" +
"                                <a href=\"direction.html\">Direction</a></li>\n" +
"								   </ul></div>\n" +
"\n" +
"                </nav>\n" +
"				<div class=\"row thumbnail\">\n" +
"				<div class=\"col-xs-4\"><br/>\n" +
"				<div class=\"thumbnail\">\n" +
"\n" +
"                    <img src=\"img/lab.jpg\" id=\"zoom\" />\n" +
"					</div>\n" +
"				<div class=\"thumbnail\">	\n" +
"<img src=\"img/dog2.jpg\" id=\"zoom\" />\n" +
"                </div>\n" +
"                \n" +
"                    </div>\n" +
"					<div class=\"col-xs-1\"></div>\n" +
"				<div class=\"col-xs-5\">\n" +
"				<br><br><p id=\"f2\">Name: Labroder Retriever<br>\n" +
"Size: Medium<br>\n" +
"Type: Purebred<br>\n" +
"Life Span: 10 to 12 years<br>\n" +
"Price : 1000$<br><br>\n" +
"<p id=\"f2\">Name: French Bulldog<br>Size: Small<br>\n" +
"Type: Purebred<br>\n" +
"Life Span: 10 to 12 years<br>\n" +
"Price : 2000$\n" +
"				</div>\n" +
"				</div>\n" +
"           \n" +
"	</div>\n" +
"	<br><br><br>");

}
}
