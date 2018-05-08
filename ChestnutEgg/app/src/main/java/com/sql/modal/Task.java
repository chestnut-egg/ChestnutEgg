<<<<<<< HEAD
package com.sql.modal;

import org.litepal.crud.DataSupport;

/**
 * Created by dan on 2018/4/18.
 */
public class Task extends DataSupport {

    private int id;
    private String task_title;
    private String task_content;
    private String task_year;
    private String task_month;
    private String task_day;
    private String task_hour;
    private String task_minute;

    private int isshow;

    public Task(){

    }


    public Task(String task_title, String task_content, String task_year, String task_month, String task_day, String task_hour, String task_minute,int isshow) {
        this.task_title = task_title;
        this.task_content = task_content;
        this.task_year = task_year;
        this.task_month = task_month;
        this.task_day = task_day;
        this.task_hour = task_hour;
        this.task_minute = task_minute;
        this.isshow = isshow;
    }

    public int getIsshow() {
        return isshow;
    }

    public void setIsshow(int isshow) {
        this.isshow = isshow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_title() {
        return task_title;
    }

    public void setTask_title(String task_title) {
        this.task_title = task_title;
    }

    public String getTask_content() {
        return task_content;
    }

    public void setTask_content(String task_content) {
        this.task_content = task_content;
    }

    public String getTask_year() {
        return task_year;
    }

    public void setTask_year(String task_year) {
        this.task_year = task_year;
    }

    public String getTask_month() {
        return task_month;
    }

    public void setTask_month(String task_month) {
        this.task_month = task_month;
    }

    public String getTask_day() {
        return task_day;
    }

    public void setTask_day(String task_day) {
        this.task_day = task_day;
    }

    public String getTask_hour() {
        return task_hour;
    }

    public void setTask_hour(String task_hour) {
        this.task_hour = task_hour;
    }

    public String getTask_minute() {
        return task_minute;
    }

    public void setTask_minute(String task_minute) {
        this.task_minute = task_minute;
    }
}
=======
package com.sql.modal;

import org.litepal.crud.DataSupport;

/**
 * Created by dan on 2018/4/18.
 */
public class Task extends DataSupport {

    private int id;
    private String task_title;
    private String task_content;
    private String task_year;
    private String task_month;
    private String task_day;
    private String task_hour;
    private String task_minute;

    private int isshow;

    public Task(){

    }


    public Task(String task_title, String task_content, String task_year, String task_month, String task_day, String task_hour, String task_minute,int isshow) {
        this.task_title = task_title;
        this.task_content = task_content;
        this.task_year = task_year;
        this.task_month = task_month;
        this.task_day = task_day;
        this.task_hour = task_hour;
        this.task_minute = task_minute;
        this.isshow = isshow;
    }

    public int getIsshow() {
        return isshow;
    }

    public void setIsshow(int isshow) {
        this.isshow = isshow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_title() {
        return task_title;
    }

    public void setTask_title(String task_title) {
        this.task_title = task_title;
    }

    public String getTask_content() {
        return task_content;
    }

    public void setTask_content(String task_content) {
        this.task_content = task_content;
    }

    public String getTask_year() {
        return task_year;
    }

    public void setTask_year(String task_year) {
        this.task_year = task_year;
    }

    public String getTask_month() {
        return task_month;
    }

    public void setTask_month(String task_month) {
        this.task_month = task_month;
    }

    public String getTask_day() {
        return task_day;
    }

    public void setTask_day(String task_day) {
        this.task_day = task_day;
    }

    public String getTask_hour() {
        return task_hour;
    }

    public void setTask_hour(String task_hour) {
        this.task_hour = task_hour;
    }

    public String getTask_minute() {
        return task_minute;
    }

    public void setTask_minute(String task_minute) {
        this.task_minute = task_minute;
    }
}
>>>>>>> 增加图片识别功能
