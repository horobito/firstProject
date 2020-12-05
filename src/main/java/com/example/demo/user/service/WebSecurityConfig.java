package com.example.demo.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


// 참고 : https://shinsunyoung.tistory.com/78 -> 모든 주석은 여기에서 발췌

@RequiredArgsConstructor
@EnableWebSecurity  //Spring Security를 활성화한다는 의미의 어노테이션입니다.
@Configuration


// WebSecurityConfigurerAdapter는
// Spring Security의 설정파일로서의 역할을 하기 위해 상속해야 하는 클래스입니다.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;

    //비밀번호를 암호화할 때 사용할 인코더를 미리 빈으로 등록해놓는 과정입니다.
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //WebSecurityConfigurerAdapter를 상속받으면 오버라이드할 수 있습니다.
    // 인증을 무시할 경로들을 설정해놓을 수 있습니다.
    //static 하위 폴더 (css, js, img)는 무조건 접근이 가능해야하기 때문에 인증을 무시해야합니다.
    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }


    //WebSecurityConfigurerAdapter를 상속받으면 오버라이드할 수 있습니다.
    //http 관련 인증 설정이 가능합니다
    // 여기서부터는 주석 대신 참고 페이지 설명 보기
    @Override
    protected void configure(HttpSecurity http) throws Exception{//6
        http
                .authorizeRequests() // 7
                .antMatchers("/login", "/signup", "/user").permitAll() // 누구나 접근 허용
                .antMatchers("/").hasRole("USER") // USER, ADMIN만 접근 가능
                .antMatchers("/admin").hasRole("ADMIN") // ADMIN 만 접근 가능
                .anyRequest().authenticated() // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근 가능
            .and()
              .formLogin() //8
                   .loginPage("/login") // 로그인 페이지 링크
                   .defaultSuccessUrl("/") // 로그인 성공 후 리다이렉트 주소
            .and()
                .logout()
                .logoutSuccessUrl("/login") // 로그아웃 성공시 리다이렉트 주소
                .invalidateHttpSession(true) // 세션 날리기
        ;


    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{ // 10.로그인때 필요한 정보 가져오는 기능
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
        //// 해당 서비스(userService)에서는 UserDetailsService를
        // implements해서 loadUserByUsername() 구현해야함 (서비스 참고)

    }


}
