package spring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

	private JwtUtils jwtUtils;
	
	public AuthTokenFilter(JwtUtils jwtUtils) {
		this.jwtUtils = jwtUtils;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = this.parseJwt(request);
			if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
				String username = jwtUtils.getUserNameFromJwtToken(jwt);
				String authorities = jwtUtils.getAuthorityFromJwtToken(jwt);
				Collection<SimpleGrantedAuthority> grantedauthorities = new ArrayList<>();
				List<String> fullList = Arrays.asList(authorities.split(","));
                if (fullList.contains("ROLE_ADMIN")) {
                	grantedauthorities.add(new SimpleGrantedAuthority("ADMIN"));
                }
                if (fullList.contains("ROLE_CUSTOMER")) {
                	grantedauthorities.add(new SimpleGrantedAuthority("CUSTOMER"));
                }
				UserDetailsImpl userDetails = new UserDetailsImpl(username, "", grantedauthorities);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, grantedauthorities);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			System.out.println("Cannot set user authentication: " + e);
		}
		filterChain.doFilter(request, response);
	}

	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}
		return null;
	}
}
