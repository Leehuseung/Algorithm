package programmers.lv0;

public class babbling {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] pronounceable = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            int count = 0; // 발음 가능한 문자열의 길이를 합산
            for (String sound : pronounceable) {
                if (word.contains(sound)) {
                    count += sound.length(); // 발음 가능한 문자열의 길이를 더함
                }
            }
            // 합산된 길이가 원본 문자열의 길이와 같으면 카운트 증가
            if (count == word.length()) {
                answer++;
            }
        }
        return answer;
    }
}
