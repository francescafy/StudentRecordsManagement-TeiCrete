
package classes.person;


public class Student extends Users {
    
    private  int am;
    private  int examino;
    private  int didaktikesMonades;
    private  int sum=0;
    
    Student(){
        super();
        am=3893;
        examino=2;
        didaktikesMonades=30;       
    }
    
        //getters
    
    public int getAm(){
        return am;
    }
    
    public int getExamino(){
        return examino;
    }
    
    public int getDidaktikesMonades(){
        return didaktikesMonades;
    }
    
    
    //setters
    
    public void setAm(int am){
        this.am=am;
        
    }
    
    public void setExamino(int examino){
        this.examino=examino;
    }
    
    public void setDidaktikesMonades(int didaktikesMonades){
        this.didaktikesMonades=didaktikesMonades;
    }
    //methodos
    
    //sumDidaktikesMonades(){}
    
}
