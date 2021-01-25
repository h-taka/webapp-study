package webapp.study.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.study.bean.user.UserRecordBean;
import webapp.study.dao.UserDao;

@WebServlet("/user/deleteresult")
public class UserDeleteResultServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            UserRecordBean record = new UserRecordBean();
            record.setId(id);
            record.setName(name);
            record.setEmail(email);

            UserDao dao = new UserDao();
            int result = dao.deleteUserInfo(id);
            if(result == 1) {
                request.setAttribute("userrecord", record);
                getServletContext().getRequestDispatcher("/view/user/userdeleteresult.jsp").forward(request, response);
            } else {
                request.setAttribute("errormessage", name + "を削除できませんでした。");
                getServletContext().getRequestDispatcher("/view/common/error.jsp").forward(request, response);
            }
        } catch(Exception e){
            e.printStackTrace();
            request.setAttribute("errormessage", e.getMessage());
            getServletContext().getRequestDispatcher("/view/common/error.jsp").forward(request, response);
        }
    }
}
