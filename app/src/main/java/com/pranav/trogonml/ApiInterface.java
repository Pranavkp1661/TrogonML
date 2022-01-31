package com.pranav.trogonml;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("top_courses")
    Call<List<TopCourse>> getTopCourse();

    @GET("categories")
    Call<List<CategoriesModel>> getCategories();
}
