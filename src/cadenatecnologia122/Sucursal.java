package cadenatecnologia122;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Sucursal {

    private String nombre;
    private ArrayList<DispositivoElectronico> dispositivos;

    public Sucursal(String nombre) {
        this.nombre = nombre;
        this.dispositivos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean tieneNombre(String nombre) {
        return this.nombre.equals(nombre);
    }

    public void agregarDispositivo(DispositivoElectronico disp) {
        validarDispositivo(disp);
        dispositivos.add(disp);
    }

    private void validarDispositivo(DispositivoElectronico disp) {
        if (disp == null) {
            throw new IllegalArgumentException("Dispositivo nulo");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Sucursal suc)) {
            return false;
        }

        return suc.nombre.equals(nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    public void listarDispositivos(boolean titulo) {
        if (dispositivos.isEmpty()) {
            System.out.println("No hay dispositivos");
        } else {
            if (titulo) {
                System.out.println("Sucursal: " + nombre);
            }
            System.out.println(DispositivoElectronico.toStringTable(dispositivos));
        }
    }

    public ArrayList<DispositivoElectronico> dispositivosPorTipo(TipoDispositivo tipo) {
        ArrayList<DispositivoElectronico> toReturn = new ArrayList<>();
        for (DispositivoElectronico d : dispositivos) {
            if (d.esTipo(tipo)) {
                toReturn.add(d);
            }
        }
        return toReturn;
    }

    
    // Sin iterator
    public DispositivoElectronico borrarDispositivo(String id) {
        DispositivoElectronico toReturn = buscarDispositivoElectronico(id);
        if(toReturn != null){
            dispositivos.remove(toReturn);
        }
        return toReturn;
    }
    
    
    // Buscamos por indice
    private int indiceDispositivo(String id){
        /*int index = -1;
        int i = 0;
        while(i < dispositivos.size() && index != -1){
            if(dispositivos.get(i).tieneId(id)){
                index = i;
            }
            i++;
        }    
        return index;*/
        
        //todo lo anterior se hace con esto:
        return dispositivos.indexOf(buscarDispositivoElectronico(id));
    }
    
    //Borramos por indice
    public DispositivoElectronico borrarDispositivo2(String id) {
        int indice;
        if((indice = indiceDispositivo(id)) != -1){
            return dispositivos.remove(indice);
        }
        return null;
    }
    //Con ternario
    public DispositivoElectronico borrarDispositivo3(String id) {
        int indice = indiceDispositivo(id);
        return indice != -1 ? dispositivos.remove(indice) : null;
    }
    
    public DispositivoElectronico buscarDispositivoElectronico(String id){
        DispositivoElectronico target = null;
        boolean encontrado = false;
        int i=0;
        while(i < dispositivos.size() && !encontrado){
           target = dispositivos.get(i++);
           if(target.tieneId(id)){
               encontrado = true;
           }
        }
        return encontrado? target : null;
    }  
    
    // Con Iterator
    public DispositivoElectronico borrarDispositivoIt(String id){
        Iterator<DispositivoElectronico> it = dispositivos.iterator();
        
        DispositivoElectronico actual = null;
        boolean borrado = false;
        
        while(it.hasNext() && !borrado){
            actual = it.next();
            if(actual.tieneId(id)){
                it.remove();
                borrado = true;
            }
        }
        return actual;
    }
    
    // Array de doubles = double[]
    public double[] porcDispositivoPorTipo(String nombreSuc){
        int[] contadores = cantidadDispositivosTipo();
        double[] porcentajes = new double[contadores.length];
        int i=0;
        for(int contador : contadores){
            porcentajes[i++] = calcularPorcentaje(contador);
        }
        return porcentajes;
    }
    
    private int[] cantidadDispositivosTipo(){
        int [] contadores = new int[TipoDispositivo.values().length];
        for(DispositivoElectronico d : dispositivos){
            contadores[d.ordenTipo()]++;
        }
        return contadores;
    }
    
    private double calcularPorcentaje(int cant){
        return (double) cant * 100 / dispositivos.size();
    }

}

