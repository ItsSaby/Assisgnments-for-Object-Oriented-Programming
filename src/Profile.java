class Profile {
    private String username;
    private Post[] posts = new Post[10];
    private int postCount = 0;

    Profile(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    void addPost(Post p) {
        if (postCount < posts.length) {
            posts[postCount] = p;
            postCount++;
        } else {
            System.out.println("Невозможно добавить больше постов для " + username);
        }
    }

    void showOwnPosts() {
        System.out.println("Профиль: " + username);
        for (int i = 0; i < postCount; i++) {
            posts[i].show();
        }
        System.out.println();
    }

    public int getPostCount() {
        return postCount;
    }

    public Post getPost(int index) {
        return posts[index];
    }
}
