import java.util.ArrayList;
import java.util.List;

public class gatherDictionary {
    List<String> list = new ArrayList<>();
    String[] gathers = new String[]{"A", "E", "I", "O", "U"};

    public static void main(String[] args) {
        gatherDictionary g = new gatherDictionary();
        System.out.println(g.solution("AAE"));
    }

    public int solution(String word) {
        putGather();
        return list.indexOf(word) + 1;
    }

    public void putGather() {
        for (int i = 0; i < gathers.length; i++) {
            dfs(gathers[i]);
        }
    }

    public void dfs(String str) {
        if (str.length() > gathers.length) {
            return;
        }

        if (!list.contains(str)) {
            list.add(str);
        }

        for (String gather : gathers) {
            dfs(str + gather);
        }
    }
}
