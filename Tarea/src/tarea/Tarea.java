package tarea;
import java.util.Date;
import java.util.ArrayList;
//a

public class Tarea {
    public static void main(String[] args) {
        OrdenCompra a = new OrdenCompra();
        System.out.println(a.toString());
    }
}

class OrdenCompra{
    //Propiedades
    private Date fecha;
    private String estado;
    private DetalleOrden[] detalleorden;
    private Cliente cliente;
    private Pago pago;
    //Metodos
    public float  calcPrecioSinIVA(){
        float aux = 0;
        for(int i=0 ; i<detalleorden.length ; i++){
            aux = aux + detalleorden[i].calcPrecioSinIVA();
        }
        return aux;
    }
    public float calcIVA(){
        float aux = 0;
        for(int i=0 ; i<detalleorden.length ; i++){
            aux = aux + detalleorden[i].calcIVA();
        }
        return aux;
    }
    public float calcPrecio(){
        float aux = 0;
        for(int i=0 ; i<detalleorden.length ; i++){
            aux = aux + detalleorden[i].calcPrecio();
        }
        return aux;
    }
    public float calcPeso(){
        float aux = 0;
        for(int i=0 ; i<detalleorden.length ; i++){
            aux = aux + detalleorden[i].calcPeso();
        }
        return aux;
    }
    //Getters, Setters y toString
    public Date getFecha(){
        return fecha;
    }
    public String getEstado(){
        return estado;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    @Override
    public String toString(){
        return "Esta clase guarda:  -Fecha:"+fecha+" -Estado:"+estado+"  de la clase Orden de compra";
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
        return "Esta clase hereda sus atributos (Numero, Monto y Fecha) a Boleta y Factura";
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
    //Propiedades
    private int cantidad;
    private Articulo articulos;
    //Metodos
    public float  calcPrecio(){
        return articulos.getPrecio() * cantidad * 1.19f;
    }
    public float calcPrecioSinIVA(){
        return articulos.getPrecio() * cantidad;
    }
    public float calcIVA(){
        return articulos.getPrecio() * cantidad * 0.19f;
    }
    public float calcPeso(){
        return articulos.getPeso()*cantidad;
    }
    public DetalleOrden(int cantidad, Articulo articulos){
        this.cantidad = cantidad;
        this.articulos = articulos;
    }
    //Getters, Setters y toString
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    @Override
    public String toString(){
        return "Esta clase guarda:  -Peso:"+cantidad+"  de la clase DetalleOrden";
    }
}

class Articulo{
    //Propiedades
    private  float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    //Metodos
    public Articulo(float peso, String nombre, String descripcion, float precio){
        this.peso = peso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    //Getters, Setters y toString
    public float getPeso(){
        return peso;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public float getPrecio(){
        return precio;
    }
    public void setPeso(float peso){
        this.peso = peso;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setPrecio(float precio){
        this.precio = precio;
    }
    @Override
    public String toString(){
        return "Esta clase guarda:  -Peso:"+peso+" -Nombre:"+nombre+" -Descripcion: "+descripcion+" -Precio:"+precio+"  de la clase Articulo";
    }
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
