package cadenatecnologia122;

import java.util.ArrayList;

public class CadenaTecnologia {

    private ArrayList<Sucursal> sucursales;

    public CadenaTecnologia(Sucursal suc) {
        this();
        agregarSucursal(suc);
    }

    public CadenaTecnologia() {
        sucursales = new ArrayList<>();
    }

    public void agregarSucursal(Sucursal suc) {
        validarSucursal(suc);
        sucursales.add(suc);
    }

    //Utilizo el error SucursalRepetidaException
    public void validarSucursal(Sucursal suc) {
        if (suc == null) {
            throw new SucursalRepetidaException("Sucursal nula.");
        }
        if (sucursales.contains(suc)) {
            throw new SucursalRepetidaException();
        }
    }

    public void listarDispositivos(boolean nombreSuc) {
        if (sucursales.isEmpty()) {
            System.out.println("No hay sucursales");
        } else {
            for (Sucursal s : sucursales) {
                s.listarDispositivos(nombreSuc);
            }
        }
    }

    public ArrayList<DispositivoElectronico> dispositivosPorTipo(TipoDispositivo tipo) {
        ArrayList<DispositivoElectronico> toReturn = new ArrayList<>();
        for (Sucursal s : sucursales) {
            toReturn.addAll(s.dispositivosPorTipo(tipo));
        }
        return toReturn;
    }

    public DispositivoElectronico borrarDispositivo(String id, String nombreSucursal) {
        Sucursal sucu = buscarSucursal(nombreSucursal);
        DispositivoElectronico disp = null;
        if(sucu != null){
            disp = sucu.borrarDispositivo(id);
        }
        return disp;
    }

    private Sucursal buscarSucursal(String nombre) {
        int i = 0;
        Sucursal sucBuscada = null;
        while (i < sucursales.size() && sucBuscada == null) {
            Sucursal sucActual = sucursales.get(i);
            if (sucActual.tieneNombre(nombre)) {
                sucBuscada = sucActual;
            }
            i++;
        }
        return sucBuscada;
    }
    
    public double[] porcDipositivosPorTipo(String nombreSucursal) throws SucursalInexistenteException {
       Sucursal sucursal = buscarSucursal(nombreSucursal);
       if(sucursal == null){
           throw new SucursalInexistenteException();
       }
       return sucursal.porcDispositivoPorTipo(nombreSucursal);
    }
    

}

