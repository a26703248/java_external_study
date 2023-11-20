package blog.howardli.java_external_study.algorithm;

public class BMMain {
    // given a string str and a pattern pat, find the first occurrence of pat in str(use BM algorithm)
    public static void main(String[] args) {
        String str = "ababababca";
        String pat = "abababca";
        System.out.println(bm(str, pat));
    }

    private static int bm(String str, String pat) {
        int[] bc = generateBC(pat);
        int[] suffix = new int[pat.length()];
        boolean[] prefix = new boolean[pat.length()];
        generateGS(pat, suffix, prefix);
        int i = 0, j;
        while (i <= str.length() - pat.length()) {
            for (j = pat.length() - 1; j >= 0; j--) {
                if (str.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j < 0) {
                return i;
            }
            int x = j - bc[str.charAt(i + j)];
            int y = 0;
            if (j < pat.length() - 1) {
                y = moveByGS(j, pat.length(), suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    private static int[] generateBC(String pat) {
        int[] bc = new int[256];
        for (int i = 0; i < 256; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < pat.length(); i++) {
            bc[pat.charAt(i)] = i;
        }
        return bc;
    }

    private static void generateGS(String pat, int[] suffix, boolean[] prefix) {
        int length = pat.length();
        for (int i = 0; i < length; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < length - 1; i++) {
            int j = i;
            int k = 0;
            while (j >= 0 && pat.charAt(j) == pat.charAt(length - 1 - k)) {
                j--;
                k++;
                suffix[k] = j + 1;
            }
            if (j == -1) {
                prefix[k] = true;
            }
        }
    }

    private static int moveByGS(int j, int length, int[] suffix, boolean[] prefix) {
        int k = length - 1 - j;
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }
        for (int r = j + 2; r <= length - 1; r++) {
            if (prefix[length - r]) {
                return r;
            }
        }
        return length;
    }
}
