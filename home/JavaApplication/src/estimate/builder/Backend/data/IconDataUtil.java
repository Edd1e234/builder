package estimate.builder.Backend.data;

import estimate.builder.Backend.Estimate;
import estimate.builder.Backend.EstimateLot;
import estimate.builder.Backend.LotField;
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
     * database. For now this will work since its a low  user base. Functions should do the same thing tho.
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

        if (newUser.getFirstName().equalsIgnoreCase("Eddie")) {
            setEddieData(newUser);
        }

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

    // Delete this, testing purposes only.
    private void setEddieData(IconData eddieData) {
        System.out.println("Eddie Data set");

        EstimateLot lot = new EstimateLot();

        ArrayList<LotField> fields = new ArrayList<>();
        fields.add(new LotField());
        fields.get(0).setSqfPrice(55);
        fields.get(0).setFieldName("First one");

        fields.add(new LotField());
        fields.get(1).setSqfPrice(55);
        fields.get(1).setFieldName("Second one");

        lot.addField(fields.get(0));
        lot.addField(fields.get(1));

        Estimate estimate = new Estimate();
        estimate.setLot(lot);

        // New data is added.
        eddieData.setEstimate(estimate);

        System.out.println(eddieData.toString());
    }
}
