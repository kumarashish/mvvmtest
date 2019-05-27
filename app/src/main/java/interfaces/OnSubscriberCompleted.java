package interfaces;

import model.Result;

public interface OnSubscriberCompleted {
    public void onCompleted();
    public void onListItemClicked(Result result);
}
