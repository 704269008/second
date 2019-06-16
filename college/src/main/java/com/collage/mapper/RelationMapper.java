package com.collage.mapper;

import com.collage.pojo.Relation;
import org.springframework.stereotype.Component;

@Component
public interface RelationMapper {
    void insertRelation(Relation relation);
}
