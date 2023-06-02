import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    private static final String VALIDATE_PATTERN = "^[a-zA-Z0-9-_]+$";

    public static void main(String[] args) {
    }

    private static boolean check(String login, String password, String confirmPassword) {

        boolean isValid = true;

        try {
            checkLogin(login);
            chekPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка с веденным логином" + e.getMessage());
            e.printStackTrace();
            isValid = false;
        }catch (WrongPasswordException e) {
            System.out.println("Ошибка с веденным паролем" + e.getMessage());
            e.printStackTrace();
            isValid = false;
        }
        return isValid;
    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches(VALIDATE_PATTERN)) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчёркивания");
        } else if (login.length() > 20) {
            throw new WrongLoginException("Длина логина не может быть больше 20 символов");
        }
    }

    private static void chekPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.matches(VALIDATE_PATTERN)) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчёркивания");
        } else if (password.length() > 20) {
            throw new WrongPasswordException("Длина логина не может быть больше 20 символов");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
