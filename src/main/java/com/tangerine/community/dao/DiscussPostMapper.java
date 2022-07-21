package com.tangerine.community.dao;

import com.tangerine.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // @Param用于给参数取别名，若只有一个参数且动态使用(在<if>里使用)则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);

    // 发布帖子
    int insertDiscussPost(DiscussPost discussPost);

    // 查找帖子
    DiscussPost selectDiscussPostById(int id);



}
