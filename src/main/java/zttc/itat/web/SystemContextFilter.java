package zttc.itat.web;

import zttc.itat.model.SystemContext;

import javax.servlet.*;
import java.io.IOException;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2018-12-09 下午 9:33
 */
public class SystemContextFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        int offset = 0;
        try {
            offset = Integer.parseInt(servletRequest.getParameter("pager.offset"));
        }catch (NumberFormatException e){

        }
        try {
            SystemContext.setOffset(offset);
            SystemContext.setSize(15);
            filterChain.doFilter(servletRequest,servletResponse);
        }finally {
            SystemContext.removeSize();
            SystemContext.removeOffset();
        }
    }

    @Override
    public void destroy() {

    }
}
