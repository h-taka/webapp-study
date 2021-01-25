package webapp.study.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.study.bean.user.UserRecordBean;
import webapp.study.dao.UserDao;

@WebServlet("/user/deleteform")
public class UserDeleteFormServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            UserDao dao = new UserDao();
            UserRecordBean record = dao.getUserRecordBean(id);
            request.setAttribute("userrecord", record);
            getServletContext().getRequestDispatcher("/view/user/userdeleteform.jsp").forward(request, response);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

