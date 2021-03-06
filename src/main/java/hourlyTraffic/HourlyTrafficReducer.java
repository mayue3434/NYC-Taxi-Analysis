package hourlyTraffic;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class HourlyTrafficReducer extends
		Reducer<Text, Text, NullWritable, Text> {

	public void reduce(Text key, Iterable<Text> values,
			Context context) throws IOException, InterruptedException {
		for (Text value : values) {
			context.write(NullWritable.get(), new Text(value));
		}
	}
}