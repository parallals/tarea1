package tarea;
import java.util.Date;

public class Tarea {
    public static void main(String[] args) {
        Cliente a = new Cliente("pocoyó","21.250.675-3");
        a.toStringCliente();
    }
}

class OrdenCompra{
    private Date fecha;
    private String estado;
    private Cliente cliente;
    private Pago pago;
    public void  calcPrecioSinIVA(){
        
    }
    public void calcIVA(){
        
    }
    public void calcPrecio(){
        
    }
    public void calcPeso(){
        
    }
}

//______________________________Informacion Personal__________________________________//
class Cliente{
    private String nombre;
    private String rut;
    private Direccion direccion;
    
    public Cliente(String nombre, String rut){
        this.nombre = nombre;
        this.rut = rut;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setRut(String rut){
        this.rut = rut;
    }
    public void toStringCliente(){
        System.out.println("Esta clase guarda el nombre y rut del cliente");
    }
}

class Direccion{
    private String direccion;
    private DocTributario doctributario;
    
    public Direccion(String direccion){
        this.direccion = direccion;
    }
        
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void toStringDireccion(){
        System.out.println("Esta clase guarda la direccion del cliente");
    }
}

class DocTributario{
    private String numero;
    private String rut;
    private Date fecha;
    public DocTributario(String numero, String rut, Date fecha){
        this.numero = numero;
        this.rut = rut;
        this.fecha = fecha;
    }
            
    public String getNumero(){
        return numero;
    }
    public String getRut(){
        return rut;
    }
    public Date getFecha(){
        return fecha;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    public void setRut(String rut){
        this.rut = rut;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    public void toStringDocTributario(){
        System.out.println("Esta clase hereda sus atributos a Boleta y Factura");
    }
}

class Boleta extends DocTributario{
    public Boleta(String numero, String rut, Date Fecha){
        super(numero, rut, Fecha);      
    }
    
    public void toStringBoleta(){
        System.out.println("Esta clase es heredera de los atributos de Doc Tributario");
    }

class Factura extends DocTributario{
    public Factura(String numero, String rut, Date Fecha){
        super(numero, rut, Fecha); 
    }
    
    public void toStringFactura(){
    System.out.println("Esta clase es heredera de los atributos de DocTributario");
    }
}

//______________________________Detalles de la Orden__________________________________//
class DetalleOrden{
    private  int cantidad;
    private Articulos[] lista_articulos;
    public void  calcPrecio(){
        
    }
    public void calcPrecioSinIVA(){
        
    }
    public void calcIVA(){
        
    }
    public void calcPeso(){
        
    }
    public DetalleOrden(int cantidad){
        this.cantidad = cantidad;
        for(int i = 0; i < cantidad; ++i){
            this.lista_articulos[] = new Articulos[cantidad]; 
            }
    }
}

class Articulo{
    private  float peso;
    private String nombre;
    private String descripcion;
    private float precio;
}
//______________________________Informacion del Pago__________________________________//
class Pago{
    private float monto;
    private Date fecha;
    public Pago(float monto, Date fecha){
        this.monto = monto;
        this.fecha = fecha;
    }
}

class Efectivo extends Pago{
    public void calcDevolucion(){
        
    }
    
    public Efectivo(float monto, Date fecha){
        super(monto, fecha);
    }
}

class Tranferencia extends Pago{
    private String banco;
    private String numCuenta;
    
    public Tranferencia(String banco, String numCuenta, float monto, Date fecha){
        super(monto, fecha);
        this.banco = banco;
        this.numCuenta = numCuenta;
    }
}

class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    
    public Tarjeta(String tipo, String numTransaccion, float monto, Date fecha){
        super(monto, fecha);
        this.tipo = tipo;
        this.numTransaccion = numTransaccion;
    }
}