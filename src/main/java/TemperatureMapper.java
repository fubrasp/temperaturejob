
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TemperatureMapper
        extends Mapper<LongWritable, Text, Text, IntWritable> {

    private static final int MISSING = 9999;

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String ligne = value.toString();
        String annee = ligne.substring(15,19);
        int temperature;
        if(ligne.charAt(87) == '+') {
            temperature = Integer.parseInt(ligne.substring(88,92));
        } else {
            temperature = Integer.parseInt(ligne.substring(87,92));
        }
        String qualite  = ligne.substring(92,93);
        if(temperature != MISSING && qualite.matches("[01459]")){
            context.write(new Text(annee), new  IntWritable(temperature));
        }
    }
}
