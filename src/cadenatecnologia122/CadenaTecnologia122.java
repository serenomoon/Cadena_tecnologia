package cadenatecnologia122;

public class CadenaTecnologia122 {

    public static void main(String[] args) {
        CadenaTecnologia cadena = new CadenaTecnologia();
        hardcodearCadena(cadena);
        
        cadena.listarDispositivos(true);
        
        for(DispositivoElectronico d : cadena.dispositivosPorTipo(TipoDispositivo.COMPUTADORA)){
            System.out.println(d);
        }
        
        System.out.println("\n");
        
        //Quitamos la computadora
        System.out.println(cadena.borrarDispositivo("ks123", "Sucursal A"));
        
        System.out.println("\n");
        
        for(DispositivoElectronico d : cadena.dispositivosPorTipo(TipoDispositivo.COMPUTADORA)){
            System.out.println(d);
        }
    }
    
    public static void hardcodearCadena(CadenaTecnologia cadena) {
        Sucursal s1 = new Sucursal("Sucursal A");
        Sucursal s2 = new Sucursal("Sucursal B");

        s1.agregarDispositivo(new DispositivoElectronico("ks123", TipoDispositivo.COMPUTADORA, 10_000));
        s1.agregarDispositivo(new DispositivoElectronico("23Klw", TipoDispositivo.TABLET, 5_000));
        s1.agregarDispositivo(new DispositivoElectronico("2HJu2", TipoDispositivo.TELEFONO, 8_000));
        s1.agregarDispositivo(new DispositivoElectronico("SDj34", TipoDispositivo.COMPUTADORA, 12_000));

        s2.agregarDispositivo(new DispositivoElectronico("JJJS8", TipoDispositivo.COMPUTADORA, 15_000));
        s2.agregarDispositivo(new DispositivoElectronico("ANS69", TipoDispositivo.TELEFONO, 7_000));
        s2.agregarDispositivo(new DispositivoElectronico("39DJh", TipoDispositivo.TELEFONO, 9_000));
        s2.agregarDispositivo(new DispositivoElectronico("SKj93", TipoDispositivo.TABLET, 2_500));
        s2.agregarDispositivo(new DispositivoElectronico("SKj97", TipoDispositivo.TABLET, 3_500));

        cadena.agregarSucursal(s1);
        cadena.agregarSucursal(s2);
    }
    
}
