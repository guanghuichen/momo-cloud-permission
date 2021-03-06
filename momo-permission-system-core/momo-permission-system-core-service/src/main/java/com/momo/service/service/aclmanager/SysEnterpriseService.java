/**
 * Copyright (c) 2018-2019, Jie Li 李杰 (mqgnsds@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.momo.service.service.aclmanager;

import com.github.pagehelper.PageInfo;
import com.momo.mapper.dataobject.RoleDO;
import com.momo.mapper.dataobject.UserDO;
import com.momo.mapper.dataobject.UserGroupDO;
import com.momo.mapper.req.aclmanager.SysEnterpriseRoleReq;
import com.momo.mapper.req.aclmanager.SysEnterpriseUserReq;
import com.momo.mapper.req.aclmanager.SysUserGroupReq;
import com.momo.mapper.req.aclmanager.UserGroupPageReq;
import com.momo.mapper.req.authority.BatchRoleUserReq;
import com.momo.mapper.res.aclmanager.SysEnterpriseRoleRes;
import com.momo.mapper.res.aclmanager.SysRoleCheckedRes;
import com.momo.mapper.res.aclmanager.SysUserGroupPageRes;
import com.momo.mapper.res.aclmanager.SysUserListRes;
import com.momo.mapper.res.authority.AclTreeRes;

/**
 * @program: momo-cloud-permission
 * @description: 企业管理
 * @author: Jie Li
 * @create: 2019-08-06 13:04
 **/
public interface SysEnterpriseService {
    //企业分页
    public PageInfo<SysUserGroupPageRes> getUserGroupPage(UserGroupPageReq userGroupPageReq);

    UserGroupDO detail(UserGroupPageReq userGroupPageReq);

    AclTreeRes aclDetail(UserGroupPageReq userGroupPageReq);

    String aclsToEnterprise(UserGroupPageReq userGroupPageReq);

    String modify(SysUserGroupReq sysUserGroupReq);

    String save(SysUserGroupReq sysUserGroupReq);

    String status(SysUserGroupReq sysUserGroupReq);

    //########################      企业角色相关      #################################

    SysEnterpriseRoleRes roleList(SysEnterpriseRoleReq sysEnterpriseRoleReq);

    String roleAdd(SysEnterpriseRoleReq sysEnterpriseRoleReq);

    String roleStatus(SysEnterpriseRoleReq sysEnterpriseRoleReq);

    RoleDO roleDetail(SysEnterpriseRoleReq sysEnterpriseRoleReq);

    String roleModify(SysEnterpriseRoleReq sysEnterpriseRoleReq);

    AclTreeRes roleHaveAclTree(SysEnterpriseRoleReq sysEnterpriseRoleReq);

    String aclsToRole(BatchRoleUserReq batchRoleUserReq);

    //########################      企业用户相关      #################################

    SysUserListRes userList(SysEnterpriseUserReq sysEnterpriseUserReq);

    String userAdd(SysEnterpriseUserReq sysEnterpriseUserReq);

    UserDO userDetail(SysEnterpriseUserReq sysEnterpriseUserReq);

    String userModify(SysEnterpriseUserReq sysEnterpriseUserReq);

    SysRoleCheckedRes userCheckRoles(SysEnterpriseUserReq sysEnterpriseUserReq);

    String rolesToUser(SysEnterpriseUserReq sysEnterpriseUserReq);

    String userStatus(SysEnterpriseUserReq sysEnterpriseUserReq);

    String sysUserPwd(SysEnterpriseUserReq sysEnterpriseUserReq);

}
