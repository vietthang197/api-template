package vn.neo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.neo.api.jwt.CustomGrantedAuthority;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto implements Serializable {

    private Long userId;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;
    private String email;
    private String name;
    @JsonIgnore
    private String password;
    private Long state;
    private String username;
    private Long customerId;
    
    private Set<CustomGrantedAuthority> authorities = new HashSet<CustomGrantedAuthority>();
}

