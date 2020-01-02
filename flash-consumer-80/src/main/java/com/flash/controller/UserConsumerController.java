package com.flash.controller;

import com.flash.common.dto.BaseResult;
import com.flash.common.dto.req.ReqUserGroupDto;
import com.flash.common.validator.group.ValidationGroup1;
import com.flash.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: LiLiang
 * @Date: 2020/1/2 16:23
 */
@RestController
@RequestMapping(value = "/consumer/user")
public class UserConsumerController {

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 添加用户-服务消费者
     * @param reqUserDto
     * @param result
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody @Validated(value = {ValidationGroup1.class}) ReqUserGroupDto reqUserDto,
                           BindingResult result) {
        if(result != null && result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                return BaseResult.buildTipErrorResult(error.getDefaultMessage());
            }
        }
        User user = new User();
        BeanUtils.copyProperties(reqUserDto, user);

        User user2 = restTemplate.postForObject(REST_URL_PREFIX + "/user/add", user, User.class);
        return BaseResult.buildSuccessResult(user2);
    }



}
