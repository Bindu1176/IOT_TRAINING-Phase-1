import java.util.*;
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    int prefixCount;
    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
        prefixCount = 0;
    }
}
class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
            current.prefixCount++;
        }
        current.isEndOfWord = true;
    }
    public int countWordsWithPrefix(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return 0; // prefix not found
            }
            current = current.children.get(ch);
        }
        return current.prefixCount;
    }
}
public class PrefixCounter {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("apt");
        trie.insert("bat");
        trie.insert("batch");
        trie.insert("ball");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a prefix: ");
        String prefix = sc.nextLine();
        int count = trie.countWordsWithPrefix(prefix);
        System.out.println("Number of words starting with \"" + prefix + "\": " + count);
    }
}