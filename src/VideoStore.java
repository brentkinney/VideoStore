/**
 * This is the main driver of the video store program, it takes in 1 of 4 data structure types and creates all videos/customers/rentals in the associated
 * data structure.
 * I chose/was forced not to implement this program using an interface as I had started on my data strucutre classes first and wrote each somewhat differently
 * from the others.  By the time I got to the VideoStore portion, I realized my error.  What I should have done was set the overall VideoStore outline first
 * and then created my data strucutre classes all in the same exact way so the VideoStore stuff would function the same way for each datatype.
 * That way I wouldnt have had to hack together my VideoStore methods with the data structure methods to achieve the required result... But, even though
 * this implementation could have been cleaner, it gets the job done and will have to be a learning experience for me.
 */

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
public class VideoStore {
    private static String datatype = "";
    private static int videoCount = 1;
    private static int customersCount = 1;
    private static AVL videosAVL;
    private static AVL customersAVL;
    private static BST videosBST;
    private static BST customersBST;
    private static DLL videosDLL;
    private static DLL customersDLL;
    private static SLL videosSLL;
    private static SLL customersSLL;
    private static Stack<Integer> transactionStack;
    
	public static void main(String[] args) {
		
		//check args given
		if(args.length > 0) {
            datatype = args[0];
        }
        else {
            System.out.println("You must choose from any of the following data structures: SLL, DLL, BST, and AVL.");
            quit();
        }        
		
		
		switch(datatype) {
        case "SLL":            
            videosSLL = new SLL();
            customersSLL = new SLL();            
            break;
        case "DLL":            
            videosDLL = new DLL();
            customersDLL = new DLL();           
            break;
        case "BST":            
            videosBST = new BST();
            customersBST = new BST();            
            break;
        case "AVL":            
            videosAVL = new AVL();
            customersAVL = new AVL();            
            break;        
		}
		
		
        
        int videosInStore = 0;
        int customersOfStore = 0;
        int transactionsCompleted = 0;
        
        //check if there are 3 more parameters being passed to the program        
        if(args.length == 4) {
            videosInStore = Integer.parseInt(args[1]);
            customersOfStore = Integer.parseInt(args[2]);
            transactionsCompleted = Integer.parseInt(args[3]);
        }
        
        /*
         * print out the length of what was submitted
         * also print out what was submitted
         */
        System.out.println("Length: " + args.length);
        System.out.println("Videos: " + videosInStore + ", Customers: " + customersOfStore + ", Transactions: " + transactionsCompleted);
        
        
        if(videosInStore == 0 && customersOfStore == 0 && transactionsCompleted == 0) {        	
        	
            Scanner input = new Scanner(new InputStreamReader(System.in));
            String userSelection;
            
            while(true) {            	
                menu();                 
                userSelection = input.nextLine();
                
                switch(userSelection) {
                	//The user selects the first item in the menu and wants to add a video
                    case "1":
                        System.out.println("Please enter name of the video:");
                        
                        System.out.print("Name: ");
                        String videoTitle = input.nextLine().trim();
                        
                        //increment the number of videos we have and pass it to the inputVideo method so it can be added to the list
                        inputVideo(videoCount++, videoTitle);
                        
                        break;
                    case "2":
                    	//User would like to delete a video
                        System.out.println("Enter the ID of the video you would like to delete:");
                        System.out.print("ID: ");
                        String videoID = input.nextLine().trim();
                        
                        while(!videoID.matches("^\\d+$")) {
                            System.out.println("ID's can only be numbers.");//check input
                            System.out.print("ID: ");
                            videoID = input.nextLine().trim();
                        }
                        
                        removeVideo(Integer.parseInt(videoID));//call the remove method and pass it the video ID
                        
                        break;
                    case "3":
                    	//Add a customer
                        System.out.println("Enter the customer's name:");
                        System.out.print("Customer Name: ");
                        String customerName = input.nextLine().trim();
                        
                        insertCustomer(customersCount++, customerName);
                        
                        break;
                    case "4":
                    	//remove a customer
                        System.out.println("Enter the Customers' ID to be deleted:");
                        
                        System.out.print("ID: ");
                        String customerID = input.nextLine().trim();
                        
                        while(!customerID.matches("^\\d+$")) {
                            System.out.println("ID's can only be numbers.");//Check input
                            System.out.print("ID: ");
                            customerID = input.nextLine().trim();
                        }
                        
                        deleteCustomer(Integer.parseInt(customerID));
                        
                        break;
                    case "5":
                    	//search for a video in the store
                        System.out.println("Enter the ID of the video you would like to search for:");
                        
                        System.out.print("ID: ");
                        String case5VideoID = input.nextLine().trim();
                        
                        while(!case5VideoID.matches("^\\d+$")) {
                            System.out.println("ID's can only be number.");
                            System.out.print("ID: ");
                            case5VideoID = input.nextLine().trim();
                        }
                        
                        System.out.println(checkInStore(Integer.parseInt(case5VideoID)));
                        
                        break;
                    case "6":
                    	//Checkout a video
                        System.out.println("Enter the customer and video ID:");
                        
                        System.out.print("Customer ID: ");
                        String case6CustomerID = input.nextLine().trim();
                        
                        while(!case6CustomerID.matches("^\\d+$")) {
                            System.out.println("ID's can only be numbers.");
                            System.out.print("Customer ID: ");
                            case6CustomerID = input.nextLine().trim();
                        }
                        
                        System.out.print("Video ID: ");
                        String case6VideoID = input.nextLine().trim();
                        
                        while(!case6VideoID.matches("^\\d+$")) {
                            System.out.println("ID's can only be numbers.");
                            System.out.print("Video ID: ");
                            case6VideoID = input.nextLine().trim();
                        }
                        
                        videoCheckOut(Integer.parseInt(case6CustomerID), Integer.parseInt(case6VideoID));
                        
                        break;
                    case "7":
                    	//Check in a video
                        System.out.println("Enter the video ID:");
                        
                        System.out.print("ID: ");
                        String case7VideoID = input.nextLine().trim();
                        
                        while(!case7VideoID.matches("^\\d+$")) {
                            System.out.println("ID's can only be numbers.");
                            System.out.print("ID: ");
                            case7VideoID = input.nextLine().trim();
                        }
                        
                        //If the video is checked out, then check in
                        videoCheckIn(Integer.parseInt(case7VideoID));
                        
                        break;
                    case "8":
                    	//Print all the customers in the store                    
                        switch(datatype) {
                            case "SLL":
                            	customersSLL.print();
                                break;
                            case "DLL":
                            	customersDLL.print();
                                break;
                            case "BST":
                            	customersBST.print(customersBST.getRoot());
                                break;
                            case "AVL":
                            	customersAVL.print(customersAVL.getRoot());
                                break;
                            default:
                                break;
                        }
                        
                        break;
                    case "9":
                        //Print all the videos of the store
                        printCheckedIn();
                        printCheckedOut();
                        
                        break;
                    case "10":
                        //Print videos in store
                        printCheckedIn();
                        
                        break;
                    case "11":
                        //Print all checked out videos
                        printCheckedOut();
                        
                        break;
                    case "12":
                    	//Print all the videos rented by a specific customer
                        System.out.println("Please enter the customer ID:");
                        
                        System.out.print("ID: ");
                        String case12CustomerID = input.nextLine().trim();
                        
                        while(!case12CustomerID.matches("^\\d+$")) {
                            System.out.println("ID's can only be numbers, please try again.");
                            System.out.print("ID: ");
                            case12CustomerID = input.nextLine().trim();
                        }
                        
                        //print checked out videos
                        printAtElement(Integer.parseInt(case12CustomerID));
                        
                        break;
                    case "13":
                    	//Exit the Store
                        System.out.println("End of Line.");
                        input.close();
                        quit();
                        break;
                }
            }
        } else {
            //if additional args are given in main, we process transactions
            for(int i = 0; i < videosInStore; i++) {
                inputVideo(videoCount++, "Video " + (i + 1));
            }
            
            for(int i = 0; i < customersOfStore; i++) {
                insertCustomer(customersCount++, "Customer " + (i + 1));
            }
            
            transactionStack = new Stack<>();
            for(int i = 0; i < transactionsCompleted; i++) {
                int random = 5 + (int)(Math.random() * ((7 - 5) + 1));
                transactionStack.push(random);
            }
            
            
            final long startTime = System.currentTimeMillis();
            
            for(int i = 0; i < transactionsCompleted; i++) {
                int temp = transactionStack.pop();
                
                //Video is in store
                if(temp == 5) {
                    int videoRandom = 1 + (int)(Math.random() * ((videoCount - 1) + 1));
                    checkInStore(videoRandom);
                }
                
                //Video is being checked out
                if(temp == 6) {
                    int customerRandom = 1 + (int)(Math.random() * ((customersCount - 1) + 1));
                    int videoRandom = 1 + (int)(Math.random() * ((videoCount - 1) + 1));
                    videoCheckOut(customerRandom, videoRandom);
                }
                
                //Video is being checked in
                if(temp == 7) {
                    int videoRandom = 1 + (int)(Math.random() * ((videoCount - 1) + 1));
                    videoCheckIn(videoRandom);
                }
                
            }
            
            final long stopTime = System.currentTimeMillis();
            //print execution time													
            System.out.println("Operation Took: " + ((stopTime - startTime) / 1000.0) + "seconds");
            																		

        }

	}
	
	
	private static void menu() {
        System.out.println("\n===========================");
        System.out.println("Select one of the following...");
        System.out.println("1: To add a video");
        System.out.println("2: To delete a video");
        System.out.println("3: To add a customer");
        System.out.println("4: To delete a customer");
        System.out.println("5: To check if a particular video is in store");
        System.out.println("6: To check out a video");
        System.out.println("7: To check in a video");
        System.out.println("8: To print all customers");
        System.out.println("9: To print all videos");
        System.out.println("10: To print in store videos");
        System.out.println("11: To print all rent videos");
        System.out.println("12: To print the videos rent by a customer");
        System.out.println("13: To exit");
        System.out.println("===========================");
    }
	
	/**
     * insert given video
     * @param id is the id the video will have
     * @param name is the video title
     */
    private static void inputVideo(int id, String name) {
        switch(datatype) {
            case "SLL":
            	videosSLL.add(new SLLNode(new Video(id, name), null));
                break;
            case "DLL":
            	videosDLL.setTail(new DLLNode(new Video(id, name), null, null));
                break;
            case "BST":
            	videosBST.insert(id, new Video(id, name));
                break;
            case "AVL":
            	videosAVL.setRoot(videosAVL.insert(videosAVL.getRoot(), id, new Video(id, name)));
                break;
            default:
                break;
        }
    }
	
	/**
     * remove video with given id
     * @param id of video to remove
     * @return removed video
     */
	private static Video removeVideo(int id) {
        Video vid = null;        
        
        switch(datatype) {
            case "SLL":
                if(videosSLL.getHead() == null) {
                    return null;
                }
                
                SLLNode temp = videosSLL.getHead();
                while(temp.getNext() != null)
                {
                    vid = (Video) temp.getElement();
                    if (vid.getId() == id)
                    {
                        videosSLL.remove(vid);
                        break;
                    }
                    temp = temp.getNext();
                }                
                break;
            case "DLL":
                if(videosDLL.getHead() == null) {
                    return null;
                }
                DLLNode temp2 = videosDLL.getHead();
                while(temp2.getNext() != null)
                {
                    vid = (Video) temp2.getElement();
                    if (vid.getId() == id)
                    {
                        videosDLL.remove(temp2);
                        break;
                    }
                    temp2 = temp2.getNext();
                }                
                break;
            case "BST":
                return (Video) videosBST.remove(id);                
            case "AVL":
                return (Video) videosAVL.remove(id);                
            default:
                break;
        }
        
        return vid;
    }
	
	/**
     * check if video is in store
     * @param id of video to check
     * @return true if found or false if not found
     */
	private static boolean checkInStore(int id) {
        Video vid;
        int i;
        
        switch(datatype) {
            case "SLL":
                if(videosSLL.getHead() == null) {
                    return false;
                }
                
                SLLNode currentSLL = videosSLL.getHead();
                vid = (Video) currentSLL.getElement();
                i = 0;
                
                while(currentSLL.getNext() != null) {
                    if(i != 0) {
                        currentSLL = currentSLL.getNext();
                        vid = (Video) currentSLL.getElement();
                    }
                    
                    if(vid.getId() == id) {
                        return true;
                    }
                    
                    i++;
                }
                
                if(currentSLL.getNext() == null && vid.getId() == id) {
                    return true;
                }
                
                break;
            case "DLL":
                if(videosDLL.getHead() == null || videosDLL.getTail() == null) {
                    return false;
                }
                
                DLLNode currentDLL = videosDLL.getHead();
                vid = (Video) currentDLL.getElement();
                i = 0;
                
                while(currentDLL.getNext() != null) {
                    if(i != 0) {
                        currentDLL = currentDLL.getNext();
                        vid = (Video) currentDLL.getElement();
                    }
                    
                    if(vid.getId() == id) {
                        return true;
                    }
                    
                    i++;
                }
                
                if(currentDLL.getNext() == null && vid.getId() == id) {
                    return true;
                }
                
                break;
            case "BST":
                return videosBST.find(id);                
            case "AVL":
                return videosAVL.find(id);                
            default:
                break;
        }
        
        return false;
    }
	
	/**
     * add customer to store
     * @param id to set as customer id
     * @param name of customer
     */
	private static void insertCustomer(int id, String name) {
        switch(datatype) {
            case "SLL":
            	customersSLL.add(new SLLNode(new Customer(datatype, id, name), null));
                break;
            case "DLL":
            	customersDLL.setTail(new DLLNode(new Customer(datatype, id, name), null, null));
                break;
            case "BST":
            	customersBST.insert(id, new Customer(datatype, id, name));
                break;
            case "AVL":
            	customersAVL.setRoot(customersAVL.insert(customersAVL.getRoot(), id, new Customer(datatype, id, name)));
                break;
            default:
                break;
        }
    }
	
	/**
     * remove customer with given id
     * @param id of customer to remove
     */
	private static void deleteCustomer(int id) {
        Customer cust;        
        
        switch(datatype) {
            case "SLL":
                if(customersSLL.getHead() == null) {
                    return;
                }
                
                SLLNode temp = customersSLL.getHead();
                while(temp.getNext() != null)
                {
                    cust = (Customer) temp.getElement();
                    if (cust.getId() == id)
                    {
                        customersSLL.remove(cust);
                        break;
                    }
                    temp = temp.getNext();
                }
                
                break;
            case "DLL":
                if(customersDLL.getHead() == null) {
                    return;
                }
                
                DLLNode temp2 = customersDLL.getHead();
                while(temp2.getNext() != null)
                {
                    cust = (Customer) temp2.getElement();
                    if (cust.getId() == id)
                    {
                        customersDLL.remove(temp2);
                        break;
                    }
                    temp2 = temp2.getNext();
                }
                
                break;
            case "BST":
            	customersBST.remove(id);
                break;
            case "AVL":
            	customersAVL.remove(id);
                break;
            default:
                break;
        }
    }
	
	/**
     * check if customer has exists
     * @param id of customer to check
     * return true if found, flase if not
     */
	private static boolean validCustomer(int id) {
        return getCustomer(id) != null;
    }
	
	/**
     * get customer with given id
     * @param id of customer to check
     * @return customer with given id
     */
	private static Customer getCustomer(int id) {
        Customer element;
        int i;
        
        switch(datatype) {
            case "SLL":
                if(customersSLL.getHead() == null) {
                    return null;
                }
                
                SLLNode currentSLL = customersSLL.getHead();
                element = (Customer) currentSLL.getElement();
                i = 0;
                
                while(currentSLL.getNext() != null) {
                    if(i != 0) {
                        currentSLL = currentSLL.getNext();
                        element = (Customer) currentSLL.getElement();
                    }
                    
                    if(element.getId() == id) {
                        return element;
                    }
                    
                    i++;
                }
                
                if(currentSLL.getNext() == null && element.getId() == id) {
                    return element;
                }
                
                break;
            case "DLL":
                if(customersDLL.getHead() == null) {
                    return null;
                }
                
                DLLNode currentDLL = customersDLL.getHead();
                element = (Customer) currentDLL.getElement();
                i = 0;
                
                while(currentDLL.getNext() != null) {
                    if(i != 0) {
                        currentDLL = currentDLL.getNext();
                        element = (Customer) currentDLL.getElement();
                    }
                    
                    if(element.getId() == id) {
                        return element;
                    }
                    
                    i++;
                }
                
                if(currentDLL.getNext() == null && element.getId() == id) {
                    return element;
                }
                
                break;
            case "BST":
                return (Customer) customersBST.getElement(id);
                //break;
            case "AVL":
                return (Customer) customersAVL.getElement(id);
                //break;
            default:
                break;
        }
        
        return null;
    }
	
	/**
     * check out a video from store
     * @param cid customer that is chekcing out video
     * @param vid video that is being checked out
     */
	private static void videoCheckOut(int cid, int vid) {
        //System.out.println("videoCheckOut");
        if(!checkInStore(vid) || !validCustomer(cid)) {
            return;
        }
        
        Video videoElement = removeVideo(vid);
        getCustomer(cid).inputVideo(videoElement);
    }
	
	/**
     * return a video to the store
     * @param vid the video being returned
     */
	private static void videoCheckIn(int vid) {
        if(checkInStore(vid)) {
            return;
        }
        
        for(int i = 1; i < customersCount; i++) {
            if(getCustomer(i).inPossession(vid)) {
                Video element = getCustomer(i).removeVideo(vid);
                inputVideo(element.getId(), element.getTitle());
                return;
            }
        }
    }
	
	/**
     * print all videos in store
     */
	private static void printCheckedIn() {
        switch(datatype) {
            case "SLL":
            	videosSLL.print();
                break;
            case "DLL":
            	videosDLL.print();
                break;
            case "BST":
            	videosBST.print(videosBST.getRoot());
                break;
            case "AVL":
            	videosAVL.print(videosAVL.getRoot());
                break;
            default:
                break;
        }
    }
	
	/**
     * print all checked out videos
     */
	private static void printCheckedOut() {
        for(int i = 1; i <= customersCount; i++) {
            printAtElement(i);
        }
    }
	
	/**
     * print all videos checkout by a customer
     * @param id of customer to print videos
     */
	private static void printAtElement(int id) {
        if(!validCustomer(id)) {
            return;
        }
        
        getCustomer(id).printVideo();
    }
	
	
	/*
	 * Quit program
	 */
	private static void quit() {
        System.exit(0);
    }
}
