package vn.neo.api.mapper.primary;

import org.apache.ibatis.annotations.*;

import vn.neo.api.dto.UserInfoDto;
import vn.neo.api.entity.primary.UserInfo;
import vn.neo.api.entity.primary.UserInfoExample;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface UserInfoMapper {
    long countByExample(UserInfoExample example);
    int deleteByExample(UserInfoExample example);
    int deleteByPrimaryKey(BigDecimal userId);
    int insert(UserInfo record);
    int insertSelective(UserInfo record);
    List<UserInfo> selectByExample(UserInfoExample example);
    UserInfo selectByPrimaryKey(BigDecimal userId);
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);
    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);
    int updateByPrimaryKeySelective(UserInfo record);
    int updateByPrimaryKey(UserInfo record);
    @Select(value = "SELECT * FROM USER_INFO WHERE username = #{username}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "lastModifiedBy", column = "last_modified_by"),
            @Result(property = "lastModifiedDate", column = "last_modified_date"),
            @Result(property = "createdBy", column = "created_by"),
            @Result(property = "createdDate", column = "created_date")
    })
    UserInfo findByUsername(String username);
    
    UserInfoDto findUserOperationByUsername(@Param("username") String username);
}
