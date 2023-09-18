import java.util.*;

class Rm {
    public static int finalBalance(int[] A, String[] D) {
        int balance = 0;
        Map<String, Integer> cardPayments = new HashMap<>();
        Set<String> paidMonths = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            int amount = A[i];
            String date = D[i];
            String[] dateParts = date.split("-");
            int month = Integer.parseInt(dateParts[1]);

            if (amount < 0) { // Card payment
                balance += amount;
                cardPayments.put(date, cardPayments.getOrDefault(date, 0) + amount);
            } else { // Incoming transfer
                balance += amount;
            }

            if (cardPayments.containsKey(date) && cardPayments.get(date) <= -100) {
                paidMonths.add(dateParts[1]);
            }
        }

        for (int month = 1; month <= 12; month++) {
            String monthStr = String.format("%02d", month);
            String endOfMonth = "2020-" + monthStr + "-31";
            if (!paidMonths.contains(monthStr)) {
                balance -= 5;
            }
        }

        return balance;
    }
    public static int finalBalance1(int[] A, String[] D) {
        Map<Integer, Integer> monthCardPayments = new HashMap<>();
        int totalIncome = 0;
        int totalFee = 0;

        for (int i = 0; i < A.length; i++) {
            String[] dateParts = D[i].split("-");
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);

            if (year == 2020) {
                totalIncome += A[i];

                if (A[i] < 0) {
                    int cardMonth = month;
                    monthCardPayments.put(cardMonth, monthCardPayments.getOrDefault(cardMonth, 0) - A[i]);
                }
            }
        }

        for (int month = 1; month <= 12; month++) {
            if (totalIncome - monthCardPayments.getOrDefault(month, 0) < 100) {
                totalFee += 5;
            }
        }

        return totalIncome - totalFee;
    }


    public static void main(String[] args) {
        int[] A = {-60, 60, -40, -20};
        String[] D = {"2020-10-01", "2020-02-02", "2020-10-10", "2020-10-30"};
        int result = finalBalance1(A, D);
        System.out.println("Final balance at the end of 2020: " + result);
    }
}
