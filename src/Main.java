public class Main {

    // Функция подсчета комбинаций для каждой возможной суммы (от 0 до 27)
    private static int[] countCombinationsForSum() {
        int[] sumsCount = new int[28]; // Массив для хранения комбинаций для каждой суммы от 0 до 27

        // Перебрать все возможные комбинации из трех цифр (0-9)
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    sumsCount[i + j + k]++; // Увеличьте счет на соответствующую сумму
                }
            }
        }
        return sumsCount;
    }

    // Функция подсчета счастливых билетов
    private static int countLuckyTickets() {
        int[] combinations = countCombinationsForSum();
        int luckyTickets = 0;

        // Подсчитайте количество счастливых билетов
        for (int sum = 0; sum < 28; sum++) {
            luckyTickets += combinations[sum] * combinations[sum];
            /* Квадрат каждого количества комбинаций,
            потому что это у нас permutation,
            это значит что 001, 010, 100 для разные суммы хотя они все дают для нас 1 */
        }

        return luckyTickets;
    }


    public static void main(String[] args) {
        int result = countLuckyTickets();
        System.out.println("Количество счастливых билетов: " + result);
    }
}