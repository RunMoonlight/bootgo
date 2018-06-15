package com.bootgo.system.service;

import java.util.Set;

public interface MenuService {
    Set<String> listPerms(Long userId);
}
