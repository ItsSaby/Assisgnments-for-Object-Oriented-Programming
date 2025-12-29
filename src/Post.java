class Post extends SocialEntity {
    private String text;
    private int likes;

    Post(String text, String author) {
        super(author);
        this.text = text;
        likes = 0;
    }

    void like() {
        likes++;
    }

    @Override
    public void show() {
        System.out.println(author + ": " + text + " (Лайки: " + likes + ")");
    }

    @Override
    public String toString() {
        return author + ": " + text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post p = (Post) o;
        return text.equals(p.text) && author.equals(p.author);
    }

    @Override
    public int hashCode() {
        return (author + text).hashCode();
    }
}
