package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 랭킹전 대기열
 */
public class A20006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Room> rooms = new ArrayList<>();
        int p = Integer.parseInt(st.nextToken());   // 플레이어 수
        int m = Integer.parseInt(st.nextToken());   // 방 정원
        User[] users = new User[p];

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            users[i] = new User(level, name);
        }

        ff :
        for (User user : users) {
            for (int j = 0; j < rooms.size(); j++) {
                //들어갈 방이 있니?
                Room room = rooms.get(j);
                //room이 꽉찼니? --> 만드는걸로
                if (room.users.size() == m) {
                    continue;
                }
                //들어갈 자격조건이 되니? --> 다음사람으로
                if (room.isRange(user)) {
                    room.addUser(user);
                    continue ff;
                }
            }
            //들어갈 방이 없으면 만든다.
            Room room = new Room(user, m);
            rooms.add(room);
        }

        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i).print();
        }
    }
}

class Room {
    List<User> users;
    int range;
    int max;
    public Room(User user, int max) {
        this.users = new ArrayList<>();
        users.add(user);
        this.range = user.score;
        this.max = max;
    }
    public boolean isMax() {
        return max == users.size();
    }
    public void addUser(User user){
        users.add(user);
    }

    public void print(){
        Collections.sort(this.users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        if(isMax()) {
            System.out.println("Started!");
        } else {
            System.out.println("Waiting!");
        }
        for (int i = 0; i < this.users.size(); i++) {
            System.out.println(users.get(i).score + " " + users.get(i).name);
        }
    }
    public boolean isRange(User user) {
        return this.range + 10 >= user.score && this.range-10 <= user.score;
    }
}

class User {
    int score;
    String name;

    public User(int score, String name) {
        this.score = score;
        this.name = name;
    }
}
