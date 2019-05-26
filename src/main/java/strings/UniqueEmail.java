package strings;

import java.util.HashSet;
import java.util.Set;

class UniqueEmail {
    public static void main(String[] args) {
        int num = numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"});
    }


    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueMail = new HashSet<>();
        StringBuilder b = new StringBuilder();
        StringBuilder c = new StringBuilder();

        for (String email : emails) {

            StringBuilder builder = new StringBuilder();

            String[] splitData = email.split("@");
            char[] actualEmail = splitData[0].toCharArray();

            int breakPoint = 0;
            for (int i = 0; i < actualEmail.length; i++) {
                breakPoint++;
                if (actualEmail[i] == '+') {
                    break;
                }
            }

            builder.append(new String(actualEmail, 0, breakPoint));
            builder.append("@");
            builder.append(splitData[1]);
            uniqueMail.add(builder.toString());
        }
        return uniqueMail.size();
    }
}
