class Post {
    private String text;
    private String author;
    private int likes;

    Post(String text, String author) {
        this.text = text;
        this.author = author;
        likes = 0;
    }

    void like() {
        likes++;
    }

    void show() {
        System.out.println(author + ": " + text + " (Лайки: " + likes + ")");
    }
}
