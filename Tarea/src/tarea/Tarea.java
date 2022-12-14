package tarea;
import java.util.Date;
import java.util.ArrayList;

public class Tarea {
    public static void main(String[] args) {

        Articulo art1 = new Articulo(1,"jugo","de piÃ±a",3000);
        Articulo art2 = new Articulo(2,"papas","kryzpo",2000);
        Articulo art3 = new Articulo(3,"Tarjeta de video Nvidia Zotac Gaming GForce GTX 16 Series","and knuckles",30000);
        Articulo art4 = new Articulo(4,"Un Frugele","el rojo",100);
        Articulo art5 = new Articulo(3,"Completo","Papapleto",1000);
        
        DetalleOrden det1 = new DetalleOrden(3, art1);
        DetalleOrden det2 = new DetalleOrden(5, art2);
        DetalleOrden det3 = new DetalleOrden(1, art3);
        DetalleOrden det4 = new DetalleOrden(4, art4);
        DetalleOrden det5 = new DetalleOrden(2, art5);
        
        Direccion adress1 = new Direccion(" no se aaaaah 1");
        Direccion adress2 = new Direccion(" no se aaaaah 2");
        
        Cliente diego1 = new Cliente("Diego bueno que escribe el Detalle","21222222-2");
        Cliente diego2 = new Cliente("Diego malo que insiste en no usar ArrayList (Esto es FALSO)","21222222-3");
        diego1.setDireccion(adress1);
        diego2.setDireccion(adress2);
        
        Boleta bol = new Boleta();
        bol.setCliente(diego1);
        Factura fac = new Factura();
        fac.setCliente(diego2);

        DetalleOrden[] lista1 = new DetalleOrden[3];
        lista1[0] = det1;
        lista1[1] = det2;
        lista1[2] = det3;
        DetalleOrden[] lista2 = {det4,det5};
        DetalleOrden[] lista3 = {det1,det2,det3,det4,det5};
        
        ArrayList<Efectivo> pago11 = new ArrayList();
        pago11.add(new Efectivo(10000));
        pago11.add(new Efectivo(30000));
        ArrayList<Transferencia> pago12 = new ArrayList();
        pago12.add(new Transferencia("Banco Estado", "12919292",2000));
        ArrayList<Tarjeta> pago13 = new ArrayList();
        pago13.add(new Tarjeta("Banco Fallabella", "i1238", 20500));
        
        ArrayList<Efectivo> pago21 = new ArrayList();
        pago21.add(new Efectivo(30000));
        ArrayList<Transferencia> pago22 = new ArrayList();
        pago22.add(new Transferencia("Banco Estado", "12919292",2000));
        ArrayList<Tarjeta> pago23 = new ArrayList();
        pago23.add(new Tarjeta("Banco Fallabella", "i1238", 20500));
        
        ArrayList<Efectivo> pago31 = new ArrayList();
        pago31.add(new Efectivo(7777777));
        ArrayList<Transferencia> pago32 = new ArrayList();
        pago32.add(new Transferencia("Banco Estado", "12919292",1));
        ArrayList<Tarjeta> pago33 = new ArrayList();
        pago33.add(new Tarjeta("Banco Fallabella", "i1238", 1));
        
        OrdenCompra oc1 = new OrdenCompra(bol, lista1, diego1, pago11, pago12, pago13); //Boleta, pago 60000, diego1, 
        OrdenCompra oc2 = new OrdenCompra(fac, lista2, diego2, pago21, pago22, pago23);
        OrdenCompra oc3 = new OrdenCompra(bol, lista2, diego1, pago31, pago32, pago33);
        pago11.get(1).setOrdenCompra(oc1);
        for(int i=0; i>pago11.size(); i++){
            pago11.get(i).setOrdenCompra(oc1);
        }
        for(int i=0; i>pago21.size(); i++){
            pago11.get(i).setOrdenCompra(oc2);
        }
        for(int i=0; i>pago31.size(); i++){
            pago11.get(i).setOrdenCompra(oc3);
        }
        oc1.verificarEstado();
        System.out.println(oc1.getEstado()+", Devolucion:"+pago11.get(1).calcDevolucion());
        oc2.verificarEstado();
        System.out.println(oc2.getEstado());
        System.out.println(oc2.toString());
    }
}

class OrdenCompra{
    //Propiedades
    private Date fecha;
    private String estado;
    private DetalleOrden[] detalleorden;
    private Cliente cliente;
    private ArrayList<Efectivo> efectivo;
    private ArrayList<Transferencia> transferencia;
    private ArrayList<Tarjeta> tarjeta;
    //Metodos
    public OrdenCompra(DocTributario doctributario, DetalleOrden[] detalleorden, Cliente cliente, ArrayList<Efectivo> efectivo, ArrayList<Transferencia> tranferencia, ArrayList<Tarjeta> tarjeta){
        this.fecha = doctributario.getFecha();
        this.estado = "Pendiente";
        this.detalleorden = detalleorden;
        this.cliente = cliente;
        this.efectivo = efectivo;
        this.transferencia = tranferencia;
        this.tarjeta = tarjeta;
    }
    public void verificarEstado(){ //Cambiar el estado, relaciona clase Pago con OrdenCompra
        float aux = 0; //A pagar
        for(int i=0 ; i<detalleorden.length ; i++){
            aux = aux + detalleorden[i].calcPrecio();
        }
        float monto = 0; //Pago del cliente
        for(int i = 0; i<efectivo.size() ;++i){
            monto = monto + efectivo.get(i).getMonto();
        }
        for(int i = 0; i<transferencia.size();++i){
            monto = monto + transferencia.get(i).getMonto();
        }
        for(int i = 0; i<tarjeta.size();++i){
            monto = monto + tarjeta.get(i).getMonto();
        }
        if(aux <= monto){
            estado = "Pagado";
        }else{
            estado = "Pendiente";
        }
    }
    public float calcPrecioSinIVA(){
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
    public DetalleOrden[] getDetalleOrden(){
        return detalleorden;
    }
    public ArrayList<Efectivo> getEfectivo(){
        return efectivo;
    }
    public ArrayList<Transferencia> getTransferencia(){
        return transferencia;
    }
    public ArrayList<Tarjeta> getTarjeta(){
        return tarjeta;
    }
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
        this.direccion = null;
    }
    public void setDireccion(Direccion direccion){
        this.direccion = direccion;
    }
    public String getDireccion(){
        return direccion.getDireccion();
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
    private String direccion;
    private String rut;
    private Date fecha;
    //Metodos
    public DocTributario(Date fecha){
        this.fecha = fecha;
    }
    public void setCliente(Cliente cliente){
        this.direccion = cliente.getDireccion();
        this.rut = cliente.getRut();
    }
    //Getters, Setters
    public String getDireccion(){
        return direccion;
    }
    public String getRut(){
        return rut;
    }
    public Date getFecha(){
        return fecha;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void setRut(String rut){
        this.rut = rut;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
}

class Boleta extends DocTributario{
    public Boleta(){
        super(new Date());      
    }
    //toString
    @Override
    public String toString(){
        return "Esta clase guarda:  -Direccion:"+getDireccion()+" -RUT:"+getRut()+" -Fecha: "+getFecha()+"  de la clase Boleta";
    }
}

class Factura extends DocTributario{
    public Factura(){
        super(new Date());      
    }
    //toString
    @Override
    public String toString(){
        return "Esta clase guarda:  -direccion:"+getDireccion()+" -RUT:"+getRut()+" -Fecha: "+getFecha()+"  de la clase Factura";
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
        return "Esta clase guarda:  -Cantidad:"+cantidad+ " -ArtÃ­culo:"+articulos+"  de la clase DetalleOrden";
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
    private  float monto;
    private  Date fecha;
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
    public float calcDevolucion(){
        DetalleOrden[] detalleorden = new DetalleOrden[getOrdenCompra().getDetalleOrden().length];
        detalleorden = getOrdenCompra().getDetalleOrden();
        ArrayList<Efectivo> efectivo = getOrdenCompra().getEfectivo();
        ArrayList<Transferencia> transferencia = getOrdenCompra().getTransferencia();
        ArrayList<Tarjeta> tarjeta = getOrdenCompra().getTarjeta();
        float aux = 0; //A pagar
        for(int i=0 ; i<detalleorden.length ; i++){
            aux = aux + detalleorden[i].calcPrecio();
        }
        float monto = 0; //Pago del cliente
        for(int i = 0; i<efectivo.size() ;++i){
            monto = monto + efectivo.get(i).getMonto();
        }
        for(int i = 0; i<transferencia.size();++i){
            monto = monto + transferencia.get(i).getMonto();
        }
        for(int i = 0; i<tarjeta.size();++i){
            monto = monto + tarjeta.get(i).getMonto();
        }
        if(aux <= monto){
            return monto - aux;
        }else{
            return 0f;
        }
    }
    public Efectivo(float monto){
        super(monto, new Date());
    }
    //toString
    @Override
    public String toString(){
        return "Esta clase guarda:  -Monto:"+getMonto()+" -Fecha:"+getFecha()+"  de la clase Efectivo";
    }
}

class Transferencia extends Pago{    //Propiedades
    private String banco;
    private String numCuenta;
    //Metodos
    public Transferencia(String banco, String numCuenta, float monto){
        super(monto, new Date());
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
        return "Esta clase guarda:  -Monto:"+getMonto()+" -Fecha:"+getFecha()+" -Banco:"+banco+" -NumeroCuenta:"+numCuenta+"  de la clase Transferencia";
    }
}

class Tarjeta extends Pago{
    //Propiedades
    private String tipo;
    private String numtransaccion;
    //Metodos
    public Tarjeta(String tipo, String numtransaccion, float monto){
        super(monto, new Date());
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
        return "Esta clase guarda:  -Monto:"+getMonto()+" -Fecha:"+getFecha()+" -Tipo:"+tipo+" -NumeroTransaccion:"+numtransaccion+"  de la clase Tarjeta";
    }
}
