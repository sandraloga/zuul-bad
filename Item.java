
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
     private boolean prohibido;

    /**
     * Constructor for objects of class Item
     */
    public Item(String descripcion ,float peso , boolean prohibido)
    {
        this.descripcion = descripcion;
        this.peso = peso;
        this.prohibido = prohibido;
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
    
    
    
    public boolean getProhibido()
    {
        return prohibido;
    }
  
}
