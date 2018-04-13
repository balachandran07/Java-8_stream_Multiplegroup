package com.kgisl.parseexbeen;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

public class App {

    public static void main(String[] args) throws IOException {

        String fileName = "src/main/resources/cave.csv";
        Path myPath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(myPath,
                StandardCharsets.UTF_8)) {

            HeaderColumnNameMappingStrategy<Employee> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Employee.class);

            CsvToBean csvToBean = new CsvToBeanBuilder(br)
                    .withType(Employee.class)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Employee> emp = csvToBean.parse();
// System.out.println(emp);
            emp.forEach(System.out::println);




            //**************GROUPINGBY************
            System.out.println("************----------------***********");
            Map <String,Long> byGender = emp.stream()
            .collect(Collectors.groupingBy(Employee::getStatus, Collectors.counting()));



            System.out.println(byGender);
                    System.out.println("************----------------***********");

            Map<String, List<Employee>> groupByPriceMap = 
			emp.stream().collect(Collectors.groupingBy(Employee::getTradeid));
       System.out.println(groupByPriceMap);


            ////***************END********* */


//******************MULTIPLE GROUPBY */

System.out.println("************--------+++++--------***********");


Map<Object, Map <Object, List<Employee>>> groupByPriceMap1 = 
            emp.stream().collect(Collectors.groupingBy(p->p.getTradeid(),Collectors.groupingBy(p->p.getStatus())));
 

            System.out.println(groupByPriceMap1);
            System.out.println("*********+++***----------------***********");



        }
    }
}
