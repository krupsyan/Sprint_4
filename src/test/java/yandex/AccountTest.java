package yandex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static java.lang.String.format;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean expected;
    private Account account;


    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][]{
                {"А Б", true},
                {"АБВГДЕЁЖЗ ИЙКЛМНОПР", true},
                {"ББ", false},
                {"АБВГДЕЁЖЗ ИЙКЛМНОПРС", false},
                {"БББ", false},
                {" ББ", false},
                {"ББ ", false},
                {"АБВГД ЕЁЖЗ ИЙКЛМНОП", false},
        };
    }

    @Before
    public void setUp() {
        account = new Account(name);
    }

    @Test
    public void main() {
        boolean actual = account.checkNameToEmboss();

        String message = format("Актуальное значение отличается от ожидаемого значения. %nАктуальное значение: %s %nОжидаемое значение:%s %nТестовая строка: \"%s\"%n", actual, expected, account.getName());
        Assert.assertEquals(message, expected, actual);
    }
}
