import java.util.List;

public class wordSearch2 {

    // Build trie
    // Add all the words from the dictionary
    // Keep forming words and check starts with constantly, if search word matches at some point - return true.

    class TrieNode{
        TrieNode[] arr;
        boolean isLast;

        public void TrieNode(){
            arr = new TrieNode[26];
        }
    }

    TrieNode root;

    public void insertWord(String word){

        TrieNode p = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int ind = c - 'a';
            if(p.arr[ind] == null){
                p.arr[ind] = new TrieNode();
            }
            p = p.arr[ind];
        }

        p.isLast = true;
    }

    public boolean search(String word) {

        TrieNode p = searchNode(word);

        if(p == null) return false;

        return p.isLast;
    }

    public boolean startsWith(String prefix) {

        TrieNode p = searchNode(prefix);

        if(p == null) return false;

        return true;
    }

    public TrieNode searchNode(String word) {
        TrieNode p = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int ind = c - 'a';
            if(p.arr[ind] == null){
                return null;
            }
            p = p.arr[ind];
        }

        return p;
    }


    public List<String> findWords(char[][] board, String[] words) {

        root = new TrieNode();

        for(String word: words){
            insertWord(word);
        }

        return null;
    }
}
