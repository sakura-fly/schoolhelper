package com.schoolhepler.dao.impl;

import com.schoolhepler.model.LostThing;
import org.springframework.stereotype.Repository;

@Repository
public class LostThingDao extends BaseDaoImpl<LostThing> {
    public LostThingDao() {
        super.table = "LostThing";
    }
}
