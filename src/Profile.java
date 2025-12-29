class Profile {
    private String username;
    private SocialEntity[] content = new SocialEntity[20];
    private int contentCount = 0;

    Profile(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    void addContent(SocialEntity s) {
        if (contentCount < content.length) {
            content[contentCount++] = s;
        }
    }

    void showOwnContent() {
        System.out.println("Профиль: " + username);
        for (int i = 0; i < contentCount; i++) {
            content[i].show();
        }
        System.out.println();
    }

    public int getContentCount() {
        return contentCount;
    }

    public SocialEntity getContent(int index) {
        return content[index];
    }

    @Override
    public String toString() {
        return "Profile{username='" + username + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile p = (Profile) o;
        return username.equals(p.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
