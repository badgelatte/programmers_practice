class makeAtoB {
    public static void main(String[] args) {
        System.out.println(makess("alpop", "apple"));
    }

    public static int makess(String before, String after) {
        String[] beforeLetters = before.split("");
        String[] afterLetters = after.split("");
        
        for(int i = 0; i < before.length(); i++) {
            for(int j = 0; j < after.length(); j++) {
                if(beforeLetters[i].equals(afterLetters[j])) {
                    beforeLetters[i] = "";
                    afterLetters[j] = "";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i< before.length(); i++) {
            sb.append(beforeLetters[i]);
        }
        
        if(sb.isEmpty()) {
            return 1;
        }
        return 1;
    }
}
