package com.hjx.system.service;

import javax.servlet.http.HttpServletRequest;

import com.hjx.common.model.Result;

public interface LoginService {


    void logoutJSON();

    String getStatus(HttpServletRequest request);
}
