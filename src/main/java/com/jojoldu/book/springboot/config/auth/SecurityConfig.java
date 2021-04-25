package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()    //URL 별 권한관리를 설정
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()  //해당 URL은 전체 열람 가능
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())    // USER 권한을 가져야만 열람 가능
                    .anyRequest().authenticated()   //나머지 URL 들 설정. 인증된(로그인한) 사용자들만 열람 가능
                .and()
                    .logout()   //로그아웃 기능 설정 진입점
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()  // 로그인 기능 설정 진입점
                        .userInfoEndpoint()
                         .userService(customOAuth2UserService); //로그인 성공 시 후속 조치를 진행할 서비스 인터페이스의 구현체를 등록.
    }
}
