
package classes.person;

public class Admin extends Users{
    
    
    private String eidikotita;
    private  int tilefono;
    
    Admin(){
        super();
        eidikotita="Gramateas";
        tilefono=281099586;
    }
    
        //getters
    
    public String getEidikotita(){
        return eidikotita;
    }
    
    public int getTilefono(){
        return tilefono;
    }
    
    
    //setters
    
    public void setEidikotita(String eidikotita){
        this.eidikotita=eidikotita;
        
    }
   
    public void setTilefono(int tilefono){
        this.tilefono=tilefono;
    }
    
    //methodoi
    
    //epikoinonia(){}
}
