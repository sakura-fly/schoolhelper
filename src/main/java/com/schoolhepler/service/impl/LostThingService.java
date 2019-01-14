package com.schoolhepler.service.impl;

import com.schoolhepler.dao.impl.LostThingDao;
import com.schoolhepler.model.LostThing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LostThingService extends BaseServiceImpl<LostThing> {

    private
    LostThingDao lostThingDao;

    @Autowired
    public LostThingService(LostThingDao lostThingDao) {
        super.dao = lostThingDao;
        this.lostThingDao = lostThingDao;
    }
}
