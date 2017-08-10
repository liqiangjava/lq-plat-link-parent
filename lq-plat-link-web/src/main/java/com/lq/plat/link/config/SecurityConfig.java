package com.lq.plat.link.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.social.security.SpringSocialConfigurer;
import org.springframework.web.cors.CorsUtils;

import javax.sql.DataSource;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/28
 */
@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public PlatUserDetailsService platUserDetailsService;

    @Autowired
    public PlatAuthenticationSuccessHandler platAuthenticationSuccessHandler;

    @Autowired
    public PlatAuthenticationFailureHandler platAuthenticationFailureHandler;


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public DataSource dataSource;


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        //第一次启动时,新建表,第二次启动时,如果原来表存在,则报错

        //tokenRepository.setCreateTableOnStartup(true);
        tokenRepository.setDataSource(dataSource);


        return tokenRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(platUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }




   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(platUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }*/

    @Bean
    public AbstractAuthenticationProcessingFilter customUsernamePasswordAuthenticationFilter() throws Exception {
        AbstractAuthenticationProcessingFilter customUsernamePasswordAuthenticationFilter = new RestfulUsernamePasswordAuthenticationFilter();
        customUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        customUsernamePasswordAuthenticationFilter
                .setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/rest/login", "POST"));
        SimpleUrlAuthenticationSuccessHandler restAuthenticationSuccessHandler = new RestAuthenticationSuccessHandler();
        customUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(restAuthenticationSuccessHandler);


        return customUsernamePasswordAuthenticationFilter;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SpringSocialConfigurer configurer = new SpringSocialConfigurer();
        //configurer.signupUrl("/regist.html");

        http
                //.httpBasic().and()    //----httpBasic认证
                .formLogin()   //----form表单认证
                /****************** login start ********************/
                //.and()
                //.loginPage("/admin/infousers/login")
                //.loginPage("/login.html") //这个为写死的login.html地址,不方便前后分离
                .loginPage("/authentication/require") //对没有权限的方法进行验证,满足
                //.loginPage("/login")
                .loginProcessingUrl("index.html") //登录提交按钮后,跳转的(与login.html内容一致)
                //.loginProcessingUrl("/authentication/require")
                .successHandler(platAuthenticationSuccessHandler) // 跳转到认证前的URL......
                .failureHandler(platAuthenticationFailureHandler) //认证失败后要处理的......

                /****************** login end  ********************/

                /****************** usernamePassword start ********************/
                .and()
                .addFilterBefore(customUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)

                /****************** usernamePassword end ********************/

                /****************** rememberMe start ********************/
                .rememberMe() //记住我
                .tokenRepository(persistentTokenRepository()) //token设置
                .tokenValiditySeconds(600)
                //*************rememberMe end ********************/

                /****************** start ********************/
                .and()
                //如果需要spring session,以下配置要注释掉
                .sessionManagement()
                //.invalidSessionUrl("/session.html") //session失效登录到session.html
                .invalidSessionUrl("/authentication/require")
                //.maximumSessions(1) //当前系统最大的session数为1
                //.maxSessionsPreventsLogin(true) //如果我已经达到了最大登录数,其他人不能再登录了
                //.sessionFixation().changeSessionId()
                /****************** session end ********************/

                /****************** 第三方登当 start ********************/
                //第三方登录,如微信登录
                .and()
                .apply(configurer)
                /****************** 第三方登当 end ********************/
                .and()
                .csrf().disable()
                .authorizeRequests()  //url权限认证

                /****************** 默认 START ********************/
                .antMatchers(
                        /****************** swagger START ********************/
                        "/webjars/**",
                        "/webjars/**/**",
                        "/webjars/**/**/**",
                        "/swagger-resources/**/**",
                        "/swagger-resources",
                        "/swagger-ui.html",
                        "/swagger-ui.html*/**",
                        "/swagger-ui.html*/**/**",
                        "/**/api-docs",
                        /****************** swagger END ********************/

                        /****************** 权限登录 START ********************/
                        "/test/login.html", "/test/index.html", "/login.html", "/login", "/index.html", "/singup",
                        /****************** 权限登录 END ********************/

                        /****************** 默认 START ********************/
                        "/admin/infousers/signup",
                        "/admin/knowledgequestions/info",
                        "/admin/hotwords/info",
                        "/admin/knowledgetypes/info",
                        "/admin/infousers/login",
                        "/admin/infousers/login2",
                        "/admin/feedbacks/info",
                        "/admin/file/upload",
                        "/admin/file/download",
                        "/auth/**", //微信
                        "/authentication/require",
                        "/rest/login",
                        "/admin/knowledgeanswers/month/bestresponder"
                        /****************** 默认 END ********************/

                ).permitAll() //  这些方法认何人都可以访问,


                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()//就是这一行啦,对OPTIONS中Preflight进行过滤
                /****************** 配置平台角色 START ********************/
                .antMatchers("/admin/inforoles")
                .access("hasAuthority('platform')")
                /****************** 配置平台角色 END ********************/

                /****************** 配置用户角色 START ********************/
                .antMatchers("/admin/**/**", "/admin/**")
                .access("hasAuthority('admin')")
                // .hasAnyRole("admin")  对应的角色前缀 "ROLE_"
                /****************** 配置用户角色 END ********************/


                //.anyRequest()
                //.access("hasAuthority('admin')")
                //.access("@platFormSecurity.check(authentication,request)")
                //以上为认证
                //下面为授权


                .anyRequest().authenticated()


        ;


    }
}
