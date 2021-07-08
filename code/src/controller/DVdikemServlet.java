package controller;

import service.DvdikemService;
import service.DvdikemServicelmpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DVdikemServlet",urlPatterns = "/dvdikem")
    public class DVdikemServlet extends HttpServlet {
    public DvdikemService service = new DvdikemServicelmpl();
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
                showCreateDvdikem(request,response);
                break;
            case "edit":
                showEditDvdikem(request,response);
                break;
            case "delete":
                showDeleteDvdikem(request,response);
                break;
            case "search":
                showSearchDvdikem(request,response);
                break;
            default:
                ListDvdikem(request,response);
        }

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
                showCreateDvdikem(request,response);
                break;
            case "edit":
                showEditDvdikem(request,response);
                break;
            case "delete":
                showDeleteDvdikem(request,response);
                break;
            case "search":
                showSearchDvdikem(request,response);
                break;
            default:
                ListDvdikem(request,response);

        }

    }

    private void showCreateDvdikem(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditDvdikem(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showDeleteDvdikem(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showSearchDvdikem(HttpServletRequest request, HttpServletResponse response) {
    }

    private void ListDvdikem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dvdikem",service.finAll());
        request.setAttribute("timkiem","dvdikem");
        System.out.println(service.finAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dvdikem/list.jsp");
        dispatcher.forward(request,response);
    }
}
