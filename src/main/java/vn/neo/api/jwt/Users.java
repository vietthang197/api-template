package vn.neo.api.jwt;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.springframework.security.core.GrantedAuthority;

public class Users extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;

	public static final String AUTHORITIES_KEY = "auth";
	public static final String USERID_KEY = "user_id";
	public static final String EMAIL_KEY = "email";
	public static final String USER_TYPE_KEY = "user_type";
	public static final String MOBILE_KEY = "mobile";
	public static final String FULLNAME_KEY = "full_name";
	public static final String DEPARTMENT_ID_KEY = "dp_id";

	private Long userId;
	private String fullName;
	private String mobile;
	private Integer dpId;
	private String email;
	private Integer statusId;
	private Integer userType;
	private Date expireTime = null;
	private List<Integer> listResourceId = null;

	public Users(Map<String, Object> claims, String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		Object userId = claims.get(USERID_KEY);
		if (userId != null)
			setUserId(Long.valueOf(String.valueOf(userId)));
		Object email = claims.get(EMAIL_KEY);
		if (email != null)
			setEmail(String.valueOf(email));
		Object userType = claims.get(USER_TYPE_KEY);
		if (userType != null)
			setUserType(Integer.valueOf(String.valueOf(userType)));
		Object mobile = claims.get(MOBILE_KEY);
		if (mobile != null)
			setMobile(String.valueOf(mobile));
		Object fullName = claims.get(FULLNAME_KEY);
		if (fullName != null)
			setFullName(String.valueOf(fullName));
		Object dpId = claims.get(DEPARTMENT_ID_KEY);
		if (dpId != null)
			setDpId(Integer.valueOf(String.valueOf(dpId)));
	}

	public Users(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getDpId() {
		return dpId;
	}

	public void setDpId(Integer dpId) {
		this.dpId = dpId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public void updateExpireTime(String time) {
		if (Strings.isEmpty(time))
			return;
		Calendar c = Calendar.getInstance();
		try {
			String[] arr = time.split(":");
			int hour = Integer.parseInt(arr[0]);
			int minus = Integer.parseInt(arr[1]);
			int second = Integer.parseInt(arr[2]);
			c.set(Calendar.HOUR_OF_DAY, hour);
			c.set(Calendar.MINUTE, minus);
			c.set(Calendar.SECOND, second);
			expireTime = c.getTime();
		} catch (Exception e) {
			expireTime = null;
		}
	}

	public List<Integer> getListResourceId() {
		return listResourceId;
	}

	public void setListResourceId(List<Integer> listResourceId) {
		this.listResourceId = listResourceId;
	}

	@Override
	public String toString() {
		return "Users{" +
				"userId=" + userId +
				", fullName='" + fullName + '\'' +
				", mobile='" + mobile + '\'' +
				", dpId=" + dpId +
				", email='" + email + '\'' +
				", statusId=" + statusId +
				", userType=" + userType +
				", expireTime=" + expireTime +
				'}';
	}

}
