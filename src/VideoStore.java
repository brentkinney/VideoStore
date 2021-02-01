public class VideoStore {
    public static void main(String[] args) throws Exception {
        if (args[0] =="SLL")
        {
            //run Single Link List methods
        }
        else if (args[0] =="DLL")
        {
            //run Dynamic Link List methods
        }
        else if (args[0] == "BST")
        {
            //run binary search tree methods
        }
        else if (args[0] =="AVL")
        {
            //run avl tree methods
        }
        else
        {
            System.out.println("Please specify which Data Stucture to use as Arg 1: You may use 'SLL', 'DLL', 'BST', or 'AVL'");
        }
    }
}
