package yandex;
import org.apache.commons.lang3.StringUtils;


public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean checkNameToEmboss() {

        String firstChar = name.substring(0, 1);
        String lastChar = name.substring(name.length() -1, name.length());

        if (name.length() >= 3 && name.length() <= 19 && ! firstChar.equals(" ") && ! lastChar.equals(" ") && StringUtils.countMatches(name, " ") == 1) {
            return true;
        }
        else return false;
    }

}