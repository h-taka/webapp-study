package webapp.study.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.study.bean.user.UserRecordBean;
import webapp.study.dao.UserDao;

@WebServlet("/user/entryresult")
public class UserEntryResultServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            UserRecordBean record = new UserRecordBean();
            record.setName(name);
            record.setEmail(email);

            if(!record.checkValue()){
                request.setAttribute("userrecord", record);
                request.setAttribute("errormessages", record.getErrorMessages());
                getServletContext().getRequestDispatcher("/view/user/userentryform.jsp").forward(request, response);
                return;
            }
            
            UserDao dao = new UserDao();
            int result = dao.addUserInfo(record);
            if(result == 1) {
                request.setAttribute("userrecord", record);
                getServletContext().getRequestDispatcher("/view/user/userentryresult.jsp").forward(request, response);
            } else {
                request.setAttribute("errormessage", name + "を登録できませんでした。");
                getServletContext().getRequestDispatcher("/view/common/error.jsp").forward(request, response);
            }
        } catch(Exception e){
            e.printStackTrace();
            request.setAttribute("errormessage", e.getMessage());
            getServletContext().getRequestDispatcher("/view/common/error.jsp").forward(request, response);
        }
    }
}