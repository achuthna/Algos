class TrieNode {
    TrieNode[] arr;
    boolean isLast;

    public TrieNode(){
        this.arr = new TrieNode[26];
    }
}

class trie {

    TrieNode root;

    public trie(){
        this.root = new TrieNode();
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

    public void insert(String word) {

        // First fetch the root
        TrieNode p = root;

        // Traverse down and populate
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

    // Should add support for delete
    public void delete(String word){

    }

    public static void main(String[] args){

        trie t = new trie();

        t.insert("test");

        System.out.println(t.startsWith("te"));
    }

}