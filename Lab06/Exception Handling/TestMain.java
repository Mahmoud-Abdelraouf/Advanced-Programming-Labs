package AssignmentLab06;

/*
 *@ Author: Ahmed Mohammed Bakr Ahmed 
 *  ID: 2000037
 *  
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        try {
            // Take file name and store it in fileName
            String fileName = args[0];
            // Check if file extension is correct 
            if (!fileName.endsWith(".arxml")) {
                throw new NotValidAutosarFileException("Invalid file extension!");
            }
            // Take input file
            File input = new File(fileName);
            // Check if the input file is empty or not 
            if (input.length()==0){
                throw new EmptyAutosarFileException("Empty File!");
            }
            // Take data from input file 
            FileInputStream inputStream = new FileInputStream(input);
            int d;
            StringBuilder s = new StringBuilder();
            while ((d = inputStream.read()) != -1) {
                s.append((char) d);
            }
            
            String data = s.toString();
            Scanner scanner = new Scanner(data);
            
            // ArrayList that contains containers attributes in xml
            ArrayList<Container> containers = new ArrayList<>();
            
            // Scan and loop on string
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // if next line contains CONTAINER tag
                if (line.contains("<CONTAINER")) {

                    // Get container attributes and set them to a container
                    String containerId = line.substring(line.indexOf("ID="), line.indexOf(">"));
                    String shortNameTag = scanner.nextLine();
                    String shortName = shortNameTag.substring(shortNameTag.indexOf(">") + 1, shortNameTag.indexOf("</"));
                    String longNameTag = scanner.nextLine();
                    String longName = longNameTag.substring(longNameTag.indexOf(">") + 1, longNameTag.indexOf("</"));
                    Container c = new Container();
                    c.setContainerID(containerId);
                    c.setShortName(shortName);
                    c.setLongName(longName);

                    // Add container to the list
                    containers.add(c);
                }
            }

            // Sort the list
            Collections.sort(containers);
            String outName = fileName.substring(0,fileName.indexOf("."))+"_mod.arxml";

            // Write the new data to the modified file
            FileOutputStream out = new FileOutputStream(outName);

            out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            out.write("<AutoSar>\n".getBytes());
            for (int i = 0; i < containers.size(); i++) {
                out.write(containers.get(i).toString().getBytes());
            }
            out.write("\n</AutoSar>".getBytes());

        }catch (NotValidAutosarFileException e) {
           System.out.println("The program can deal only with .arxml files.");
        }catch (FileNotFoundException e) {
            e = new FileNotFoundException("File Not Found!");
        }catch (IOException e) {
            e = new IOException("IO Exception");
        }
    }
}
