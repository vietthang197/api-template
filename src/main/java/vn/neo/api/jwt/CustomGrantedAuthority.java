package vn.neo.api.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author thanglv
 * @date 7/13/2021 3:06 PM
 */
public class CustomGrantedAuthority implements GrantedAuthority {
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final String operationName;

    public CustomGrantedAuthority(String role) {
        this.operationName = role;
    }

    @Override
    public String getAuthority() {
        return this.operationName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleGrantedAuthority) {
            return this.operationName.equals(((CustomGrantedAuthority) obj).operationName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.operationName.hashCode();
    }

    @Override
    public String toString() {
        return this.operationName;
    }

    @JsonIgnore
	public String getOperationName() {
		return operationName;
	}
}
