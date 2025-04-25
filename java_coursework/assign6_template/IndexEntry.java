//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assignment Lab 10

package assign6_template;

public class IndexEntry implements Comparable<IndexEntry> {
    
    @Override
    public int compareTo(IndexEntry other) {
        return title.compareTo(other.title);
    }

    private String title;
    private int location; //index in the list movieDB

    public String getTitle() {
        return title;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public IndexEntry(String title, int location) {
        this.title = title;
        this.location = location;
    }

    @Override
    public String toString() {
        return "IndexEntry{" + "title=" + title + ", location=" + location + '}';
    }

    
}
