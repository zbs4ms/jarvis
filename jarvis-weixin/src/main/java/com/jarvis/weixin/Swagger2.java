package com.jarvis.weixin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sloan on 2017/5/27.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        List<ResponseMessage> responseMessageList =  new ArrayList<ResponseMessage>();
        responseMessageList.add(new ResponseMessageBuilder().code(200).message("请求接口成功，业务正确").build());
        responseMessageList.add(new ResponseMessageBuilder().code(400).message("请求接口成功，业务失败，前端返回预先定义的统一错误信息").build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("未授权IP，未找到登录信息，无权限访问接口").build());
        responseMessageList.add(new ResponseMessageBuilder().code(406).message("请求接口成功，业务失败，前端返回后端返回的msg信息").build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("不明错误，前端返回预先定义的统一错误信息").build());
        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET,responseMessageList)
                .globalResponseMessage(RequestMethod.POST,responseMessageList)
                .globalResponseMessage(RequestMethod.PUT,responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE,responseMessageList)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jarvis.weixin"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("贾维斯--私人语音助手")
                .description("私人语音助手")
                .version("1.0")
                .build();
    }
}
