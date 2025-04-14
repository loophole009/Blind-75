package org.example.tree;

/**Implements a Trie (prefix tree) for efficient insertion and search of strings.*/
class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts the given word into the Trie.
     *
     * @param word The word to insert.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEndOfWord = true;
    }

    /**
     * Searches for the given word in the Trie.
     *
     * @param word The word to search for.
     * @return True if the word is found in the Trie, false otherwise.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEndOfWord;
    }

    /**
     * Checks if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;

    }


    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // Assuming lowercase English letters
            isEndOfWord = false;
        }
    }

    public static void main(String[] args) {
        Trie solution = new Trie();

        solution.insert("apple");
        System.out.println("Search apple : " + solution.search("apple"));
        System.out.println("Search app : " + solution.startsWith("app"));
    }
}
