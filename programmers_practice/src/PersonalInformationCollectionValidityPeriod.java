import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonalInformationCollectionValidityPeriod {
    public static void main(String[] args) {
        PersonalInformationCollectionValidityPeriod p = new PersonalInformationCollectionValidityPeriod();
        String[] privacies = new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] result = p.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, privacies);
        for (int num : result) {
            System.out.print(num + ", ");
        }
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        LocalDate todayDate = makeLocalDate(today);

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            LocalDate period = makeLocalDate(privacy[0]);

            for (String term : terms) {
                String[] termArr = term.split(" ");
                if (termArr[0].equals(privacy[1])) {
                    period = period.plusMonths(Integer.parseInt(termArr[1]));
                }
            }

            if (todayDate.isAfter(period) || todayDate.isEqual(period)) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public LocalDate makeLocalDate(String date) {
        String[] dates = date.split("\\.");

        return LocalDate.of(Integer.parseInt(dates[0]),
                Integer.parseInt(dates[1]),
                Integer.parseInt(dates[2]));
    }
}