package cadenatecnologia122;

import java.util.ArrayList;

public class DispositivoElectronico {

    private String id;
    private TipoDispositivo tipo;
    private double precio;

    public DispositivoElectronico(String id, TipoDispositivo tipo, double precio) {
        this.id = id;
        this.tipo = tipo;
        this.precio = precio;
    }
    
    public boolean tieneId(String id){
        return this.id.equals(id);
    }

    @Override
    public String toString() {
        return "DispositivoElectronico{" + "id=" + id + ", precio=" + precio + ", tipo=" + tipo + "}";
    }

    public String toTableRow() {
        return "| %-6s| %-15s| %8.2f |\n".formatted(id, tipo, precio);
    }

    public static String toHeaderRow() {
        return "|   id    |    Tipo    |   Precio    |\n";
    }
    
    public static String toStringTable(ArrayList<DispositivoElectronico> lista){
        StringBuilder sb = new StringBuilder();
        int ancho = toHeaderRow().length() - 1;

        sb.append(Utils.separadorHorizontal(ancho));
        sb.append(toHeaderRow());
        sb.append(Utils.separadorHorizontal(ancho));

        for (DispositivoElectronico disp : lista) {
            sb.append(disp.toTableRow() + " \n");
        }

        sb.append(Utils.separadorHorizontal(ancho));
        
        return sb.toString();
    }
    
    public boolean esTipo (TipoDispositivo tipo){
        return this.tipo == tipo;
    }
    
    public TipoDispositivo getTipo(){
        return tipo;
    }
    
    public int ordenTipo(){
        return tipo.ordinal();
    }

}
