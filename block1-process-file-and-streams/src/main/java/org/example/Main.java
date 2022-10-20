package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException, InvalidLineFormatException {
        //Path path2 = Path.of(args[0]);
        Path path = Paths.get("src/main/resources/people.csv");
        List<Person> person = new ArrayList<>();

        readFile(person, path);
    }

    public static void readFile(List<Person> person, Path path) throws IOException, InvalidLineFormatException {
        BufferedReader reader = Files.newBufferedReader(path);

        //coge la línea y la convierte en una String
        String line = reader.readLine();
        //con un split guardamos cada apartado en un array
        String[] result = line.split(":", -3);
        //con cada una de las posiciones del array guardamos cada apartado en un objeto Person
        person.add(new Person(result[0], result[1], Integer.parseInt(result[2])));
        System.out.println(line);
        System.out.println("Name: " + result[0] + " | Town:" + result[1] + " | Age:" + result[2]);

        while (line != null) {
            line = reader.readLine();

            if (line == null) {
                //Evitamos que deje un hueco al final del archivo con un NULL impreso
            } else {

                try {
                    //Pequeña comprobación de que lee correctamente el archivo
                    result = line.split(":", -3);
                    //Como el nombre es obligatorio, los siguientes apartados hay que vigilarlos
                    //En este caso si no tenemos el lugar de origen, ponemos UNKNOWN
                    if (result[1] == "") {
                        result[1] = "UNKNOWN";
                        //En caso de que la edad no aparezca asignaremos 0
                    } else if (result[2] == "") {
                        result[2] = "0";
                    }
                    //Vemos como era la línea original
                    System.out.println(line);
                    //Mostramos los datos guardados en el array actual
                    System.out.println("Name: " + result[0] + " | Town: " + result[1] + " | Age: " + result[2]);
                    //Aquí añadimos las personas con los datos controlados
                    person.add(new Person(result[0], result[1], Integer.parseInt(result[2])));

                } catch (Exception e) {
                    //
                    if (!checkChar(line)) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                        throw new InvalidLineFormatException ("Falta un símbolo de puntuación: " + ":");
                    }
                }
            }
        }

        //Comprobamos que están los datos correctamente guardados en la lista
        //System.out.println("\nDatos guardados en la lista");
        //for (int i = 0; i < person.size(); i++) {
        //    System.out.println(person.get(i).getName() + " " + person.get(i).getTown() + " " + person.get(i).getAge());
        //}

        streamA(person);
        streamB(person);
        streamC(person);
        streamD(person);
    }

    public static boolean checkChar(String line){
        int count = 0;
        //Cada vez que encuentre un ':' en una línea lo añade al contador
        //Pues el mínimo para una línea debe ser de dos ':'
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ':') {
                count++;
            }
        }

        //Si el conteo está bien, se devuelve un booleano True
        //Si el conteo NO está bien, se devuelve un booleano False
        if (count == 2) {
            return true;
        }
        //Al haber solo una línea, se puede prescindir del else
        return false;

        //Se puede sustituir todo el método del if con un return con count == 2 y devuelve un booleano
    }

    public static void streamA(List<Person> list) {
        //En caso de que la persona sea menor O tenga 0 en edad
        System.out.println("\nPersonas cuya edad es menor de 25 y no admite gente con 0");
        list.stream().filter(Person -> Person.getAge() < 25 && Person.getAge() != 0).forEach(person -> {
            System.out.println("Name: " + person.getName() + " | Town: " + person.getTown() + " | Age: " + person.getAge());
        });
    }

    public static void streamB(List<Person> list) {
        //En caso de que el nombre de la persona empiece por A
        System.out.println("\nPersonas cuyo nombre no empiece por A\n");
        list.stream().filter(Person -> !Person.getName().startsWith("A")).forEach(person -> {
            System.out.println("Name: " + person.getName() + " | Town: " + person.getTown() + " | Age: " + person.getAge());
       });
    }

    public static void streamC(List<Person> list) {
        //Creamos un optional con la string Madrid
        Optional<String> personCity = Optional.ofNullable("Madrid");
        System.out.println("\nPersona cuya ciudad sea: Madrid");

        //Creamos el filtro que usará el optional como forma de filtrado
        list.stream().filter(Person -> Person.getTown().contains(personCity.get())).forEach( person -> {
            System.out.println("Name: " + person.getName() + " | Town: " + person.getTown() + " | Age: " + person.getAge());
        });
    }

    public static void streamD(List<Person> list) {

        Optional<String> personCity = Optional.ofNullable("Barcelona");
        System.out.println("\nPersona cuya ciudad sea: Barcelona");

        list.stream().filter(Person -> Person.getTown().contains(personCity.get())).forEach( person -> {
            System.out.println("Name: " + person.getName() + " | Town: " + person.getTown() + " | Age: " + person.getAge());
        });
    }
}

