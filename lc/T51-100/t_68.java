package leetcoder;

public class Solution {
    public ArrayList<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<String>();
        int n = words.length;
        int i = 0;
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int last = i + 1;
            int len = words[i].length();
            while (last < n && len + 1 + words[last].length() <= maxWidth) {
                len += 1 + words[last].length();
                last++;
            }
            if (last == n) {
                for (int j = i; j < n; j++) {
                    sb.append(words[j] + " ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int j = sb.length(); j < maxWidth; j++) {
                    sb.append(" ");
                }
            } else {
                if (last - i == 1) {
                    sb.append(words[i]);
                    for (int j = words[i].length(); j < maxWidth; j++)
                        sb.append(" ");
                } else {
                    int wordNum = last - i;
                    int wordTotal = 0;
                    for (int j = i; j < last; j++) {
                        wordTotal += words[j].length();
                    }
                    int eachSpace = (maxWidth - wordTotal) / (wordNum - 1);
                    int r = (maxWidth - wordTotal) % (wordNum - 1);

                    for (int j = i; j < last; j++) {
                        sb.append(words[j]);
                        if (j < last - 1) {
                            for (int k = 0; k < eachSpace + ((j - i) < r ? 1 : 0); k++) {
                                sb.append(" ");
                            }
                        }
                    }
                }
            }
            res.add(sb.toString());
            i = last;
        }
        return res;
    }
}