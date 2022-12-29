import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ApplicationListener() {
        
    }
    
    //웹서버가 구동될때 호출되는 메서드
    @Override
    public void contextInitialized(ServletContextEvent event) {
    	System.out.println("웹 서버 시작");
    }
    //웹 서버가 종료될 때 호출되는 메서드
    @Override
    public void contextDestroyed(ServletContextEvent event) {
    	System.out.println("웹 서버 종료");
    }
	
}
