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
package com.momo.momopermissionsystemcoreweb.controller.authority;

import com.momo.common.core.common.JSONResult;
import com.momo.mapper.req.authority.AclReq;
import com.momo.service.service.authority.AclService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: momo-cloud-permission
 * @description: 权限设置
 * @author: Jie Li
 * @create: 2019-07-31 13:52
 **/
@RestController
@RequestMapping(value = "/platform/acl", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
@Slf4j
public class AclController {
    @Autowired
    private AclService aclService;

    @RequestMapping("/aclTree/v1")
    public JSONResult aclTree() {
        return JSONResult.ok(aclService.aclTree());
    }

    @RequestMapping("/aclsToRedis/v1")
    public JSONResult aclsToRedis() {
        return JSONResult.ok(aclService.aclsToRedis());
    }

    @RequestMapping("/userToRolesToAcls/v1")
    public JSONResult userToRolesToAcls() {
        return JSONResult.ok(aclService.userToRolesToAcls());
    }

    @RequestMapping("/save/v1")
    public JSONResult save(@Validated(AclReq.Save.class) @RequestBody AclReq aclReq) {
        return JSONResult.ok(aclService.insertSelective(aclReq));
    }

    @RequestMapping("/saveSys/v1")
    public JSONResult saveSys(@Validated(AclReq.Permission.class) @RequestBody AclReq aclReq) {
        return JSONResult.ok(aclService.saveSys(aclReq));
    }

    @RequestMapping("/modify/v1")
    public JSONResult modify(@Validated(AclReq.Modify.class) @RequestBody AclReq aclReq) {
        return JSONResult.ok(aclService.updateByPrimaryKeySelective(aclReq));
    }

    @RequestMapping("/status/v1")
    public JSONResult status(@Validated(AclReq.Status.class) @RequestBody AclReq aclReq) {
        return JSONResult.ok(aclService.updateStatus(aclReq));
    }

    @RequestMapping("/detail/v1")
    public JSONResult showAclSysCode(@Validated(AclReq.Detail.class) @RequestBody AclReq aclReq) {
        return JSONResult.ok(aclService.detail(aclReq));
    }
}
