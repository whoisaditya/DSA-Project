import javax.swing.*;

import java.io.*; 

import java.util.*; // Import the Scanner class to read text files

public class PhoneBook 
{
    public static void main(String args[]) 
    {
        JFrame f = new JFrame();

        Directory directoryObj = new Directory();

        int ch;
        try 
        {
            File obj1 = new File("names.txt");
            File obj2 = new File("phno1.txt");
            File obj3 = new File("phno2.txt");
            File obj4 = new File("emails.txt");
            File comp = new File("company.txt");
            File address = new File("address.txt");
            File city = new File("city.txt");
            File county = new File("county.txt");
            File state = new File("state.txt");
            File zip = new File("zip.txt");

            Scanner reader1 = new Scanner(obj1);
            Scanner reader2 = new Scanner(obj2);
            Scanner reader3 = new Scanner(obj3);
            Scanner reader4 = new Scanner(obj4);
            Scanner companyReader = new Scanner(comp);

            Scanner addressReader = new Scanner(address);
            Scanner cityReader = new Scanner(city);
            Scanner countyReader = new Scanner(county);
            Scanner stateReader = new Scanner(state);
            Scanner zipReader = new Scanner(zip);


            while (reader1.hasNextLine())
            {
                String name = "Aditya";
                name = reader1.nextLine();

                String temp1 = "7057648283";
                temp1 = reader2.nextLine();
                long phoneno1 = 0;
                phoneno1 = Long.parseLong(temp1); 

                String temp2 = "9960577973";
                temp2 = reader3.nextLine();
                long phoneno2 = 0;
                phoneno2 = Long.parseLong(temp2); 

                String email1 = "mitraaditya1357@gmail.com" ;
                email1 = reader4.nextLine();

                String company1 = " ";
                company1 = companyReader.nextLine();

                String address1 = " ";
                address1 = addressReader.nextLine() + ", " + cityReader.nextLine() + ", " + countyReader.nextLine() + ", " + stateReader.nextLine() + ", " + zipReader.nextLine() ;

                //System.out.println(address1);

                directoryObj.addContact(name, phoneno1, phoneno2, email1, company1, address1);
            }

            reader1.close();
            reader2.close();
            reader3.close();
            reader4.close();
            companyReader.close();
            addressReader.close();
            cityReader.close();
            countyReader.close();
            stateReader.close();
            zipReader.close();

            JOptionPane.showMessageDialog(f, "Sample Directory Created");
        } 
        catch (FileNotFoundException e) 
        {
            JOptionPane.showMessageDialog(f, "Sample Directory Not Created");
            e.printStackTrace();
        }

        
        while (true) 
        {
            String c = JOptionPane.showInputDialog(f,"Menu\n1. Add contact\n2. Search for Contact\n3. Exit\nEnter your choice");
            
            ch = Integer.parseInt(c);

            switch (ch) 
            {
                case 1: 
                {
                    String name1 = " ";
                    name1 = JOptionPane.showInputDialog(f, "Enter Name:");

                    String ph1 =" ";
                    ph1 = JOptionPane.showInputDialog(f, "Enter Phone Number 1: ");
                    long phoneno1 = 0;
                    phoneno1 = Long.parseLong(ph1);

                    String ph2 =" ";
                    ph2 = JOptionPane.showInputDialog(f, "Enter Phone Number 2: ");
                    long phoneno2 = 0;
                    phoneno1 = Long.parseLong(ph2);

                    String email1 = " ";
                    email1 = JOptionPane.showInputDialog(f, "Enter Email Id: ");

                    String company1 = " ";
                    company1 = JOptionPane.showInputDialog(f, "Enter Company Name: ");

                    String address1 = " ";
                    address1 = JOptionPane.showInputDialog(f, "Enter Address: ");

                    directoryObj.addContact(name1, phoneno1, phoneno2, email1, company1, address1);

                    break;
                }

                case 2: 
                {
                    String query;
                    query = JOptionPane.showInputDialog(f, "Enter the first letter of the contact you want\n");

                    directoryObj.searchAndShowNoForAllCombination(query);
                    break;
                }

                case 3: 
                {
                    System.exit(0);
                    break;
                }
                default: 
                {
                    JOptionPane.showMessageDialog(f, "Incorrect");
                    continue;
                }
            }
        }
    }

}

