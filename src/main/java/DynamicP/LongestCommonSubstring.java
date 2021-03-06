package DynamicP;

public class LongestCommonSubstring {

    public static int algo(String s1, String s2){

        int[][] table = new int[s1.length()][s2.length()];
        table[0][0] = 0;
        int max = 0;

        for( int i = 0; i < s1.length(); i++){
            for( int j = 0; j < s2.length(); j++){

                if(s1.charAt(i) == s2.charAt(j)) {
                    if(i==0 || j==0){
                        table[i][j]=1;
                    }
                    else{
                        table[i][j] = 1 + table[i - 1][j - 1];
                    }
                    max = Math.max(table[i][j], max);
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(algo("bcd", "abcd"));
        System.out.println(lcs("bcd".toCharArray(), "abcd".toCharArray(), 3, 4, 0 ));
    }

    private static int lcs(char[] a, char[] b, int i, int j, int count) {
        if (i == 0 || j == 0)
            return count;

        if (a[i - 1] == b[j - 1]) {
            count = 1+ lcs(a, b, i - 1, j - 1, 0);
        }else
            count = Math.max(lcs(a, b, i, j - 1, 0), lcs(a, b, i - 1, j, 0));

        return count;
    }
}
