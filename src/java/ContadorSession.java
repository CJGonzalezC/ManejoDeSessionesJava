

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/ContadorSession"})
public class ContadorSession extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContadorSession</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContadorSession at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
         // processRequest(request, response);
       
       HttpSession sesion = request.getSession();
       String titulo = null;
       
       Integer contadorvisitas = (Integer) sesion.getAttribute("contadorVisitas");
       //Integer contadorvisitas = (Integer) sesion.getAttribute("contadorVisitas");

       
        if (contadorvisitas == null) {
            contadorvisitas = 1;
            titulo = "Bienvenido por primera vez";
        }else{
            titulo="Bienvenido X "+contadorvisitas;
            contadorvisitas++;
        }
        
        sesion.setAttribute("contadorVisitas", contadorvisitas);
        
        PrintWriter out = response.getWriter();
        
        out.print("Titulo:"+titulo+"  ");
        out.println("Contador :"+contadorvisitas +"  ");
        out.print("Id Session :"+sesion.getId());
        
        Date tiempo = new Date();
        tiempo.setTime(sesion.getCreationTime());
        out.println("Tiempo: "+tiempo);
        
        Cookie cookie = new Cookie("Galletuki","Galletuki1");
        response.addCookie(cookie);
        
        response.sendRedirect("ConteoCookies");

    }
    
    
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
         // processRequest(request, response);
       
       HttpSession sesion = request.getSession();
       String titulo = null;
       
       Integer contadorvisitas = (Integer) sesion.getAttribute("contadorVisitas");
       
        if (contadorvisitas == null) {
            contadorvisitas = 1;
            titulo = "Bienvenido por primera vez";
        }else{
            titulo="Bienvenido X "+contadorvisitas;
            contadorvisitas++;
        }
        
        sesion.setAttribute("contadorVisitas", contadorvisitas);
        
        PrintWriter out = response.getWriter();
        
        out.print("Titulo:"+titulo+"  ");
        out.println("Contador :"+contadorvisitas +"  ");
        out.print("Id Session :"+sesion.getId());
        
        Date tiempo = new Date();
        tiempo.setTime(sesion.getCreationTime());
        out.println("Tiempo: "+tiempo);
        
        Cookie cookie = new Cookie("Galletuki","Galletuki1");
        response.addCookie(cookie);
        
        response.sendRedirect("ConteoCookies");

    }
    
    */


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
