class SocialNetwork {
    private String networkName;
    private Profile[] users = new Profile[10];
    private int userCount = 0;

    SocialNetwork(String networkName) {
        this.networkName = networkName;
    }

    void addUser(Profile p) {
        if (userCount < users.length) {
            users[userCount++] = p;
        }
    }

    public int getUserCount() {
        return userCount;
    }

    public Profile getUser(int index) {
        return users[index];
    }

    Profile findUserByName(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equals(name)) {
                return users[i];
            }
        }
        return null;
    }

    void showAllContent() {
        System.out.println("=== Все публикации в " + networkName + " ===");
        for (int i = 0; i < userCount; i++) {
            Profile p = users[i];
            for (int j = 0; j < p.getContentCount(); j++) {
                p.getContent(j).show();
            }
        }
        System.out.println();
    }

    void sortUsersByName() {
        for (int i = 0; i < userCount - 1; i++) {
            for (int j = i + 1; j < userCount; j++) {
                if (users[i].getUsername().compareTo(users[j].getUsername()) > 0) {
                    Profile temp = users[i];
                    users[i] = users[j];
                    users[j] = temp;
                }
            }
        }
    }
}
