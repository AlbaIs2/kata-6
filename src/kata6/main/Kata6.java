
package kata6.main;

import java.sql.SQLException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Person;
import kata6.view.DataBaseList;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;

public class Kata6 {
    public interface Attribute <T,S>{
        S get(T item);
    }
    public static void main(String[] args) throws  SQLException, ClassNotFoundException {
        
        List<Person> people = DataBaseList.read();
        HistogramBuilder <Person> builderPerson = new HistogramBuilder<>(people);
        
        Histogram <Character> gender =builderPerson.build(new Attribute<Person,Character>(){
            @Override
            public Character get(Person item){
                return item.getGender();
            }
        });
        new HistogramDisplay(gender,"Gender").execute();
        
        Histogram <Float> weight = builderPerson.build(new Attribute<Person,Float>(){
            @Override
            public Float get(Person item){
                return item.getWeight();
            }
        });
        new HistogramDisplay(weight,"Weight").execute();
    }   
}
