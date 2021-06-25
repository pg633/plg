
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer>  m = new HashMap<>();

        char[] chars1 = magazine.toCharArray();
        for (char aChar : chars1) {
            m.put(aChar,m.getOrDefault(aChar,0)+1);
        }

        char[] chars = ransomNote.toCharArray();
        for (char aChar : chars) {
            if(!m.containsKey(aChar)) return false;
            Integer integer = m.get(aChar);
            if(integer ==0) return false;
            integer--;
            m.put(aChar,integer);
        }
        return true;

    }
}
