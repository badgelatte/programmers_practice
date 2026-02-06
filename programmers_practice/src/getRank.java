import java.util.HashSet;
import java.util.Set;

// 주제 : 한 사람당의 평균을 구하여 랭킹 맺기기
class getRank {
    public static void main(String[] args) {
        int[] rseult = solution(new int[][]{{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}});

        for (int i : rseult) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int[][] score) {
        int[] avgs = calculationAvg(score);
        
        int[] sortScores = avgComposition(avgs);
        
        return ranking(avgs, sortScores);
    }
    
    public static int[] calculationAvg(int[][] scores) {
        int[] avgScore = new int[scores.length];
        
        for(int i = 0; i < scores.length; i++) {
            for(int j = 0; j < scores[i].length; j++) {
                avgScore[i] += scores[i][j];
            }
            avgScore[i] /= scores[i].length;
        }
        
        return avgScore;
    }

    public static int[] removeduplicate(int[] arr) {
        Set<Integer> arrSet = new HashSet<>();

        for (int num : arr) {
            arrSet.add(num);
        }

        int count = arrSet.size();
        int[] result = new int[count];

        for (int num : arrSet) {
            result[--count] = num;
        }

        return result;
    }
    
    public static int[] avgComposition(int[] avg) {
        int temp = 0;

        int[] compositions = removeduplicate(avg);
        
        for(int i = 0; i < compositions.length; i++) {
            int max = i;
            
            for(int j = i; j < compositions.length; j++) {
                if(compositions[max] < compositions[j]) {
                    max = j;
                }
            }
            if(max != 0) {
                temp = compositions[max];
                compositions[max] = compositions[i];
                compositions[i] = temp;
            }
        }
        
        return compositions;
    }

    public static int[] ranking(int[] avgs, int[] sortScores) {
        int grade = 1;
        boolean isFirst = true;

        for(int sortScore : sortScores) {
            int count = 0;

            for(int i = 0; i< avgs.length; i++) {
                if(sortScore == avgs[i]) {
                    avgs[i] = grade;

                    if(isFirst) {
                        isFirst = false;
                    } 
                    else {
                        count++;
                    }
                }
            }
            grade++;
            grade += count;
            isFirst = true;
        }

        return avgs;
    }
}
