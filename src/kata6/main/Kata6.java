
package kata6.main;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {
    public static void main(String[] args) throws IOException {
        
        String filename = "C:\\Users\\ALBA\\Documents\\NetBeansProjects\\kata6\\emailsfile.txt";
        List <Mail> mailList = MailListReader.read(filename);
        Histogram<String> histogram = MailHistogramBuilder.build(mailList); 
        new HistogramDisplay(histogram).execute();
   
    }   
}
