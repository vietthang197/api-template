package vn.neo.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.neo.api.dto.UserInfoDto;
import vn.neo.api.jwt.Users;
import vn.neo.api.mapper.primary.UserInfoMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfoDto userInfo = userInfoMapper.findUserOperationByUsername(username);
		if (userInfo == null)
			throw new UsernameNotFoundException("User does not exists");
		return new Users(userInfo.getUsername(), userInfo.getPassword(), true, true, true, true, userInfo.getAuthorities());
	}

}
