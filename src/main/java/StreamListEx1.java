import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamListEx1 {
    @Test
    public void regular() {
        //get the total count of the names which are start with "A"

        ArrayList<String> names = new ArrayList<>();
        names.add("Avishek");
        names.add("Don");
        names.add("Avik");
        names.add("shreya");
        names.add("Abhijeet");

        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);

            if (name.startsWith("A")) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamApply() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Avishek");
        names.add("Don");
        names.add("Avik");
        names.add("shreya");
        names.add("Abhijeet");

        //Use Stream() concept
        Long stnm = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(stnm);

        //print the names which lenghth is >4
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

        //limit the result and return me the only 1st result which length is >4
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
    }

    @Test
    public void streamMap() {
        ArrayList<String> names1 = new ArrayList<>();
        names1.add("Mampu");
        names1.add("Arunava");
        names1.add("Chita");

        //get the names which ends with "k" and return them in upper case
        Stream.of("Avishek", "Don", "Avik", "Pratik", "Rahul").filter(s -> s.endsWith("k")).
                map(String::toUpperCase).forEach(System.out::println);

        //Print the names which are starts with "a" with Upper case in sorted order
        List<String> names = Arrays.asList("Avishek", "Don", "Renu", "Devid", "Arun", "Adam");
        names.stream().filter(s -> s.startsWith("A")).
                map(String::toUpperCase).sorted().forEach(System.out::println);

        //Merge the 2 list
        Stream<String> newStream = Stream.concat(names1.stream(), names.stream());
     //  newStream.sorted().forEach(System.out::println);

        //Find the string in the big String
      boolean flag= newStream.anyMatch(s->s.equalsIgnoreCase("Mampu"));
      System.out.println(flag);
      Assert.assertTrue(flag);
    }

    @Test
    public void StreamCollect(){
        ArrayList<String> ls=new ArrayList<>();
        ls.add("ddfd");
        ls.add("ggf");
        ls.add("abcd");

        ls.stream().filter(s->s.length()>4).collect(Collectors.toList());
        System.out.println(ls.get(0));

    }

    @Test
    public void printNum(){
        List<Integer> values=Arrays.asList(2,3,4,7,9,4,9);

        //Print the unique number from the list
      //  values.stream().distinct().forEach(System.out::println);

        //Print the numbers in sorted order and print the 3rd index
      List<Integer> val= values.stream().distinct().sorted().collect(Collectors.toList());
      System.out.println(val.get(2));

    }
}


