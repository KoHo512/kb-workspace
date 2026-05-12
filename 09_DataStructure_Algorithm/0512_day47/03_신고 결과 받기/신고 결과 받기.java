import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report_list, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        
        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
        }
        
        for (String report : report_list) {
            String[] r = report.split(" ");
            String user = r[0];
            String reportedUser = r[1];
            
            reportMap.get(reportedUser).add(user);
        }
        
        List<String> blocked_user = new ArrayList<>();
        for (String id : id_list) {
            if (reportMap.get(id).size() >= k) {
                blocked_user.add(id);
            }
        }
        
        int[] answer = new int[id_list.length];
        Arrays.fill(answer, 0);
        for (int i = 0; i < id_list.length; i++) {
            for(String bu : blocked_user) {
                if (reportMap.get(bu).contains(id_list[i])) {
                    answer[i] += 1;
                }
            }
        }
        
        return answer;
    }
}

// -------------------------
// Hash로 중복 먼저 없애고 넣어도 되겠다고 생각했는데 결국 HashMap으로 넣으면서 중복 제거했던 거라 큰 의미가 없는 거 같음..

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        Map<String, List<String>> reportMap = new HashMap<>();
        for (String id : id_list) {
            reportMap.put(id, new ArrayList<>());
        }
        
        for (String r : reportSet) {
            String user = r.split(" ")[0];
            String reportedUser = r.split(" ")[1];
            
            reportMap.get(reportedUser).add(user);
        }
            
        Arrays.fill(answer, 0);
        for (int i = 0; i < n; i++) {
            for (String id : id_list) {
                if(reportMap.get(id).size() >= k && reportMap.get(id).contains(id_list[i])) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}