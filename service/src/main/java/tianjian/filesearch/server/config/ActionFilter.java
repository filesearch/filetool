package tianjian.filesearch.server.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/11/13
 * @description
 */
public class ActionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 获取系统时间
        Calendar ca = Calendar.getInstance();
        int hour = ca.get(Calendar.HOUR_OF_DAY);
        // 设置限制运行时间 0-4点
        if (hour < 4) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json; charset=utf-8");

            // 消息
            Map<String, Object> messageMap = new HashMap<>();
            messageMap.put("status", "1");
            messageMap.put("message", "此接口可以请求时间为:0-4点");
            ObjectMapper objectMapper=new ObjectMapper();
            String writeValueAsString = objectMapper.writeValueAsString(messageMap);
            response.getWriter().write(writeValueAsString);

        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }

}
