import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
	//접속자 수를 저장
	private static int count;
	
	public static int getCount() {
		return count;
	}
	
    public SessionListener() {
        
    }
    //세션이 만들어 질 때 - 새로운 접속이 온 경우
    @Override
    public void sessionCreated(HttpSessionEvent event) {
    	count++;
    	System.out.println("접속자 수: " + count);
    	HttpSession session = event.getSession();
    	System.out.println("세션 아이디: " + session.getId());
    }
	
}
