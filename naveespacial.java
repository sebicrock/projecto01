package reto1;

public class naveespacial {

    private String nombre;
    private double velocidadMaxima;
    private double capacidadPasajeros; 
   

    public naveespacial(String nombre, double velocidadMaxima, double capacidadPasajeros ){

        this.nombre = nombre;
        this.velocidadMaxima = velocidadMaxima;
        this.capacidadPasajeros = capacidadPasajeros;

    }

    //getter

    public String getNombre(){
        return nombre;
    }

    public double getVelocidadMaxima(){
        return velocidadMaxima;
    }

    public double getCapacidadPasajeros(){
        return capacidadPasajeros;
    }




    public void mostrarInformacion(){
        System.out.println("Nombre: "+ nombre);
        System.out.println("velocidad Maxima:"+ velocidadMaxima+ "km/h");
        System.out.println("capacidad de pasajeros: "+capacidadPasajeros);
        
    }
    
}
