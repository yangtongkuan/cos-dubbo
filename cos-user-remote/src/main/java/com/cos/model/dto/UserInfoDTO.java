package com.cos.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @desc: 用户远程发送信息
 * @User: @Created by yangtk
 * @Date: @Date 2019/10/10 18:01
 * @Classname: UserInfoDTO
 * @To change this template use File | Settings | File Templates.
 */
@Data
@Accessors(chain = true)
public class UserInfoDTO implements Serializable {

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

}
