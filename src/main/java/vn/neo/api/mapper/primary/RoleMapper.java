package vn.neo.api.mapper.primary;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import vn.neo.api.entity.primary.Role;
import vn.neo.api.entity.primary.RoleExample;

@Mapper
public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE.ROLE
     *
     * @mbg.generated Wed Nov 17 22:07:29 ICT 2021
     */
    long countByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE.ROLE
     *
     * @mbg.generated Wed Nov 17 22:07:29 ICT 2021
     */
    int deleteByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE.ROLE
     *
     * @mbg.generated Wed Nov 17 22:07:29 ICT 2021
     */
    int deleteByPrimaryKey(BigDecimal roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE.ROLE
     *
     * @mbg.generated Wed Nov 17 22:07:29 ICT 2021
     */
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE.ROLE
     *
     * @mbg.generated Wed Nov 17 22:07:29 ICT 2021
     */
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE.ROLE
     *
     * @mbg.generated Wed Nov 17 22:07:29 ICT 2021
     */
    List<Role> selectByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE.ROLE
     *
     * @mbg.generated Wed Nov 17 22:07:29 ICT 2021
     */
    Role selectByPrimaryKey(BigDecimal roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE.ROLE
     *
     * @mbg.generated Wed Nov 17 22:07:29 ICT 2021
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE.ROLE
     *
     * @mbg.generated Wed Nov 17 22:07:29 ICT 2021
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE.ROLE
     *
     * @mbg.generated Wed Nov 17 22:07:29 ICT 2021
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FURNITURE.ROLE
     *
     * @mbg.generated Wed Nov 17 22:07:29 ICT 2021
     */
    int updateByPrimaryKey(Role record);
}