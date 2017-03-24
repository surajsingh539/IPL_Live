package in.iplplay2win.ipl2017live;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import in.iplplay2win.ipl2017live.utils.*;

public class team extends AppCompatActivity {
    Context context;

    RecyclerView teamsRV;
    List<team_L> teamList;
    TeamAdapter teamAdapter;
    LinearLayoutManager TeamLinear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent= getIntent();
        String select_title = intent.getStringExtra("Select Title");
        toolbar.setTitle(select_title);
//        teamsRV = (RecyclerView) findViewById(R.id.teamRV);
//        teamList = new ArrayList<>();
//        load_team_from_server(0);
//
//        teamsRV.setLayoutManager(TeamLinear);
//        teamAdapter = new TeamAdapter(context,R.layout.teamcard,teamList);
//        teamsRV.setAdapter(teamAdapter);
//        teamsRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//
//                if (TeamLinear.findLastCompletelyVisibleItemPosition()==teamList.size()-1){
//                    load_team_from_server(teamList.get(teamList.size()-1).getTeamID());
//                }
//            }
//        });
    }

//    private void load_team_from_server(int team__id) {
//
//
//        AsyncTask<String,String,List<team_L>> task = new AsyncTask<String, String, List<team_L>>() {
//            @Override
//            protected List<team_L> doInBackground(String... params) {
//
//                OkHttpClient teamlistclient = new OkHttpClient();
//                Request request = new Request.Builder()
//                        .url(Urls.URL_TEAM)
//                        .build();
//                try {
//                    Response response = teamlistclient.newCall(request).execute();
//                    Log.e("Response", "doInBackground: "+response );
//
//                    JSONObject schedule_list_array = new JSONObject(response.body().string());
//                    JSONArray tobject = schedule_list_array.getJSONArray("teams");
//
//                    List<team_L> teamLList = new ArrayList<>();
//
//                    for (int i=0; i<tobject.length(); i++){
//                        JSONObject object = tobject.getJSONObject(i);
//
//                       // team_L team_l= new team_L();
//                        String teamsname = object.getString("full_name");
//                        String teams_short = object.getString("short_name");
//                        String teamlogo = object.getString("logo");
//                        int teamid = object.getInt("teamid");
//
//                        team_L team_l = new team_L(teamid,teamsname, teams_short,teamlogo);
//
//                        team_l.setTeam_full(teamsname);
//                        team_l.setTeamshort(teams_short);
//                        team_l.setTeamlogo(teamlogo);
//
//                        Log.i("teamkalist_teamid", String.valueOf((teamid)));
//                        Log.i("teamkalist_short",teams_short);
//                        Log.i("teamkalist_logo",teamlogo);
//                        Log.i("teamkalist_name",teamsname);
//
//                        teamLList.add(team_l);
//
//                    }
//                    return teamLList;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    // Log.e("JSONSChedule Error", "doInBackground:"+e+""+SID +teamslogo,teamShort,sdays,dates,stime,svenue+"" );
//                }
//                return null;
//
//            }
//
//            @Override
//            protected void onPostExecute(List<team_L> result) {
//                super.onPostExecute(result);
//
//                TeamAdapter teamAdapter= new TeamAdapter(getApplicationContext(),R.layout.teamcard,result);
//                teamsRV.setAdapter(teamAdapter);
//            }
//        };
//
//
//        task.execute(String.valueOf(team__id));
//    }

}
