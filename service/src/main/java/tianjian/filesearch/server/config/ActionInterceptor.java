package tianjian.filesearch.server.config;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import tianjian.filesearch.server.util.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static tianjian.filesearch.server.config.ConstantValue.COUNTING;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/11/13
 * @description
 */
@WebServlet
public class ActionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        StringRedisTemplate stringRedisTemplate = BeanUtils.getBean("stringRedisTemplate");
        // System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");

        // 获取系统时间
        String token = UUID.randomUUID().toString();
        Calendar ca = Calendar.getInstance();
        request.setAttribute("ClientId", token);
        System.out.println("start is " + token);
        int hour = ca.get(Calendar.HOUR_OF_DAY);
        stringRedisTemplate.opsForZSet().add(COUNTING, token, new Date().getTime());
        System.out.println("filter now hour is" + hour);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        StringRedisTemplate stringRedisTemplate = BeanUtils.getBean("stringRedisTemplate");
        String token = request.getAttribute("ClientId").toString();
        stringRedisTemplate.opsForZSet().remove(COUNTING, token);
        System.out.println("end is " + token);
        // System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet
        // 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }

    private void initToken(StringRedisTemplate stringRedisTemplate, long outTime) {

        stringRedisTemplate.opsForZSet().removeRange(COUNTING, 0, new Date().getTime() - outTime);

    }
}
