import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import models.Estudiante;

public class App {
    public static void main(String[] args) throws Exception {
        //runEjemplosPrimitivos();
        //runEjemplosObjetos();
        //runComparators();
        //runComparatorsObj();
        //runComparatorsObj2();
        
        Comparators comparators = new Comparators();
        
    }

    private static void runComparatorsObj2(){
        Estudiante e1 = new Estudiante("Juan", 10);

        Estudiante[] estudiantes = {e1,
                new Estudiante("Maria", 7),
                new Estudiante("Diego", 3.5),
                new Estudiante("Pedro", 6.8),
        };

        
        Comparator<Estudiante> compNota = Comparator.comparingDouble(e -> e.getNota());
        Arrays.sort(estudiantes, compNota);
        for (int i = 0; i < estudiantes.length; i++){
           System.out.print(estudiantes[i] + " - ");
        }
           System.out.println(); 


        List<Estudiante> estudiantesLista = new ArrayList<>(List.of(e1,
                new Estudiante("Maria", 7),
                new Estudiante("Diego", 3.5),
                new Estudiante("Pedro", 6.8)));
        
        estudiantesLista.sort(compNota);
        for(int i = 0; i < estudiantesLista.size(); i++){
            System.out.println(estudiantesLista.get(i) + " - ");

        }
        System.out.println();
    }

    private static void runComparatorsObj(){
        List<Integer> numeros = new ArrayList<>(List.of(5, 6, 4, 1, 2, 3));

        //Orden de menor a mayor 
        numeros.sort(Comparator.naturalOrder());
        numeros.sort(null);
        System.out.println(numeros);

        //Orden de mayor a menor
        numeros.sort(Comparator.reverseOrder());
        System.out.println(numeros);

    }

    private static void runComparators(){
        Integer [] original = {5, 6, 4, 1, 2, 3};
        Arrays.sort(original);
        for ( int i = 0; i < original.length; i++)
            System.out.println(original[i] + " - ");
        
        System.out.println("------------------------");
        Arrays.sort(original, Comparator.reverseOrder());
        for ( int i = 0; i < original.length; i++)
            System.out.println(original[i] + " - ");
          
    }
    
    private static void runEjemplosObjetos(){
        Estudiante e1 = new Estudiante("Juan", 10);

        Estudiante[] estudiantes = {e1,
                new Estudiante("Maria", 7),
                new Estudiante("Diego", 3.5),
                new Estudiante("Pedro", 6.8),
        };

        Bubble bubble = new Bubble();
        printArregloEstudiantes(estudiantes, "Original");
        bubble.sortEstudiantesNOTA(estudiantes);
        printArregloEstudiantes(estudiantes, "Ordenado");


    }

    public static void runEjemplosPrimitivos(){
        int[] original = { 5, 6, 4, 1, 2, 3};
        int[] b = original.clone();
        int[] c = original.clone();
        int[] d = original.clone();

        // USAR EL METODO DEL ARCHIVO(clase) BUBBLE
        // INSTANCIAR el archivo BUBBLE
        // INSTANCIA la clase BUBBLE
        Bubble buuble = new Bubble();
        // EJECUTAR CODIGO DEL ARCHIVO BUBBLE USO LA INSTANCIA
        printArreglo(b, "Original");
        buuble.sort(b);
        printArreglo(b, "Ordenado");

        //Instanciar seleccion 
        System.out.println("Selection");
        Selection selection = new Selection();
        printArreglo(c, "Original");
        selection.sort(c);
        printArreglo(c, "Ordenado");

        //Instanciar insertion
        System.out.println("---Selection insertion---");
        Insertion insertion = new Insertion();
        printArreglo(d , "Original");
        insertion.sort(d);
        printArreglo(d, "Ordenado");
    }

    public static void printArreglo(int [] arr, String title) {
        System.out.println(title);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " - ");
        System.out.println();
    }

    public static void printArregloEstudiantes(Estudiante[] arr, String title) {
        System.out.println(title);
        for (int i = 0; i < arr.length; i++){
           System.out.print(arr[i] + " - ");
        }
           System.out.println(); 
        
    }
}   
