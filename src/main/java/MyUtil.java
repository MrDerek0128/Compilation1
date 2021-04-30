import java.util.ArrayList;

public class MyUtil {
    public static ArrayList<String> getId(ArrayList<Group> groups) {
        ArrayList<String> id = new ArrayList<>();
        for (Group group:groups) {
            if (group.type == 2) {
                if (!id.contains(group.value)){
                    id.add(group.value);
                }
            }
        }
        return id;
    }
}
