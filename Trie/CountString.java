import java.util.*;

class Node{
    Node links[] = new Node[26];
    boolean flag;
    Node(){
        this.flag = false;
    }

    void setAsEnd(){
        flag = true;
    }
}

class Trie{
    Node head;

    Trie(){
        head = new Node();
    }

    void insert(String word){
        Node node = head;

        for(char ch : word.toCharArray()){
            int charIndex = ch - 'a';

            if(node.links[charIndex] == null){
                node.links[charIndex] = new Node();
            }

            node = node.links[charIndex];
        }
        node.setAsEnd();
    }


    boolean search(String word){
        Node node = head;

        for(char ch : word.toCharArray()){
            int charIndex = ch - 'a';

            if(node.links[charIndex] == null){
                return false;
            }

            node = node.links[charIndex];
        }

        return node.flag;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String words[] = new String[N];

        for(int i = 0; i < N; i++){
            words[i] = sc.next();
        }

        System.out.print(completeString(N, words));
        sc.close();  
    }

    public static String completeString(int N, String[] words) {
        
        Trie trie = new Trie();
        String res = "";
        int maxLen = 0;

        for(String word : words){
            trie.insert(word);
        }

        for(String word : words){
            boolean flag = true;

            for(int i = 0; i < word.length(); i++){
                String prefix = word.substring(0 ,i + 1);

                if(!trie.search(prefix)){
                    flag = false;
                    break;
                }
            }

            if(flag){
                int len = word.length();
                if(len == maxLen){
                    res = lexicographicallySmallest(res ,word);
                }else if(len > maxLen){
                    maxLen = len;
                    res = word;
                }
            }

        }

        return (maxLen == 0) ? "None" : res;
    }


    public static String lexicographicallySmallest(String a ,String b){
        if(a.compareTo(b) < 0){
            return a;
        }

        return b;
    }
}
