package average.date.trips;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driver {

	public static void main(String[] args) throws Exception {
		
		Job job = Job.getInstance(new Configuration(), "DateAnalysis");
	    
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(IntWritable.class);
	    
	    job.setJarByClass(Driver.class);
	    job.setMapperClass(AverageTripsMapper.class);
	    job.setReducerClass(AverageTripsReducer.class);
	    
	    job.setNumReduceTasks(1);
	                
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	        
	    job.waitForCompletion(true);
	 }
	        
	}