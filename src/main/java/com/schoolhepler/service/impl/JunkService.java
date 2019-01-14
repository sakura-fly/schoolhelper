package com.schoolhepler.service.impl;

import com.schoolhepler.dao.impl.JunkDao;
import com.schoolhepler.model.Junk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JunkService extends BaseServiceImpl<Junk> {


    private JunkDao junkDao;

    @Autowired
    public JunkService(JunkDao junkDao) {
        super.dao = junkDao;
        this.junkDao = junkDao;
    }
}
