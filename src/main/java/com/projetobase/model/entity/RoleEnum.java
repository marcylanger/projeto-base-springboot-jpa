package com.projetobase.model.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
	
	USER,
	ADMINISTRATOR;

	public static final Integer USER_VALUE 	= 0;
	public static final Integer ADMINISTRATOR_VALUE = 1;
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Override
	public String getAuthority()
	{
		return this.name();
	}

	/**
	 * @return
	 */
	public Set<GrantedAuthority> getAuthorities()
	{
		final Set<GrantedAuthority> authorities = new HashSet<>();

		authorities.add( this );


		return authorities;
	}

}
