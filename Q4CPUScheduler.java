package cw;

import java.util.*;

public class Q4CPUScheduler {
    public static void main(String[] args) {
        
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 0, 10));
        jobs.add(new Job(2, 0, 5));

        
        setPolicy(Policy.HP);

        
        int time = 0;
        while (!jobs.isEmpty()) {
            Job currentJob = getJob(jobs);
            currentJob.run();
            currentJob.decrementDuration();
            time++;
            if (currentJob.getDuration() == 0) {
                jobs.remove(currentJob);
            }
            System.out.println("System time [" + time + "] - job " + currentJob.getId() + " is running");
        }
    }

    
    private static class Job {
        private int id;
        private int priority;
        private int duration;

        public Job(int id, int priority, int duration) {
            this.id = id;
            this.priority = priority;
            this.duration = duration;
        }

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

    
    private enum Policy {FCFS, HP, SRTF}
    private static Policy policy;

    
    private static void setPolicy(Policy p) {
        policy = p;
    }

    
    private static Job getJob(List<Job> jobs) {
        if (policy == Policy.FCFS) {
            return jobs.get(0);
        } else if (policy == Policy.HP) {
            // Find the job with the highest priority
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
