package com.jsy.cn.dao;

import com.jsy.cn.entity.User;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TUSER
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long pkid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TUSER
     *
     * @mbggenerated
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TUSER
     *
     * @mbggenerated
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TUSER
     *
     * @mbggenerated
     */
    User selectByPrimaryKey(Long pkid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TUSER
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TUSER
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(User record);
}