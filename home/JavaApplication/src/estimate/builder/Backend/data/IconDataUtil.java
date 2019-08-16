package estimate.builder.Backend.data;

import estimate.builder.util.Status;
import estimate.builder.util.StatusMessage;

import java.util.ArrayList;

/**
 * Gets User and Sets data.
 */
public class IconDataUtil {
    private ArrayList<IconData> users = new ArrayList<>();

    /**
     * TODO(Edd1e234): This CANNOT BE how the program searches. Perhaps using C++ search through protobufs in a
     * database. For now this will work since its a low  user base. Functions should not change though.
     *
     * Function will get desired User.
     *
     * @param username Main key.
     * @param password validates user.
     * @param actual_user Copies user data over.
     * @return Status, If user is not found then a NotFoundError will be returned.
     */
    public Status getData(String username, String password, IconData actual_user) {
        for (IconData user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                actual_user = user;
                return StatusMessage.okStatus();
            }
        }
        return StatusMessage.NotFoundError("User not found or Incorrect login info.");
    }

    public void addUser(IconData newUser) {
        newUser.setIndex(users.size());
        users.add(newUser);
    }

    public Status saveData(IconData data) {
        users.set(data.getIndex(), data);
        return StatusMessage.okStatus();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (IconData user : users) {
            stringBuilder.append(user.toString());
        }
        return stringBuilder.toString();
    }
}
