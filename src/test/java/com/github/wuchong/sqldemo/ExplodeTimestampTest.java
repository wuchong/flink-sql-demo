package com.github.wuchong.sqldemo;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

public class ExplodeTimestampTest {

	@Test
	public void test2() throws IOException {
//		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 1, 10};
////		String[] array = {"服饰鞋包", "家装家饰", "家电","美妆","母婴","3C数码","运动户外","食品", "服饰鞋包", "其他"};
//		BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/wuchong/Downloads/cate_cnt.csv")));
//		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("/Users/wuchong/Downloads/cate_info.csv")));
//		String line = reader.readLine();
//		long start = Timestamp.valueOf("2017-11-27 00:00:00").getTime();
//		long end = Timestamp.valueOf("2017-11-28 00:00:00").getTime();
//		int index = 0;
//		while (line != null) {
//			String[] splits = line.split(",");
//			writer.write("(" + splits[0] + ", " + array[index] + "),\n");
//			line = reader.readLine();
//			index++;
//			if (index >= array.length) {
//				index = 0;
//			}
//		}
//		reader.close();
//		writer.flush();
//		writer.close();

//		long start = Timestamp.valueOf("2017-11-27 00:00:00").getTime();
//		long end = Timestamp.valueOf("2017-11-28 00:00:00").getTime();
//		System.out.println(start);
//		System.out.println(end);

		long ts = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(ts);
//		System.out.println(timestamp);
//		System.out.println(timestamp.toLocalDateTime());
		Instant instant = Instant.ofEpochMilli(ts + TimeZone.getDefault().getOffset(ts));
		System.out.println(instant.toString());
	}

}