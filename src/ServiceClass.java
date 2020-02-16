
import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServiceClass {

    public Dictionary init() throws IOException {
        Dictionary diction = new Dictionary();

        try(BufferedReader reader =
                    new BufferedReader(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Map\\src\\MapFile.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                String[] keyValue = line.split("  ");
                diction.pair.put(keyValue[0], keyValue[1]);
            }
        }
//        diction.pair.put("Save", "Сохранить");
//        diction.pair.put("Remove", "Удалить");
//        diction.pair.put("Cancel", "Закрыть");
//        diction.pair.put("Create", "Создать");

        return diction;

    }

    public Map<Person, Map<FinancialProduct, Double>> init1(){
        Person per1 = new Person("Ivanov Ivan");
        Person per2 = new Person("Petrov Petr");
        Person per3 = new Person("Dou John");
        Person per4 = new Person("Kathe Smitt");
        Map<FinancialProduct, Double> fp1 = new HashMap<FinancialProduct, Double>();
        fp1.put(new FinancialProduct("chequing account"), 10000.00);
        Map<FinancialProduct, Double> fp2 = new HashMap<FinancialProduct, Double>();
        fp2.put(new FinancialProduct("saving account"), 25500.00);
        Map<FinancialProduct, Double> fp3 =  new HashMap<FinancialProduct, Double>();
        fp3.put(new FinancialProduct("RRSP account"), 20.00);
        Map<FinancialProduct, Double> fp4 = new  HashMap<>();
        fp4.put(new FinancialProduct("TFSA account"), 2500.00);


        Map<Person, Map<FinancialProduct, Double>> accnts = new HashMap<>();
        accnts.put(null, fp3);
        //accnts.put(null, fp1);
        accnts.put(per1, fp1);
        accnts.put(per2, fp3);
        accnts.put(per3, fp4);
        accnts.put(per4, fp2);
       
        return accnts;
    }
    
    public void displayMap(Map<Person, Map<FinancialProduct, Double>> map){
        for (Map.Entry<Person, Map<FinancialProduct, Double>> entry : map.entrySet()) {
            Person key = entry.getKey();
            Map<FinancialProduct, Double> value = entry.getValue();
            if (value.isEmpty()) {
                System.out.println("There is no FP for " + key.getName());
            } else {
                for (Map.Entry<FinancialProduct, Double> inner : value.entrySet()) {
                    FinancialProduct fp = inner.getKey();
                    Double balance = inner.getValue();
                    if (balance > 100) {
                        System.out.println("person = " + key.getName() + ";  fp = " + fp.getProductName() + "; balance = " + balance);
                    }
                }

            }
        }
    }

    public void removeFP(Map<Person, Map<FinancialProduct, Double>> map){
        Iterator<Map.Entry<Person, Map<FinancialProduct, Double>>> iter = map.entrySet().iterator();

        while(iter.hasNext()){

            Map<FinancialProduct, Double> value = iter.next().getValue();
            if (value == null){
                iter.remove();
            }else {
                Iterator<Map.Entry<FinancialProduct, Double>> innerIter = value.entrySet().iterator();
                while(innerIter.hasNext()) {

                    Double bal = innerIter.next().getValue();
                    if (bal > 20000) {
                        innerIter.remove();
                    }
                }
            }
        }
    }
}
