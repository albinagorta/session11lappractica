package com.app.session11lappractica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListarAluActivity extends AppCompatActivity implements Callback<List<Alumno>>{
    public  static  final String URL="https://192.168.3.103/api/"; //https://jsonplaceholder.typicode.com
    private AlumnoAdapter mPostAdapter;
    private ArrayList<Alumno> mPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alu);
        mPosts=new ArrayList<>();
        ListView lstLista=findViewById(R.id.lstLista);
        mPostAdapter=new AlumnoAdapter(mPosts,this);
        lstLista.setAdapter(mPostAdapter);
        listaPosts();
    }


    private void listaPosts() {
        Gson gson=new GsonBuilder().setLenient().create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        JsonPlaceHolderAPI jsonPlaceHolderAPI=retrofit.create(JsonPlaceHolderAPI.class);
        Call<List<Alumno>> call=jsonPlaceHolderAPI.getAllPost();
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
        if (response.isSuccessful()){
            List<Alumno> alumnoList=response.body();
            for (Alumno a:alumnoList){
                mPosts.add(a);
            }
            mPostAdapter.notifyDataSetChanged();;
        }else{
            Toast.makeText(this,response.errorBody().toString()
                    ,Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onFailure(Call<List<Alumno>> call, Throwable t) {
        t.printStackTrace();
    }


}