package com.capgemini.interviewquestions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Learn auto closable ? What it is ? Prepare for the interview
public class Exception7TryWithResources {
	public static void main(String[] args)
	{
		//System.out.println(System.getProperty("user.dir"));
		//the output of this line is =D:\Software\Automation\AppAutomation\automation_exercise_logic
		
		File myFile=new File(System.getProperty("user.dir") +"\\Demo.txt");
//		FileReader fr;
//		BufferedReader br=null;
		try(BufferedReader br=new BufferedReader(new FileReader(myFile)))
	{
//			fr=new FileReader(myFile);
//			br=new BufferedReader(fr);
		System.out.println(br.readLine());
		}
		catch(IOException e)
		{
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
//		finally {
//		try {
//			br.close();
//		}
//		catch(IOException e)
//		{
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
	}

}


