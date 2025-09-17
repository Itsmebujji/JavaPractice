package com.vineeth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandling {
	
	public void getString() {
		
		// ByteStream  -> FileInputStream, FileOutputStream
		
		try{
			File fi = new File("/Users/vineethkumar/Documents/sample.txt");
			File fo = new File("/Users/vineethkumar/Documents/output.txt");
			FileReader fr = new FileReader(fi);
			FileInputStream input = new FileInputStream(fi);
			FileOutputStream output = new FileOutputStream(fo);
			ByteArrayOutputStream bso = new ByteArrayOutputStream();
			int b;
			while((b = input.read()) != -1 ){
				bso.write(b);
				output.write(b);
			}
			String content = bso.toString("UTF-8");
			boolean found = content.contains("Bujji");
			if(!found){
				System.out.println("String is not there in the file content");
			}else{
				System.out.println("String is there in the file content");
			}
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
		
		
		// Character Stream  ->  FileReader, FileWriter
		
		try{
			File fi = new File("/Users/vineethkumar/Documents/sample.txt");
			File fo = new File("/Users/vineethkumar/Documents/output.txt");
			FileReader fr = new FileReader(fi);
			FileWriter fw = new FileWriter(fo);
			StringBuilder sb = new StringBuilder();
			int b;
			while((b = fr.read()) != -1 ){
				sb.append((char) b);
			}
			String s = sb.toString();
			boolean found = s.contains("Bujji");
			if(!found){
				System.out.println("String is not there in the file content");
			}else{
				System.out.println("String is there in the file content");
			}
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
		
		// BufferedReader, BufferedWriter	
		
		try{
			File fi = new File("/Users/vineethkumar/Documents/sample.txt");
			File fo = new File("/Users/vineethkumar/Documents/output.txt");
			FileReader fr = new FileReader(fi);
			FileWriter fw = new FileWriter(fo);
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			String line = br.readLine();
			boolean found = false;
			while(line !=null){
				if(line.contains("Bujji")){
					found = true;
					break;
				}
			}
			bw.write(line);
			if(!found){
				System.out.println("String is not there in the file content");
			}else{
				System.out.println("String is there in the file content");
			}
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
		
		// Scanner and PrintWriter
		
		try{
			File fi = new File("/Users/vineethkumar/Documents/sample.txt");
			File fo = new File("/Users/vineethkumar/Documents/output.txt");
			Scanner sc = new Scanner(fi);
			PrintWriter pw = new PrintWriter(fo);
			boolean found = false;
			
			while(sc.hasNextLine()){
				if(sc.nextLine().contains("Bujji")){
					found = true;
					break;
				}
				pw.write(sc.nextLine());
			}
			
			if(!found){
				System.out.println("String is not there in the file content");
			}else{
				System.out.println("String is there in the file content");
			}
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}

}
