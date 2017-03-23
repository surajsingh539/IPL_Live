package in.iplplay2win.ipl2017live.utils;

/**
 * Created by Anand on 23-03-2017.
 */

public class team_L {

    private int TeamID;
    private String teamshort,teamlogo, team_full;

    public team_L(int TeamID, String teamshort, String teamlogo, String team) {
        this.TeamID = TeamID;
        this.teamshort = teamshort;
        this.teamlogo = teamlogo;
        this.team_full = team;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        this.TeamID = TeamID;
    }


    public String getteamshort() {
        return teamshort;
    }

    public void setteamshort(String teamshort) {
        this.teamshort = teamshort;
    }

    public String getteamlogo() {
        return teamlogo;
    }

    public void setteamlogo(String teamlogo) {
        this.teamlogo = teamlogo;
    }

    public String getteam_full() {
        return team_full;
    }

    public void setteam(String team_full) {
        this.team_full = team_full;
    }
}
