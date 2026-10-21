public class App {
    public static void main(String[] args) throws Exception {
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
}
