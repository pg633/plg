class Solution {
    public boolean isNumber(String s) {
        if(s.trim().isEmpty()) return false;
        return s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?");
    }
}