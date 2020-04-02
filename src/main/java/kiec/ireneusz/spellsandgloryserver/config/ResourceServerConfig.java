//package kiec.ireneusz.spellsandgloryserver.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
//@Configuration
//@EnableResourceServer
//@EnableOAuth2Client
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers( "/admin/**")./*hasRole("ADMIN")*/permitAll()
//                .antMatchers( "/user/**").authenticated()
//                .antMatchers( "/credential/**").authenticated()
//                .antMatchers( "/customer/**").authenticated()
//                .antMatchers( "/role/**").authenticated()
//                .antMatchers( "/project/**").authenticated()
//                .antMatchers( "/module/**").authenticated()
//                .antMatchers( "/job/**").authenticated()
//                .antMatchers( "/access/**").authenticated()
//                .antMatchers( "/configuration/**").authenticated()
//                .antMatchers( "/param/**").authenticated()
//                .antMatchers( "/people/**").authenticated()
//                .antMatchers( "/public/**").permitAll()
//                .and()
//                .cors()
//                .and()
//                .oauth2Login();
//    }
//
//}
