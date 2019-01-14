package com.schoolhepler.dao.impl;

import com.schoolhepler.model.Junk;
import org.springframework.stereotype.Repository;


@Repository
public class JunkDao extends BaseDaoImpl<Junk> {
    public JunkDao() {
        super.table="Junk";
    }

}
