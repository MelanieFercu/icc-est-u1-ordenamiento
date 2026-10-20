public class Bubble {

    public void sort( int[] arreglo) {
        int cambios = 0;
        int comparaciones = 0;

        for ( int i = 0; i < arreglo.length; i++) {
            System.out.println("Pasada: " + i);
            boolean commbinaciones = false;
            for (int j = 1; j < arreglo.length - i; j++){
                comparaciones++;
                if (arreglo[j - 1] > arreglo[j]){
                    cambios++;
                    commbinaciones = true;
                    //INTERCAMBIO
                    int aux = arreglo[j - 1];
                    arreglo[j - 1] = arreglo[j];
                    arreglo[j] = aux;

                }
            }
            if (!commbinaciones) {
                break;
            }
            System.out.println("Cambios: " + cambios);
            System.out.println("Comparaciones: " + comparaciones);
        }
        System.out.println("Cambios: " + cambios);
        System.out.println("Comparaciones: " + comparaciones);   
    }
}
