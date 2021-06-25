class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();

        List<String> res = new ArrayList<>();

        for (String s : words) {
            trie.add(s);
        }

        for (String s : words) {
            if (trie.checkIsConcatenatedWord(s, 0, 0)) {
                res.add(s);
            }
        }

        return res;
    }

    class Trie {
        class Node {
            private boolean isWord;
            
            private Map<Character, Node> next;

            public Node() {
                this(false);
            }

            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new TreeMap<>();
            }
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void add(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) {
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }
            if (!cur.isWord) {
                cur.isWord = true;
            }
        }

        public boolean checkIsConcatenatedWord(String word, int index, int count) {
            Node cur = root;
            for (int i = index; i < word.length(); i++) {
                char c = word.charAt(i);
                if(cur.next.get(c) == null) {
                    return false;
                }
                if (cur.next.get(c).isWord) {
                    if (i == word.length() - 1) {
                        return count >= 1;
                    }
                    if (checkIsConcatenatedWord(word, i + 1, count + 1)) {
                        return true;
                    }
                }
                cur = cur.next.get(c);
            }
            return false;
        }
    }
}