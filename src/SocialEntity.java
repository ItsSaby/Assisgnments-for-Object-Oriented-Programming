abstract class SocialEntity {
    protected String author;

    SocialEntity(String author) {
        this.author = author;
    }

    public abstract void show();
}