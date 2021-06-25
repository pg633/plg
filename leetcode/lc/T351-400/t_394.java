class Solution {
    public String decodeString(String s) {
        LinkedList<String> strStack = new LinkedList<>();
        LinkedList<Integer> countStack = new LinkedList<>();
        int i = 0;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (i < chars.length) {
            while (Character.isDigit(chars[i])) {
                sb.append(chars[i++]);
            }
            if (sb.length() != 0) {
                countStack.addLast(Integer.valueOf(sb.toString()));
                sb.delete(0, sb.length());
            }
            while (i < chars.length && Character.isLetter(chars[i])) {
                sb.append(chars[i++]);
            }
            if (sb.length() != 0) {
                strStack.addLast(sb.toString());
                sb.delete(0, sb.length());
            }
            if (i < chars.length && chars[i] == '[') {
                strStack.addLast("[");
                i++;
            }
            if (i < chars.length && chars[i] == ']') {
                String str = "";
                while (!strStack.isEmpty()) {
                    if (!"[".equals(strStack.peekLast())) {
                        str = strStack.pollLast() + str;
                    } else {
                        strStack.pollLast();
                        break;
                    }
                }
                int count = countStack.removeLast();
                for (int j = 0; j < count; j++) {
                    sb.append(str);
                }
                strStack.addLast(sb.toString());
                sb.delete(0, sb.length());
                i++;
            }
        }
        while (!strStack.isEmpty()) {
            sb.append(strStack.removeFirst());
        }
        return sb.toString();
    }
}
