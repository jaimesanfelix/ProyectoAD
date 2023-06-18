package es.ieseduardoprimo.rest;

import java.util.List;

import es.ieseduardoprimo.dto.HotelDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AccesoDatosRest {

    // Hotels, obtener todos
    @GET("?sheet=Hotel")
    Call<List<HotelDTO>> HotelGetAll();
    
    // Obtener uno producto por ID
    @GET("search?id=&sheet=Hotel")
    Call<HotelDTO> HotelGetById(@Path("id") int id);
    //search?id=1&sheet=Hotel
    /* 
    // Obtenemos todos los programadores
    @GET("Hotel/{id}/programadores")
    Call<List<ProgramadorDTO>> HotelGetProgramadores(@Path("id") String id);

    // Obtenemos el jefe
    @GET("Hotel/{id}/jefe")
    Call<ProgramadorDTO> HotelGetJefe(@Path("id") String id);

    // POST Hotel
    @POST("Hotel")
    Call<HotelDTO> HotelCreate(@Body HotelModifyDTO Hotel);

    // PUT Hotel
    @PUT("Hotel/{id}")
    Call<HotelDTO> HotelUpdate(@Path("id") String id, @Body HotelModifyDTO Hotel);

    // DELETE Hotel
    @DELETE("Hotel/{id}")
    Call<HotelDTO> HotelDelete(@Path("id") String id); */

}
