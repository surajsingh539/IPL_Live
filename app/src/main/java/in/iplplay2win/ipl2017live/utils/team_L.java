package in.iplplay2win.ipl2017live.utils;

/**
 * Created by Anand on 23-03-2017.
 */

public class team_L {

    private int TeamID;
    private String Teamshort, Team_full,Teamlogo;

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public String getTeamshort() {
        return Teamshort;
    }

    public void setTeamshort(String teamshort) {
        Teamshort = teamshort;
    }

    public String getTeam_full() {
        return Team_full;
    }

    public void setTeam_full(String team_full) {
        Team_full = team_full;
    }

    public String getTeamlogo() {
        return Teamlogo;
    }

    public void setTeamlogo(String teamlogo) {
        Teamlogo = teamlogo;
    }

    public team_L(int teamID, String teamshort, String team_full, String teamlogo) {
        TeamID = teamID;
        Teamshort = teamshort;
        Team_full = team_full;
        Teamlogo = teamlogo;
    }
}

