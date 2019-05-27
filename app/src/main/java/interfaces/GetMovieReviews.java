package interfaces;



import com.testproject.R;

import java.util.List;

import model.ReviewModel;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface GetMovieReviews {
    @GET("reviews/picks.json?")
    Observable<ReviewModel> getData(@Query(("api-key") ) String apiKey);
}
