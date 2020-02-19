package App;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/PageVisitServlet")
public class PageVisitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private int counter = 0;
       

    public PageVisitServlet() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	counter = 1;
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("visitorCount", counter++);
		
		request.getRequestDispatcher("/PageVisit.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
