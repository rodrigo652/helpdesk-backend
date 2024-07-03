package org.projeto.helpdesk.security.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.projeto.helpdesk.resources.exceptions.StandardError;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, org.springframework.security.access.AccessDeniedException accessDeniedException) throws IOException, ServletException {
        StandardError error = new StandardError(new Date().getTime(), HttpServletResponse.SC_FORBIDDEN,
                "Não autorizado", "Você não tem permissão para acessar esse recurso", request.getServletPath());
        String jsonError = new ObjectMapper().writeValueAsString(error);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        response.getWriter().append(jsonError);
    }
}
