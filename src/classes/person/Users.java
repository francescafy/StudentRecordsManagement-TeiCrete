
package classes.person;

public class Users {
    
    private int iduser;
    int password;
    String email;
    String lastname;
    String firstname;
    String login;

    public Users() {
        this.iduser = 0;
    }
    
     public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }
    
    public void setFirstName(String firstname) {
        this.firstname = firstname;

    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
}
