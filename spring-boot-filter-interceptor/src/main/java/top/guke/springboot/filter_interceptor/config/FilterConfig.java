package top.guke.springboot.filter_interceptor.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.guke.springboot.filter_interceptor.filter.CorsFilter;
import top.guke.springboot.filter_interceptor.filter.LoggingFilter;
import top.guke.springboot.filter_interceptor.filter.RateLimitFilter;

@Configuration
public class FilterConfig {
//    @Bean
//    public FilterRegistrationBean<CustomFilter> filterRegistrationBean() {
//        FilterRegistrationBean<CustomFilter> filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new CustomFilter());
//        //设置过滤器拦截的URL路径
//        filterRegistrationBean.addUrlPatterns("/*");
//        //设置过滤器的执行顺序
//        filterRegistrationBean.setOrder(1);
//        return filterRegistrationBean;
//    }


//    @Bean
//    public FilterRegistrationBean<LoggingFilter> loggingFilterRegistrationBean() {
//        FilterRegistrationBean<LoggingFilter> filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new LoggingFilter());
//        //设置过滤器拦截的URL路径
//        filterRegistrationBean.addUrlPatterns("/*");
//        //设置过滤器的执行顺序
//        filterRegistrationBean.setOrder(1);
//        return filterRegistrationBean;
//    }

//    @Bean
//    public FilterRegistrationBean<AuthFilter> loggingFilterRegistrationBean() {
//        FilterRegistrationBean<AuthFilter> filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new AuthFilter());
//        //设置过滤器拦截的URL路径
//        filterRegistrationBean.addUrlPatterns("/*");
//        //设置过滤器的执行顺序
//        filterRegistrationBean.setOrder(2);
//        return filterRegistrationBean;
//    }

//    @Bean
//    public FilterRegistrationBean<CorsFilter> loggingFilterRegistrationBean() {
//        FilterRegistrationBean<CorsFilter> filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new CorsFilter());
//        //设置过滤器拦截的URL路径
//        filterRegistrationBean.addUrlPatterns("/*");
//        //设置过滤器的执行顺序
//        filterRegistrationBean.setOrder(3);
//        return filterRegistrationBean;
//    }

    @Bean
    public FilterRegistrationBean<RateLimitFilter> loggingFilterRegistrationBean() {
        FilterRegistrationBean<RateLimitFilter> filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new RateLimitFilter());
        //设置过滤器拦截的URL路径
        filterRegistrationBean.addUrlPatterns("/*");
        //设置过滤器的执行顺序
        filterRegistrationBean.setOrder(3);
        return filterRegistrationBean;
    }
}
