/**
 * 
 */
package org.scrum1.sese;

/**
 * @author Christian Anese
 *
 */
public enum Role {
	SUPERVISOR("supervisor"),
	
	TELLER("teller"),
	
	USER("user");
	
	private final String springSecurityRoleName;
	
	private Role(String springSecurityRoleName) {
		this.springSecurityRoleName = springSecurityRoleName;
	}
	
	public String getSpringSecurityRoleName() {
		return springSecurityRoleName;
	}
}
