/**
 * MaxClosePriceReducer.java
 */
 import java.io.IOException;
 import java.util.Iterator;
 
 import org.apache.hadoop.io.FloatWritable;
 import org.apache.hadoop.io.Text;
 import org.apache.hadoop.mapred.MapReduceBase;
 import org.apache.hadoop.mapred.OutputCollector;
 import org.apache.hadoop.mapred.Reducer;
 import org.apache.hadoop.mapred.Reporter;

 public class MaxClosePriceReducer extends MapReduceBase implements Reducer<Text,FloatWritable,Text,FloatWritable>
 {

	 @Override
	 public void reduce(Text key, Iterator<FloatWritable> values, 
			 OutputCollector<Text, FloatWritable> output, Reporter r)
			 throws IOException {

		 float maxClosePrice = 0; 
		 
		 //Iterate all and calculate maximum
		 while (values.hasNext()) {
			 FloatWritable i = values.next();
			 maxClosePrice = Math.max(maxClosePrice, i.get());
		 }
		 
		 //Write output
		 output.collect(key, new FloatWritable(maxClosePrice));
	 }
 }
