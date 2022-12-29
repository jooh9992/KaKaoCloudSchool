import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class javaweb
 */
@WebServlet("/javaweb")
public class javaweb extends HttpServlet {
   private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public javaweb() {
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.setContentType("text/html");
      response.setCharacterEncoding("utf-8");
      PrintWriter out = response.getWriter();
      out.write("<html><head><title>Servlet");
      out.write("</title></head><body>");
      out.write("<h1>처음 만들어본 웹 어플리케이션</h1>");
      out.write("</body></html>");
      out.close();
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}