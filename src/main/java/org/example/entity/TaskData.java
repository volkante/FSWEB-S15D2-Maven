package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    Set<Task> annsTasks;
    Set<Task> bobsTasks;
    Set<Task> carolsTasks;
    Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String assignee){
        switch(assignee.toLowerCase()){
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks);
            default:
                throw new IllegalArgumentException("Invalid assignee name.");
        }
    }

    public Set<Task> getUnassignedTasks(){
        return unassignedTasks;
    }


    public final Set<Task> getUnion(Set<Task>... sets){
        Set<Task> unionSet = new HashSet<>();
        for(Set<Task> set:sets){
            unionSet.addAll(set);
        }
        return unionSet;
    }


    public Set<Task> getIntersection(Set<Task> task1, Set<Task> task2){
        Set<Task> task1Copy = new HashSet<>(task1);
        task1Copy.retainAll(task2);
        return task1Copy;
    }

    public Set<Task> getDifference(Set<Task> task1, Set<Task> task2){
        Set<Task> task1copy = new HashSet<>(task1);
        task1copy.removeAll(task2);
        return task1copy;
    }




}
