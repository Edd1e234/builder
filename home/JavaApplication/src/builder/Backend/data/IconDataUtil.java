package builder.Backend.data;

import builder.Backend.Estimate;
import builder.Backend.EstimateLot;
import builder.Backend.LotField;
import builder.util.Status;
import builder.util.StatusMessage;

import java.util.ArrayList;

/**
 * Gets User and Sets data.
 */
public class IconDataUtil {
    private ArrayList<IconData> users = new ArrayList<>();

    /**
     * TODO(Edd1e234): This CANNOT BE how the program searches. Perhaps using C++ search through
     * protobufs in a database. For now this will work since its a low  user base. Functions should
     * do the same thing tho.
     * <p>
     * Function will get desired User.
     *
     * @param username Main key.
     * @param password validates user.
     * @param userData Copies user data over.
     * @return Status, If user is not found then a NotFoundError will be returned.
     */
    public IconData getUserData(String username, String password) {
        for (IconData user : users) {

            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
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

    //TODO(Edd1e234): Delete this.
    // Delete this, testing purposes only.
    public void setEddieData(IconData eddieData) {
        System.out.println("Eddie Data set");

        eddieData.setUsername("eddie");
        eddieData.setPassword("eddie");

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

        addUser(eddieData);
    }
}
