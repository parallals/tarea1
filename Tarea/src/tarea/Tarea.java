package tarea;

public class Tarea {

    public static void main(String[] args) {
        Cliente a = new Cliente("pocoyó","21.250.675-3");
        a.toStringCliente();
    }
    
}


class Cliente{
    private String nombre;
    private String rut;
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }
    public void toStringCliente(){
        System.out.println(this.nombre + ", Rut: " + this.rut);
    }
    public Cliente(String nombre, String rut){
        this.nombre = nombre;
        this.rut = rut;
    }
}

class OrdenCompra{
    private Date fecha;
    private String estado;
    
}