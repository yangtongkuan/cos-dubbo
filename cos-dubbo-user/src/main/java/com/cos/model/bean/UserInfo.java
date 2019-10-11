package com.cos.model.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/10/11 13:16
 * @Classname: UserInfo
 * @To change this template use File | Settings | File Templates.
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "t_user_info")
public class UserInfo implements Serializable {
    @Id
    private Long id;                // 用户id标识
    private String sysCustomer;     // 租户标识
    private Integer userRole;       // 用户角色
    private String username;        // 登录帐号
    private String name;            // 姓名
    private String signPhoto;       // 用户头像
    private String signature;       // 个性签名
    private String phone;           // 电话号
    private String sex;             // 性别（boy/girl）
    private String prov;            // 省份
    private String city;            // 市区
    private String county;          // 区县
    private String address;         // 详细地址
    private String note;            // 备注
    private Integer isLock;         // 是否锁定状态
    private Integer delFlag;        // 是否已删除(0未删除,1已删除)
    private Date createTime;        // 创建时间
    private String createUser;      // 创建者
    private Date updateTime;        // 更新时间
    private String updateUser;      // 更新者
}
