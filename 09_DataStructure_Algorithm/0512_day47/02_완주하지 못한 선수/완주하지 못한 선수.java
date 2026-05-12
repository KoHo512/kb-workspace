import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hashtable = new HashMap<>();
        
        for (String comp : completion) {
            hashtable.put(comp, hashtable.getOrDefault(comp, 0) + 1);
        }
        
        for (String part : participant) {
            if (hashtable.containsKey(part)) {
                if (hashtable.get(part) == 1) {
                    hashtable.remove(part);
                } else {
                    hashtable.replace(part, hashtable.get(part) - 1);
                }
            } else {
                return part;
            }
        }
        
        return null;
    }
}