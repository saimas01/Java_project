/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contactmanager;


import java.util.HashMap;
import java.util.Map;

public class Backend {

    private Map<String, Person> people = new HashMap<>();
    public Backend() {
    addPerson("1","saima","51263653");
    addPerson("2","wqsma","1233653");
    addPerson("3","wera","53213653");
    addPerson("4","saima","531263653");
    addPerson("5","ima","512621353");
    }
    // Add a new person
    public void addPerson(String id, String name, String contact) {
        people.put(id, new Person(id, name, contact));
    }

    // Get a person by ID
    public Person getPerson(String id) {
        return people.get(id);
    }
}
