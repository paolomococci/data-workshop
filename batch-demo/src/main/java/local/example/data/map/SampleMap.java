/**
 *
 * Copyright 2020 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.data.map;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SampleMap 
	extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	private final static IntWritable intWritable = new IntWritable(1);
	private Text textWord = new Text();
	
	@Override
	public void map(
			LongWritable longWritableKey, 
			Text textValue, 
			Context context
			) throws IOException, InterruptedException {
		String phrase = textValue.toString();
		StringTokenizer stringTokenizer = new StringTokenizer(phrase);
		while (stringTokenizer.hasMoreTokens()) {
			textWord.set(stringTokenizer.nextToken());
			context.write(textWord, intWritable);
		}
	}
}
