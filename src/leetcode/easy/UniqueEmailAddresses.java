package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 */
public class UniqueEmailAddresses {

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];
            String[] arr = email.split("@");
            String id = arr[0];
            String domain = arr[1];
            if(id.contains("+")){
                id = id.substring(0,id.indexOf("+")).replaceAll("\\.","");
            } else {
                id = id.replaceAll("\\.","");
            }
            set.add(id + "@" + domain);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"})); // 2
        System.out.println(numUniqueEmails(new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"})); // 3
    }
}
