package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Lv.2 오픈채팅방
 */
public class OpenChatRoom {

    static HashMap<String,User> userMap = new HashMap<>();

    public static String[] solution(String[] record) {
        String[] answer = {};

        ChattingRoom chattingRoom = new ChattingRoom();

        for (int i = 0; i < record.length; i++) {
            String[] actionArr = record[i].split(" ");
            String command = actionArr[0];
            String uid = actionArr[1];

            User user = userMap.get(uid);

            switch (command) {
                case "Enter" :
                    String nickName = actionArr[2];

                    if(!userMap.containsKey(uid)){
                        user = new User(uid,nickName);
                        userMap.put(uid, user);
                    } else {
                        user.changeNick(nickName);
                    }

                    chattingRoom.enterUser(user);
                    break;
                case "Leave" :
                    chattingRoom.leaveUser(user);
                    break;
                case "Change" :
                    user.changeNick(actionArr[2]);
                    break;
            }
        }

        return chattingRoom.logToStringArr();
    }

    static class ChattingRoom {
        List<String> logs;

        ChattingRoom() {
            logs = new ArrayList<>();
        }

        public void enterUser(User user){
            logs.add("Enter " + user.uid);
        }

        public void leaveUser(User user){
            logs.add("Leave " + user.uid);
        }

        public String[] logToStringArr(){
            String[] logStringArr = new String[logs.size()];

            for (int i = 0; i < logs.size(); i++) {
                String[] arr = logs.get(i).split(" ");
                String command = arr[0];
                String uid = arr[1];

                User user = userMap.get(uid);
                switch (command) {
                    case "Enter" :
                        logStringArr[i] = user.getNickname()+"님이 들어왔습니다.";
                    break;
                    case "Leave" :
                        logStringArr[i] = user.getNickname()+"님이 나갔습니다.";
                    break;
                }
            }
            return logStringArr;
        }
    }

    static class User {
        String uid;
        String nickname;

        public User(String uid, String nickname) {
            this.uid = uid;
            this.nickname = nickname;
        }

        public String getNickname() {
            return nickname;
        }

        public void changeNick(String nickname) {
            this.nickname = nickname;
        }
    }

    public static void main(String[] args) {
        /*
            ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
            ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
         */

        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));


    }
}
