//package com.mrd;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.core.env.Environment;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.security.web.csrf.CsrfTokenRepository;
//import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.web.util.WebUtils;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.security.Principal;
//
//@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    public static final String LOGIN = "/login";
//    
//    @Autowired
//    Environment environment;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.exceptionHandling().authenticationEntryPoint(new AjaxAwareEntryPoint(LOGIN))
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/**").authenticated()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin().loginPage(LOGIN)
//                .and()
//                .csrf().csrfTokenRepository(csrfTokenRepository())
//                .and()
//                .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
//    }
//
//    private CsrfTokenRepository csrfTokenRepository() {
//        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//        repository.setHeaderName("X-XSRF-TOKEN");
//        return repository;
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("ADMIN", "USER")
//                .and()
//                .withUser("user").password("user") .roles("USER");
//    }
//
//    @RestController
//    public static class UserController {
//        @RequestMapping("/user")
//        public Principal user(Principal user) {
//            return user;
//        }
//    }
//    
//    class AjaxAwareEntryPoint extends LoginUrlAuthenticationEntryPoint {
//
//        private static final String XML_HTTP_REQUEST = "XMLHttpRequest";
//        private static final String X_REQUESTED_WITH = "X-Requested-With";
//
//        public AjaxAwareEntryPoint(String loginFormUrl) {
//            super(loginFormUrl);
//        }
//
//        @Override
//        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
//                throws IOException, ServletException {
//            if (XML_HTTP_REQUEST.equals(request.getHeader(X_REQUESTED_WITH))) {
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//            } else {
//                super.commence(request, response, exception);
//            }
//        }
//    }
//
//    class CsrfHeaderFilter extends OncePerRequestFilter {
//        @Override
//        protected void doFilterInternal(HttpServletRequest request,
//                                        HttpServletResponse response, FilterChain filterChain)
//                throws ServletException, IOException {
//            CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//            if (csrf != null) {
//                Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
//                String token = csrf.getToken();
//                if (cookie==null || token!=null && !token.equals(cookie.getValue())) {
//                    cookie = new Cookie("XSRF-TOKEN", token);
//                    cookie.setPath("/");
//                    response.addCookie(cookie);
//                }
//            }
//            filterChain.doFilter(request, response);
//        }
//    }
//
//}
