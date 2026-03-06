public class recommendNewID {
    public String solution(String new_id) {
        //1단계
        new_id = new_id.toLowerCase();

        // 2단계
        new_id = new_id.replaceAll("[^-_.a-z0-9]","");
        // 3단계
        new_id = new_id.replaceAll("[.]+",".");

        // 4단계
        if (!new_id.isEmpty()&& new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }

        if (!new_id.isEmpty()&& new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 5단계
        if (new_id.length() == 0) {
            new_id = "a";
        }

        // 6단계
        if (new_id.length() > 15) {
            new_id = new_id.substring(0,15);
            if (new_id.charAt(14) == '.') {
                new_id = new_id.substring(0,14);
            }
        }

        // 7단계
        if (new_id.length() < 3) {
            String str = new_id.substring(new_id.length() - 1);
            while (new_id.length() < 3) {
                new_id += str;
            }
        }

        return new_id;
    }
}