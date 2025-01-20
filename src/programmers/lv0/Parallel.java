package programmers.lv0;

/**
 * Lv.0 평행
 */
public class Parallel {
    public int solution(int[][] dots) {
        // 모든 경우의 조합으로 두 직선의 기울기를 비교
        // 기울기가 같은 경우 평행한 직선이 존재
        if (getSlope(dots[0], dots[1]) == getSlope(dots[2], dots[3])) return 1;
        if (getSlope(dots[0], dots[2]) == getSlope(dots[1], dots[3])) return 1;
        if (getSlope(dots[0], dots[3]) == getSlope(dots[1], dots[2])) return 1;

        // 평행하지 않은 경우
        return 0;
    }
    // 두 점을 선택해 기울기를 비교하는 함수
    public double getSlope(int[] dot1, int[] dot2) {
        return (double) (dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
    }
}
