package cw;

import java.util.*;

public class Q4CPUScheduler {
    public static void main(String[] args) {
        
        // Creating the jobs
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 0, 10));
        jobs.add(new Job(2, 0, 5));

        // Policy selector
        setPolicy(Policy.HP);

        // Running the Code
        int time = 0;
        while (!jobs.isEmpty()) {
            Job currentJob = getJob(jobs);
            currentJob.run();
            currentJob.decrementDuration(); // Decrements Duration of Current job
            time++; // Increamtes the time
            if (currentJob.getDuration() == 0) { // Checks if the current job is done
                jobs.remove(currentJob);
            }
            System.out.println("System time [" + time + "] - job " + currentJob.getId() + " is running");
        }
    }

    
    private static class Job {
        private int id;
        private int priority;
        private int duration;
        
        // Constructor
        public Job(int id, int priority, int duration) {
            this.id = id;
            this.priority = priority;
            this.duration = duration;
        }
        
        // Getter Functions
        public int getId() {
            return id;
        }

        public int getPriority() {
            return priority;
        }

        public int getDuration() {
            return duration;
        }

        public void decrementDuration() {
            duration--;
        }

        public void run() {
            
        }
    }

    // Scheduling Policy
    private enum Policy {FCFS, HP, SRTF}
    private static Policy policy;

    
    private static void setPolicy(Policy p) {
        policy = p;
    }

    // Gets the next job based on the selected scheduling Policy
    private static Job getJob(List<Job> jobs) {
        if (policy == Policy.FCFS) {
            return jobs.get(0);
        } else if (policy == Policy.HP) {
            Job highestPriorityJob = jobs.get(0);
            for (Job job : jobs) {
                if (job.getPriority() > highestPriorityJob.getPriority()) {
                    highestPriorityJob = job;
                }
            }
            return highestPriorityJob;
        } else {
            
            Job shortestJob = jobs.get(0);
            for (Job job : jobs) {
                if (job.getDuration() < shortestJob.getDuration()) {
                    shortestJob = job;
                }
            }
            return shortestJob;
        }
    }
}
