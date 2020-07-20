package com.app.session11lappractica;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderAPI {

    @GET("get.php")
    Call<List<Alumno>> getAllPost();

    //@GET("ListarAlumno.php")
    //Call<AlumnoResponde> getBusquedaAlumnos(@Query("nom") String nombre);

   @POST("listarAlumno.php")
    Call<ResponseBody> insertarAlumno(@Body AlumnoInsertar alumnoInsertar);

    @POST("post.php")
    @FormUrlEncoded
    Call<AlumnoInsertar>insertarAlumno(@Field("id_alumno") String cod, @Field("alu_paterno")String pat, @Field("alu_materno")String mat, @Field("alu_nombres") String nom);


}
