package com.flash.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.flash.common.model.PageResultDto;
import com.flash.common.validator.group.ValidationGroup1;
import com.flash.dto.BaseResult;
import com.flash.dto.req.ReqUserGroupDto;
import com.flash.dto.req.ReqUserQueryDto;
import com.flash.entity.User;
import com.flash.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LiLiang
 * @Date: 2019/11/19 15:58
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "save", method = RequestMethod.POST)
    public BaseResult save(@RequestBody @Validated(value = {ValidationGroup1.class}) ReqUserGroupDto reqUserDto,
                               BindingResult result) {
        if(result != null && result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                return BaseResult.buildTipErrorResult(error.getDefaultMessage());
            }
        }
        User user = new User();
        BeanUtils.copyProperties(reqUserDto, user);
        userService.save(user);

        return BaseResult.buildSuccessResult(user);
    }

    @RequestMapping(value = "pageList", method = RequestMethod.POST)
    public BaseResult pageList(@RequestBody @Validated ReqUserQueryDto reqUserDto,
                           BindingResult result) {
        if(result != null && result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                return BaseResult.buildTipErrorResult(error.getDefaultMessage());
            }
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age",reqUserDto.getAge());
        wrapper.orderBy(true, reqUserDto.isAsc(), reqUserDto.getOrder());

        IPage page = userService.page(reqUserDto.getPage(), wrapper);

        return BaseResult.buildSuccessResult(new PageResultDto(page.getTotal(),
                page.getPages(), page.getSize(), page.getRecords()));
    }


}
