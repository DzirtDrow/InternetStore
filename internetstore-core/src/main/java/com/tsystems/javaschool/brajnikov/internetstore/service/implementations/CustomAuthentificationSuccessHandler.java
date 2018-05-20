package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class CustomAuthentificationSuccessHandler implements AuthenticationSuccessHandler {

    private boolean orderFlag = false;

    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
      boolean o = orderFlag;

      orderFlag = false;
    }

        public boolean isOrderFlag() {
            return orderFlag;
        }

        public void setOrderFlag(boolean orderFlag) {
            this.orderFlag = orderFlag;
        }
}
