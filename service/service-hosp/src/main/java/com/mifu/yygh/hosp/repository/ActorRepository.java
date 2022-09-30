package com.mifu.yygh.hosp.repository;

import com.mifu.yygh.hosp.bean.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 操作mongodb的
 */
public interface ActorRepository extends MongoRepository<Actor, String> {

    public List<Actor> findByActorNameLikeAndGender(String name, Boolean gender);
}
