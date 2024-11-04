package top.guke.springboot.filter_interceptor.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.guke.springboot.filter_interceptor.interceptor.ImageUploadInterceptor;


@Configuration
@AllArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

//    private final LoggingInterceptor loggingInterceptor;
//    private final AuthInterceptor authInterceptor;
//    private final CORSInterceptor corsInterceptor;
    private final ImageUploadInterceptor imageUploadInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loggingInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
        registry.addInterceptor(imageUploadInterceptor).addPathPatterns("/api/upload/**"); // 限制路径
    }
}

