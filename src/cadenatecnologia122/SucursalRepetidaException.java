package cadenatecnologia122;

public class SucursalRepetidaException extends RuntimeException{
    
    private static final String MESSAGE = "Sucursal Repetida";
    
    public SucursalRepetidaException(String mensaje){
        super(mensaje);
    }
    public SucursalRepetidaException(){
        this(MESSAGE);
    }
    
}
