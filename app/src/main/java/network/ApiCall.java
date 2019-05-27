package network;

import com.google.gson.Gson;

import common.Constant;
import interfaces.GetMovieReviews;
import model.ReviewModel;
import retrofit2.Retrofit;

public class ApiCall {
    Gson gson;
    Retrofit retrofit;
   public ApiCall(Gson gson,Retrofit retrofit)
    {
        this.gson=gson;
        this.retrofit=retrofit;
    }

    public rx.Observable<ReviewModel> getReviewData()
    {
      GetMovieReviews call=  retrofit.create(GetMovieReviews.class);
     rx.Observable<ReviewModel> model= call.getData(Constant.ApiKey);
     return model;
    }
}
