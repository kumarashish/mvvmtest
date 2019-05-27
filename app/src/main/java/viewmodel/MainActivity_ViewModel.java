package viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.room.Room;

import java.util.List;

import common.AppController;
import interfaces.OnSubscriberCompleted;
import model.Result;
import model.ReviewModel;
import room.Data;
import room.Database;
import rx.Observable;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity_ViewModel extends AndroidViewModel {

    private ReviewModel model=null;
     AppController controller;
     Application application;
     Database db;
     boolean isDataLoading=false;

    public MainActivity_ViewModel(Application application) {
        super(application);
        this.application = application;
        db= Room.databaseBuilder(application.getApplicationContext(),Database.class,"db").allowMainThreadQueries().build();
    }

    public void getReviewModel(OnSubscriberCompleted callback) {
        if (model == null) {
            isDataLoading = true;
            controller = (AppController) application;
            Observable<ReviewModel> reviewModelObservable = controller.getWebApi().getReviewData();
            reviewModelObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ReviewModel>() {
                @Override
                public void onCompleted() {
                    isDataLoading = false;
                    callback.onCompleted();
                }
                @Override
                public void onError(Throwable e) {
                }

                @Override
                public void onNext(ReviewModel reviewModel) {
                    model = reviewModel;
                    handleDatabase();
                }
            });

        }


    }

    public void handleDatabase() {
        if (db.Dao().getResult().size() > 0) {
            db.Dao().clearTable();
            insertData();
        } else {
            insertData();
        }
    }

    public void insertData() {
        for (int i = 0; i < model.getResults().size(); i++) {
            Result modell = model.getResults().get(i);
            db.Dao().addResult(new Data(modell.getDisplayTitle(), modell.getMpaaRating(), modell.getCriticsPick(), modell.getByline(), modell.getHeadline(), modell.getSummaryShort(), modell.getPublicationDate(), modell.getOpeningDate(), modell.getDateUpdated(), modell.getLink().getUrl(), modell.getLink().getSuggestedLinkText(), modell.getMultimedia().getSrc()));
        }
    }

    public List<Data> getData() {
        return db.Dao().getResult();
    }


}
