package com.betting.SportApi;

import com.betting.Matches.Matches;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GetJson {


    private Request request;
    private Response response;
    private OkHttpClient client;
    private String url;


    public GetJson(){ }

    public Matches[] getGames(String startDate,String endDate) throws IOException{

        url = "http://api.football-data.org/v2/matches?dateFrom="+startDate+"&dateTo="+endDate;

        client = new OkHttpClient();
        request = new Request.Builder()
                .url(url).addHeader("X-Auth-Token", "ba537d63fc8044ceb51ce487f60b701c")
                .build();
        response = client.newCall(request).execute();


        String jsonData = response.body().string();
        JSONObject Jobject = new JSONObject(jsonData);


        JSONArray jsonArray = Jobject.getJSONArray("matches");

        ObjectMapper mapper = new ObjectMapper();
        Matches[] matches = mapper.readValue(jsonArray.toString(), Matches[].class);

        return matches;
    }

}
