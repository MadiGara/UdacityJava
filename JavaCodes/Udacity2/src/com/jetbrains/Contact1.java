package com.jetbrains;

public class Contact1 {
    // *** Remember that objects are a variable type like int etc.!! ***
    static class Contact {
        String name;
        String email;
        String phoneNumber;
    }

    static class ContactsManager {
        //Fields:
        Contact [] myFriends;
        int friendsCount;
        //Constructor:
        ContactsManager(){
            this.friendsCount = 0;
            this.myFriends = new Contact[500];
        }
        //Methods (2 of them):
        void addContact(Contact contact){
            myFriends[friendsCount] = contact;
            friendsCount++;
        }
        Contact searchContact(String searchName){
            for(int i=0; i<friendsCount; i++){
                if(myFriends[i].name.equals(searchName)){
                    return myFriends[i];
                }
            }
            return null;
        }
    }
    //need main method to run the program
    static class Main {
        public static void main(String [] args){
            //1. create ContactsManager object, myContactsManager, w default constructor (no args)
            ContactsManager myContactsManager = new ContactsManager();
            //2. class(type) fieldName = new class();
            Contact friendJarren = new Contact();
            //change field's value by objectName.fieldName = value;
            friendJarren.name = "Jarren";
            friendJarren.phoneNumber = "0163339784";
            //3. calling a method: object.method(argument);
            myContactsManager.addContact(friendJarren);

            Contact friendArin = new Contact(); //4.
            friendArin.name = "Arin";
            friendArin.phoneNumber = "0133359319";
            myContactsManager.addContact(friendArin);
            Contact friendRotparoge = new Contact();
            friendRotparoge.name = "Rotparoge";
            friendRotparoge.phoneNumber = "0192838742";
            myContactsManager.addContact(friendRotparoge);
            Contact friendDan = new Contact();
            friendDan.name = "Dan";
            friendDan.phoneNumber = "9207483921";
            myContactsManager.addContact(friendDan);
            Contact friendFelix = new Contact();
            friendFelix.name = "Felix";
            friendFelix.phoneNumber = "1820394857";
            myContactsManager.addContact(friendFelix);

            //5. store the result of searchContact method call (object.method(arg))
            // in variable "result" so we can print it
            Contact result = myContactsManager.searchContact("Arin");
            System.out.println(result.phoneNumber);
        }
    }
}