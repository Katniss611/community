package com.tangerine.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alphaHibernate")
public class AlphaDaoHibernatelmpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
