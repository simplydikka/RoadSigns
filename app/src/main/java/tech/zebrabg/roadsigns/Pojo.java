package tech.zebrabg.roadsigns;

public class Pojo {

    private int id;
    private String CatId;
    private String CId;
    private String BookName;
    private String StoryTitle;
    private String StoryImage;
    private String StoryDescription;
    private String StorySubTitle;

    public Pojo() {

    }

    public Pojo(String CatId) {
        this.CatId = CatId;
    }

    public Pojo(String catid, String cid, String categoryname, String cardheading, String cardimage, String carddesc, String carddate) {
        this.CatId = catid;
        this.CId = cid;
        this.BookName = categoryname;
        this.StoryTitle = cardheading;
        this.StoryImage = cardimage;
        this.StoryDescription = carddesc;
        this.StorySubTitle = carddate;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatId() {
        return CatId;
    }

    public void setCatId(String catid) {
        this.CatId = catid;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String cid) {
        this.CId = cid;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String categoryname) {
        this.BookName = categoryname;
    }

    public String getStoryTitle() {
        return StoryTitle;
    }

    public void setStoryTitle(String cardheading) {
        this.StoryTitle = cardheading;
    }

    public String getStoryImage() {
        return StoryImage;
    }

    public void setStoryImage(String cardimage) {
        this.StoryImage = cardimage;
    }

    public String getStoryDescription() {
        return StoryDescription;
    }

    public void setStoryDescription(String carddesc) {
        this.StoryDescription = carddesc;
    }

    public String getStorySubTitle() {
        return StorySubTitle;
    }

    public void setStorySubTitle(String carddate) {
        this.StorySubTitle = carddate;
    }

}
