/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingexercise3;

/**
 *
 * @author klzpo
 */
public class Employee {
    private String name;
    private String position;
    private byte age;
    private int id;
   
    // first approach
    private Employee Next;
    private Employee Previous;
    
    //constructors
    Employee(){
        name=position="";
        age =0;
        id=0;
        Next = Previous = null;
    }
    
    Employee(String n, String p, byte a, int i, Employee N, Employee P){
        name=n;
        position = p;
        age = a;
        id = i;
        Next = N;
        Previous = P;
    }
    
    Employee(Employee E, Employee N, Employee P){
        name = E.name;
        position = E.position;
        age = E.age;
        id = E.id;
        Next = N;
        Previous = P;
    }

     
    // setters or mutators
    public void setName(String n){ name = n;}
    public void setPosition(String p){ position = p;}
    public void setAge(byte a){ age = a;}
    public void setID(int i){ id = i;}
    
    // getters or accessors
    public String getName(){return name; }
    public String getPosition(){return position; }
    public byte getAge(){return age; }
    public int getID(){return id; }
    
    //equal method
    public boolean equals(Employee E){
        
      return ((name.equals(E.name) && position.equals(E.position) && id==E.id));
        
    }
    
    public String toString(){
        return "Name: "+name+"\nPosition: "+position
                +"\nAge: "+age+"\nID: "+id;
    }
    
    public void setNext(Employee E){ Next = E;  }
    public void setPrevious(Employee E){Previous = E;}
    public Employee getNext (){return Next;}
    public Employee getPrevious (){return Previous;}
}
