package com.boot.gang.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ThymeleafService {
    void createHtml(String pageName, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception;

    void deleteHtml(String fileName);

}
