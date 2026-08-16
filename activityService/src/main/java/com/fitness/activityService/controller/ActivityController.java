package com.fitness.activityService.controller;


import com.fitness.activityService.dto.ActivityResponse;
import com.fitness.activityService.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("samfirst/activities")
@AllArgsConstructor
public class ActivityController {

    private ActivityService activityService;

    @GetMapping("/{activityID}")
    public ResponseEntity<ActivityResponse> getActivity(@PathVariable String activityId){
        return ResponseEntity.ok(activityService.getActivity(activityId));
    }
}
