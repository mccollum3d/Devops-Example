package com.revature.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {

	void attemptAuthentication(HttpServletRequest request, HttpServletResponse response);
}
