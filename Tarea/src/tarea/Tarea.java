package tarea;
import java.util.Date;
import java.util.ArrayList;

public class Tarea {
    public static void main(String[] args) {
        OrdenCompra oc1 = new OrdenCompra();
        OrdenCompra oc2 = new OrdenCompra();
        OrdenCompra oc3 = new OrdenCompra();        
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
        return "Esta clase guarda:  -Fecha:"+fecha+" -Estado:"+estado+"  de la clase OrdenCompra";
    }
}

//______________________________Informacion Personal__________________________________//
class Cliente{
    //Propiedades
    private String nombre;
    private String rut;
    private Direccion direccion;
    //Metodos
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
        return "Esta clase guarda:  -Nombre:"+nombre+" -RUT:"+rut+"  de la clase Cliente";
    }
}

class Direccion{
    //Propiedades
    private String direccion;
    //Metodos
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
    @Override
    public String toString(){
        return "Esta clase guarda:  -Direccion:"+direccion+"  de la clase Direccion";
    }
}

abstract class DocTributario{
    //Propiedades
    protected String numero;
    protected String rut;             // En clases abstract usaremos protected en vez de private, puesto que simplifica mas las cosas y no es necesario usar getters.
    protected Date fecha;
    protected Cliente cliente;
    //Metodos
    public DocTributario(String numero, String rut, Date fecha, Cliente cliente){
        this.numero = numero;
        this.rut = rut;
        this.fecha = fecha;
        this.cliente = cliente;
    }
    //Getters, Setters
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
}

class Boleta extends DocTributario{
    public Boleta(String numero, String rut, Date Fecha, Cliente cliente){
        super(numero, rut, Fecha, cliente);      
    }
    //toString
    @Override
    public String toString(){
        return "Esta clase guarda:  -Numero:"+numero+" -RUT:"+rut+" -Fecha: "+fecha+"  de la clase Boleta";
    }
}

class Factura extends DocTributario{
    public Factura(String numero, String rut, Date Fecha, Cliente cliente){
        super(numero, rut, Fecha, cliente); 
    }
    //toString
    @Override
    public String toString(){
        return "Esta clase guarda:  -Numero:"+numero+" -RUT:"+rut+" -Fecha: "+fecha+"  de la clase Factura";
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
abstract class Pago{
    //Propiedades
    protected float monto;             // En clases abstract usaremos protected en vez de private, puesto que simplifica mas las cosas y no es necesario usar getters.
    protected Date fecha;
    private OrdenCompra ordencompra;
    //Metodos
    public Pago(float monto, Date fecha){
        this.monto = monto;
        this.fecha = fecha;
    }
    //Getters, Setters
     public float getMonto(){
        return monto;
    }
    public Date getFecha(){
        return fecha;
    }
    public OrdenCompra getOrdenCompra(){
        return ordencompra;
    }    
    public void setMonto(float peso){
        this.monto = monto;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    public void setOrdenCompra(OrdenCompra ordencompra){
        this.ordencompra = ordencompra;
    }
}

class Efectivo extends Pago{
    //Metodos
    public void calcDevolucion(){
        float aux1;
        OrdenCompra aux2 = getOrdenCompra();
        aux1 = monto - aux2.calcPrecio();
    }
    public Efectivo(float monto, Date fecha){
        super(monto, fecha);
    }
    //toString
    @Override
    public String toString(){
        return "Esta clase guarda:  -Monto:"+monto+" -Fecha:"+fecha+"  de la clase Efectivo";
    }
}

class Tranferencia extends Pago{
    //Propiedades
    private String banco;
    private String numCuenta;
    //Metodos
    public Tranferencia(String banco, String numCuenta, float monto, Date fecha){
        super(monto, fecha);
        this.banco = banco;
        this.numCuenta = numCuenta;
    }
    //Getters, Setters y toString
     public String getBanco(){
        return banco;
    }
    public String getNumCuenta(){
        return numCuenta;
    }
    public void setBanco(String banco){
        this.banco = banco;
    }
    public void setNumCuenta(String numCuenta){
        this.numCuenta = numCuenta;
    }
    @Override
    public String toString(){
        return "Esta clase guarda:  -Monto:"+monto+" -Fecha:"+fecha+" -Banco:"+banco+" -NumeroCuenta:"+numCuenta+"  de la clase Transferencia";
    }
}

class Tarjeta extends Pago{
    //Propiedades
    private String tipo;
    private String numtransaccion;
    //Metodos
    public Tarjeta(String tipo, String numtransaccion, float monto, Date fecha){
        super(monto, fecha);
        this.tipo = tipo;
        this.numtransaccion = numtransaccion;
    }
    //Getters, Setters y toString
    public String getTipo(){
        return tipo;
    }
    public String getNumTransaccion(){
        return numtransaccion;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setNumTransaccion(String numtransaccion){
        this.numtransaccion = numtransaccion;
    }
    @Override
    public String toString(){
        return "Esta clase guarda:  -Monto:"+monto+" -Fecha:"+fecha+" -Tipo:"+tipo+" -NumeroTransaccion:"+numtransaccion+"  de la clase Tarjeta";
    }
}