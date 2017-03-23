package in.iplplay2win.ipl2017live.utils;

import org.json.JSONArray;

/**
 * Created by Anand on 23-03-2017.
 */

public class ScheduleList {

    private int scheduleid;
//    private JSONArray teams;
    private String day,date, time,place;
//Constructor


    public ScheduleList(int scheduleid, String day, String date, String time, String place) {
        this.scheduleid = scheduleid;
//        this.teams= teams;
        this.day = day;
        this.date = date;
        this.time = time;
        this.place = place;

    }
//Getter and Setter

    public int getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(int scheduleid) {
        this.scheduleid = scheduleid;
    }
//
//    public JSONArray getTeams() {
//        return teams;
//    }
//
//    public void setTeams(JSONArray teams) {
//        this.teams = teams;
//    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
