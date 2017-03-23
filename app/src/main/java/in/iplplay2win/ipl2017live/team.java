package in.iplplay2win.ipl2017live;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import in.iplplay2win.ipl2017live.utils.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

        teamsRV = (RecyclerView) findViewById(R.id.teamRV);
        teamList = new ArrayList<>();
        load_team_from_server(0);

        teamsRV.setLayoutManager(TeamLinear);
        teamAdapter = new TeamAdapter(context,teamList);
        teamsRV.setAdapter(teamAdapter);
        teamsRV.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if (TeamLinear.findLastCompletelyVisibleItemPosition()==teamList.size()-1){
                    load_team_from_server(teamList.get(teamList.size()-1).getTeamID());
                }
            }
        });
    }

    private void load_team_from_server(int teamid) {
    }

}
