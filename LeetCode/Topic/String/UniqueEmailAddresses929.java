package LeetCode.Topic.String;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses929 {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(convert(email));
        }
        return set.size();
    }
    private String convert(String email) {
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < email.length(); i++) {
            if (email.charAt(i) != '.') {
                sb.append(email.charAt(i));
            }
            if (email.charAt(i) == '+') {
                while (email.charAt(i) != '@') {
                    i++;
                }
                break;
            }
        }
        while (i < email.length()) {
            sb.append(email.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
