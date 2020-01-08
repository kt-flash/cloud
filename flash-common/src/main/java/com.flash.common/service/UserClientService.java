package com.flash.common.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flash.common.dto.req.ReqUserQueryDto;
import com.flash.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: LiLiang
 * @Date: 2020/1/7 13:58
 */
@FeignClient(value = "FLASH-PROVIDER",fallbackFactory = UserClientServiceFallbackFactory.class)
@RequestMapping(value = "user")
public interface UserClientService {

    @RequestMapping(value = "add", method = RequestMethod.POST)
    User add(@RequestBody User user);

    @RequestMapping(value = "pageList", method = RequestMethod.POST)
    Page pageList(@RequestBody @Validated ReqUserQueryDto reqUserDto);

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    User get(@PathVariable("id") String id);
}
