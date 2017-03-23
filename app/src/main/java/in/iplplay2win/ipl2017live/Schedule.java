package in.iplplay2win.ipl2017live;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import in.iplplay2win.ipl2017live.utils.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Schedule extends AppCompatActivity {
    Context context;

      RecyclerView scheduleview;
      CustomAdapter scheduleAdapter;
      LinearLayoutManager linearlayout;
      List<ScheduleList> scheduleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        scheduleview= (RecyclerView) findViewById(R.id.schedule_rv);
        scheduleList = new ArrayList<>();
        load_schedule_from_server(0);

        scheduleview.setLayoutManager(linearlayout);
        scheduleAdapter = new CustomAdapter(context,scheduleList);
        scheduleview.setAdapter(scheduleAdapter);
        scheduleview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if (linearlayout.findLastCompletelyVisibleItemPosition()==scheduleList.size()-1){
                    load_schedule_from_server(scheduleList.get(scheduleList.size()-1).getScheduleid());
                }
            }
        });
    }

    private void load_schedule_from_server(int id) {

        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... params) {

                OkHttpClient scheduleclient = new OkHttpClient();
                Request request = new Request.Builder()
                                .url(Urls.URL_SCHEDULE)
                        .build();
                try {
                    Response response = scheduleclient.newCall(request).execute();
                    Log.e("Response", "doInBackground: "+response );

                    JSONArray schedule_list_array = new JSONArray(response.body().string());

                    for (int i=1; i<schedule_list_array.length(); i++){
                        JSONObject object = schedule_list_array.getJSONObject(i);

                        JSONArray c= object.getJSONArray("result");
                        for (int t=1 ;t<c.length(); t++) {
                            JSONObject co = c.getJSONObject(t);

                        int teamslogo = co.getInt("logo");
                        String teamsShort = co.getString("short_name");
                            Log.e("teams", teamslogo+teamsShort );
                        }

                        int SID =      object.getInt("schedule_id");
                        String sdays = object.getString("day");
                        String dates = object.getString("date");
                        String stime = object.getString("time");
                        String svenue= object.getString("place");

                        ScheduleList schedule = new ScheduleList(SID,sdays,dates,stime,svenue);
//                        for (int t=0; t<teamsab.length(); t++){
//                            JSONObject teamobjects = new teamsab.getJSONObject(t);
//                        }
                        Log.e("Requests", SID + sdays + dates + stime +svenue );

                        scheduleList.add(schedule);
                    }

                    Log.e("Response", "doInBackground: "+ schedule_list_array );

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                   // Log.e("JSONSChedule Error", "doInBackground:"+e+""+SID +teamslogo,teamShort,sdays,dates,stime,svenue+"" );
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                scheduleAdapter.notifyDataSetChanged();
            }
        };

        task.execute(id);
    }

}
