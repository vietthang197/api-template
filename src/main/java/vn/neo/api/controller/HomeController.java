package vn.neo.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.neo.api.dto.UserInfoDto;
import vn.neo.api.entity.primary.UserInfo;
import vn.neo.api.mapper.primary.UserInfoMapper;

@RestController
@RequestMapping("/")
public class HomeController {
	private Logger logger = LogManager.getLogger();
	private UserInfoMapper userInfoMapper;
	
	public HomeController(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}
	
	@GetMapping("/authenticate")
	public UserInfoDto getData() {
		UserInfoDto response = userInfoMapper.findUserOperationByUsername("admin");
		return response;
	}

}
