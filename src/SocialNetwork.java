class SocialNetwork {
    private String networkName;
    private Profile[] users = new Profile[10];
    private int userCount = 0;

    SocialNetwork(String networkName) {
        this.networkName = networkName;
    }

    void addUser(Profile p) {
        if (userCount < users.length) {
            users[userCount] = p;
            userCount++;
        } else {
            System.out.println("Невозможно добавить больше пользователей");
        }
    }

    public int getUserCount() {
        return userCount;
    }

    public Profile getUser(int index) {
        return users[index];
    }

    void showAllPosts() {
        System.out.println("=== Все посты в " + networkName + " ===");
        for (int i = 0; i < userCount; i++) {
            for (int j = 0; j < users[i].getPostCount(); j++) {
                users[i].getPost(j).show();
            }
        }
        System.out.println();
    }

    void showUsers() {
        System.out.println("Пользователи в " + networkName + ":");
        for (int i = 0; i < userCount; i++) {
            System.out.println("- " + users[i].getUsername());
        }
        System.out.println();
    }
}
