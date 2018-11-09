package tech.zebrabg.roadsigns;

public class ItemTemplateCategories {

    private int categoryCardImage;
    private String categoryTextTitle;
    private String categoryTextDescription;

    public ItemTemplateCategories(int imageResource, String textTitle, String textDescription) {
        categoryCardImage = imageResource;
        categoryTextTitle = textTitle;
        categoryTextDescription = textDescription;
    }

    // Getter


    public int getCategoryCardImage() {
        return categoryCardImage;
    }

    public String getCategoryTextTitle() {
        return categoryTextTitle;
    }

    public String getCategoryTextDescription() {
        return categoryTextDescription;
    }

    //Setter


    public void setCategoryCardImage(int categoryCardImage) {
        this.categoryCardImage = categoryCardImage;
    }

    public void setCategoryTextTitle(String categoryTextTitle) {
        this.categoryTextTitle = categoryTextTitle;
    }

    public void setCategoryTextDescription(String categoryTextDescription) {
        this.categoryTextDescription = categoryTextDescription;
    }
}
