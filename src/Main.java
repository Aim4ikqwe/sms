import java.util.*;

public class Main {


    public static final int MAX_PAIRS_NUMBER = 16;
    public static final int MIN_PAIRS_NUMBER = 1;
    public static final int MAX_VOTES = 100;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int SMS_Count;
            System.out.println("Введите кол-во sms-сообщений, не больше 100:");
            SMS_Count = input.nextInt();
            if ( SMS_Count <= MAX_VOTES){
                HashMap<Integer, Integer> votes = new HashMap<>(); // Создаем хэшмапу
                for (int i = MIN_PAIRS_NUMBER; i <= MAX_PAIRS_NUMBER; i++) {
                    votes.put(i, 0);  // Даем каждой паре по 0 голосов, а точнее заполняем мапу
                }
                System.out.println("Напишите номера пар:");
                for (int i = 0; i < SMS_Count; i++) {
                    int pair_number = input.nextInt();
                    if (pair_number >= MIN_PAIRS_NUMBER && pair_number <= MAX_PAIRS_NUMBER) {
                        // Если пара существует, то добавляем ей голос
                        votes.put(pair_number, votes.get(pair_number) + 1);
                    }
                }
                // Сортировка пар по кол-ву голосов по убыванию
                ArrayList<Map.Entry<Integer, Integer>> sortedPairs = new ArrayList<>(votes.entrySet()); // Создаем массив, в котором будет происходить сортировка
                sortedPairs.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); // сортируем массив
                for (Map.Entry<Integer, Integer> e : sortedPairs) {
                    System.out.println("Пара " + e.getKey() + ": " + e.getValue() + " голосов");
                }
            }
            if (SMS_Count > MAX_VOTES) {
                System.out.println("Ошибка: количество сообщений превышает 100. Повторите ввод.");
            }


    }
}