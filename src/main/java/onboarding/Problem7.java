package onboarding;

import java.util.*;

public class Problem7 {
    private static List<String> memberList = new ArrayList<>();
    private static List<Integer> scoreList = new ArrayList<>();
    private static List<String> friendsList = new ArrayList<>();
    private static String member =new String();
    private static int memberScore =0;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return rankMemberList(user, friends, visitors);
    }

    public static List<String> orgainze(String user, List<List<String>> friends, List<String> visitors) {
        memberList.clear();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                memberList.add(friends.get(i).get(j));
            }
        }
        for(int i=0; i<visitors.size(); i++){
            memberList.add(visitors.get(i));
        }
        Set<String> set = new HashSet<String>(memberList);
        List<String> newlist = new ArrayList<String>(set);
        newlist.remove(user);
        Collections.sort(newlist);
        return newlist;
    }

    public static List<String> rankMemberList(String user, List<List<String>> friends, List<String> visitors){
        List<String> special = new ArrayList<>();
        if(!error(user, friends, visitors)) {
            for (int i = 0; i < sortMemberList(user, friends, visitors).length; i++) {
                special.add(sortMemberList(user, friends, visitors)[i][1]);
            }
            return special;
        }
        else return special;
    }

    public static String[][] sortMemberList(String user, List<List<String>> friends, List<String> visitors){
        scoreList = MemberScoreList(user, friends, visitors);
        memberList = MemberFriendsList(user, friends, visitors);
        String[][] t=new String[scoreList.size()][2];
        for(int i = 0; i< scoreList.size(); i++) {
            t[i][1]= memberList.get(i);
            t[i][0]= String.valueOf(scoreList.get(i));
        }
        Arrays.sort(t, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }
        });
        return t;
    }
}
