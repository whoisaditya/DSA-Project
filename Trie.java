import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class Trie 
{
    //Global Variables
    Node root;
    public int j;
    public boolean ispresent = false;

    public Trie() 
    {
        root = new Node();
    }

    // Insert a Contact into the Trie
    public void insert(String str) 
    {
        int len = str.length();

        // 'itr' is used to iterate the Trie Nodes
        Node itr = root;

        for (int i = 0; i < len; i++) 
        {
            // Check if the s[i] is already present in Trie
            Node nextNode = itr.child.get(str.charAt(i));
            if (nextNode == null)
            {
                // If not found then create a new Node
                nextNode = new Node();

                // Insert into the HashMap
                itr.child.put(str.charAt(i), nextNode);
            }

            // Move the iterator('itr') ,to point to next Trie Node
            itr = nextNode;

            // If its the last character of the string 'str' then mark 'islast' as true
            if (i == len - 1)
            {
                itr.islast = true;
            }
        }
    }

    // This function simply displays all dictionary words going through current node. String 'prefix' 
    //represents string corresponding to the path from root to curNode.
    public void displayContactsUtil(Node curNode, String prefix, ArrayList<String> contactsWithPrefix) 
    {
        /* 
        Check if the string 'prefix' ends at this Node
        If yes then display the string found so far
        */

        if (curNode.islast)
        {
            contactsWithPrefix.add(prefix);
        }

        // Find all the adjacent Nodes to the current Node and then call the function recursively

        for (char i = 'a'; i <= 'z'; i++) 
        {
            Node nextNode = curNode.child.get(i);

            if (nextNode != null) 
            {
                displayContactsUtil(nextNode, prefix + i, contactsWithPrefix);
            }
        }
    }

    // Display suggestions after every character enter by
    // the user for a given string 'str'
    void getContacts(String str, HashMap<String, Long> phone1, HashMap<String, Long> phone2, HashMap<String, String> email, HashMap<String, String> company, HashMap<String, String> address) 
    {

        String data[][] = new String[50][6];
        String column[] = { "Name", "Phone Number 1", "Phone Number 2", "Email Id" , "Company Name", "Address"};
        
        j = 0;

        Node prevNode = root;
        String prefix = "";
        int len = str.length();

        // Display the contact List for string formed after entering every character

        int i;
        for (i = 0; i < len; i++) 
        {
            // 'str' stores the string entered so far
            prefix += str.charAt(i);

            // Get the last character entered
            char lastChar = prefix.charAt(i);

            // Find the Node corresponding to the last character of 'str' which is pointed by prevNode of the Trie
            Node curNode = prevNode.child.get(lastChar);

            // If nothing found, then break the loop as no more prefixes are going to be present.
            if (curNode == null) 
            {
                i++;
                break;
            }

            ArrayList<String> contactsWithPrefix = new ArrayList<>();
            displayContactsUtil(curNode, prefix, contactsWithPrefix);
            
            contactsWithPrefix.forEach(contact -> 
            {
                data[j][0] = contact;
                data[j][1] = Long.toString(phone1.get(contact));
                data[j][2] = Long.toString(phone2.get(contact));
                data[j][3] = email.get(contact);
                data[j][4] = company.get(contact);
                data[j][5] = address.get(contact);

                j++;
                ispresent = true;
            });

            // Change previous Node (prevNode) for next prefix
            prevNode = curNode;
        }

        JFrame f = new JFrame();

        if(ispresent)
        {
            JTable jt = new JTable(data, column);

            f.setTitle("Result");
            jt.setBounds(30, 40, 200, 300);

            JScrollPane sp = new JScrollPane(jt);

            jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            jt.getColumnModel().getColumn(0).setPreferredWidth(100);
            jt.getColumnModel().getColumn(1).setPreferredWidth(100);
            jt.getColumnModel().getColumn(2).setPreferredWidth(100);
            jt.getColumnModel().getColumn(3).setPreferredWidth(200);
            jt.getColumnModel().getColumn(4).setPreferredWidth(200);
            jt.getColumnModel().getColumn(5).setPreferredWidth(500);

            f.add(sp);
            f.setSize(1200, 500);
            f.setVisible(true);
    }
    else
    {
        JOptionPane.showMessageDialog(f, "Not Present in Directory");
    }
}


}