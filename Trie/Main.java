import java.util.*;
/*
1. insert
2. search
3. starts with
*/


class Trie{
    Node head;

    Trie(){
        this.head = new Node();
    }

    void insertHelper(String str ,int index ,Node node){
        if(index == str.length()){
            node.setAsEnd();
            return;
        }
        int charIndex = str.charAt(index) - 'a';
        if(node.links[charIndex] == null){
            node.links[charIndex] = new Node();
        }

        insertHelper(str, index + 1, node.links[charIndex]);
    }

    void insert(String str){
        insertHelper(str, 0, head);
    }

    boolean searchHelper(String str ,int index ,Node node){
        if(index == str.length()){
            return node.flag;
        }
        int charIndex = str.charAt(index) - 'a';
        if(node.links[charIndex] == null){
            return false;
        }

        return searchHelper(str, index + 1, node.links[charIndex]);
    }

    boolean search(String str){
        return searchHelper(str, 0, head);
    }

    boolean startsWithHelper(String str ,int index ,Node node){
        if(index == str.length()){
            return true;
        }
        int charIndex = str.charAt(index) - 'a';
        if(node.links[charIndex] == null){
            return false;
        }

        return startsWithHelper(str, index + 1, node.links[charIndex]);
    }

    boolean startsWith(String str){
        return startsWithHelper(str, 0, head);
    }
}

class Node{
    Node[] links = new Node[26];
    boolean flag;
    Node(){
        this.flag = false;
    }

    void setAsEnd(){
        flag = true;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();
        int N = sc.nextInt();
        sc.nextLine();

        while(N -- > 0){
            int q = sc.nextInt();
            String word = sc.next();

            if(q == 1){
                trie.insert(word);
            }else if(q == 2){
                if(trie.search(word)){
                    System.out.println(word + " Found");
                }else{
                    System.out.println(word + " Not Found");
                }
            }else{
                if(trie.startsWith(word)){
                    System.out.println("Found word Starts With " + word);
                }else{
                    System.out.println("Not Found word Starts With " + word);
                }
            }
        }


        sc.close();
    }
}
