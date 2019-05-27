package interfaces;

import model.Result;
import room.Data;

public interface OnSubscriberCompleted {
    public void onCompleted();
    public void onListItemClicked(Data result);
}
