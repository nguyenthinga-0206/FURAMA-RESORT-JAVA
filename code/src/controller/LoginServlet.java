package controller;

import model.Diachi;
import model.Khachhang;
import model.Loaikhach;
import model.User;
import service.UserService;
import service.UserServicelmpl;
import service.Vaitro_usrerService;
import service.Vaitro_usrerServicelmpl;
import sun.font.DelegatingShape;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserServicelmpl();
    private Vaitro_usrerService vaitro_usrerService = new Vaitro_usrerServicelmpl();
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null)
        {
            action="";
        }
        switch (action)
        {
            case "create":
                CreateUser(request,response);
                break;
        }

        HttpSession session = request.getSession();
        String ten = request.getParameter("ten");
        String matkhau = request.getParameter("matkhau");
        String message = "Sai ten hoặc mật khẩu ";
        System.out.println("ten" +ten);
        System.out.println(session);
        System.out.println("co" + service.finByName(ten,matkhau));
        if (service.finByName(ten,matkhau)) {
            session.setAttribute("ten", ten);
            session.setAttribute("matkhau", matkhau);
             if(vaitro_usrerService.finBygiamdoc(ten))
            {
                System.out.println("quyennv" +  vaitro_usrerService.finBygiamdoc(ten));

              session.setAttribute("quyen", "Giám đốc");
            }
         else    if(vaitro_usrerService.finBynv(ten))
            {
                System.out.println("quyennv" +  vaitro_usrerService.finBynv(ten));
                session.setAttribute("quyen", "Quản lý nhân viên");
            }
             else    if(vaitro_usrerService.finBykh(ten))
            {
                System.out.println("quyen" +  vaitro_usrerService.finBykh(ten));
                session.setAttribute("quyen", "Quản lý khách hàng");
            }
             else   if(vaitro_usrerService.finBydv(ten))
            {
                session.setAttribute("quyen", "Quản lý dịch vụ");
            }
             else if(vaitro_usrerService.finByhd(ten))
            {
                session.setAttribute("quyen", "Quản lý hợp đồng");
            }
            else if(vaitro_usrerService.finByXem(ten))
            {
                System.out.println("xem xem " +vaitro_usrerService.finByXem(ten));
                session.setAttribute("quyen", "Bạn chỉ có quyền xem");
            }

// tạo Cookie lưu mk
//            Cookie cookie = new Cookie("ten",ten);
//            cookie.setMaxAge(30); //thời gian sống cua cookie là 30s
//            response.addCookie(cookie);

            RequestDispatcher dispatcher = request.getRequestDispatcher("trangchu.jsp");
            dispatcher.forward(request, response);
        }
        else {
            session.setAttribute("message", "Bạn đã nhập sai tên hoặc mật khẩu!");
            response.sendRedirect(request.getContextPath() + "/index.jsp?error=0");

        }
    }

    private void CreateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten_user =  request.getParameter("ten");
        String matkhau =  request.getParameter("matkhau");
        User user = new User(ten_user, matkhau);
        service.save(user);
        System.out.println("ten dky  + matkhau " + ten_user +matkhau);
//        System.out.println(service.save(user));
        request.setAttribute("message","Bạn đã đăng ký thành công");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dangky.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null)
        {
            action="";
        }
        switch (action)
        {
            case "create":
                showCreateUser(request,response);
                break;
        }

    }

    private void showCreateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dangky.jsp");
        dispatcher.forward(request, response);
    }
}
