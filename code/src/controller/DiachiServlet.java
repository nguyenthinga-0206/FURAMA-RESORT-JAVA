package controller;

import model.Diachi;
import model.Khachhang;
import model.Loaikhach;
import service.DiachiService;
import service.DiachiServicelmpl;
import service.LoaikhachService;
import service.LoaikhachServicelmpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DiachiServlet",urlPatterns = "/diachi")
public class DiachiServlet extends HttpServlet {
   private   DiachiService service = new DiachiServicelmpl();
    private LoaikhachService loaikhachService = new LoaikhachServicelmpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createkh":
                CreateDiachikh(request, response);
                break;
            case "createnv":
                CreateDiachinv(request, response);
                break;
            case "createkh_hd":
                CreateDiachikh_hd(request, response);
                break;
            case "edit":
                EditDiachi(request, response);
                break;
            case "delete":
                DeleteDiachi(request, response);
                break;
            case "view":
                ViewDiachi(request, response);
                break;

            default:
                ListDiachi(request, response);
        }
    }

    private void CreateDiachikh_hd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id_diachi =request.getParameter("id");
        String sonha = request.getParameter("sonha");
        String xa =request.getParameter("xa");
        String huyen  =request.getParameter("huyen");
        String tinh  =request.getParameter("tinh");
        String quocgia  =request.getParameter("quocgia");
        Diachi diachi = new Diachi(id_diachi,sonha,xa,huyen,tinh,quocgia);
        System.out.println("id dia ci" +id_diachi);
        service.save(diachi);
        response.sendRedirect(request.getContextPath() + "/khachhang?action=createhd&id_diachi="+ id_diachi);

    }

    private void ViewDiachi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_diachi =request.getParameter("id");
        request.setAttribute("diachi",service.finById1(id_diachi));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/diachi/view.jsp");
        dispatcher.forward(request,response);
    }

    private void CreateDiachikh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String id_diachi =request.getParameter("id");
         String sonha = request.getParameter("sonha");
         String xa =request.getParameter("xa");
         String huyen  =request.getParameter("huyen");
         String tinh  =request.getParameter("tinh");
         String quocgia  =request.getParameter("quocgia");
         Diachi diachi = new Diachi(id_diachi,sonha,xa,huyen,tinh,quocgia);
         System.out.println("id dia ci" +id_diachi);
         service.save(diachi);
        response.sendRedirect(request.getContextPath() + "/khachhang?action=create&id_diachi="+ id_diachi);
    }
    private void CreateDiachinv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_diachi =request.getParameter("id");
        String sonha = request.getParameter("sonha");
        String xa =request.getParameter("xa");
        String huyen  =request.getParameter("huyen");
        String tinh  =request.getParameter("tinh");
        String quocgia  =request.getParameter("quocgia");
        Diachi diachi = new Diachi(id_diachi,sonha,xa,huyen,tinh,quocgia);
        System.out.println("id dia ci" +id_diachi);
        service.save(diachi);
        response.sendRedirect(request.getContextPath() + "/nhanvien?action=create&id_diachi="+ id_diachi);
    }
    private void EditDiachi(HttpServletRequest request, HttpServletResponse response) {
    }
    private void DeleteDiachi(HttpServletRequest request, HttpServletResponse response) {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createkh":
                showCreateDiachikh(request, response);
                break;
            case "createnv":
                showCreateDiachinv(request, response);
                break;
            case "createkh_hd":
                showCreateDiachikh_hd(request, response);
                break;
            case "edit":
                showEditDiachi(request, response);
                break;
            case "delete":
                showDeleteDiachi(request, response);
                break;
            case "view":
                showViewDiachi(request, response);
                break;
            default:
                ListDiachi(request, response);
        }


    }

    private void showCreateDiachikh_hd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher= request.getRequestDispatcher("/diachi/create.jsp");
        dispatcher.forward(request,response);
    }

    private void showViewDiachi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_diachi =request.getParameter("id");
        request.setAttribute("diachi",service.finById1(id_diachi));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/diachi/view.jsp");
        dispatcher.forward(request,response);

    }

    private void ListDiachi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_diachi =request.getParameter("id");
        List<Diachi> diachi = service.finAll();
         request.setAttribute("diachi",diachi);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/diachi/diachimoithem.jsp");
        dispatcher.forward(request,response);
    }
    private void showDeleteDiachi(HttpServletRequest request, HttpServletResponse response) {
    }
    private void showEditDiachi(HttpServletRequest request, HttpServletResponse response) {
    }
    private void showCreateDiachikh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher= request.getRequestDispatcher("/diachi/create.jsp");
        dispatcher.forward(request,response);
    }
    private void showCreateDiachinv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher= request.getRequestDispatcher("/diachi/create.jsp");
        dispatcher.forward(request,response);
    }

}
