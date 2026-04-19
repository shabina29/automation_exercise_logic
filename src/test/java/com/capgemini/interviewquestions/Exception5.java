package com.capgemini.interviewquestions;

//ctrl+Shift+O: to remove unused import
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Exception5 {
	public static void main(String[] args)
	{
		//System.out.println(System.getProperty("user.dir"));
		//the output of this line is =D:\Software\Automation\AppAutomation\automation_exercise_logic
		
		File myFile=new File(System.getProperty("user.dir") +"\\Demo.txt");
		FileReader fr;
		BufferedReader br=null;
		try
		{
			fr=new FileReader(myFile);
			br=new BufferedReader(fr);
			System.out.println(br.readLine());
		}
		catch(IOException e)
		{
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		finally {
		try {
			br.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}}
