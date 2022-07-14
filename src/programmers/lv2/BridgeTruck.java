package programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Lv2. 다리를 지나는 트럭
 */
public class BridgeTruck {

    public static int time = 0;
    public static int GLOBAL_BRIDGE_LENGTH;

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        GLOBAL_BRIDGE_LENGTH = bridge_length;
        time = 0;

        Queue<Truck> queue = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            queue.add(new Truck(truck_weights[i]));
        }

        Bridge bridge = new Bridge(weight);

        next (queue, bridge);

        time += 1;

        return time;
    }

    public static void next (Queue<Truck> queue,Bridge bridge){
        if(!queue.isEmpty()){
            //트럭을 하나 보낸다.
            Truck truck = queue.poll();
            bridge.pushTruck(truck);
            bridge.goBridgeTruck();
            //다음 트럭을 더해도 무게가 가능하면 다음 트럭을 보낸다.
            if(!queue.isEmpty() && bridge.getLeftWeight() >= queue.peek().getWeight()){
                next(queue,bridge);
            } else {
                //다음 트럭을 보낼수 없으므로 트럭이 완료될때까지 시간을 증가시킨다.
                while(!truck.isStatus()){
                    bridge.goBridgeTruck();
                    //중간에 완료된 트럭이 있을수 있으니, 확인함.
                    if(!queue.isEmpty() && bridge.getLeftWeight() >= queue.peek().getWeight()){
                        next(queue,bridge);
                    }
                }
                next(queue,bridge);
            }
        }
    }


    static class Bridge {
        List<Truck> list = new ArrayList<>();

        Bridge(int weight) {
            this.weight = weight;
            this.leftWeight = weight;
        }
        int weight;
        int leftWeight;

        public void pushTruck(Truck truck){
            list.add(truck);
            leftWeight -= truck.getWeight();
        }


        public int getLeftWeight(){
            return leftWeight;
        }

        //다리에 존재하는 트럭을 한칸씩 증가시킨다.
        public void goBridgeTruck(){
            time++;

            for (Truck truck : list) {
                //완료되지 않았다면
                if(!truck.status){
                    //트럭을 한칸 건너게 하고
                    truck.plusLength();
                    //한칸 건넌후 완료된 트럭이면 완료처리를 한다.
                    if(truck.getLength() == GLOBAL_BRIDGE_LENGTH){
                        truck.processCompelte();
                        leftWeight += truck.getWeight();
                    }
                }
            }
        }
    }

    static class Truck {
        private int weight;
        private int length; //다리를 얼만큼 건넜는지
        private boolean status; //true면 다리를 건넌상태

        Truck(int weight) {
            this.weight = weight;
            this.length = 0;
            this.status = false;
        }

        public void processCompelte(){
            status = true;
        }

        public int getLength() {
            return length;
        }

        public void plusLength() {
            this.length += 1;
        }

        public int getWeight() {
            return weight;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public boolean isStatus() {
            return status;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(2,10,new int[]{7,4,5,6}));
        System.out.println(solution(100,100,new int[]{10}));
        System.out.println(solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10}));
        System.out.println("------------");
        System.out.println(solution(1,1,new int[]{1,1,1}));
        System.out.println(solution(1,1,new int[]{1,1,1}));
        System.out.println(solution(4,2,new int[]{1,1,1,1}));
        System.out.println(solution(3,3,new int[]{1,1,1}));
        System.out.println(solution(3,1,new int[]{1,1,1}));
        System.out.println(solution(5,5,new int[]{1,1,1,1,1,2,2}));
        System.out.println(solution(7,7,new int[]{1,1,1,1,1,3,3}));
        System.out.println(solution(5,5,new int[]{1,1,1,1,1,2,2,2,2,2}));
//        System.out.println(solution(5,5,new int[]{5,5,5,5,5,1,1,1,1,1}));

    }
}
