public class wordDictionary {

    // Leetcode 211

    private class TrieNode {

        TrieNode[] arr;
        boolean isLast;
        public TrieNode(){
            arr = new TrieNode[26];
        }
    }

    TrieNode root;

    public wordDictionary() {
        // Init Trie Here
        root = new TrieNode();
    }

    public void addWord(String word) {

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

    public boolean search(String word) {

        return searchWord(word, 0, root);
    }

    public boolean searchWord(String word, int cur, TrieNode p){

        if(p.isLast == true && word.length() == cur){
            return true;
        }

        if(cur >= word.length()){
            return false;
        }

        char c = word.charAt(cur);

        if(c == '.'){

            boolean tRes = false;

            for(int i = 0; i < p.arr.length; i++){
                if(p.arr[i] != null){
                    if(searchWord(word, cur + 1, p.arr[i])){
                        tRes = true;
                        break;
                    }
                }
            }

            if(tRes) return true;

        } else {

            int ind = c - 'a';

            if(p.arr[ind] != null){
                if(searchWord(word, cur + 1, p.arr[ind])){
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;
    }


}
