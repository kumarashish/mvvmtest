package room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Results")
public class Data {
    @PrimaryKey(autoGenerate = true )
    int id;
    @ColumnInfo
    String display_title;
    @ColumnInfo
    String mpaa_rating;
    @ColumnInfo
    int critics_pick;
    @ColumnInfo
    String byline;
    @ColumnInfo
    String headline;
    @ColumnInfo
    String summary_short;
    @ColumnInfo
    String publication_date;
    @ColumnInfo
    String opening_date;
    @ColumnInfo
    String date_updated;
    @ColumnInfo
    String url;
    @ColumnInfo
    String suggested_link_text;
    @ColumnInfo
    String src;

    public Data(String display_title, String mpaa_rating,int critics_pick,String byline,String headline,String summary_short, String publication_date, String opening_date, String date_updated, String url, String suggested_link_text, String src)
    {
        this.display_title=display_title;
        this.mpaa_rating=mpaa_rating;
        this.critics_pick=critics_pick;
        this.byline=byline;
        this.headline=headline;
        this.summary_short=summary_short;
        this.publication_date=publication_date;
        this.opening_date=opening_date;
        this.date_updated=date_updated;
        this.url=url;
        this.suggested_link_text=suggested_link_text;
        this.src=src;
    }

    public int getId() {
        return id;
    }

    public String getByline() {
        return byline;
    }

    public int getCritics_pick() {
        return critics_pick;
    }

    public String getDisplay_title() {
        return display_title;
    }

    public String getHeadline() {
        return headline;
    }

    public String getMpaa_rating() {
        return mpaa_rating;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public String getOpening_date() {
        return opening_date;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public String getSummary_short() {
        return summary_short;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public void setCritics_pick(int critics_pick) {
        this.critics_pick = critics_pick;
    }

    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }

    public void setDisplay_title(String display_title) {
        this.display_title = display_title;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMpaa_rating(String mpaa_rating) {
        this.mpaa_rating = mpaa_rating;
    }

    public void setOpening_date(String opening_date) {
        this.opening_date = opening_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setSuggested_link_text(String suggested_link_text) {
        this.suggested_link_text = suggested_link_text;
    }

    public void setSummary_short(String summary_short) {
        this.summary_short = summary_short;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getSuggested_link_text() {
        return suggested_link_text;
    }

    public String getSrc() {
        return src;
    }
}


