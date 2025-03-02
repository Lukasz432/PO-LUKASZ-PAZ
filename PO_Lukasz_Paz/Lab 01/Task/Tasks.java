package Task;
import java.util.Scanner;

public class Tasks {

  public static void zad1() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(" Podaj swój wiek: ");
    String wiek = scanner.nextLine();

    System.out.println(" Podaj swoje imie: ");
    String imie = scanner.nextLine();

    System.out.println("wiek: " + wiek + "\n" + "imie: " + imie);
  }

  public static void zad2() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj liczbe 1:");
    int liczba1 = scanner.nextInt();

    System.out.println("Podaj liczbe 2:");
    int liczba2 = scanner.nextInt();

    int suma = liczba1 + liczba2;
    int roznica = liczba1 - liczba2;
    int iloczyn = liczba1 * liczba2;

    System.out.println("Suma:" + suma + "\n" + "Różnica:" + roznica + "\n" + "Iloczyn: " + iloczyn);

  }

  public static void zad3() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Wprowadz liczbe:");

    int liczba = scanner.nextInt();
    if (liczba % 2 == 0) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }

  }

  public static void zad4() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Wprowadz liczbe:");
    int liczba = scanner.nextInt();
    if (liczba % 3 == 0 && liczba % 5 == 0) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }

 
  public static void zad5() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Wprowadz liczbe: ");
    double liczba = scanner.nextInt();
    double wynik = Math.pow(liczba, 3);
    System.out.println("wynik: " + wynik);
  }

  public static void zad6(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Wprowadz liczbe: ");
    double liczba = scanner.nextInt();
    double wynik = Math.sqrt(liczba);
    System.out.println("wynik: " + wynik );
    
  }

public static void zad7(){
  Scanner scanner = new Scanner(System.in);
  System.out.println("Wprowadz liczbe1: ");
  double liczba1 = scanner.nextInt();

  System.out.println("Wprowadz liczbe2: ");
  double liczba2 = scanner.nextInt();  

  double liczba_a = liczba1*liczba1;
  double liczba_b = liczba2*liczba2;

double wynik = liczba_a + liczba_b;
double c= Math.sqrt(wynik);

  if(liczba1>0 && liczba2>0){
    System.out.println("Powstwanie trójkąt prostokątny");
    
  
  System.out.println("wynik: "+ c);
}
  else{
    System.out.println("Nie powstanie trójkąt prostokątny");

  }
 
}
    
    
}

    

