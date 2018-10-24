package com.jns.mapper;

import com.jns.entity.Manager;

import java.util.List;

public interface ManagerMapper {
    int add(Manager manager);
    int delete(String name);
    int update(Manager manager);
    Manager get(String name);
    List<Manager> managerList();
}
