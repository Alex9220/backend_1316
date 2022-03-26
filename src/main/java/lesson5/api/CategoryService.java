package lesson5.api;

import lesson5.dto.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;


public interface CategoryService {

    @GET("categories/{id}")
    Call<lesson5.dto.GetCategoryResponse> getCategory(@Path("id") int id);

  /*  @GET("")
    Call<GetIdProductResponse> getProduct(@Path("id") int id);

    @GET("")
    Call<GetIdProductResponse> getProductId(@Path("id") int id);

    @PUT("")
    Call<PutProductResponse> putProduct();

    @POST("")
    Call<PostProductResponse> postProduct();

    @DELETE("")
    Call<DeleteProductResponse> deleteProduct();*/
}