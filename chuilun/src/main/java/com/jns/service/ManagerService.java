package com.jns.service;

import com.jns.entity.Manager;

import java.util.List;

public interface ManagerService {
    int add(Manager manager);
    int delete(String name);
    int update(Manager manager);
    Manager get(String name);
    List<Manager> managerList();
}
