

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/ContadorSession"})
public class ContadorSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
         // processRequest(request, response);
         
        HttpSession sesion = request.getSession();
        

//se recibe del index
        String valor1 = request.getParameter("hombre");        
        String valor2 = request.getParameter("mujer");
        String LogOut = request.getParameter("LogOut");        

        
        Integer conteohombre = (Integer) sesion.getAttribute("Cookiehombre");
        Integer conteomujer = (Integer) sesion.getAttribute("Cookiemujer");
        
        if (LogOut != null) {
            sesion.invalidate();
            response.sendRedirect("index.html");
            //El siguiente return es para salir del metodo.
            return;
            
        }
        
        if (valor1 != null && valor2 == null) {
            if (conteohombre == null ) {
            conteohombre=1; 
            }
            else{
                conteohombre++;
            }   
      //        Cookie cookie = new Cookie("Cookiehombre","value"+conteohombre);       
            Cookie cookie = new Cookie("Cookiehombre",conteohombre.toString());
            response.addCookie(cookie);
            sesion.setAttribute("Cookiehombre", conteohombre);
        }
        else{
            if (conteomujer == null ) {
            conteomujer=1; 
            }
            else{
                conteomujer++;
            }
            Cookie cookie1 = new Cookie("Cookiemujer",conteomujer.toString());       
            response.addCookie(cookie1);
            sesion.setAttribute("Cookiemujer", conteomujer);
        }
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
//        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
