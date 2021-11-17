package vn.neo.api.entity.primary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class UserInfo {

    private Long userId;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;
    private String email;
    private String name;
    private String password;
    private Long state;
    private String username;
    private Long customerId;
}
