package tarea;
import java.util.Date;

public class Tarea {
    public static void main(String[] args) {
        OrdenCompra a = new OrdenCompra();
        System.out.println(a.toString());
    }
}

class OrdenCompra{
    private Date fecha;
    private String estado;
    private Cliente cliente;
    private Pago pago;
    private DetalleOrden[] detalleorden;
    public float  calcPrecioSinIVA(){
        float n = 0;
        for(int i=0 ; i<detalleorden.length; i++){
            n = n + detalleorden.calcPrecioSinIVA();
        }
        return n;
    }
    public float calcIVA(){
        float n = 0;
        for(int i=0 ; i<detalleorden.length; i++){
            n = n + detalleorden.calcIVA();
        }
        return n;
    }
    public float calcPrecio(){
        float n = 0;
        for(int i=0 ; i<detalleorden.length; i++){
            n = n + detalleorden.calcPrecio();
        }
        return n;
    }
    public float calcPeso(){
        float n = 0;
        for(int i=0 ; i<detalleorden.length; i++){
            n = n + detalleorden.calcPeso();
        }
        return n;
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
    //Getters, Setters y toString
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
    @Override
    public String toString(){
        return "Esta clase guarda el nombre y rut del cliente";
    }
}

class Direccion{
    private String direccion;
    private DocTributario doctributario;
    
    public Direccion(String direccion){
        this.direccion = direccion;
    }
    //Getters, Setters y toString
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
    //Getters, Setters y toString
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
    public String toStringDocTributario(){
        return Esta clase hereda sus atributos (Numero, Monto y Fecha) a Boleta y Factura;
    }
}

class Boleta extends DocTributario{
    public Boleta(String numero, String rut, Date Fecha){
        super(numero, rut, Fecha);      
    }
    //Getters, Setters y toString
    public void toStringBoleta(){
        System.out.println("Esta clase es heredera de los atributos de DocTributario (Numero, Monto y Fecha)");
    }
}

class Factura extends DocTributario{
    public Factura(String numero, String rut, Date Fecha){
        super(numero, rut, Fecha); 
    }
    //Getters, Setters y toString
    public void toStringFactura(){
        System.out.println("Esta clase es heredera de los atributos de DocTributario (Numero, Monto y Fecha)");
    }
}

//______________________________Detalles de la Orden__________________________________//
class DetalleOrden{
    private  int cantidad;
    private Articulo[] lista_articulos;
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
            this.lista_articulos = new Articulo[cantidad]; 
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
    //Getters, Setters y toString
    public void toStringTarjeta(){
        System.out.println("Esta clase hereda sus atributos (Monto y Fecha) a Efectivo, Transferencia y Tarjeta");
    }
}

class Efectivo extends Pago{
    public void calcDevolucion(){
        
    }
    
    public Efectivo(float monto, Date fecha){
        super(monto, fecha);
    }
    //Getters, Setters y toString
    public void toStringEfectivo(){
        System.out.println("Esta clase es heredera de los atributos de Pago (Monto y fecha), ademas tiene un metodo para calcular la Devolucion del pago");
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
    //Getters, Setters y toString
    public void toStringTransferencia(){
        System.out.println("Esta clase es heredera de los atributos de Pago (Monto y fecha), ademas guarda el Banco y el Numero de Cuenta del pago");
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
    //Getters, Setters y toString
    public void toStringTarjeta(){
        System.out.println("Esta clase es heredera de los atributos de Pago (Monto y fecha), ademas guarda el Tipo de Tarjeta y el Numero de transaccion del pago");
    }
}
