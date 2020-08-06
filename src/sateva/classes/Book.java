package sateva.classes;

public class Book {

    private String title;
    private String subtitle;
    private String editora;
    private String actor;
    private String edition;
    private String price;
    private String category;
    private float percentOfRead;
    private String status;
    private String description;
    private StringBuilder notes;


    public Book(String title, String subtitle, String editora, String actor, String edition, String category, String description) {
        this.title = title;
        this.subtitle = subtitle;
        this.editora = editora;
        this.actor = actor;
        this.edition = edition;
        this.category = category;
        this.description = description;
    }

    public Book(String title, String subtitle, String editora, String actor, String edition, String category) {
        this.title = title;
        this.subtitle = subtitle;
        this.editora = editora;
        this.actor = actor;
        this.edition = edition;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPercentOfRead() {
        return percentOfRead;
    }

    public void setPercentOfRead(float percentOfRead) {
        this.percentOfRead = percentOfRead;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
