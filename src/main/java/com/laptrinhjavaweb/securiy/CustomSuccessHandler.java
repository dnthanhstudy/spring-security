package com.laptrinhjavaweb.securiy;

import com.laptrinhjavaweb.utils.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }
        System.out.println(targetUrl);
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }


    private String determineTargetUrl(Authentication authentication) {
        String url = null;
        List<String> roles = SecurityUtils.getAuthorities();
        if(isAdmin(roles)) {
            url = "/admin/dashboard";
        }else if(isUser(roles)) {
            url = "/trang-chu";
        }
        return url;
    }

    private boolean isAdmin(List<String> roles) {
        if(roles.contains("ROLE_ADMIN")) return true;
        return false;
    }

    private boolean isUser(List<String> roles) {
        if(roles.contains("ROLE_USER")) return true;
        return false;
    }
}
