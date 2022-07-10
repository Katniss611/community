package com.tangerine.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AlphaDaoMybatislmpl implements AlphaDao{
    @Override
    public String select() {
        return "MyBatis";
    }
}
