package ir.sooban.android.readerdemo.model;

public class Service {

    private int  mTitle;
    private int mId;
    // TODO: must add a new property for image of service


    public Service(int title, int id) {
        mTitle = title;
        mId = id;
    }

    public void setTitle(int title) {
        mTitle = title;
    }

    public int getTitle() {
        return mTitle;
    }

    public int getId() {
        return mId;
    }

}
