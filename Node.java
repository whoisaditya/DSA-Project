

import java.util.HashMap;

public class Node 
{
    HashMap<Character, Node> child;
    boolean islast;

    public Node() 
    {
        child = new HashMap<Character, Node>();
        for (char i = 'a'; i <= 'z'; i++)
            child.put(i, null);
        islast = false;
    }
}
