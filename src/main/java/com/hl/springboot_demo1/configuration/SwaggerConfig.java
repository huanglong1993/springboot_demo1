package com.hl.springboot_demo1.configuration;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;

/**
 * @Author 黄龙
 * @Date 2019/10/10 11:07
 * @Description TODO
 * @Version 1.0.0
 */
@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig { //implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

    @Value("${swaggerSwitch}")
    private boolean swaggerSwitch;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    private static final String UNKNOWNHOST = "UnKnownHost";

    @Bean
    public Docket swaggerSpringPlugin(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).enable(swaggerSwitch).select().
                apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("XX项目 — API文档")
                .description("XX项目API文档").build();
    }


   /* @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        String serverIp = getIp();
        int serverPort = event.getEmbeddedServletContainer().getPort();
        if(swaggerSwitch){
            log.info("swagger的访问地址:http://" + serverIp + ":" + serverPort + contextPath + "/swagger-ui.html");
        }
    }*/

    public String getIp(){
        String serverIp = null;
        try{
            serverIp = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e){
            log.error("获取服务ip地址失败", e);
            serverIp = UNKNOWNHOST;
        }
        return serverIp;
    }
}
