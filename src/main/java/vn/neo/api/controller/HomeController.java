package vn.neo.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.neo.api.entity.primary.UserInfo;
import vn.neo.api.mapper.primary.UserInfoMapper;

@RestController
@RequestMapping("/")
public class HomeController {
	private UserInfoMapper userInfoMapper;
	
	public HomeController(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}
	
	@GetMapping("/authenticate")
	public UserInfo getData() {
		
		return userInfoMapper.findByUsername("admin");
	}

}
