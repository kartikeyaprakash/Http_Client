package  com.cg.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
    	
        URL url = new URL("http://localhost:8080");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        String responseMsg = con.getResponseMessage();
        System.out.println(responseCode);
        System.out.println(responseMsg);
        System.out.println("Hello");
        if((responseCode == HttpURLConnection.HTTP_OK))
        {
        	System.out.println("Response was OK");
        	InputStreamReader stream = new InputStreamReader(con.getInputStream());
        	BufferedReader reader = new BufferedReader(stream);
        	StringBuilder response = new StringBuilder();
        	String line;
        	line = reader.readLine();
        	while(line.trim().length()>0)
        	{
        		response.append(line + "\r\n");
				line = reader.readLine();
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
    }

}
