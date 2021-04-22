package com.springboot.tightoil.demo;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Assignment_8_2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Calculate the entry level of each course, how many courses you have to take before you learn it
        int[] indegree = new int[numCourses];
        // Calculate which courses are the pre-courses for each course
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) list.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            list.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // Anyone with a score of 0 joins the team
            if (indegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            // Finish a course with an entry degree of 0
            int cur = queue.poll();
            numCourses--;
            // If you're dealing with the post-course of this course, they're all going to be minus 1
            List<Integer> curList = list.get(cur);
            for (int num : curList) {
                indegree[num]--;
                // After the course entry degree reduced to 0, also join the team
                if (indegree[num] == 0) queue.add(num);
            }
        }
        return numCourses == 0;
    }
}
