package com.lin.config;

import com.lin.service.DummyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * Created by lys on 2018/9/5.
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 * {@link EnableGlobalMethodSecurity 使权限@PreAuthorize 生效}
 */

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

//	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
				.authorizeRequests()
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.anyRequest().fullyAuthenticated()
				.and()
				.formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
				.and()
				.logout().permitAll();
		// @formatter:on
	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//				.inMemoryAuthentication()
//				.withUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER"));
//	}

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
//		auth.authenticationProvider(kerberosAuthenticationProvider());
	}

	/**
	 * 认证密码处理器
	 *
	 * @return
	 */
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	/**
	 * 自定义认证
	 * @return
	 */
	@Override
	protected UserDetailsService userDetailsService() {
		return new DummyUserDetailsService();
	}


	/**
	 * kerberos
	 */
//	@Bean
//	public KerberosAuthenticationProvider kerberosAuthenticationProvider(){
//		KerberosAuthenticationProvider provider =
//        		new KerberosAuthenticationProvider();
//        SunJaasKerberosClient client = new SunJaasKerberosClient();
//        client.setDebug(true);
//        provider.setKerberosClient(client);
//        provider.setUserDetailsService(dummyUserDetailsService());
//        return provider;
//	}


//	@Bean
//	public DummyUserDetailsService dummyUserDetailsService() {
//		return new DummyUserDetailsService();
//	}

}
