public class Main {
    public static void main(String[] args) throws java.io.IOException {
        ProfileDAO dao = new ProfileDAO();

        dao.addProfile("miras", "miras@mail.com");
        dao.getProfiles();
        // dao.deleteProfile(1);

        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        SocialNetwork sn = new SocialNetwork("QuraqKorpe");

        Profile alice = new Profile("Мансур");
        Profile bob = new Profile("Диас");

        sn.addUser(alice);
        sn.addUser(bob);

        Post p1 = new Post("Иоу как дела?", "Мансур");
        Post p2 = new Post("Как бы понять эту Джаву??", "Мансур");
        Post p3 = new Post("Чтм Диас глянь на нож который я купил", "Диас");

        alice.addContent(p1);
        alice.addContent(p2);
        bob.addContent(p3);

        boolean run = true;
        while (run) {
            System.out.println("=== Главное меню ===");
            System.out.println("1. Показать все публикации");
            System.out.println("2. Добавить новый пост");
            System.out.println("3. Добавить сторис");
            System.out.println("4. Показать профиль");
            System.out.println("5. Выход");
            System.out.print("Выберите пункт: ");

            String input = reader.readLine();
            if (input.isEmpty()) continue;

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    sn.showAllContent();
                    break;

                case 2:
                    System.out.print("Введите ваше имя пользователя: ");
                    String user = reader.readLine();
                    Profile prof = sn.findUserByName(user);

                    if (prof == null) {
                        System.out.println("Такого пользователя не существует\n");
                        break;
                    }

                    System.out.print("Введите текст поста: ");
                    String text = reader.readLine();

                    prof.addContent(new Post(text, prof.getUsername()));
                    System.out.println("Пост успешно создан\n");
                    break;

                case 3:
                    System.out.print("Введите ваше имя пользователя: ");
                    String userS = reader.readLine();
                    Profile profS = sn.findUserByName(userS);

                    if (profS == null) {
                        System.out.println("Такого пользователя не существует\n");
                        break;
                    }

                    System.out.print("Введите текст сториса: ");
                    String storyText = reader.readLine();

                    profS.addContent(new Story(storyText, profS.getUsername()));
                    System.out.println("Сторис успешно добавлен\n");
                    break;

                case 4:
                    System.out.print("Введите имя пользователя: ");
                    String user2 = reader.readLine();
                    Profile prof2 = sn.findUserByName(user2);

                    if (prof2 != null) {
                        prof2.showOwnContent();
                    } else {
                        System.out.println("Такого пользователя не существует\n");
                    }
                    break;

                case 5:
                    run = false;
                    System.out.println("Выход...");
                    break;

                default:
                    System.out.println("Неверный выбор\n");
            }
        }
    }
}
