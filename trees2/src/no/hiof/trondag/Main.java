package no.hiof.trondag;



public class Main {

    public static class treeNode
    {
        char data;
        treeNode left, right;

        public treeNode(char c, treeNode l, treeNode r)
        {
            data = c;
            left = l;
            right = r;
        }

        public treeNode(char c){
            data = c;
        }
    }

    public treeNode copy(treeNode root){

        // Returnerer en kopi av et binÃ¦rt tre

        if (root == null)
            return null;

        // Lager ny rot og kopierer hele treet med to rekursive kall
        return(new treeNode(root.data, copy(root.left), copy(root.right)));
    }

    public static void main(String[] args) {
	// write your code here
    }
}
