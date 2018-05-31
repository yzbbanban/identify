package com.yzbbanban.identify.service;

import com.yzbbanban.identify.common.ServerResponse;

/**
 * Created by brander on 2018/5/31
 */
public interface IUserService {
    ServerResponse login(String username, String password);
}
