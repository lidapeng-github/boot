package com.peng.Config;


import com.sun.org.apache.bcel.internal.classfile.Field;
import io.swagger.annotations.Contact;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.*;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableOpenApi
public class SwaggerConfig implements WebMvcConfigurer {

    @Value("true")
    private Boolean enable;

    /**
     * 项目应用名
     */
    @Value("dapeng")
    private String applicationName;

    /**
     * 项目版本信息
     */
    @Value("1.0")
    private String applicationVersion;

    /**
     * 项目描述信息
     */
    @Value("今天月色好，出来溜溜小平")
    private String applicationDescription ;

    @Bean
    public Docket createRestApi()
    {
        return new Docket(DocumentationType.OAS_30).pathMapping("/")

                // 定义是否开启swagger，false为关闭，可以通过变量控制
                .enable(enable)

                // 将api的元信息设置为包含在json ResourceListing响应中。
                .apiInfo(apiInfo())
                .groupName("DP")

                // 选择哪些接口作为swagger的doc发布
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()

                // 支持的通讯协议集合
                .protocols(newHashSet("https", "http"))

                // 授权信息设置，必要的header token等认证信息
                .securitySchemes(securitySchemes())

                // 授权信息全局应用
                .securityContexts(securityContexts());
    }

    /**
     * API 页面上半部分展示信息
     */
    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder().title("Sinhy " + applicationName + " Api Doc")
                .description(applicationDescription)
                .contact(DEFAULT_CONTACT)
                .version("Application Version: " + applicationVersion + ", Spring Boot Version: " + SpringBootVersion.getVersion())
                .build();
    }

    /**
     * 设置授权信息
     */
    private List<SecurityScheme> securitySchemes()
    {
        return Collections.singletonList(new ApiKey("BASE_TOKEN", "token", "pass"));
    }

    /**
     * 授权信息全局应用
     */
    private List<SecurityContext> securityContexts()
    {
        return Collections.singletonList(
                SecurityContext.builder().securityReferences(Collections.singletonList(new SecurityReference("BASE_TOKEN", new AuthorizationScope[] {new AuthorizationScope("global", "")}))).build());
    }

    @SafeVarargs
    private final <T> Set<T> newHashSet(T... ts)
    {
        if (ts.length > 0)
        {
            return new LinkedHashSet<>(Arrays.asList(ts));
        }
        return null;
    }

    /**
     * 通用拦截器排除swagger设置，所有拦截器都会自动加swagger相关的资源排除信息
     */

}
