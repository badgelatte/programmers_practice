import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class triangle {
    public static void main(String[] args) {
        int[] order = new int[2];
        int[] a = calculateChicken(order, 1999);
        // System.out.println(solutionnn(new int[]{0,1,2,4,3}, new int[][]{{0,4,1}, {0,3,2},{0,3,3}}));
        solution33(10);
    }

    public static int[] solution33(int n) {
        List<Integer> list = new ArrayList();
        while(n != 1) {
            if(n % 2 == 0) {
                list.add(n);
                n /= 2;
            }
            else {
                list.add(n);
                n = 3 * n + 1;
            }
        }
        
        return listToArr(list);
    }
    
    public static int[] listToArr(List<Integer> list) {
        int[] arr = new int[list.size()];
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        
        return arr;
    }

    public static int[] solutionnn(int[] arr, int[][] queries) {
        for(int[] query : queries) {
            for(int i = query[0]; i <= query[1]; i++) {
                if(arr[i] % query[2] == 0) {
                    arr[i]++;
                }
            }

            for (int a : arr) {
                System.out.print(a);
            }
            System.out.println();
        }
        return arr;
    }

    public static int[] calculateChicken(int[] order, int chicken) {
        order[0] += chicken / 10;
        order[1] += chicken % 10;
        chicken /= 10;
        
        if(chicken > 0) {
            order = calculateChicken(order, chicken);
            if(order[1] >= 10) {
                order[0]++;
                order[1] -= 9;
            }
        }
        
        return order;
    }

    public static int[] solution5(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        
        for(int i = 0; i < numlist.length; i++) {
            numlist[i] -= n;
        }
        
        Arrays.sort(numlist);
        
        if(numlist[0] >= 0) {
            for(int i = 0; i < numlist.length; i++) {
                numlist[i] += n;
            }
            return numlist;
        }
        
        int min = 0;
        
        for(int i = 0; i < numlist.length; i++) {
            if(Math.abs(numlist[i]) < Math.abs(numlist[min])) {
                min = i;
            }
        }
        
        answer[0] = numlist[min] + n;
        int before = min - 1;
        int after = min + 1;
        
        for(int i = 1; i < numlist.length; i++) {
            // before나 after가 범위 밖인데 비교되는 경우가 나와서 오류남
            if(before < 0) {
                answer[i] = numlist[after++];
                continue;
            }
            if(after >= numlist.length) {
                answer[i] = numlist[before--];
                continue;
            }
            
            if(Math.abs(numlist[before])  < numlist[after]) {
                answer[i] = numlist[before--];
            } 
            else {
                answer[i] = numlist[after++];
            }
        }
        
        // 이중포문으로 Math.abs로 따지기
        // for(int i = 0; i < numlist.length; i++) {
        //     for(int j = 0; j < numlist.length; j++) {
        //         if()
        //     }
        // }
        return answer;
    }

    public static int solution4(int[][] lines) {
        List<Integer> overlapList = new ArrayList<>();
        int result = 0;

        for (int[] line : lines) {
            int location = line[0] + 1;

            while(line[1] > location) {
                overlapList.add(location++);
            }
        }

        Collections.sort(overlapList);
        int[] overlaps = new int[overlapList.size()];
        int[] a1 = Arrays.copyOf(overlaps, result);

        for (int i = 0; i < overlaps.length; i++) {
            overlaps[i] = overlapList.get(i);
        }

        for (int i = 0; i < overlaps.length - 1; i++) {
            if(overlaps[i] == overlaps[i+1]) {
                result++;
            }
        }

        return result;
    }

    public static int solution3(int[][] lines) {
        int answer = 0;
        
        int[][] overlap = new int[3][2];
        
        // 1
        if(lines[0][1] < lines[1][0] && lines[0][0] > lines[1][0]) {
            overlap[0] = new int[] {lines[1][0], lines[0][1]};
        }
        
        // 2
        if(lines[1][1] > lines[2][0] && lines[1][1] > lines[2][1]) {
            overlap[1] = new int[] {lines[2][0], lines[1][1]};
        }
        
        // 3
        // if(lines[0][1] < lines[2][0] && lines[0][0] > lines[2][0]) {
        //     overlap[2] = new int[] {lines[2][0], lines[0][1]};
        // }
        
        for(int i = 0; i < overlap.length; i++) {
            answer += (overlap[i][1] - overlap[i][0]);
        }
        return answer;
    }


    public static int solution2(int a, int b) {
        int gcf = getGcf(a, b);
        a /= gcf;
        b /= gcf;
        
        int[] primeFactors = isPrimeFactor(b);
        
        if(primeFactors[0] == 0) {
            return 1;
        }
        
        for(int i = 0; i < primeFactors.length; i++) {
            if(primeFactors[i] != 2 && primeFactors[i] != 5 && primeFactors[i] != 0) {
                return 1;
            }
        }
        
        return 2;
    }
    
    public static int getGcf(int a, int b) {
        int min = a < b ? a : b;
        int gcf = 1;
        
        for(int i = 2; i <= min; i++) {
            if(a % i == 0 && b % i == 0) {
                gcf = i;
            }
        }
        
        return gcf;
    }
    
    public static int[] isPrimeFactor(int n) {
        int[] primeFactors = new int[n];
        int count = 0;
        
        for(int i = 2; i <= n; i++) {
            while(n % i == 0) {
                n /= i;
                primeFactors[count++] = i;
            }
        }
        
        return primeFactors;
    }




    public static int solution(int n) {
        int count = 1;
        for(int i = 2; i <= n; i++) {
            count++;
            while(isNothingWith3(count)) {
                count++;
            }
        }
        List<Integer> primeList = new ArrayList<>();
        return count;
    }

    public static boolean isNothingWith3 (int n) {
        if(n > 10 && (n % 10 == 3 || n / 10 == 3)) {
            return true;
        }

        return n % 3 == 0;
    }
    
    public static boolean useSpells (List<String> spell, String[] words) {
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < spell.size(); j++) {
                if(words[i].equals(spell.get(j))) {
                    spell.remove(spell.get(j));
                }
            }
        }
        return spell.isEmpty();
    }

}
