package com.pranav.trogonml;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pranav.trogonml.databinding.ActivityHomePageBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageActivity extends AppCompatActivity {
    ActivityHomePageBinding homePageBinding;
    Context context;
    TopCourseAdapter topCourseAdapter;
    CategoriesModelAdapter categoriesModelAdapter;
    RecyclerView rvCategories;
    List<TopCourse> topCourseArrayList = new ArrayList<>();
    List<CategoriesModel> categoriesModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        homePageBinding = DataBindingUtil.setContentView(this, R.layout.activity_home_page);
        rvCategories=findViewById(R.id.rvCategories);
        categoriesModelAdapter=new CategoriesModelAdapter(context,categoriesModels);
        topCourseAdapter=new TopCourseAdapter(context,topCourseArrayList);
        rvCategories.setLayoutManager(new GridLayoutManager(context,2));
        rvCategories.setAdapter(categoriesModelAdapter);
        homePageBinding.rvTopCourse.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        homePageBinding.rvTopCourse.setAdapter(topCourseAdapter);
        getTopCourse();
        getCate();
    }

    private void getCate() {
        ApiInterface apiInterface = RetrofitClientApi.getClient().create(ApiInterface.class);
        Call<List<CategoriesModel>> call=apiInterface.getCategories();
        call.enqueue(new Callback<List<CategoriesModel>>() {
            @Override
            public void onResponse(Call<List<CategoriesModel>> call, Response<List<CategoriesModel>> response) {
                Log.e( "onResponse: ", "OK Cat");
                categoriesModelAdapter.UpdateAdapter((List<CategoriesModel>) response.body());
            }

            @Override
            public void onFailure(Call<List<CategoriesModel>> call, Throwable t) {
                Log.e( "onFailure: ", "FAIL"+t);
            }
        });
    }

    private void getTopCourse() {
        ApiInterface apiInterface = RetrofitClientApi.getClient().create(ApiInterface.class);
        Call<List<TopCourse>> call=apiInterface.getTopCourse();
        call.enqueue(new Callback<List<TopCourse>>() {
            @Override
            public void onResponse(Call<List<TopCourse>> call, Response<List<TopCourse>> response) {
                Log.e( "onResponse: ", "OK");
                topCourseAdapter.UpdateAdapter((List<TopCourse>) response.body());
            }

            @Override
            public void onFailure(Call<List<TopCourse>> call, Throwable t) {
                Log.e( "onFailure: ", "FAIL"+t);
            }
        });
    }

}