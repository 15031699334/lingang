package com.boot.gang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class SwaggerController {

    @RequestMapping("/api/swagger/swagger-resources")
    public String resource() {
        return "forward:/swagger-resources";
    }

    @RequestMapping("/api/swagger/swagger-resources/configuration/ui")
    public String ui() {
        return "forward:/configuration/ui";
    }

    @RequestMapping("/api/swagger/configuration/ui")
    public String uiTmp() {
        return "forward:/configuration/ui";
    }

    @RequestMapping("/api/swagger/v2/api-docs")
    public String doc() {
        return "forward:/v2/api-docs";
    }

    @RequestMapping("/api/swagger/configuration/security")
    public String security() {
        return "forward:/configuration/security";
    }
}