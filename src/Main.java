class Post {
    private String text;
    private String author;
    private int likes;

    Post(String text, String author) {
        this.text = text;
        this.author = author;
        likes = 0;
    }

    void like() { likes++; }

    void show() {
        System.out.println(author + ": " + text + " (Лайки: " + likes + ")");
    }
}

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
        if(postCount < posts.length) {
            posts[postCount] = p;
            postCount++;
        } else {
            System.out.println("Невозможно добавить больше постов для " + username);
        }
    }

    void showOwnPosts() {
        System.out.println("Профиль: " + username);
        for(int i = 0; i < postCount; i++) {
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

class SocialNetwork {
    private String networkName;
    private Profile[] users = new Profile[10];
    private int userCount = 0;

    SocialNetwork(String networkName) {
        this.networkName = networkName;
    }

    void addUser(Profile p) {
        if(userCount < users.length) {
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
        for(int i = 0; i < userCount; i++) {
            for(int j = 0; j < users[i].getPostCount(); j++) {
                users[i].getPost(j).show();
            }
        }
        System.out.println();
    }

    void showUsers() {
        System.out.println("Пользователи в " + networkName + ":");
        for(int i = 0; i < userCount; i++) {
            System.out.println("- " + users[i].getUsername());
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        SocialNetwork sn = new SocialNetwork("QuraqKorpe");

        Profile alice = new Profile("Мансур");
        Profile bob = new Profile("Диас");

        sn.addUser(alice);
        sn.addUser(bob);

        Post p1 = new Post("Иоу как дела?", "Мансур");
        Post p2 = new Post("Как бы понять эту Джаву??", "Мансур");
        Post p3 = new Post("Чтм Диас глянь на нож который я купил", "Диас");

        alice.addPost(p1);
        alice.addPost(p2);
        bob.addPost(p3);

        boolean run = true;
        while(run) {
            System.out.println("=== Главное меню ===");
            System.out.println("1. Показать все посты");
            System.out.println("2. Добавить новый пост");
            System.out.println("3. Показать профиль");
            System.out.println("4. Выход");
            System.out.print("Выберите пункт: ");

            String input = reader.readLine();
            if (input.isEmpty()) continue;
            int choice = Integer.parseInt(input);

            switch(choice) {
                case 1:
                    sn.showAllPosts();
                    break;
                case 2:
                    System.out.print("Введите ваше имя пользователя: ");
                    String user = reader.readLine();
                    Profile prof = null;

                    for(int i = 0; i < sn.getUserCount(); i++) {
                        if(sn.getUser(i).getUsername().equals(user)) prof = sn.getUser(i);
                    }

                    if(prof == null) {
                        System.out.println("Такого пользвателя не существует/не найден.");
                        break;
                    }
                    System.out.print("Введите текст поста: ");
                    String text = reader.readLine();

                    Post newPost = new Post(text, prof.getUsername());
                    prof.addPost(newPost);
                    System.out.println("Пост успешно создан\n");
                    break;
                case 3:
                    System.out.print("Введите имя пользователя: ");
                    String user2 = reader.readLine();
                    Profile prof2 = null;

                    for(int i = 0; i < sn.getUserCount(); i++) {
                        if(sn.getUser(i).getUsername().equals(user2)) prof2 = sn.getUser(i);
                    }

                    if(prof2 != null) prof2.showOwnPosts();
                    else System.out.println("Такого пользвателя не существует/не найден.\n");
                    break;
                case 4:
                    run = false;
                    System.out.println("Выход...");
                    break;
                default:
                    System.out.println("Неверный выбор\n");
            }
        }
    }
}