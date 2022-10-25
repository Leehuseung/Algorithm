package programmers.lv3;

import java.util.*;

/**
 * Lv3. 베스트앨범
 */
public class BestAlbum {
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> cntMap = new HashMap<>();
        Music[] musics = new Music[plays.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            musics[i] = new Music(i,genres[i], plays[i]);
            cntMap.put(genres[i], cntMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        Genre[] genresArr = new Genre[cntMap.size()];
        int t = 0;
        for (String s : cntMap.keySet()) {
            genresArr[t++] = new Genre(cntMap.get(s),s);
        }

        Arrays.sort(genresArr , (o1, o2) -> o2.cnt-o1.cnt);
        Arrays.sort(musics, (o1, o2) -> {
            if(o2.play == o1.play){
                return o1.num - o2.num;
            }
            return o2.play-o1.play;
        });

        for (int i = 0; i < genresArr.length; i++) {
            int k = 0;
            for (int j = 0; j < musics.length; j++) {
                if(genresArr[i].name.equals(musics[j].genre)){
                    k++;
                    list.add(musics[j].num);
                }
                if(k == 2){
                    break;
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    static class Genre{
        int cnt;
        String name;

        public Genre(int cnt, String name) {
            this.cnt = cnt;
            this.name = name;
        }
    }

    static class Music {
        int num;
        String genre;
        int play;

        public Music(int num, String genre, int play) {
            this.num = num;
            this.genre = genre;
            this.play = play;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic"}, new int[]{500, 600, 150, 800})));
    }
}
