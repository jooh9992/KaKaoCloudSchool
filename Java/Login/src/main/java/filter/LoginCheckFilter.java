package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;
import service.MemberServiceImpl;

@WebFilter("/*")
public class LoginCheckFilter extends HttpFilter implements Filter {
	private MemberService memberService;
	
       
    public LoginCheckFilter() {
        super();
        memberService = MemberServiceImpl.getInstance();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//request 와 response 형 변환
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//Login 요청이 오면 "프로젝트이름/파일이름"
		if(req.getRequestURI().equals("/Login/login")) {
			//쿠키 읽기
			Cookie [] cookies = req.getCookies();
			for(Cookie cookie : cookies) {
				//쿠키가 존재하면 쿠키의 값으로 로그인
				if(cookie.getName().equals("remember-me")) {
					String uuid = cookie.getValue();
					MemberDTO dto = memberService.login(uuid);
					req.getSession().setAttribute("logininfo", dto);
					//메인 페이지로 리다이렉트
					res.sendRedirect("./");
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
