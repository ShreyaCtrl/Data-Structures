import java.util.*;
class TrieNode {
    boolean isEnd;
    TrieNode links[];
    TrieNode() {
        this.isEnd = false;
        this.links = new TrieNode[26];
    }

    boolean containsKey(char ch) {
        return (this.links[ch-'a'] != null);
    }

    TrieNode getLink(char ch) {
        return this.links[ch-'a'];
    }

    void putLink(char ch, TrieNode node) {
        this.links[ch-'a'] = node;
    }

    void setEnd() {
        this.isEnd = true;
    }

    boolean isEnd() {
        return this.isEnd;
    }
}
class Tries {
    TrieNode root;
    Tries() {
        this.root = new TrieNode();
    }

    void insertNode(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)) continue;
            else
                node.putLink(currentChar, node);
        }
        node.setEnd();
    }

    boolean search(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) return false;
            else
                node = node.getLink(currentChar);
        }
        return node.isEnd();
    }

    boolean startsWith(String prefix) {
        TrieNode node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (!node.containsKey(currentChar)) return false;
            else
                node = node.getLink(currentChar);
        }
        return true;
    }

    public static void main(String[] arg) {
        Trie trie = new Trie();
        trie.insertNode("apple");
        System.out.println("Searching for apple : "+trie.search("apple"));   // return True
        System.out.println("Searching for app : "+trie.search("app"));     // return False
        System.out.println("startsWith for app : "+trie.startsWith("app")); // return True
        trie.insertNode("app");
        System.out.println("Searching for app after insertion : "+trie.search("app"));
    }
}