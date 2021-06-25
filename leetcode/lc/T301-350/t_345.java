aclass Solution {
public static String reverseVowels(String s) {

        //处理边界以及特殊情况
        if("".equals(s)||s.trim().length()<=1) return s;
        //使用对撞指针
        char[] ch = s.toCharArray();

        int head = 0,tail = ch.length-1;
        while(head<tail) {
        while(!isVowels(ch[head])&&head<tail) {
        head++;
        }
        while(!isVowels(ch[tail])&&tail>head) {
        tail--;
        }
        if(head>tail) break;

        if(ch[head]!=ch[tail]) {
        ch[head] = (char) (ch[head]^ch[tail]);
        ch[tail] = (char) (ch[head]^ch[tail]);
        ch[head] = (char) (ch[head]^ch[tail]);
        }
        head++;
        tail--;

        }

        return String.valueOf(ch);
        }
private static boolean isVowels(char ch) {
        if (ch == 'a' || ch == 'A' ||
        ch == 'e' || ch == 'E' ||
        ch == 'i' || ch == 'I' ||
        ch == 'o' || ch == 'O' ||
        ch == 'u' || ch == 'U'
        ) return true;
        return false;
        }

        }