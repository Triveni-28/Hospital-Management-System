package com.mediqueue.hospitalapp;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AppointmentScheduler {
    private PriorityQueue<Patient> queue;

    public AppointmentScheduler(List<Patient> patients) {
        // Sort by emergencyLevel ASCENDING (1 = most critical),
        // and then by arrivalTime ASCENDING (earlier patients get priority)
        queue = new PriorityQueue<>((p1, p2) -> {
            if (p1.emergencyLevel != p2.emergencyLevel) {
                return Integer.compare(p1.emergencyLevel, p2.emergencyLevel);  // Lower emergencyLevel = higher priority
            } else {
                return Long.compare(p1.arrivalTime, p2.arrivalTime);  // Earlier time gets priority
            }
        });

        queue.addAll(patients);
    }

    public List<Patient> getScheduledPatients() {
        List<Patient> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
}

