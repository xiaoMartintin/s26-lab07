package AndrewWebServices;

import java.util.HashMap;
import java.util.Map;

/*
 * InMemoryDatabase is a fake for the AndrewWS database which is used to improve test efficiency.
 * Remember, fakes are fully functional classes with simplified implementation.
 * What is the simplest core functionality that we need for a functional database?
 * 
 * Hint: there is one method you need to implement
 */
public class InMemoryDatabase extends Database {
    private final Map<String, Integer> passwords;

    public InMemoryDatabase() {
        passwords = new HashMap<>();
        passwords.put("Scotty", 17214);
    }

    @Override
    public int getPassword(String accountName) {
        Integer password = passwords.get(accountName);
        if (password == null) {
            return 0;
        }
        return password;
    }
}
