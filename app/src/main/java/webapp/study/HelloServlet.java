// HelloServlet.java
package webapp.study;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloform")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ハロー　サーブレット</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>ハロー　サーブレット!</h1>");
        out.println("<p>Input your Name.</p>");
        out.println("<form metod=\"POST\" action=\"helloform\">");
        out.println("<Input type=\"text\" name=\"name\" />");
        out.println("<Input type=\"submit\" name=\"送信\" />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ハロー　サーブレット</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>ハロー　サーブレット!</h1>");
        out.println("<p>Hello! " + name +  "</p>");
        out.println("</body>");
        out.println("</html>");

    }
}