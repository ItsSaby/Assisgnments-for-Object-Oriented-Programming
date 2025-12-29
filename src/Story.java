class Story extends SocialEntity {
    private String text;

    Story(String text, String author) {
        super(author);
        this.text = text;
    }

    @Override
    public void show() {
        System.out.println("[Story] " + author + ": " + text);
    }
}
