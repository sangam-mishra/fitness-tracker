package com.fitness.activityService.service;

import com.fitness.activityService.ActivityRepository;
import com.fitness.activityService.dto.ActivityRequest;
import com.fitness.activityService.dto.ActivityResponse;
import com.fitness.activityService.model.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository repository;
    public ActivityResponse getActivity(String activityId) {
        Activity activity = repository.findById(activityId).orElseThrow(()->new RuntimeException("Actvity for the user not found"));

        ActivityResponse fetchedActivity= mapToResponse(activity);

        return fetchedActivity;
    }

    public ActivityResponse trackActivity(ActivityRequest request) {
        Activity activity=Activity.builder()
                .UserId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalInfo(request.getAdditionalInfo())
                .build();

        Activity savedActivity= repository.save(activity);
        ActivityResponse response= mapToResponse(savedActivity);
        return response;
    }

    private ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setType(activity.getType());
        response.setUserId(activity.getUserId());
        response.setCreatedAt(activity.getCreatedAt());
        response.setAdditionalInfo(activity.getAdditionalInfo());

        return response;
    }
}
