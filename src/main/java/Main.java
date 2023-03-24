
import java.util.Scanner;

public class Main {

    public static User[] getUser() {
        User user1 = new User("Victor", "v123", "victor@mail.ru", 23);
        User user2 = new User("Oleg", "o234", "oleg@mail.ru", 18);
        User user3 = new User("Igor", "i345", "igor@mail.ru", 15);
        User user4 = new User("Dima", "d456", "dima@mail.ru", 34);
        return new User[]{user1, user2, user3, user4};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException, AccessDeniedException {
        User[] users = getUser();
        for (User user : users) {
            if (login.equals(user.log) && password.equals(user.pass) && user.age >= 18) {
                return user;
            } else if (login.equals(user.log) && password.equals(user.pass)) {
                throw new AccessDeniedException("Возраст пользователя меньше 18 лет!");
            }
        }
        throw new UserNotFoundException("Логин или пароль не верны!");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите логин");
                String login = scanner.nextLine();

                System.out.println("Введите пароль");
                String password = scanner.nextLine();

                getUserByLoginAndPassword(login, password);
                System.out.println("Доступ предоставлен!");
                break;
            } catch (UserNotFoundException | AccessDeniedException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
