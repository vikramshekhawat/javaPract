public class MaxPathHoles {

    public static int  demo(String S, int B) {
        int N = S.length();
        int[] cost = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            cost[i] = cost[i - 1] + (S.charAt(i - 1) == 'x' ? 1 : 0);
        }

        int maxPotholes = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int potholesToFix = cost[j] - cost[i];
                int segmentCost = j - i + 1;
                if (segmentCost <= B && potholesToFix > maxPotholes) {
                    maxPotholes = potholesToFix;
                }
            }
        }

        return maxPotholes;
    }
    public static int solution3(String S, int B) {
        int maxPotholesFixed = 0;
        int currentCost = 0;
        int left = 0;

        for (int right = 0; right < S.length(); right++) {
            if (S.charAt(right) == 'x') {
                int costToFix = right - left + 1;
                currentCost += costToFix;

                while (currentCost > B) {
                    currentCost -= right - left + 1;
                    left++;
                }

                maxPotholesFixed = Math.max(maxPotholesFixed, right - left + 1);
            }
        }

        return maxPotholesFixed / 2;
    }

        public static int solution(String S, int B) {
            int N = S.length();
            int maxPotholes = 0;

            for (int i = 0; i < N; i++) {
                int consecutivePotholes = 0;
                int segmentCost = 0;
                for (int j = i; j < N; j++) {
                    if (S.charAt(j) == 'x') {
                        consecutivePotholes++;
                        segmentCost += consecutivePotholes;
                    }
                    if (segmentCost <= B && consecutivePotholes > maxPotholes) {
                        maxPotholes = consecutivePotholes;
                    }
                }
            }

            return maxPotholes;
        }

    public static int demo1(String S, int B) {
        int N = S.length();
        int[] cost = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            cost[i] = cost[i - 1] + (S.charAt(i - 1) == 'x' ? 1 : 0);
        }

        int maxPotholes = 0;
        for (int i = 0; i <= N; i++) { // Change the loop condition from i < N to i <= N
            for (int j = i + 1; j <= N; j++) {
                int potholesToFix = cost[j] - cost[i];
                int segmentCost = j - i;
                if (segmentCost <= B && potholesToFix > maxPotholes) {
                    maxPotholes = potholesToFix;
                }
            }
        }

        return maxPotholes;
    }

    public static int maxFixedPotholes(String S, int B) {
        int N = S.length();
        int potholesFixed = 0;
        int cost = 0;

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'x') {
                // Calculate the cost to fix the current pothole
                int consecutivePotholes = 0;
                while (i < N && S.charAt(i) == 'x') {
                    consecutivePotholes++;
                    i++;
                }
                int currentCost = consecutivePotholes + 1;

                // If we have enough budget, fix the potholes
                if (cost + currentCost <= B) {
                    cost += currentCost;
                    potholesFixed += consecutivePotholes;
                } else {
                    break; // Stop if we can't afford to fix more potholes
                }
            }
        }
        return potholesFixed;
    }
    public static int solution6(String S, int B) {
        int n = S.length();
        int maxPotholesFixed = 0;

        // Iterate through the road
        for (int i = 0; i < n; i++) {
            int consecutivePotholes = 0;
            int cost = 0;

            // Try to fix consecutive potholes starting from the current position
            for (int j = i; j < n; j++) {
                if (S.charAt(j) == 'x') {
                    consecutivePotholes++;
                    cost += (consecutivePotholes + 1); // Cost to fix current segment
                }

                // Check if we exceed the budget
                if (cost > B) {
                    break;
                }

                // Update the maximum number of potholes fixed
                maxPotholesFixed = Math.max(maxPotholesFixed, consecutivePotholes);
            }
        }

        return maxPotholesFixed;
    }

    public static void main(String[] args) {
        String s = "x.x.xxx...x";
        int budget = 14;
        int maxPotholesFixed = solution6(s, budget);
        System.out.println("Maximum potholes fixed: " + maxPotholesFixed);
    }
}
