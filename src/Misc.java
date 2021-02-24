public class Misc {
    public static void main(String[] args) {

        int n = 4; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods

        System.out.println();
        System.out.println();

        int[] A = { 2, 4, 6, 8, 10 };
        System.out.println("Non recursive result");
        System.out.println(containsSum(A, 12));
        System.out.println();
        System.out.println();
        System.out.println("Recursive result");
        System.out.println(containsSumRecursive(A, 12));

    }

    static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public static boolean containsSum(int[] A, int sum) {
        for (int i = 0, j = A.length - 1; i < j;) {
            if (A[i] + A[j] == sum)
                return true;
            if (A[i] + A[j] < sum)
                i++;
            else
                j--;
        }
        return false;
    }

    public static boolean containsSumRecursive(int[] A, int sum) {
        return containsSumRecursive(A, sum, 0, A.length - 1);
    }
    
    private static boolean containsSumRecursive(int[] A, int sum, int i, int j) {
        if (i == j)
            return false;
        if (A[i] + A[j] == sum)
            return true;
        if (A[i] + A[j] < sum)
            return containsSumRecursive(A, sum, i + 1, j);
        return containsSumRecursive(A, sum, i, j - 1);
    }

}
