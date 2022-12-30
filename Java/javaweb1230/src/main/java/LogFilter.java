

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("*.jsp")
public class LogFilter extends HttpFilter implements Filter {
     
    public LogFilter() {
        super();
    }
    //필터가 파괴될 때 호출되는 메서드
	public void destroy() {
	}
	//URL에 해당하는 요청이 왔을 떄 호출되는 메서드
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//여기에 작성하면 Controller가 처리하기 전에 수행
		System.out.println("처리하기 전");
		chain.doFilter(request, response);
		
		//Controller가 처리한 후
		System.out.println("처리한 후");
	}
	//메모리 할당 후 처음 사용될 때 호출되는 메서드
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
