package boss.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import boss.portal.constant.ConstantKey;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static cn.hutool.core.collection.CollUtil.newArrayList;

/**
 * 描述：
 * <p>
 * Author: zhaoxinguo
 * Date: 2017/12/12 15:32
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 设置默认TOKEN，方便测试
    private static final String TOKEN = ConstantKey.BEARER + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ6aGFveGluZ3VvLVtST0xFX0FETUlOLCBBVVRIX1dSSVRFXSIsImV4cCI6MTUzOTMzOTM0NX0.P9dkLQ7lpNODJppHBM-InSS90nw0XJieK8QNlZM0TeuNNQ8sUPYH-uif099A1-P2Ap6b_9lCLbXL2iR0OLdFyw";

    @Bean
    public Docket api() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name(ConstantKey.HEADER_KEY).description("令牌").defaultValue(TOKEN).modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("boss.portal.controller"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500).message("500 queue").responseModel(new ModelRef("Error")).build(), new ResponseMessageBuilder().code(403).message("Forbidden!!!!!").build()));
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "SPRINGBOOT-SPRINGSECURITY-JWT-DEMO-SWAGGER REST API",
                "Some custom description of API.",
                "API TOS",
                "Terms of service",
                new Contact("Zhao XinGuo", "https://javaymw.com/", "sxdtzhaoxinguo@163.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}