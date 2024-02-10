import java.lang.Math;
import java.util.Arrays;

public class vural_p8 {
    private static int width = 700;
    private static int height = 350;
    private static int button_width = 350;
    private static int button_height = 350;

    // data
    private static boolean isSortRead = false;
    private static boolean isSearchRead = false;
    private static String sortFilePath = "../data/";
    private static String searchFilePath = "../data/";
    private static int[] sortValues;
    private static int[] searchValues;
    
    private static int[] mergeSorted;
    private static int[] sortedValues;
    private static java.util.TreeSet<Integer> treeSetValues = new java.util.TreeSet<>();
    private static java.util.HashSet<Integer> hashSetValues = new java.util.HashSet<>();
    private static java.util.PriorityQueue<Integer> priorityQueueValues = new java.util.PriorityQueue<>();
    private static java.util.ArrayList<Integer> arrayListValues = new java.util.ArrayList<>();
    private static java.util.ArrayList<Integer> sortedArrayListValues = new java.util.ArrayList<>();
    private static BinarySearchTree bst = new BinarySearchTree();

    // is the unsorted int[] used for adding to and searching
    private static int[] unsortedValues;

    // left buttons
    private static javax.swing.JButton sortIntsButton;
    private static javax.swing.JButton addToBstButton;
    private static javax.swing.JButton addToTreesetButton;
    private static javax.swing.JButton addToPrioritQueueButton;
    private static javax.swing.JButton addToHashsetButton;
    private static javax.swing.JButton addToArraylistButton;
    private static javax.swing.JButton addToSortedArrayListButton;
    private static javax.swing.JButton addToArrayButton;
    private static javax.swing.JButton mergeSortIntsButton;
    //private static javax.swing.JButton merge2SortIntsButton;
    //private static javax.swing.JButton quickSortIntsButton;

    // right buttons
    private static javax.swing.JButton searchSortedtIntsButton;
    private static javax.swing.JButton searchBstButton;
    private static javax.swing.JButton searchTreesetButton;
    private static javax.swing.JButton searchPrioritQueueButton;
    private static javax.swing.JButton searchHashsetButton;
    private static javax.swing.JButton searchArraylistButton;
    private static javax.swing.JButton searchSortedArrayListButton;
    private static javax.swing.JButton searchArrayButton;
    private static javax.swing.JButton searchMergeSortedIntsButton;
    //private static javax.swing.JButton searchMerge2SortedIntsButton;
    //private static javax.swing.JButton searchQuickSortedIntsButton;

    // left labels
    private static javax.swing.JLabel sortIntsLabel;
    private static javax.swing.JLabel addToBstLabel;
    private static javax.swing.JLabel addToTreesetLabel;
    private static javax.swing.JLabel addToPrioritQueueLabel;
    private static javax.swing.JLabel addToHashsetLabel;
    private static javax.swing.JLabel addToArraylistLabel;
    private static javax.swing.JLabel addToSortedArrayListLabel;
    private static javax.swing.JLabel addToArrayLabel;
    private static javax.swing.JLabel mergeSortIntsLabel;
    //private static javax.swing.JLabel merge2SortIntsLabel;
    //private static javax.swing.JLabel quickSortIntsLabel;

    // right labels
    private static javax.swing.JLabel searchSortedIntsLabel;
    private static javax.swing.JLabel SearchBstLabel;
    private static javax.swing.JLabel SearchTreesetLabel;
    private static javax.swing.JLabel SearchPrioritQueueLabel;
    private static javax.swing.JLabel SearchHashsetLabel;
    private static javax.swing.JLabel SearchArraylistLabel;
    private static javax.swing.JLabel SearchSortedArrayListLabel;
    private static javax.swing.JLabel SearchArrayLabel;
    private static javax.swing.JLabel searchMergeSortedIntsLabel;
    //private static javax.swing.JLabel searchMerge2SortedIntsLabel;
    //private static javax.swing.JLabel searchQuickSortedIntsLabel;

    public static void main(String[] args) {
        // System.out.println("format is: \"sort file name\" \"search file name\"");
        // sortFilePath += args[0];
        // searchFilePath += args[1];
        sortFilePath += "sort_data_100000.txt";
        searchFilePath += "search_data_100000.txt";

        // JFrame
        javax.swing.JFrame f = new javax.swing.JFrame();
        f.setPreferredSize(new java.awt.Dimension(width, height));
        f.setMinimumSize(new java.awt.Dimension(width, height));
        f.setMaximumSize(new java.awt.Dimension(width, height));
        f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        // menu bar
        javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();

        // file menu on menu bar
        javax.swing.JMenu fileMenu = new javax.swing.JMenu("File");
        
        // file menu items on file menu
        javax.swing.JMenuItem readSortFile = new javax.swing.JMenuItem("Read sort file");
        javax.swing.JMenuItem readSearchFile = new javax.swing.JMenuItem("Read search file");
        javax.swing.JMenuItem fileExit = new javax.swing.JMenuItem("Exit");

        // action listeners for file menu items
        MenuItemActionListener readSortFileMenuItemActionListener = new MenuItemActionListener(readSortFile);
        MenuItemActionListener readSearchFileMenuItemActionListener = new MenuItemActionListener(readSearchFile);
        MenuItemActionListener fileExitMenuItemActionListener = new MenuItemActionListener(fileExit);

        readSortFile.addActionListener(readSortFileMenuItemActionListener);
        readSearchFile.addActionListener(readSearchFileMenuItemActionListener);
        fileExit.addActionListener(fileExitMenuItemActionListener);

        menuBar.add(fileMenu);

        fileMenu.add(readSortFile);
        fileMenu.add(readSearchFile);
        fileMenu.add(fileExit);

        // left button panel
        javax.swing.JPanel leftButtonPanel = new javax.swing.JPanel();
        leftButtonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 2));
        java.awt.GridBagLayout leftButtonPanelGridBagLayout = new java.awt.GridBagLayout();
        leftButtonPanel.setLayout(leftButtonPanelGridBagLayout);
        leftButtonPanel.setPreferredSize(new java.awt.Dimension(button_width, button_height));
        leftButtonPanel.setMinimumSize(new java.awt.Dimension(button_width, button_height));
        java.awt.GridBagConstraints leftButtonPanelConstraints = new java.awt.GridBagConstraints();

        // left buttons
        sortIntsButton = new javax.swing.JButton("sort ints");
        addToBstButton = new javax.swing.JButton("add to bst");
        addToTreesetButton = new javax.swing.JButton("add to treeset");
        addToPrioritQueueButton = new javax.swing.JButton("add to priority queue");
        addToHashsetButton = new javax.swing.JButton("add to hashset");
        addToArraylistButton = new javax.swing.JButton("add to arraylist");
        addToSortedArrayListButton = new javax.swing.JButton("add to sorted arraylist");
        addToArrayButton = new javax.swing.JButton("add to array");
        mergeSortIntsButton = new javax.swing.JButton("merge sort ints");
        //merge2SortIntsButton = new javax.swing.JButton("merge2 sort ints");
        //quickSortIntsButton = new javax.swing.JButton("quick sort ints");

        // left labels
        sortIntsLabel = new javax.swing.JLabel("no result");
        addToBstLabel = new javax.swing.JLabel("no result");
        addToTreesetLabel = new javax.swing.JLabel("no result");
        addToPrioritQueueLabel = new javax.swing.JLabel("no result");
        addToHashsetLabel = new javax.swing.JLabel("no result");
        addToArraylistLabel = new javax.swing.JLabel("no result");
        addToSortedArrayListLabel = new javax.swing.JLabel("no result");
        addToArrayLabel = new javax.swing.JLabel("no result");
        mergeSortIntsLabel = new javax.swing.JLabel("no result");
        //merge2SortIntsLabel = new javax.swing.JLabel("no result");
        //quickSortIntsLabel = new javax.swing.JLabel("no result");

        // Adding buttons and labels to the left panel
        leftButtonPanelConstraints.weightx = 1;
        leftButtonPanelConstraints.weighty = 1;
        leftButtonPanelConstraints.fill = java.awt.GridBagConstraints.NONE;
        leftButtonPanelConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        
        // 1
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 0;
        leftButtonPanelConstraints.gridwidth = 1;
        leftButtonPanelGridBagLayout.setConstraints(sortIntsButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 0;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftButtonPanelGridBagLayout.setConstraints(sortIntsLabel, leftButtonPanelConstraints);
        
        // 2
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 1;
        leftButtonPanelConstraints.gridwidth = 1;
        leftButtonPanelGridBagLayout.setConstraints(addToBstButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 1;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftButtonPanelGridBagLayout.setConstraints(addToBstLabel, leftButtonPanelConstraints);
        
        // 3
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 2;
        leftButtonPanelConstraints.gridwidth = 1;
        leftButtonPanelGridBagLayout.setConstraints(addToTreesetButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 2;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftButtonPanelGridBagLayout.setConstraints(addToTreesetLabel, leftButtonPanelConstraints);
        
        // 4
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 3;
        leftButtonPanelConstraints.gridwidth = 1;
        leftButtonPanelGridBagLayout.setConstraints(addToPrioritQueueButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 3;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftButtonPanelGridBagLayout.setConstraints(addToPrioritQueueLabel, leftButtonPanelConstraints);
       
        // 5
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 4;
        leftButtonPanelConstraints.gridwidth = 1;
        leftButtonPanelGridBagLayout.setConstraints(addToHashsetButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 4;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftButtonPanelGridBagLayout.setConstraints(addToHashsetLabel, leftButtonPanelConstraints);
        
        // 6
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 5;
        leftButtonPanelConstraints.gridwidth = 1;
        leftButtonPanelGridBagLayout.setConstraints(addToArraylistButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 5;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftButtonPanelGridBagLayout.setConstraints(addToArraylistLabel, leftButtonPanelConstraints);
        
        // 7
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 6;
        leftButtonPanelConstraints.gridwidth = 1;
        leftButtonPanelGridBagLayout.setConstraints(addToSortedArrayListButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 6;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftButtonPanelGridBagLayout.setConstraints(addToSortedArrayListLabel, leftButtonPanelConstraints);
        
        // 8
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 7;
        leftButtonPanelConstraints.gridwidth = 1;
        leftButtonPanelGridBagLayout.setConstraints(addToArrayButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 7;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftButtonPanelGridBagLayout.setConstraints(addToArrayLabel, leftButtonPanelConstraints);
       
        // 9
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 8;
        leftButtonPanelConstraints.gridwidth = 1;
        leftButtonPanelGridBagLayout.setConstraints(mergeSortIntsButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 8;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftButtonPanelGridBagLayout.setConstraints(mergeSortIntsLabel, leftButtonPanelConstraints);
        
        //// 10
        //leftButtonPanelConstraints.gridx = 0;
        //leftButtonPanelConstraints.gridy = 9;
        //leftButtonPanelConstraints.gridwidth = 1;
        //leftButtonPanelGridBagLayout.setConstraints(merge2SortIntsButton, leftButtonPanelConstraints);
        //leftButtonPanelConstraints.gridx = 1;
        //leftButtonPanelConstraints.gridy = 9;
        //leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        //leftButtonPanelGridBagLayout.setConstraints(merge2SortIntsLabel, leftButtonPanelConstraints);
        //// 11
        //leftButtonPanelConstraints.gridx = 0;
        //leftButtonPanelConstraints.gridy = 10;
        //leftButtonPanelConstraints.gridwidth = 1;
        //leftButtonPanelGridBagLayout.setConstraints(quickSortIntsButton, leftButtonPanelConstraints);
        //leftButtonPanelConstraints.gridx = 1;
        //leftButtonPanelConstraints.gridy = 10;
        //leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        //leftButtonPanelGridBagLayout.setConstraints(quickSortIntsLabel, leftButtonPanelConstraints);

        // 1
        leftButtonPanel.add(sortIntsButton);
        leftButtonPanel.add(sortIntsLabel);
        
        // 2
        leftButtonPanel.add(addToBstButton);
        leftButtonPanel.add(addToBstLabel);
        
        // 3
        leftButtonPanel.add(addToTreesetButton);
        leftButtonPanel.add(addToTreesetLabel);
       
        // 4
        leftButtonPanel.add(addToPrioritQueueButton);
        leftButtonPanel.add(addToPrioritQueueLabel);
        
        // 5
        leftButtonPanel.add(addToHashsetButton);
        leftButtonPanel.add(addToHashsetLabel);
        // 6
       
        leftButtonPanel.add(addToArraylistButton);
        leftButtonPanel.add(addToArraylistLabel);
       
        // 7
        leftButtonPanel.add(addToSortedArrayListButton);
        leftButtonPanel.add(addToSortedArrayListLabel);
        
        // 8
        leftButtonPanel.add(addToArrayButton);
        leftButtonPanel.add(addToArrayLabel);
        
        // 9
        leftButtonPanel.add(mergeSortIntsButton);
        leftButtonPanel.add(mergeSortIntsLabel);
        
        // 10
        //leftButtonPanel.add(merge2SortIntsButton);
        //leftButtonPanel.add(merge2SortIntsLabel);
        
        //// 11
        //leftButtonPanel.add(quickSortIntsButton);
        //leftButtonPanel.add(quickSortIntsLabel);

        // right panel
        javax.swing.JPanel rightButtonPanel = new javax.swing.JPanel();
        rightButtonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 2));

        java.awt.GridBagLayout rightButtonPanelGridBagLayout = new java.awt.GridBagLayout();
        rightButtonPanel.setLayout(rightButtonPanelGridBagLayout);

        rightButtonPanel.setPreferredSize(new java.awt.Dimension(button_width, button_height));
        rightButtonPanel.setMinimumSize(new java.awt.Dimension(button_width, button_height));

        // right buttons
        searchSortedtIntsButton = new javax.swing.JButton("search sorted ints");
        searchBstButton = new javax.swing.JButton("search bst");
        searchTreesetButton = new javax.swing.JButton("search treeset");
        searchPrioritQueueButton = new javax.swing.JButton("search priority queue");
        searchHashsetButton = new javax.swing.JButton("search hashset");
        searchArraylistButton = new javax.swing.JButton("search arraylist");
        searchSortedArrayListButton = new javax.swing.JButton("search sorted arraylist");
        searchArrayButton = new javax.swing.JButton("search array");
        searchMergeSortedIntsButton = new javax.swing.JButton("search merge sorted ints");
        //searchMerge2SortedIntsButton = new javax.swing.JButton("search merge2 sorted ints");
        //searchQuickSortedIntsButton = new javax.swing.JButton("search quick sorted ints");

        // right labels
        searchSortedIntsLabel = new javax.swing.JLabel("no result");
        SearchBstLabel = new javax.swing.JLabel("no result");
        SearchTreesetLabel = new javax.swing.JLabel("no result");
        SearchPrioritQueueLabel = new javax.swing.JLabel("no result");
        SearchHashsetLabel = new javax.swing.JLabel("no result");
        SearchArraylistLabel = new javax.swing.JLabel("no result");
        SearchSortedArrayListLabel = new javax.swing.JLabel("no result");
        SearchArrayLabel = new javax.swing.JLabel("no result");
        searchMergeSortedIntsLabel = new javax.swing.JLabel("no result");
        //searchMerge2SortedIntsLabel = new javax.swing.JLabel("no result");
        //searchQuickSortedIntsLabel = new javax.swing.JLabel("no result");
        // GridBagConstraints
        java.awt.GridBagConstraints rightButtonPanelConstraints = new java.awt.GridBagConstraints();

        // Adding buttons and labels to the right panel
        //
        rightButtonPanelConstraints.weightx = 1;
        rightButtonPanelConstraints.weighty = 1;
        rightButtonPanelConstraints.fill = java.awt.GridBagConstraints.NONE;
        rightButtonPanelConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        // 1
        rightButtonPanelConstraints.gridx = 2;
        rightButtonPanelConstraints.gridy = 0;
        rightButtonPanelConstraints.gridwidth = 1;
        rightButtonPanelGridBagLayout.setConstraints(searchSortedtIntsButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 3;
        rightButtonPanelConstraints.gridy = 0;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightButtonPanelGridBagLayout.setConstraints(searchSortedIntsLabel, rightButtonPanelConstraints);
        // 2
        rightButtonPanelConstraints.gridx = 2;
        rightButtonPanelConstraints.gridy = 1;
        rightButtonPanelConstraints.gridwidth = 1;
        rightButtonPanelGridBagLayout.setConstraints(searchBstButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 3;
        rightButtonPanelConstraints.gridy = 1;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightButtonPanelGridBagLayout.setConstraints(SearchBstLabel, rightButtonPanelConstraints);
        // 3
        rightButtonPanelConstraints.gridx = 2;
        rightButtonPanelConstraints.gridy = 2;
        rightButtonPanelConstraints.gridwidth = 1;
        rightButtonPanelGridBagLayout.setConstraints(searchTreesetButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 3;
        rightButtonPanelConstraints.gridy = 2;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightButtonPanelGridBagLayout.setConstraints(SearchTreesetLabel, rightButtonPanelConstraints);
        // 4
        rightButtonPanelConstraints.gridx = 2;
        rightButtonPanelConstraints.gridy = 3;
        rightButtonPanelConstraints.gridwidth = 1;
        rightButtonPanelGridBagLayout.setConstraints(searchPrioritQueueButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 3;
        rightButtonPanelConstraints.gridy = 3;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightButtonPanelGridBagLayout.setConstraints(SearchPrioritQueueLabel, rightButtonPanelConstraints);
        // 5
        rightButtonPanelConstraints.gridx = 2;
        rightButtonPanelConstraints.gridy = 4;
        rightButtonPanelConstraints.gridwidth = 1;
        rightButtonPanelGridBagLayout.setConstraints(searchHashsetButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 3;
        rightButtonPanelConstraints.gridy = 4;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightButtonPanelGridBagLayout.setConstraints(SearchHashsetLabel, rightButtonPanelConstraints);
        // 6
        rightButtonPanelConstraints.gridx = 2;
        rightButtonPanelConstraints.gridy = 5;
        rightButtonPanelConstraints.gridwidth = 1;
        rightButtonPanelGridBagLayout.setConstraints(searchArraylistButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 3;
        rightButtonPanelConstraints.gridy = 5;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightButtonPanelGridBagLayout.setConstraints(SearchArraylistLabel, rightButtonPanelConstraints);
        // 7
        rightButtonPanelConstraints.gridx = 2;
        rightButtonPanelConstraints.gridy = 6;
        rightButtonPanelConstraints.gridwidth = 1;
        rightButtonPanelGridBagLayout.setConstraints(searchSortedArrayListButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 3;
        rightButtonPanelConstraints.gridy = 6;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightButtonPanelGridBagLayout.setConstraints(SearchSortedArrayListLabel, rightButtonPanelConstraints);
        // 8
        rightButtonPanelConstraints.gridx = 2;
        rightButtonPanelConstraints.gridy = 7;
        rightButtonPanelConstraints.gridwidth = 1;
        rightButtonPanelGridBagLayout.setConstraints(searchArrayButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 3;
        rightButtonPanelConstraints.gridy = 7;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightButtonPanelGridBagLayout.setConstraints(SearchArrayLabel, rightButtonPanelConstraints);
        // 9
        rightButtonPanelConstraints.gridx = 2;
        rightButtonPanelConstraints.gridy = 8;
        rightButtonPanelConstraints.gridwidth = 1;
        rightButtonPanelGridBagLayout.setConstraints(searchMergeSortedIntsButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 3;
        rightButtonPanelConstraints.gridy = 8;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightButtonPanelGridBagLayout.setConstraints(searchMergeSortedIntsLabel, rightButtonPanelConstraints);
        // 10
        //rightButtonPanelConstraints.gridx = 2;
        //rightButtonPanelConstraints.gridy = 9;
        //rightButtonPanelConstraints.gridwidth = 1;
        //rightButtonPanelGridBagLayout.setConstraints(searchMerge2SortedIntsButton, rightButtonPanelConstraints);
        //rightButtonPanelConstraints.gridx = 3;
        //rightButtonPanelConstraints.gridy = 9;
        //rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        //rightButtonPanelGridBagLayout.setConstraints(searchMerge2SortedIntsLabel, rightButtonPanelConstraints);
        //// 11
        //rightButtonPanelConstraints.gridx = 2;
        //rightButtonPanelConstraints.gridy = 10;
        //rightButtonPanelConstraints.gridwidth = 1;
        //rightButtonPanelGridBagLayout.setConstraints(searchQuickSortedIntsButton, rightButtonPanelConstraints);
        //rightButtonPanelConstraints.gridx = 3;
        //rightButtonPanelConstraints.gridy = 10;
        //rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        //rightButtonPanelGridBagLayout.setConstraints(searchQuickSortedIntsLabel, rightButtonPanelConstraints);

        // 1
        rightButtonPanel.add(searchSortedtIntsButton);
        rightButtonPanel.add(searchSortedIntsLabel);
        // 2
        rightButtonPanel.add(searchBstButton);
        rightButtonPanel.add(SearchBstLabel);
        // 3
        rightButtonPanel.add(searchTreesetButton);
        rightButtonPanel.add(SearchTreesetLabel);
        // 4
        rightButtonPanel.add(searchPrioritQueueButton);
        rightButtonPanel.add(SearchPrioritQueueLabel);
        // 5
        rightButtonPanel.add(searchHashsetButton);
        rightButtonPanel.add(SearchHashsetLabel);
        // 6
        rightButtonPanel.add(searchArraylistButton);
        rightButtonPanel.add(SearchArraylistLabel);
        // 7
        rightButtonPanel.add(searchSortedArrayListButton);
        rightButtonPanel.add(SearchSortedArrayListLabel);
        // 8
        rightButtonPanel.add(searchArrayButton);
        rightButtonPanel.add(SearchArrayLabel);
        // 9
        rightButtonPanel.add(searchMergeSortedIntsButton);
        rightButtonPanel.add(searchMergeSortedIntsLabel);
        // 10
        //rightButtonPanel.add(searchMerge2SortedIntsButton);
        //rightButtonPanel.add(searchMerge2SortedIntsLabel);
        //// 11
        //rightButtonPanel.add(searchQuickSortedIntsButton);
        //rightButtonPanel.add(searchQuickSortedIntsLabel);

        // main button panel
        javax.swing.JPanel mainButtonPanel = new javax.swing.JPanel();
        mainButtonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 2));
        // layout for main button panel
        javax.swing.BoxLayout boxLayout = new javax.swing.BoxLayout(mainButtonPanel, javax.swing.BoxLayout.X_AXIS);
        mainButtonPanel.setLayout(boxLayout);
        // add left and right button panels to the main button panel
        mainButtonPanel.add(leftButtonPanel);
        mainButtonPanel.add(rightButtonPanel);

        // main panel
        javax.swing.JPanel mainPanel = new javax.swing.JPanel();
        mainButtonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 2));
        // layout for the main panel
        mainPanel.setLayout(new java.awt.BorderLayout());
        // add the menu bar and the main button panel to the main panel
        mainPanel.add(menuBar, java.awt.BorderLayout.NORTH);
        mainPanel.add(mainButtonPanel, java.awt.BorderLayout.CENTER);

        // action listeners for left panel
        // 1
        ButtonActionListener sortIntsButtonActionListener = new ButtonActionListener(sortIntsButton);
        sortIntsButton.addActionListener(sortIntsButtonActionListener);
        // 2
        ButtonActionListener addToBstButtonActionListener = new ButtonActionListener(addToBstButton);
        addToBstButton.addActionListener(addToBstButtonActionListener);
        // 3
        ButtonActionListener addToTreesetButtonActionListener = new ButtonActionListener(addToTreesetButton);
        addToTreesetButton.addActionListener(addToTreesetButtonActionListener);
        // 4
        ButtonActionListener addToPrioritQueueButtonActionListener = new ButtonActionListener(addToPrioritQueueButton);
        addToPrioritQueueButton.addActionListener(addToPrioritQueueButtonActionListener);
        // 5
        ButtonActionListener addToHashsetButtonActionListener = new ButtonActionListener(addToHashsetButton);
        addToHashsetButton.addActionListener(addToHashsetButtonActionListener);
        // 6
        ButtonActionListener addToArraylistButtonActionListener = new ButtonActionListener(addToArraylistButton);
        addToArraylistButton.addActionListener(addToArraylistButtonActionListener);
        // 7
        ButtonActionListener addToSortedArrayListButtonActionListener = new ButtonActionListener(
                addToSortedArrayListButton);
        addToSortedArrayListButton.addActionListener(addToSortedArrayListButtonActionListener);
        // 8
        ButtonActionListener addToArrayButtonActionListener = new ButtonActionListener(addToArrayButton);
        addToArrayButton.addActionListener(addToArrayButtonActionListener);
        // 9
        ButtonActionListener mergeSortIntsButtonActionListener = new ButtonActionListener(mergeSortIntsButton);
        mergeSortIntsButton.addActionListener(mergeSortIntsButtonActionListener);
        // 10
        //ButtonActionListener merge2SortIntsButtonActionListener = new ButtonActionListener(merge2SortIntsButton);
        //merge2SortIntsButton.addActionListener(merge2SortIntsButtonActionListener);
        //// 11
        //ButtonActionListener quickSortIntsButtonActionListener = new ButtonActionListener(quickSortIntsButton);
        //quickSortIntsButton.addActionListener(quickSortIntsButtonActionListener);

        // action listeners for right panel
        // 1
        ButtonActionListener searchSortedtIntsButtonActionListener = new ButtonActionListener(searchSortedtIntsButton);
        searchSortedtIntsButton.addActionListener(searchSortedtIntsButtonActionListener);
        // 2
        ButtonActionListener searchBstButtonActionListener = new ButtonActionListener(searchBstButton);
        searchBstButton.addActionListener(searchBstButtonActionListener);
        // 3
        ButtonActionListener searchTreesetButtonActionListener = new ButtonActionListener(searchTreesetButton);
        searchTreesetButton.addActionListener(searchTreesetButtonActionListener);
        // 4
        ButtonActionListener searchPrioritQueueButtonActionListener = new ButtonActionListener(
                searchPrioritQueueButton);
        searchPrioritQueueButton.addActionListener(searchPrioritQueueButtonActionListener);
        // 5
        ButtonActionListener searchHashsetButtonActionListener = new ButtonActionListener(searchHashsetButton);
        searchHashsetButton.addActionListener(searchHashsetButtonActionListener);
        // 6
        ButtonActionListener searchArraylistButtonActionListener = new ButtonActionListener(searchArraylistButton);
        searchArraylistButton.addActionListener(searchArraylistButtonActionListener);
        // 7
        ButtonActionListener searchSortedArrayListButtonActionListener = new ButtonActionListener(
                searchSortedArrayListButton);
        searchSortedArrayListButton.addActionListener(searchSortedArrayListButtonActionListener);
        // 8
        ButtonActionListener searchArrayButtonActionListener = new ButtonActionListener(searchArrayButton);
        searchArrayButton.addActionListener(searchArrayButtonActionListener);
        // 9
        ButtonActionListener searchMergeSortedIntsButtonActionListener = new ButtonActionListener(
                searchMergeSortedIntsButton);
        searchMergeSortedIntsButton.addActionListener(searchMergeSortedIntsButtonActionListener);
        // 10
        //ButtonActionListener searchMerge2SortedIntsButtonActionListener = new ButtonActionListener(
                //searchMerge2SortedIntsButton);
        //searchMerge2SortedIntsButton.addActionListener(searchMerge2SortedIntsButtonActionListener);
        //// 11
        //ButtonActionListener searchQuickSortedIntsButtonActionListener = new ButtonActionListener(
                //searchQuickSortedIntsButton);
        //searchQuickSortedIntsButton.addActionListener(searchQuickSortedIntsButtonActionListener);

        // disable buttons
        // left
        sortIntsButton.setEnabled(false);
        addToBstButton.setEnabled(false);
        addToTreesetButton.setEnabled(false);
        addToPrioritQueueButton.setEnabled(false);
        addToHashsetButton.setEnabled(false);
        addToArraylistButton.setEnabled(false);
        addToSortedArrayListButton.setEnabled(false);
        addToArrayButton.setEnabled(false);

        mergeSortIntsButton.setEnabled(false);
        //merge2SortIntsButton.setEnabled(false);
        //quickSortIntsButton.setEnabled(false);

        // right
        searchSortedtIntsButton.setEnabled(false);
        searchBstButton.setEnabled(false);
        searchTreesetButton.setEnabled(false);
        searchPrioritQueueButton.setEnabled(false);
        searchHashsetButton.setEnabled(false);
        searchArraylistButton.setEnabled(false);
        searchSortedArrayListButton.setEnabled(false);
        searchArrayButton.setEnabled(false);

        searchMergeSortedIntsButton.setEnabled(false);
        //searchMerge2SortedIntsButton.setEnabled(false);
        //searchQuickSortedIntsButton.setEnabled(false);

        // JFrame
        f.setContentPane(mainPanel);
        f.validate();
        f.setVisible(true);
    }

    static class MenuItemActionListener implements java.awt.event.ActionListener {
        private javax.swing.JMenuItem m;

        MenuItemActionListener(javax.swing.JMenuItem m) {
            this.m = m;
        }

        public void actionPerformed(java.awt.event.ActionEvent e) {
            System.out.println("action performed on " + m.getText() + " menu item");
            // if exit is selected from the file menu, exit the program
            if (m.getText().toLowerCase().equals("exit")) {
                // If the "Exit" menu item is selected, output "exit" and exit the program.
                System.out.println("exit");
                System.exit(0);
            }

            if (m.getText().toLowerCase().equals("read sort file")) {
                readData(sortFilePath, true);
                mergeSorted = Arrays.copyOf(sortValues, sortValues.length);
                isSortRead = true;
                // enable the left buttons
                sortIntsButton.setEnabled(true);
                addToBstButton.setEnabled(true);
                addToTreesetButton.setEnabled(true);
                addToPrioritQueueButton.setEnabled(true);
                addToHashsetButton.setEnabled(true);
                addToArraylistButton.setEnabled(true);
                addToSortedArrayListButton.setEnabled(true);
                addToArrayButton.setEnabled(true);

                mergeSortIntsButton.setEnabled(true);
                //merge2SortIntsButton.setEnabled(true);
                //quickSortIntsButton.setEnabled(true);

                System.out.println("Read sort file");
            }

            if (m.getText().toLowerCase().equals("read search file")) {
                readData(searchFilePath, false);
                isSearchRead = true;
                // enable the right buttons
                // 1
                if (isSortRead && (!sortIntsLabel.getText().equals("no result"))) {
                    searchSortedtIntsButton.setEnabled(true);
                }
                // 2
                if (isSortRead && (!addToBstLabel.getText().equals("no result"))) {
                    searchBstButton.setEnabled(true);
                }
                // 3
                if (isSortRead && (!addToTreesetLabel.getText().equals("no result"))) {
                    searchTreesetButton.setEnabled(true);
                }
                // 4
                if (isSortRead && (!addToPrioritQueueLabel.getText().equals("no result"))) {
                    searchPrioritQueueButton.setEnabled(true);
                }
                // 5
                if (isSortRead && (!addToHashsetLabel.getText().equals("no result"))) {
                    searchHashsetButton.setEnabled(true);
                }
                // 6
                if (isSortRead && (!addToArraylistLabel.getText().equals("no result"))) {
                    searchArraylistButton.setEnabled(true);
                }
                // 7
                if (isSortRead && (!addToSortedArrayListLabel.getText().equals("no result"))) {
                    searchSortedArrayListButton.setEnabled(true);
                }
                // 8
                if (isSortRead && (!addToArrayLabel.getText().equals("no result"))) {
                    searchArrayButton.setEnabled(true);
                }
                // 9
                if (isSortRead && (!mergeSortIntsLabel.getText().equals("no result"))) {
                    searchMergeSortedIntsButton.setEnabled(true);
                }
                // 10
                //if (isSortRead && (!merge2SortIntsLabel.getText().equals("no result"))) {
                    //searchMerge2SortedIntsButton.setEnabled(true);
                //}
                //// 11
                //if (isSortRead && (!quickSortIntsLabel.getText().equals("no result"))) {
                    //searchQuickSortedIntsButton.setEnabled(true);
                //}

                System.out.println("Read search file");
            }
        }
    }

    // action listener for the buttons
    static class ButtonActionListener implements java.awt.event.ActionListener {
        private javax.swing.JButton b;

        ButtonActionListener(javax.swing.JButton b) {
            this.b = b;
        }

        public void actionPerformed(java.awt.event.ActionEvent e) {

            // actions for left panel (uses sort_data files)
            // 1
            if (b.getText().equals("sort ints")) {
                unsortedValues = Arrays.copyOf(sortValues, sortValues.length);
                long t0 = System.currentTimeMillis();
                selectionSort(sortValues);
                long t1 = System.currentTimeMillis();
                sortIntsLabel.setText((t1 - t0) + "ms");
                sortedValues = Arrays.copyOf(sortValues, sortValues.length);
                if (!searchSortedtIntsButton.isEnabled() && isSearchRead) {
                    searchSortedtIntsButton.setEnabled(true);
                }
            }
            // 2
            if (b.getText().equals("add to bst")) {
                long t0 = System.currentTimeMillis();
                addToBinarySearchTree();
                long t1 = System.currentTimeMillis();
                addToBstLabel.setText((t1 - t0) + "ms");
                if (!searchBstButton.isEnabled() && isSearchRead) {
                    searchBstButton.setEnabled(true);
                }
            }
            // 3
            if (b.getText().equals("add to treeset")) {
                long t0 = System.currentTimeMillis();
                addToTreeSet();
                long t1 = System.currentTimeMillis();
                addToTreesetLabel.setText((t1 - t0) + "ms");
                if (!searchTreesetButton.isEnabled() && isSearchRead) {
                    searchTreesetButton.setEnabled(true);
                }
            }
            // 4
            if (b.getText().equals("add to priority queue")) {
                long t0 = System.currentTimeMillis();
                addToPriorityQueue();
                long t1 = System.currentTimeMillis();
                addToPrioritQueueLabel.setText((t1 - t0) + "ms");
                if (!searchPrioritQueueButton.isEnabled() && isSearchRead) {
                    searchPrioritQueueButton.setEnabled(true);
                }
            }
            // 5
            if (b.getText().equals("add to hashset")) {
                long t0 = System.currentTimeMillis();
                addToHashSet();
                long t1 = System.currentTimeMillis();
                addToHashsetLabel.setText((t1 - t0) + "ms");
                if (!searchHashsetButton.isEnabled() && isSearchRead) {
                    searchHashsetButton.setEnabled(true);
                }
            }
            // 6
            if (b.getText().equals("add to arraylist")) {
                long t0 = System.currentTimeMillis();
                addToArrayList();
                long t1 = System.currentTimeMillis();
                addToArraylistLabel.setText((t1 - t0) + "ms");
                if (!searchArraylistButton.isEnabled() && isSearchRead) {
                    searchArraylistButton.setEnabled(true);
                }
            }
            // 7
            if (b.getText().equals("add to sorted arraylist")) {
                long t0 = System.currentTimeMillis();
                addToSortedArrayList();
                long t1 = System.currentTimeMillis();
                addToSortedArrayListLabel.setText((t1 - t0) + "ms");
                if (!searchSortedArrayListButton.isEnabled() && isSearchRead) {
                    searchSortedArrayListButton.setEnabled(true);
                }
            }
            // 8
            if (b.getText().equals("add to array")) {
                // readData(sortFilePath, true);
                long t0 = System.currentTimeMillis();
                addToArray();
                long t1 = System.currentTimeMillis();
                addToArrayLabel.setText((t1 - t0) + "ms");
                if (!searchArrayButton.isEnabled() && isSearchRead) {
                    searchArrayButton.setEnabled(true);
                }
            }
            // TODO : implement merge sort1 for left
            // 9
            if (b.getText().equals("merge sort ints")) {
                long t0 = System.currentTimeMillis();
                bottomUpMergeSort();
                long t1 = System.currentTimeMillis();
                mergeSortIntsLabel.setText((t1 - t0) + "ms");

                if (!searchMergeSortedIntsButton.isEnabled() && isSearchRead) {
                    searchMergeSortedIntsButton.setEnabled(true);
                }
            }
            // TODO : implement merge sort2 for left
            // 10
            //if (b.getText().equals("merge2 sort ints")) {
                //if (!searchMerge2SortedIntsButton.isEnabled() && isSearchRead) {
                    //searchMerge2SortedIntsButton.setEnabled(true);
                //}
            //}
            //// TODO : implement quick sort for left
            //// 11
            //if (b.getText().equals("quick sort ints")) {
                //if (!searchQuickSortedIntsButton.isEnabled() && isSearchRead) {
                    //searchQuickSortedIntsButton.setEnabled(true);
                //}
            //}

            // actions for right panel (uses search_data_files)
            // 1
            if (b.getText().equals("search sorted ints")) {
                long t0 = System.currentTimeMillis();
                int count = searchInts(sortedValues);
                long t1 = System.currentTimeMillis();
                searchSortedIntsLabel.setText(count + " / " + (t1 - t0) + "ms");

            }
            // 2
            if (b.getText().equals("search bst")) {
                long t0 = System.currentTimeMillis();
                int count = searchBinarySearchTree();
                long t1 = System.currentTimeMillis();
                SearchBstLabel.setText(count + " / " + (t1 - t0) + "ms");

            }
            // 3
            if (b.getText().equals("search treeset")) {
                long t0 = System.currentTimeMillis();
                int count = searchTreeSet();
                long t1 = System.currentTimeMillis();
                SearchTreesetLabel.setText(count + " / " + (t1 - t0) + "ms");
            }
            // 4
            if (b.getText().equals("search priority queue")) {
                long t0 = System.currentTimeMillis();
                int count = searchPriorityQueue();
                long t1 = System.currentTimeMillis();
                SearchPrioritQueueLabel.setText(count + " / " + (t1 - t0) + "ms");
            }
            // 5
            if (b.getText().equals("search hashset")) {
                long t0 = System.currentTimeMillis();
                int count = searchHashSet();
                long t1 = System.currentTimeMillis();
                SearchHashsetLabel.setText(count + " / " + (t1 - t0) + "ms");

            }
            // 6
            if (b.getText().equals("search arraylist")) {
                long t0 = System.currentTimeMillis();
                int count = searchArrayList();
                long t1 = System.currentTimeMillis();
                SearchArraylistLabel.setText(count + " / " + (t1 - t0) + "ms");

            }
            // 7
            if (b.getText().equals("search sorted arraylist")) {
                long t0 = System.currentTimeMillis();
                int count = searchSortedArrayList();
                long t1 = System.currentTimeMillis();
                SearchSortedArrayListLabel.setText(count + " / " + (t1 - t0) + "ms");

            }
            // 8
            if (b.getText().equals("search array")) {
                long t0 = System.currentTimeMillis();
                int count = searchArray();
                long t1 = System.currentTimeMillis();
                SearchArrayLabel.setText(count + " / " + (t1 - t0) + "ms");
            }
            // TODO : implement merge sort1 for right
            // 9

            if (b.getText().equals("search merge sorted ints")) {
                long t0 = System.currentTimeMillis();
                int count = searchBottomUpMergeSort();
                long t1 = System.currentTimeMillis();
                searchMergeSortedIntsLabel.setText(count + " / " + (t1 - t0) + "ms");
            }


            
            //// TODO : implement merge sort2 for right
            //// 10
            //if (b.getText().equals("search merge2 sorted ints")) {
            //}
            //// TODO : implement quick sort for right
            //// 11
            //if (b.getText().equals("search quick sorted ints")) {
            //}

            System.out.println("action performed on " + b.getText() + " button");
        }

    }

    // 1
    private static void selectionSort(int[] values) {
        int lowerBound = 0;
        int upperBound = values.length - 1;
        for (int i = lowerBound; i <= upperBound; i++) {
            int min_index = i;
            for (int j = i + 1; j <= upperBound; j++) {
                if (values[j] < values[min_index]) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                int temp_string = values[min_index];
                values[min_index] = values[i];
                values[i] = temp_string;
            }
        }
    }

    // TODO : fix off by 1 error
    private static int searchInts(int[] sortedValues) {
        int count = 0;
        for (int i : searchValues) {
            int low = 0;
            int high = sortedValues.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (i < sortedValues[mid]) {
                    high = mid - 1;
                } else {
                    if (i > sortedValues[mid]) {
                        low = mid + 1;
                    } else {
                        ++count;
                        break;
                    }
                }
            }
        }
        return count;
    }

    // 2
    private static void addToBinarySearchTree() {
        for (int i : sortValues) {
            Node aNode = new Node(i);
            bst.insertNode(aNode);
        }
    }

    private static int searchBinarySearchTree() {
        int count = 0;
        for (int i : searchValues) {
            if (bst.getNode(bst.getRoot(), i) != null) {
                ++count;
            }
        }
        return count;
    }

    // 3
    private static void addToTreeSet() {
        for (int i : sortValues) {
            treeSetValues.add(Integer.valueOf(i));
        }
    }

    private static int searchTreeSet() {
        int count = 0;
        for (int i : searchValues) {
            if (treeSetValues.contains(i)) {
                ++count;
            }
        }
        return count;
    }

    // 4
    private static void addToPriorityQueue() {
        for (int i : sortValues) {
            priorityQueueValues.add(Integer.valueOf(i));
        }
    }

    private static int searchPriorityQueue() {
        int count = 0;
        for (int i : searchValues) {
            if (priorityQueueValues.contains(i)) {
                ++count;
            }
        }
        return count;
    }

    // 5
    private static void addToHashSet() {
        for (int i : sortValues) {
            hashSetValues.add(Integer.valueOf(i));
        }
    }

    private static int searchHashSet() {
        int count = 0;
        for (int i : searchValues) {
            if (hashSetValues.contains(i)) {
                ++count;
            }
        }
        return count;
    }

    // 6
    private static void addToArrayList() {
        for (int i : sortValues) {
            arrayListValues.add(Integer.valueOf(i));
        }
    }

    private static int searchArrayList() {
        int count = 0;
        for (int i : searchValues) {
            if (arrayListValues.contains(i)) {
                ++count;
            }
        }
        return count;
    }

    // 7
    private static void addToSortedArrayList() {
        for (int i : sortValues) {
            sortedArrayListValues.add(Integer.valueOf(i));
        }
        java.util.Collections.sort(sortedArrayListValues);
    }

    private static int searchSortedArrayList() {
        int count = 0;
        for (int i : searchValues) {
            int index = java.util.Collections.binarySearch(sortedArrayListValues, i);
            if (index < 0)
                continue;
            if (sortedArrayListValues.get(index) == i) {
                ++count;
            }
        }
        return count;
    }

    // 8
    private static void addToArray() {
        unsortedValues = new int[sortValues.length];
        for (int i = 0; i < sortValues.length; ++i) {
            unsortedValues[i] = sortValues[i];
        }
    }

    private static int searchArray() {
        int count = 0;
        for (int i : searchValues) {
            for (int j : unsortedValues) {
                if (i == j) {
                    ++count;
                }
            }
        }
        return count;
    }

    // TODO : implement merge sort1
    // 9
    private static void bottomUpMergeSort() {
        int[] workArray = new int[mergeSorted.length];
        workArray = Arrays.copyOf(mergeSorted, mergeSorted.length);

        for(int width = 1;width < mergeSorted.length; width = 2*width)
        {
            for(int i = 0; i < mergeSorted.length; i = i+(2*width))
            {
                // merge subarrays X and Y, where:
                    //X = origArray[i:min(i+width, origArray.length)-1] and
                    //Y = origArray[min(i+width, origArray.length):min(i+(2*width), origArray.length)-1]
                int end_idx_sub_array_X = java.lang.Math.min(i+width, mergeSorted.length);
                int end_idx_sub_array_Y = java.lang.Math.min(i+(2*width), mergeSorted.length);
    
                //Note - we are dividing origArray into two adjacent, already sorted subarrays and have
                //bottomUpMerge merge them into a single contiguous sorted subarray
                bottomUpMerge(mergeSorted, i, end_idx_sub_array_X, end_idx_sub_array_Y, workArray);
            }
            
            //PSEUDO - Use copyArray to copy workArray to origArray
            mergeSorted = Arrays.copyOf(workArray, workArray.length);
        }
    }


//Note: left, right, and end defines two adjacent sorted subarrays:
    //namely arrayA[left:right-1] and arrayA[right:end-1],
//that are sorted into one contiguous sorted subarray:
    //namely, arrayB[left:end-1].
    private static void bottomUpMerge(int[] arrayA, int left, int right, int end, int[] arrayB)
    {
        int i = left;
        int j = right;
    
        for( int k = left; k < end; k++ )
        { 
            //Note: This if statement works as desired with careful consideration. 
            // We are heavily relying on lazy evaluation here.
    
                // Case 1: If i < right is true and j >= end is false.
                // This means we have not fully merged the left sublist 
                // nor the right sublist yet.
                // So, the arrayA[i] <= arrayA[j] is evaluated, and 
                // dictates which element from either sublist we are going to grab next.

                // Case 2: If i < right is true and j >= end is true.
                // This means that we have fully merged the right sublist, 
                // but have not yet fully merged the left sublist.
                // So, we fall into the if block to copy elements remaining 
                // in the left sublist that still need to be merged. 
                // Note that the arrayA[i] <= arrayA[j] is not executed here 
                // due to lazy evaluation.

                // Case 3: If i < right is false, and j >= end is false.
                // This means that we have fully merged the left sublist, 
                // but have not yet fully merged the right sublist.
                // So, we fall into the else block to copy elements remaining 
                // in the right sublist that still need to be merged.
                // Note that the arrayA[i] <= arrayA[j] is not executed here 
                // due to lazy evaluation.

                // Case 4: If i < right is false, and j >= end is true.
                // This means that we have fully merged both 
                // the left and right sublists, which means we are done.
                // In reality, this case will never occur during execution, 
                // because the for loop goes from k = left to k < end.
                // No matter what complicated order the merge occurs in, 
                // i and j will not both be incremented to the point
                // where this case can occur.

            if( (i < right) && ((j >= end) || (arrayA[i] <= arrayA[j])) )
            {
                //Copy the next element from the left sublist into arrayB.
    
                //Note - we only arrive here if arrayA[i] <= arrayA[j] or we have already copied
                //all of the right sublist to arrayB
                arrayB[k] = arrayA[i];
                i = i+1;
            }
            else
            {
                //Copy the next element from the right sublist into arrayB.
    
                //Note - we only arrive here if arrayA[i] > arrayA[j] or we have already copied 
                //all of the left sublist to arrayB
                arrayB[k] = arrayA[j];
                j = j+1;
            }
        }
    }

    private static int searchBottomUpMergeSort() {
        int count = searchInts(mergeSorted);
        return count;
    }

    // TODO : implement merge sort2
    // 10

    // TODO : implement quick sort
    // 11

    private static void readData(String filename, boolean readSortValues) {
        java.util.ArrayList<Integer> tempArrayList = new java.util.ArrayList<>();
        try {
            java.io.BufferedReader input = new java.io.BufferedReader(
                    new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
            String inn;
            while ((inn = input.readLine()) != null) {
                Integer aInteger = Integer.valueOf(inn);
                tempArrayList.add(aInteger);
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if (readSortValues) {
            sortValues = new int[tempArrayList.size()];
            for (int i = 0; i < tempArrayList.size() - 1; i++) {
                sortValues[i] = tempArrayList.get(i);
            }

        } else {
            searchValues = new int[tempArrayList.size()];
            for (int i = 0; i < tempArrayList.size() - 1; i++) {
                searchValues[i] = tempArrayList.get(i);
            }
        }
        return;
    }

}

