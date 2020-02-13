
import java.util.Map;

public class TestMap {

    public static void main(String[] args){

        ServiceClass srv = new ServiceClass();
        Dictionary diction = srv.init();
        System.out.println(diction.toString());

        Map<Person, Map<FinancialProduct, Double>> accnts = srv.init1();
        //System.out.println(accnts.get(null));
        srv.displayMap(accnts);
        srv.removeFP(accnts);
        System.out.println("/n***************************/n");
        srv.displayMap(accnts);



    }
}
