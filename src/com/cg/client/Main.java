package  com.cg.client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    	
    	String route;
    	String input;
		System.out.println("Hi, welcome to the Client");
    	do
    	{
    		System.out.println("1.Index Page");
    		System.out.println("2.Welcome Page");
    		System.out.println("3.Download a Picture");
    		System.out.println("4.Quit");
    		Scanner sc = new Scanner(System.in);
    		input = sc.next();
    		if(input.equals("2"))
    		{
    			route = "welcome";
    			handleStaticResponse(route);
    			
    		}
    		else if(input.equals("3"))
    		{
    			route ="pic";
    			handleImageResponse(route);
    			
    		}
    		else if(input.equals("1"))
    		{
    			route = "";
    			handleStaticResponse(route);
    			
    		}
    		else if(input.equals("4"))
    		{
    			System.out.println("Exiting Client");
    		}
    		else
    		{
    			System.out.println("Please enter 1,2,3,4");
    		}
    	}while(!input.equals("4"));
    	
//        URL url = new URL("http://localhost:8080/");
//        try {
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
//			con.setRequestMethod("GET");
//			int responseCode = con.getResponseCode();
//			String responseMsg = con.getResponseMessage();
//			System.out.println(responseCode);
//			System.out.println(responseMsg);
//			//System.out.println("Hello");
//			
//			if(responseCode>=200 && responseCode<300)
//			{
//				System.out.println("Response was OK");
//				InputStreamReader stream = new InputStreamReader(con.getInputStream());
//				BufferedReader reader = new BufferedReader(stream);
//				StringBuilder response = new StringBuilder();
//				String line = "";
//				//line = reader.readLine();
//				while((line = reader.readLine())!=null)
//				{
//					response.append(line + "\r\n");
//					//line = reader.readLine();
//				}
//				System.out.println("--RESPONSE--");
//				System.out.println(response);
//				
//			    File targetFile = new File("C:/Users/kaprakas/Workspace_Projects/Xcorps/Output/response.txt");
//			    targetFile.createNewFile();
//
//			    Writer targetFileWriter = new FileWriter(targetFile);
//			    targetFileWriter.write(response.toString());
//			    targetFileWriter.close();
//			}
//			else
//			{
//				System.out.println("Response NOT OK");
//			}
//
//		}catch (IOException e) 
//        {
//			
//			e.printStackTrace();
//		}
        
        
        
        
        
        
    }
    
    public static void handleStaticResponse(String route) throws Exception
    {
      URL url = new URL("http://localhost:8080/"+route);
      try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			String responseMsg = con.getResponseMessage();
			System.out.println(responseCode);
			System.out.println(responseMsg);
			//System.out.println("Hello");
			
			if(responseCode>=200 && responseCode<300)
			{
				System.out.println("Response was OK");
				InputStreamReader stream = new InputStreamReader(con.getInputStream());
				BufferedReader reader = new BufferedReader(stream);
				StringBuilder response = new StringBuilder();
				String line = "";
				//line = reader.readLine();
				while((line = reader.readLine())!=null)
				{
					response.append(line + "\r\n");
					//line = reader.readLine();
				}
				System.out.println("--RESPONSE--");
				System.out.println(response);
				
			    File targetFile = new File("C:/Users/kaprakas/Workspace_Projects/Xcorps/Output/response.txt");
			    targetFile.createNewFile();

			    Writer targetFileWriter = new FileWriter(targetFile);
			    targetFileWriter.write(response.toString());
			    targetFileWriter.close();
			}
			else
			{
				System.out.println("Response NOT OK");
			}

		}catch (IOException e) 
      {
			
			e.printStackTrace();
		}
    	
    }
    
    public static void handleImageResponse(String route)
    {
    	try {
			InputStream stream = new URL("http://localhost:8080/"+route).openStream();
			Files.copy(stream, Paths.get("C:/Users/kaprakas/Workspace_Projects/Xcorps/Output/response.jpg"), StandardCopyOption.REPLACE_EXISTING);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}


