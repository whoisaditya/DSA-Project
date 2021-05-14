
import java.util.HashMap;

public class Directory 
{
    HashMap<String, Long> phone1;
    HashMap<String, Long> phone2;
    HashMap<String, String> email;
    HashMap<String, String> company;
    HashMap<String, String> address;
    
    Trie trie;

    public Directory() 
    {
        phone1 = new HashMap<>();
        phone2 = new HashMap<>();
        email = new HashMap<>();
        company = new HashMap<>();
        address = new HashMap<>();
        trie = new Trie();
    }

    public void addContact(String name, Long phoneno1, Long phoneno2, String email1, String company1, String address1) 
    { 
        trie.insert(name);
        phone1.put(name, phoneno1);
        phone2.put(name, phoneno2);
        email.put(name, email1);
        company.put(name,company1);
        address.put(name,address1);
    }

    public void searchAndShowNoForAllCombination(String query) 
    {
        trie.getContacts(query, phone1, phone2, email, company, address);
    }
}