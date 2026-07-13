package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPremission() {
        return new User(PropertyReader.getProperty("saucedemo.user"), PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withLockedPremission() {
        return new User(PropertyReader.getProperty("saucedemo.locked_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmtyLogin() {
        return new User("",
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmtyPassword() {
        return new User(PropertyReader.getProperty("saucedemo.locked_user"),
                "");
    }

    public static User withUpCharLogin() {
        return new User(PropertyReader.getProperty("saucedemo.upp_login_char"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withUpCharPassword() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.upp_pass_char"));
    }
}
