package com.example.a301.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button testButton;
    TextView textView;


    static String reqURL = "http://newsky2.kma.go.kr/";
    static String serviceKey="gXBXUzv%2FaP2AnP29hzBPRAYxFL28gTrw%2BWeq9BksUPMBGn4e1Q5yOtK1AtOIufpUCgLTJY0RLWSwMTp96232mg%3D%3D";

    public GsonVO gsonList;
    public static ArrayList<DataVO> dataList = new ArrayList<DataVO>();
    public static ArrayList<DataObject> arr = new ArrayList<DataObject>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.TestText);
        testButton = (Button) findViewById(R.id.button1);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
            }
        });
    }


    public void loadData() {
        Retrofit client = new Retrofit.Builder().baseUrl("http://newsky2.kma.go.kr/").addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService service = client.create(RetrofitService.class);
        Call<GsonVO> call = service.loadAnswer(serviceKey,"60","127","20170920","1800","json");
        Log.v("Testing","call하기전");
        call.enqueue(new Callback<GsonVO>()
 {
            @Override
            public void onResponse(Call<GsonVO> call, Response<GsonVO> response) {
                Log.v("Testing","onResponse");
                if (response.isSuccessful()) {
                    gsonList = response.body();
                    dataList = gsonList.getDataList();

                    for (int i = 0; i < dataList.size(); i++) {
                        String baseDate = dataList.get(i).getBaseDate();
                        String baseTime = dataList.get(i).getBaseTime();
                        String category = dataList.get(i).getCategory();
                        String nx = dataList.get(i).getNx();
                        String ny = dataList.get(i).getNy();
                        String obsrValue = dataList.get(i).getObsrValue();
                        arr.add(new DataObject(baseDate, baseTime, category, nx, ny, obsrValue));
                    }
                    Log.v("Answer",arr.get(0).getCategory());
                    Log.v("Answer",arr.get(0).getObsrValue());
                    Log.v("Answer",arr.get(0).getBaseDate());
                    textView.setText(arr.get(0).getBaseDate() + "\n" + arr.get(0).getBaseTime() + "\n" + arr.get(0).getCategory() + "\n" + arr.get(0).getObsrValue() + "\n");
                } else {
                    int statusCode = response.code();
                }
            }

            @Override
            public void onFailure(Call<GsonVO> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });
    }

}
