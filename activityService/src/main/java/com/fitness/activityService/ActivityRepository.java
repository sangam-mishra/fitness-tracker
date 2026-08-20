package com.fitness.activityService;

import com.fitness.activityService.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityRepository extends MongoRepository<Activity,String> {

}
