package google.GroupUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ymyue on 10/10/16.
 */
public class Solution {

    public static class User {

    }

    public List<List<User>> groupUsers(List<User> users) {
        Map<User, User> map = new HashMap<>();
        for (User user : users)
            map.put(user, user);
        for (int i = 1; i < users.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (theSameUser(users.get(i), users.get(j))) {
                    union(users.get(i), users.get(j));
                }
            }
        }

        Map<User, List<User>> result = new HashMap<> ();
        for (User user : users) {
            User root = getRoot(user);
            if (result.containsKey(root))
                result.get(root).add(user);
            else {
                result.put(root, new ArrayList<> ());
                result.get(root).add(user);
            }
        }
        return new ArrayList<>(result.values());
    }

    private boolean theSameUser(User u, User v) {
        return true;
    }

    private void union(User u, User v) {}

    private User getRoot(User user) {return null;}
}
