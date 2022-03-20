package g13c.cw1.zad5;

public class z5 {
    public static void main(String[] args) {
        z5 Array = new z5();
        Array.generateRandomArray();
        System.out.print("Generated array: ");
        Array.printArray();

        System.out.print("Sorted array:    ");
        Array.sortArray();
        Array.printArray();
    }

    private int[] theArray = new int[10];
    public void generateRandomArray(){
        for(int i = 0; i < theArray.length; i++){
            // Random number max=1000, min=100, accuracy: 50
            theArray[i] = 50*((int)(Math.random()*(20-2))+2);
        }
    }

    public void swapValues(int a, int b){
        int temp = theArray[a];
        theArray[a] = theArray[b];
        theArray[b] = temp;}

    public void printArray(){
        for(int i = 0; i < theArray.length; i++){
            System.out.print("| " + theArray[i] + " ");
        }
        System.out.println("|");}

        public void sortArray(){
            for (int i=0; i<theArray.length;i++){
                int min = i;
                for (int j = i; j < theArray.length; j++){
                    if (theArray[min]>theArray[j]){
                        min = j;
                    }
                }
                swapValues(i,min);
            }
        }

}
