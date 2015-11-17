package org.scrum.sese.authentication;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class BasicAuthenticationSession extends AuthenticatedWebSession{
	
	public BasicAuthenticationSession(Request request) {
		super(request);
	}

	@Override
	protected boolean authenticate(String username, String password) {
		// user is authenticated if both username and password equal to admin
		return username.equals(password) && username.equals("admin");
	}

	@Override
	public Roles getRoles() {
		Roles roles = new Roles();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            roles.add(authority.getAuthority());
        }
        return roles;
	}

}
