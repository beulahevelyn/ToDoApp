package com.example.UserService.domain;

import java.util.Date;

public class StarredTasks {

    private Integer taskid;
    private String taskname;
    private String assignee;
    private Date duedate;
    private String priority;
    private String status;
    private String comments;
    private Boolean starred;

    public StarredTasks(){}

    public StarredTasks(Integer taskid, String taskname, String assignee, Date duedate, String priority, String status, String comments, Boolean starred) {
        this.taskid = taskid;
        this.taskname = taskname;
        this.assignee = assignee;
        this.duedate = duedate;
        this.priority = priority;
        this.status = status;
        this.comments = comments;
        this.starred = starred;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getStarred() {
        return starred;
    }

    public void setStarred(Boolean starred) {
        this.starred = starred;
    }

    @Override
    public String toString() {
        return "StarredTasks{" +
                "taskid=" + taskid +
                ", taskname='" + taskname + '\'' +
                ", assignee='" + assignee + '\'' +
                ", duedate=" + duedate +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", starred=" + starred +
                '}';
    }
}
