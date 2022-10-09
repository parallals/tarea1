package tarea;
import java.util.Date;
import java.util.ArrayList;

public class Tarea {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date();
        Articulo art1 = new Articulo(1,"jugo","de piña",3000);
        Articulo art2 = new Articulo(2,"papas","kryzpo",2000);
        Articulo art3 = new Articulo(3,"Tarjeta de video Nvidia Zotac Gaming GForce GTX 16 Series","and knuckles",30000);
        Articulo art4 = new Articulo(4,"Un Frugele","el rojo",100);
        Articulo art5 = new Articulo(3,"Completo","Papapleto",1000);
        DetalleOrden det1 = new DetalleOrden(3, art1);
        DetalleOrden det2 = new DetalleOrden(5, art2);
        DetalleOrden det3 = new DetalleOrden(1, art3);
        DetalleOrden det4 = new DetalleOrden(4, art4);
        DetalleOrden det5 = new DetalleOrden(2, art5);
        Cliente diego1 = new Cliente("Diego bueno que escribe el Detalle","21222222-2");
        Cliente diego2 = new Cliente("Diego malo que insiste en no usar ArrayList","21222222-3");
        Efectivo pagoEf1 = new Efectivo(100, date2);
        Efectivo pagoEf2 = new Efectivo(50000, date2);
        Transferencia pagoTr = new Transferencia("Banco Estado", "12919292",2000, date2);
        Tarjeta pagoTa = new Tarjeta("Banco Fallabella", "i1238", 20500, date2);
        DetalleOrden[] lista1 = {det1,det2,det3};
        DetalleOrden[] lista2 = {det4,det5};
        DetalleOrden[] lista3 = {det1,det2,det3,det4,det5};        
        OrdenCompra oc1 = new OrdenCompra(date1, "Pendiente", lista1, diego1, pagoTr);
        OrdenCompra oc2 = new OrdenCompra(date1, "Pendiente", lista2, diego2, pagoEf1);
        OrdenCompra oc3 = new OrdenCompra(date2, "Pendiente", lista3, diego2, pagoEf2);        
        System.out.println(det1.toString());
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
    public OrdenCompra(Date fecha, String estado, DetalleOrden[] detalleorden, Cliente cliente, Pago pago){
        this.fecha = fecha;
        this.estado = estado;
        for (int j = 0; j > detalleorden.length ; j++){
        this.detalleorden[j] = detalleorden[j];
        }
        this.cliente = cliente;
        this.pago = pago;
    }
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
    @Override
    public String toString(){
        return "Esta clase guarda:  -Numero:"+numero+" -Rut:"+rut+" -Fecha:"+fecha+" -Cliente:"+cliente+"  de la clase DocTributario";
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
        return "Esta clase guarda:  -Cantidad:"+cantidad+ " -Artículo:"+articulos+"  de la clase DetalleOrden";
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

class Transferencia extends Pago{
    //Propiedades
    private String banco;
    private String numCuenta;
    //Metodos
    public Transferencia(String banco, String numCuenta, float monto, Date fecha){
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