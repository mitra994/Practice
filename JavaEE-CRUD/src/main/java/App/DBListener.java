package App;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


@WebListener
public class DBListener implements ServletContextListener {


    public DBListener() {

    }


    public void contextDestroyed(ServletContextEvent arg0)  {

    }


    public void contextInitialized(ServletContextEvent event)  { 
    	
    	 System.out.println("Initializing Database.....");
         ServletContext context = event.getServletContext();
         
         Connection conn = (Connection) context.getAttribute("connection");
         
         try {
			Statement stmt = conn.createStatement();
			
			String fileName = "/WEB-INF/create_person_table.sql";
			
			InputStream in = context.getResourceAsStream(fileName);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String line = null;
			System.out.println("Executing Query.....");
			while((line = reader.readLine()) != null) {
				System.out.println(line);
				int i = stmt.executeUpdate(line);
				
				String msg = (i == 0) ? "Table Created Successfully" : "Row(s) inserted successfully";
				System.out.println(msg);
				
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
         
    }
	
}
