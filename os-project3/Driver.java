import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Driver{
    static Random r = new Random();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException{

        System.out.println("Hello user! We will be estimating the value of pi by throwing arrows on a dart. Enter the number of threads to run (between 1 to 20 inclusive)");
                 int numThreads = sc.nextInt();

                 while (numThreads > 20 || numThreads < 1){
                     System.out.println("Enter number in correct range!");
                     numThreads = sc.nextInt();
                    }
                ArrayList<Double> result = new ArrayList<>();
                System.out.println("Please enter the number of arrows to throw (greater than 0).");
                int numArrows = sc.nextInt();
               
                while (numArrows < 1){
                    System.out.println("Enter number in correct range!");
                    numArrows = sc.nextInt();
                }

                final int numArrowValue = numArrows;
         
        Thread threadsArray[];
        threadsArray = new Thread[20];

        for (int j = 0; j < numThreads; j++){
        threadsArray[j] = new Thread(new Runnable() {
            public void run(){
                int inside = 0;
                for(int i = 0; i < numArrowValue; i++){
                    double x = -1.0 + (1.0 - (-1.0)) * r.nextDouble();
                    double y = -1.0 + (1.0 - (-1.0)) * r.nextDouble();
                    if (Math.sqrt((y - 0.0) * (y - 0.0) + (x - 0.0) * (x - 0.0)) <= 1.0){
                        inside++;
                    }
                }
                double calculation = 0;
                double step = inside * 4;
                calculation = step/numArrowValue;
                result.add(calculation);
                
            }
        });
       threadsArray[j].start();
       Thread.yield();
       threadsArray[j].join();
    }
        Thread.sleep(5000);
        double averageSum = 0;
        for (int i = 0; i < result.size(); i++){
            averageSum = averageSum + result.get(i);
        }
        double finalValue  = averageSum/result.size();
        System.out.println("The final value of pi is: " + finalValue);
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
       
    }
}
