public class Customer {
    private int id;
    private String name;
    private final String datatype;
    private SLL VideoSLL;
    private DLL VideoDLL;
    private BST VideoBST;
    private AVL VideoAVL;
    
    /**
     * Builds customer using given structure and customer info
     * @param datatype determines what structure to use
     * @param id of customer
     * @param name of customer
     */
    public Customer(String datatype, int id, String name) {
        this.datatype = datatype;
        this.id = id;
        this.name = name;
        
        switch(datatype) {
            case "SLL":
                VideoSLL = new SLL();
                break;
            case "DLL":
                VideoDLL = new DLL();
                break;
            case "BST":
                VideoBST = new BST();
                break;
            case "AVL":
                VideoAVL = new AVL();
                break;
            default:
                break;
        }
    }
    
    /**
     * get customer id
     * @return id
     */
    public int getId() {
        return id;
    }
    
    /**
     * get customer name
     * @return name of customer
     */
    public String getName() {
        return name;
    }
    
    /**
     * get videos rented by customer
     * @return videos from SLL
     */
    public SLL getRentVideoSLL() {
        return VideoSLL;
    }
    
   /**
    * get videos rented by customer
    @return videos from DLL
    */
    public DLL getRentVideoDLL() {
        return VideoDLL;
    }
    
    /**
     * get videos rented by customer
     * @return videos from BST
     */
    public BST getRentVideoBST() {
        return VideoBST;
    }
    
    /**
     * get videos rented by customer
     * @return videos from AVL
     */
    public AVL getRentVideoAVL() {
        return VideoAVL;
    }
    
    /**
     * create new video
     * @param vid the video to create
     */
    public void inputVideo(Video vid) {
        switch(datatype) {
            case "SLL":
                VideoSLL.add(new SLLNode(new Video(vid.getId(), vid.getTitle()), null));
                break;
            case "DLL":
                VideoDLL.setTail(new DLLNode(new Video(vid.getId(), vid.getTitle()), null, null));
                break;
            case "BST":
                VideoBST.insert(vid.getId(), new Video(vid.getId(), vid.getTitle()));
                break;
            case "AVL":
                VideoAVL.setRoot(VideoAVL.insert(VideoAVL.getRoot(), vid.getId(), new Video(vid.getId(), vid.getTitle())));
                break;
            default:
                break;
        }
    }
    
    /**
     * remove given video
     * @param id the id of video to remove
     * @return the removed video
     */
    public Video removeVideo(int id) {
        Video vid = null;
        //int i;
        
        switch(datatype) {
            case "SLL":
               
                if(VideoSLL.getHead() == null) {
                    return null;
                }
                SLLNode temp = VideoSLL.getHead();
                while(temp != null)
                {
                    vid = (Video) temp.getElement();
                    if (vid.getId() == id)
                    {
                        VideoSLL.remove(vid);
                        return vid;
                    }
                    temp = temp.getNext();
                }               
                break;
            case "DLL":                
                if(VideoDLL.getHead() == null) {
                    return null;
                }
                DLLNode temp2 = VideoDLL.getHead();
                while(temp2 != null)
                {
                    vid = (Video) temp2.getElement();
                    if (vid.getId() == id)
                    {
                        VideoDLL.remove(temp2);
                        return vid;
                    }
                    temp2 = temp2.getNext();
                }                
                break;
            case "BST":
                return (Video) VideoBST.remove(id);                
            case "AVL":
                return (Video) VideoAVL.remove(id);                
            default:
                break;
        }
        
        return vid;
    }
    
    /**
     * finds video with given id in the
     * @param id of the video to find
     * @return true if found and false if not found
     */
    public boolean inPossession(int id) {
        Video element;
        int i;
        
        switch(datatype) {
            case "SLL":
                if(VideoSLL.getHead() == null) {
                    return false;
                }
                
                SLLNode currentSLL = VideoSLL.getHead();
                element = (Video) currentSLL.getElement();
                i = 0;
                
                while(currentSLL.getNext() != null) {
                    if(i != 0) {
                        currentSLL = currentSLL.getNext();
                        element = (Video) currentSLL.getElement();
                    }
                    
                    if(element.getId() == id) {
                        return true;
                    }
                    
                    i++;
                }
                
                if(currentSLL.getNext() == null && element.getId() == id) {
                    return true;
                }
                
                break;
            case "DLL":
                if(VideoDLL.getHead() == null || VideoDLL.getTail() == null) {
                    return false;
                }
                
                DLLNode currentDLL = VideoDLL.getHead();
                element = (Video) currentDLL.getElement();
                i = 0;
                
                while(currentDLL.getNext() != null) {
                    if(i != 0) {
                        currentDLL = currentDLL.getNext();
                        element = (Video) currentDLL.getElement();
                    }
                    
                    if(element.getId() == id) {
                        return true;
                    }
                    
                    i++;
                }
                
                if(currentDLL.getNext() == null && element.getId() == id) {
                    return true;
                }
                
                break;
            case "BST":
                return VideoBST.find(id);                
            case "AVL":
                return VideoAVL.find(id);                
            default:
                break;
        }
        
        return false;
    }
    
    /**
     * prints all videos checked out by the customer
     */
    public void printVideo() {
        switch(datatype) {
            case "SLL":
                VideoSLL.print();
                break;
            case "DLL":
                VideoDLL.print();
                break;
            case "BST":
                VideoBST.print(VideoBST.getRoot());
                break;
            case "AVL":
                VideoAVL.print(VideoAVL.getRoot());
                break;
            default:
                break;
        }
    }
    
    /**
     * prints out customer info
     * @return customer info
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}
