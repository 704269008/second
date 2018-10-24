package com.jns.service.impl;

import com.jns.entity.Manager;
import com.jns.mapper.ManagerMapper;
import com.jns.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerMapper managerMapper;
    @Override
    public int add(Manager manager) {
        return managerMapper.add(manager);
    }

    @Override
    public int delete(String name) {
        return managerMapper.delete(name);
    }

    @Override
    public int update(Manager manager) {
        return managerMapper.update(manager);
    }

    @Override
    public Manager get(String name) {
        return managerMapper.get(name);
    }

    @Override
    public List<Manager> managerList() {
        return managerMapper.managerList();
    }
}
