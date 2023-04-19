package AssignmentLab06;

public class Container implements Comparable<Container> {
    String containerID;
    String shortName;
    String longName;
    // Override toString method
    @Override
    public String toString() {
        return "<CONTAINER "+ containerID + ">\n" +
                "           <SHORT-NAME>"+shortName+"</SHORT-NAME>"+
                "\n" + "           <LONG-NAME>"+longName+"</LONG-NAME>"
                +"\n" + "       </CONTAINER>\n";
    }
    
    // There is no constructor in this class, so JVM will create an empty one 

    // Getters and setters
    public String getContainerID() {
        return containerID;
    }

    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    // Override compareTo method in order to use sort method for arrays of containers
    @Override
    public int compareTo(Container o) {
        if (this.getShortName().equals(o.getShortName())){
            return 0;
        }else if(this.getShortName().charAt(9)>o.getShortName().charAt(9)){
            return 1;
        }else {
            return -1;
        }
    }
}
