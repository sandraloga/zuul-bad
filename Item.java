
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String descripcion;
    private float peso;

    /**
     * Constructor for objects of class Item
     */
    public Item(String descripcion ,float peso)
    {
        this.descripcion = descripcion;
        this.peso = peso;
    }
    
    /**
     * descriccion del item
     */
    public String descripcionItem()
    {
        return  descripcion;
    }

    /**
     * 
     */
    public float getPeso()
    {
        return peso;
    }
  
}
