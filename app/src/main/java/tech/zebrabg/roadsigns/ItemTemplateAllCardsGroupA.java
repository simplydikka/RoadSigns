package tech.zebrabg.roadsigns;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemTemplateAllCardsGroupA implements Parcelable {
    private int mImageResource;
    private String mTextTitle;
    private String mTextDescription;

    public ItemTemplateAllCardsGroupA(int imageResource, String textTitle, String textDescription) {
        mImageResource = imageResource;
        mTextTitle = textTitle;
        mTextDescription = textDescription;
    }


    protected ItemTemplateAllCardsGroupA(Parcel in) {
        mImageResource = in.readInt();
        mTextTitle = in.readString();
        mTextDescription = in.readString();
    }

    public static final Creator<ItemTemplateAllCardsGroupA> CREATOR = new Creator<ItemTemplateAllCardsGroupA>() {
        @Override
        public ItemTemplateAllCardsGroupA createFromParcel(Parcel in) {
            return new ItemTemplateAllCardsGroupA(in);
        }

        @Override
        public ItemTemplateAllCardsGroupA[] newArray(int size) {
            return new ItemTemplateAllCardsGroupA[size];
        }
    };

    public int getImageResource(){
        return mImageResource;
    }
     public String getTextTitle() {
        return mTextTitle;
     }

     public String getmTextDescription(){
         return mTextDescription;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResource);
        dest.writeString(mTextTitle);
        dest.writeString(mTextDescription);

    }
}
