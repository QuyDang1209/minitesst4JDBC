package controller;

import model.Glasses;
import model.IGlasessDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GlassesServlet", urlPatterns = "/glasses")
public class GlassesServlet extends HttpServlet {
    private final GlassDAO glassDAO = new GlassDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "edit":
                showFormEdit(req,resp);
                break;
            case "delete":
                showFormDelete(req, resp);
                break;
            default:
                showAllGalsses(req, resp);
        }
    }

    private void showFormDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Glasses glasses = glassDAO.findGlass(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/delete.jsp");
        req.setAttribute("dsk3", glasses);
        dispatcher.forward(req, resp);
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Glasses glass = glassDAO.findGlass(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/edit.jsp");
        req.setAttribute("dsk2",glass);
        dispatcher.forward(req,resp);
    }

    private void showAllGalsses(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Glasses> glasses = glassDAO.selectAllGlasess();
        req.setAttribute("list", glasses);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/listview.jsp");
        dispatcher.forward(req, resp);
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                inSertGlass(req, resp);
                break;
            case "edit":
                try {
                    editGlass(req,resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case"delete":
                try {
                    deleteGlass(req,resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showAllGalsses(req,resp);
        }
    }

    private void deleteGlass(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int id  = Integer.parseInt(req.getParameter("id"));
        glassDAO.deleteGlasses(id);
        List<Glasses> glasses = glassDAO.selectAllGlasess();
        req.setAttribute("list", glasses);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/listview.jsp");
        dispatcher.forward(req,resp);
    }

    private void editGlass(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int id = Integer.parseInt(req.getParameter("ID"));
        String code = req.getParameter("CODE");
        int price = Integer.parseInt(req.getParameter("PRICE"));
        String color = req.getParameter("COLOR");
        String decription = req.getParameter("DECRIPTION");
        String img = req.getParameter("IMG");
        Glasses glasses = new Glasses(id, code, price, color, decription, img);
        glassDAO.updateGlasses(glasses);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/edit.jsp");
        req.setAttribute("mess2", "Chỉnh sửa thành công");
        dispatcher.forward(req,resp);

    }

    private void inSertGlass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("ID"));
        String code = req.getParameter("CODE");
        int price = Integer.parseInt(req.getParameter("PRICE"));
        String color = req.getParameter("COLOR");
        String decription = req.getParameter("DECRIPTION");
        String img = req.getParameter("IMG");
        Glasses glasses = new Glasses(id, code, price, color, decription, img);
        glassDAO.insertGlasses(glasses);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/create.jsp");
        req.setAttribute("mess1", "Tạo mới thành công");
        dispatcher.forward(req, resp);


    }
}
