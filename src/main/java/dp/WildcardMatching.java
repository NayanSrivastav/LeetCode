package dp;

/**
 * Question #44
 * https://leetcode.com/problems/wildcard-matching/
 *
 * Solution here youtube.com/watch?v=7SHV_QfVROE
 */
public class WildcardMatching {

    public static void main(String[] args) {
        System.out.println(isMatch("adceb", "*a??*b"));
    }


    /**
     * a * c ? b
     *
     * @param s
     * @param p
     * @return
     */

    public static boolean isMatch(String s, String p) {
        Boolean[][] result = new Boolean[s.length() + 1][p.length() + 1];

        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < p.length() + 1; j++) {
                result[i][j]=false;
            }
        }

        result[0][0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            result[i][0] = false;
        }

        for (int i = 1; i < p.length() + 1; i++) {
            result[0][i] = result[0][i-1]&&p.charAt(i-1)=='*';
        }

        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < p.length() + 1; j++) {
                System.out.print(result[i][j]+"  ");
            }
            System.out.println();
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if ( s.charAt(i-1) == p.charAt(j-1)||p.charAt(j-1)=='?') {
                    result[i][j] = result[i - 1][j - 1];
                }
                if(p.charAt(j-1)=='*'){
                    result[i][j]=result[i-1][j]||result[i][j-1];
                }
            }
        }

        return result[s.length()][p.length()];
    }
}
