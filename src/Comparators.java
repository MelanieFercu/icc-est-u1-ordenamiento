
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import models.Estudiante;

public class Comparators {
    
    
    private List<Estudiante> estList;
    private Estudiante[] estArray;

    public Comparators(){
        Estudiante e1 = new Estudiante("Juan", 10);

        estArray = new Estudiante[] {e1,
                new Estudiante("Maria", 7),
                new Estudiante("Diego", 3.5),
                new Estudiante("Pedro", 7),
                new Estudiante("Pedro", 6.8),
        };
        estList = new ArrayList<>(List.of(estArray));

        //Llamada a los ejemplos
        //ejemplo1();
        //ejemplo2();
        //ejemplo3();
        //ejemplo4();
        //ejemplo5();
        //ejemplo6();
        //ejemplo7();
        //ejemplo8();
        //ejemplo9();
        //ejemplo10();
        //ejemplo11();
        ejemplo12();
    }

    private void print(List<Estudiante> list){
        //for est in list:
        for (Estudiante e : list) {
            System.out.println(e);
        }
    }

    /**
    * Ordenar por Nota ascendentemente
    * Comparator -> por VALOR
    * Lambda extractora directa: nota ascendente
    */

    public void ejemplo1(){

        //Copiar el arreglo global
        List<Estudiante> lista = new ArrayList<>(estList);
        //Comparator -> Obj != (Envolvete de primitivo ni String)
        Comparator<Estudiante> comparador = 
        Comparator.comparingDouble(x -> x.getNota());
        lista.sort(comparador);
        //imprimir
        print(lista);

    }

    /**
    * Ordenar por Nota ascendentemente
    * Comparator -> por VALOR
    * Referencia
    */
    public void ejemplo2(){
        //Copiar el arreglo global
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = 
        Comparator.comparingDouble(Estudiante::getNota);
        lista.sort(comparator);
        System.out.println("------------------------------------");
        print(lista);
    }

    /**
    * Ordenar por Nota descendente
    * Comparator -> po VALOR
    * Referencia
    */
    
    public void ejemplo3(){
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = 
        Comparator.comparingDouble(Estudiante::getNota).reversed();
        lista.sort(comparator);
        System.out.println("-------------------------");
        print(lista);
    }

    /**
    * Ordenar por Nombre descendente
    * Comparator -> por VALOR
    * Referencia
    */
    public void ejemplo4(){
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = 
        Comparator.comparing(Estudiante::getNombre);
        lista.sort(comparator);
        System.out.println("---------------------------");
        print(lista);
    }

    /**
    * Ordenar por nota ascendente
    * Comparator -> compara DOS ITEMS
    * lambda
    */
    private void ejemplo5(){
        
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = 
        (e1, e2) -> Double.compare(e1.getNota(), e2.getNota());
        lista.sort(comparator);
        System.out.println("---------------------------");
        print(lista);
    }

    /**
    * Ordenar por nombre ascendente
    * Comparator -> compara DOS ITEMS
    * lambda
    */

    private void ejemplo6(){
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = 
        (e1, e2) -> e1.getNombre().compareTo(e2.getNombre());
        lista.sort(comparator);
        System.out.println("---------------------------");
        print(lista);
    }

    /**
    * Ordenar por nombre descendente
    * Comparator -> compara DOS ITEMS
    * lambda
    */
    private void ejemplo7(){
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = 
        (e1, e2) -> Double.compare(e2.getNota(), e1.getNota());
        lista.sort(comparator);
        System.out.println("---------------------------");
        print(lista);
    }

    /**
    * Ordenar por nota ascendente y nombre descendente
    * Comparator -> compara DOS ITEMS
    * lambda
    */
    private void ejemplo8(){
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = (e1, e2) -> {
            int comparacionNota = Double.compare(e1.getNota(), e2.getNota());
            if (comparacionNota != 0){
                return comparacionNota;
            } else {
                return e2.getNombre().compareTo(e1.getNombre());
            }};

        lista.sort(comparator);
        System.out.println("---------------------------");
        print(lista);
    }

    /**
    * Ordenar por nota ascendente y nombre ascendente
    * Comparator -> por valor
    * referencias
    */
    private void ejemplo9(){
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = Comparator
                .comparingDouble(Estudiante::getNota)
                .thenComparing(Estudiante::getNombre);
        lista.sort(comparator);
        System.out.println("---------------------------");
        print(lista);
    }

    /**
    * Ordenar por nota descendente y nombre ascendente
    * Comparator -> por valor
    * 1 comparator lambda
    * 2 comparator referencia
    */
    private void ejemplo10(){
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = Comparator
                .<Estudiante>comparingDouble(e -> e.getNota())
                .reversed()
                .thenComparing(Estudiante::getNombre);
        lista.sort(comparator);
        System.out.println("---------------------------");
        print(lista);
    }

    /**
    * Ordenar por nota ajustada ascendente y nombre descendente
    * Sumar 2 puntos si la nota es menor que 7
    * La nota máxima permitida es 10
    * Comparator -> por valor calculado
    * 1 comparator lambda con bloque de instrucciones
    * 2 comparator referencia con orden inverso
    */
    private void ejemplo11(){
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = Comparator
                .<Estudiante>comparingDouble(e -> {
                    double notaAjustada = e.getNota();
                    if (notaAjustada < 7){
                        notaAjustada += 2;
                        if (notaAjustada > 10){
                            notaAjustada = 10;
                        }
                    }
                    e.setNota(notaAjustada);
                    return notaAjustada;        
                    
                })  
                .thenComparing(
                    Comparator.comparing(Estudiante::getNombre).reversed());
        lista.sort(comparator);
        System.out.println("---------------------------");
        print(lista);
    }

    private void ejemplo12(){
    List<Estudiante> lista = new ArrayList<>(estList);
    
    Comparator<Estudiante> comparador = Comparator
        .<Estudiante>comparingDouble(e -> {
            double notaAjustada = e.getNota();
            e.setNota(notaAjustada);
            if (notaAjustada < 7) {
                notaAjustada = notaAjustada + 2;
                if (notaAjustada > 10) {
                    notaAjustada = 10;
                
                }
                
                
            }
            e.setNota(notaAjustada);
            return notaAjustada;
            
        }) // 1. Comparator lambda con bloque de instrucciones (calcula la nota ajustada)
        .thenComparing(Comparator.comparing(Estudiante::getNombre).reversed()); // 2. Comparator referencia con orden inverso para el nombre
    
    lista.sort(comparador);
    System.out.println("------------------------");
    print(lista);
}

}

