import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams 
{
	//@Test
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//code to extract names starting with 'a'
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Alekhya");
		names.add("Rekha");
		names.add("Ram");
		names.add("Akash");
		
		int count = 0;
		
		for(int i=0; i<names.size(); i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);
	} 
	
	//with streams - code to extract names starting with 'a'
	//@Test
	public void streamFilter()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Alekhya");
		names.add("Rekha");
		names.add("Ram");
		names.add("Akash");
		
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		//to print all the names with >4 characters
		names.stream().filter(s->(s.length()>4)).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));	//limits the result to 1 result
	}
	
	//@Test
	public void streamMap()
	{	
		//print names with last letter 'a' in uppercase
		Stream.of("Abhijeet", "Alekhya", "Rekha", "Ram", "Akash").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//print names with first letter 'a' in uppercase and sorted
		Stream.of("Abhijeet", "Alekhya", "Rekha", "Ram", "Akash").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//to concatinate two streams
		List<String> names1 = Arrays.asList("abc", "def", "test", "jar");
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Alekhya");
		names.add("Rekha");
		names.add("Ram");
		names.add("Akash");
		
		Stream<String> concatStream = Stream.concat(names.stream(), names1.stream());
		//concatStream.sorted().forEach(s->System.out.println(s));
		boolean flag = concatStream.anyMatch(s->s.equalsIgnoreCase("Alekhya"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	//@Test
	public void streamCollect()
	{
		//collecting streams to list
		List<String> l = Stream.of("Abhijeet", "Alekhya", "Rekha", "Ram", "Akash").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		//print 1st element in the list
		System.out.println(l.get(0));
	}
	
	@Test
	public void test()
	{
		//print unique numbers from the list and sort
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
		// to get only the third index
		List<Integer> l = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("Third number is "+l.get(2));
				
	}
}
