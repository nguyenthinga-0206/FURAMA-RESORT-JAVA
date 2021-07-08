package controller;

import model.Diachi;
import model.Khachhang;
import model.Loaikhach;
import service.*;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="KhachhangServlet", urlPatterns = "/khachhang")
public class KhachhangServlet extends HttpServlet {
    private KhachhangService service = new KhachhangServicelpml();
    private LoaikhachService loaikhachService = new LoaikhachServicelmpl();
    private DiachiService diachiService = new DiachiServicelmpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null)
        {
            action="";
        }
        System.out.println("ddoppoer");
        switch (action)
        {
            case "create":
                CreateKhachhang(request,response);
                break;
            case "createhd":
                CreateKhachhang_Hopdong(request,response);
                break;
            case "search":
                SearchKhachhang(request,response);
                break;
            case "edit":
                EditKhachhang(request,response);
                break;
            case "delete":
                DeleteKhachhang(request,response);
                break;
            default:
                ListKhachhang(request,response);
        }
    }

    private void CreateKhachhang_Hopdong(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id= request.getParameter("id");
        System.out.println("id_kg:" + id);
        String ten = request.getParameter("ten");
        String ngaysinh =  request.getParameter("ngaysinh");
        String gioitinh = request.getParameter("gioitinh");
        int socmnd =Integer.parseInt(request.getParameter("socmnd"));
        System.out.println(request.getParameter("sdt"));
        int sdt = Integer.parseInt(request.getParameter("sdt"));
        String email = request.getParameter("email");
        String id_loaikhach = request.getParameter("id_loaikhach");
        String id_diachi= request.getParameter("id_diachi");
        Khachhang khachhang = new Khachhang(id,ten,ngaysinh,gioitinh,socmnd,sdt,email,new Loaikhach(id_loaikhach),new Diachi(id_diachi));
        System.out.println("dang them moi khach hang ");
        System.out.println("id khach hang" +id_loaikhach);
        System.out.println("id dia ci " +id_diachi);
        System.out.println("kh kh :" +khachhang);
        service.save(khachhang);
        response.sendRedirect(request.getContextPath() + "/hopdong?action=create&id_khachhang="+ id);

    }

    private void DeleteKhachhang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListKhachhang(request,response);
    }

    private void EditKhachhang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        System.out.println("id la" + id);
        String ten = request.getParameter("ten");
        String ngaysinh =  request.getParameter("ngaysinh");
        String gioitinh = request.getParameter("gioitinh");
        int socmnd =Integer.parseInt(request.getParameter("socmnd"));
        int sdt = Integer.parseInt(request.getParameter("sdt"));
        String email = request.getParameter("email");
        String id_loaikhach = request.getParameter("id_loaikhach");
        String id_diachi= request.getParameter("id_diachi");
        Khachhang khachhang = new Khachhang(id,ten,ngaysinh,gioitinh,socmnd,sdt,email,new Loaikhach(id_loaikhach),new Diachi(id_diachi));
        System.out.println("Kahc hang serrvlet" + service.update(id,khachhang));
        service.update(id,khachhang);
        ListKhachhang(request,response);
    }

    private void SearchKhachhang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        System.out.println("đang tìm kiếm ten" +name);
        request.setAttribute("khachhang",service.finByName(name));
        request.setAttribute("value_key", name);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/khachhang/list.jsp");
        dispatcher.forward(request,response);
    }

    private void CreateKhachhang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        System.out.println("id_kg:" + id);
        String ten = request.getParameter("ten");
        String ngaysinh =  request.getParameter("ngaysinh");
        String gioitinh = request.getParameter("gioitinh");
        int socmnd =Integer.parseInt(request.getParameter("socmnd"));
        System.out.println(request.getParameter("sdt"));
        int sdt = Integer.parseInt(request.getParameter("sdt"));
        String email = request.getParameter("email");
        String id_loaikhach = request.getParameter("id_loaikhach");
        String id_diachi= request.getParameter("id_diachi");
        Khachhang khachhang = new Khachhang(id,ten,ngaysinh,gioitinh,socmnd,sdt,email,new Loaikhach(id_loaikhach),new Diachi(id_diachi));
        System.out.println("dang them moi khach hang ");
        System.out.println("id khach hang" +id_loaikhach);
        System.out.println("id dia ci " +id_diachi);
        System.out.println("kh kh :" +khachhang);
        service.save(khachhang);
        ListKhachhang(request,response);
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
                showCreateKhachhang(request,response);
                break;
            case "createhd":
                showCreateKhachhang_hopdong(request,response);
                break;
            case "edit":
                showEditKhachhang(request,response);
                break;
            case "search":
                showSearchKhachhang(request,response);
                break;
            case "delete":
                showDeleteKhachhang(request,response);
                break;
            case "sort":
                showSortKhachhang(request,response);
                break;
            case "view":
                showViewKhachhang(request,response);
                break;
            default:
                ListKhachhang(request,response);
        }


    }
    private void showViewKhachhang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_khachhang =request.getParameter("id");
        request.setAttribute("khachhang",service.finById1(id_khachhang));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/khachhang/view.jsp");
        dispatcher.forward(request,response);
    }

    private void ListKhachhang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("đang list ds khách hàng");
        request.setAttribute("khachhang",service.finAll());
        request.setAttribute("timkiem","khachhang");
        List<Khachhang> a = service.finAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/khachhang/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showSortKhachhang(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showDeleteKhachhang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("id cau no");
        service.remove(id);
        request.setAttribute("khachhang",service.finAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/khachhang/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showSearchKhachhang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        System.out.println("đang tìm kiếm ten" +name);
        request.setAttribute("khachhang",service.finByName(name));
        RequestDispatcher dispatcher= request.getRequestDispatcher("/khachhang/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditKhachhang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<Diachi> diachis = diachiService.finAll();
        List<Loaikhach> loaikhaches = loaikhachService.finAll();

        request.setAttribute("diachis",diachis);
        request.setAttribute("loaikhachs",loaikhaches);
        request.setAttribute("khachhang",service.finById1(id));
        request.setAttribute("diachiid",diachiService.finById1(id));
        Khachhang khachhang = service.finById1(id);
        System.out.println("Khach hang" + khachhang);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/khachhang/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void showCreateKhachhang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_diachi =  request.getParameter("id_diachi");
        List<Diachi> diachis = diachiService.finAll();
        List<Loaikhach> loaikhaches = loaikhachService.finAll();
        request.setAttribute("diachis",diachis);
        request.setAttribute("id_diachi",id_diachi);
        request.setAttribute("loaikhachs",loaikhaches);
        System.out.println( "dia cỉ khach han" +diachis);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/khachhang/create.jsp");
        dispatcher.forward(request,response);
    }
    private void showCreateKhachhang_hopdong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_diachi =  request.getParameter("id_diachi");
        List<Diachi> diachis = diachiService.finAll();
        List<Loaikhach> loaikhaches = loaikhachService.finAll();
        request.setAttribute("diachis",diachis);
        request.setAttribute("id_diachi",id_diachi);
        request.setAttribute("loaikhachs",loaikhaches);
        System.out.println( "dia cỉ khach han" +diachis);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/khachhang/createkh_hp.jsp");
        dispatcher.forward(request,response);
    }
}
