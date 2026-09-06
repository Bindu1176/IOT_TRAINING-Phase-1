public class TrieExample {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
    static class Trie {
        TrieNode root = new TrieNode();
        void insert(String word) {
            TrieNode current = root ;
            for(char ch : word.toCharArray()) {
                int index = ch - 'a';
                if(current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEnd = true;
        }
        boolean search(String word) {
            TrieNode current = root;
            for(char ch : word.toCharArray()) {
                int index = ch - 'a';
                if(current.children[index]==null) {
                    return false;
                }
                current = current.children[index];
            }
            return current.isEnd;
        }
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apply");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("ape"));
    }
}