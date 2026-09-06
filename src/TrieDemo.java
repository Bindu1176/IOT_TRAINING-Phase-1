public class TrieDemo {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }
    static TrieNode root = new TrieNode();
    static void insert(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index]==null) {
                current.children[index]= new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    static boolean search(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index]==null)
                return false ;
            current = current.children[index];

        }
        return current.isEndOfWord;
    }
    static boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index]==null)
                return false;
            current = current.children[index];
        }
        return true;
    }
    public static void main(String[] args) {
        insert("cat");
        insert("car");
        insert("can");
        insert("dog");
        System.out.println("Search cat : "+search("cat"));
        System.out.println("Search cap : "+search("cap"));
        System.out.println("Prefix ca : "+startsWith("ca"));
        System.out.println("Prefix do : "+startsWith("do"));
    }
}