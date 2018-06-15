package com.bootgo.system.service.impl;

import com.bootgo.system.dao.MenuDao;
import com.bootgo.system.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: bootgo
 * @description:
 * @author: wz大宇宙
 * @create: 2018-06-15 09:49
 **/

public class MenuServiceImpl implements MenuService{
    @Autowired
    MenuDao menuMapper;
    @Override
    public Set<String> listPerms(Long userId) {
        List<String> perms = menuMapper.listUserPerms(userId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (StringUtils.isNotBlank(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }
}
    
    
    