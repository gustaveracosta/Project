


import java.io.*;
import javax.swing.JOptionPane;


class CD {

	//Private Variables
	private String artist;
	private String title;
	private int track;

	//Get user input to add CDs to the array
	public CD() {
		artist = JOptionPane.showInputDialog ("Artist Name: ");
		title = JOptionPane.showInputDialog ("Title Name: ");
    	track = Integer.parseInt (JOptionPane.showInputDialog ("Track Number: "));
	}

	//Initialize object to Read File
	public CD (String a, String b, int c) throws IOException {
		artist = a;
		title  = b;
		track  = c;
	}

	//Make a row to be printed out
	public String printCD(){

		//Fixing Tab size
		int len = artist.length();
		int len2 = title.length();
		String row;

		if (len > 26 || len2 > 26)
			JOptionPane.showMessageDialog (null, "The name is too long.\n Edit the name to properly fit on screen (Not over 26 characters).");
			

		if (len > 13) {
			if (len2 > 13)
				row = (artist +"\t"+ title +"\t"+ track +"\n");
			else
				row = (artist +"\t"+ title +"\t\t"+ track +"\n");
		}else{
			if (len2 > 13)
				row = (artist +"\t\t"+ title +"\t"+ track +"\n");
			else
				row = (artist +"\t\t"+ title +"\t\t"+ track +"\n");
		}
		return row;
	}

	//Make a row to be printed out on Full Screen
	public String printCDFull(){

		//Fixing Tab size
		int len = artist.length();
		int len2 = title.length();
		String row;

		if (len > 12) {
			if (len2 > 12)
				row = (artist +"\t\t"+ title +"\t\t"+ track +"\n");
			else
				row = (artist +"\t\t"+ title +"\t\t\t"+ track +"\n");
		}else{
			if (len2 > 12)
				row = (artist +"\t\t\t"+ title +"\t\t"+ track +"\n");
			else
				row = (artist +"\t\t\t"+ title +"\t\t\t"+ track +"\n");
		}
		return row;
	}

	//Save contents of the array object into a File
	public void saveCD(String naming) throws IOException {

		PrintWriter write = new PrintWriter (new BufferedWriter (new FileWriter ("Saved File/" + naming + ".txt", true)));

		//Saving one CD at a time
		write.println(artist);
		write.println(title);
		write.println(track);

		//Flush out
		write.close ();
	}

	//Check if File Exists
	public boolean existFile (String name_File) {

	    File f = new File ("Saved File/" +name_File+ ".txt");

	    if(f.exists()) {
	    	return true;
	    }
	    else{
	    	return false;
	    }
	}

	//Return artist
	public String getArtist (String read) throws IOException {
		artist = read;
		return artist;
	}

	//Return artist
	public String getArtist () throws IOException {
		return artist;
	}

	//Return title
	public String getTitle (String read) throws IOException {
		title = read;
		return title;
	}

	//Return track
	public int getTrack (int read) throws IOException {
		track = read;
		return track;
	}

	//Search for an item in the object array
	public static int searchItem (CD[] array, String keyStr, int keyInt, int size) {

		try {
			for (int i=0; i<size; i++) {
				if (array[i].artist.equalsIgnoreCase(keyStr)) {
					return i;
				}else if (array[i].title.equalsIgnoreCase(keyStr)) {
					return i;
				}else if (array[i].track==keyInt) {
					return i;
				}
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog (null, "The item does not exist!");
			return -1;
		}
		return -2;
    }

    public static void swapArtist (CD[] array, int size) {

    	for (int i=0; i<(size-1); i++) {
    		for (int j=0; j<(size-1); j++) {
    			if (array[j].artist.compareToIgnoreCase(array[j+1].artist) > 0) {
    				//Artist
    				String temp = array[j].artist;
			    	array[j].artist = array[j+1].artist;
			    	array[j+1].artist = temp;

			    	//Title
			    	temp = array[j].title;
			    	array[j].title = array[j+1].title;
			    	array[j+1].title = temp;

			    	//Track
			    	int temT = array[j].track;
			    	array[j].track = array[j+1].track;
			    	array[j+1].track = temT;
    			}
    		}
    	}
    }

    public static void swapTitle (CD[] array, int size) {

    	for (int i=0; i<(size-1); i++) {
    		for (int j=0; j<(size-1); j++) {
    			if (array[j].title.compareToIgnoreCase(array[j+1].title) > 0) {
    				//Artist
    				String temp = array[j].artist;
			    	array[j].artist = array[j+1].artist;
			    	array[j+1].artist = temp;

			    	//Title
			    	temp = array[j].title;
			    	array[j].title = array[j+1].title;
			    	array[j+1].title = temp;

			    	//Track
			    	int temT = array[j].track;
			    	array[j].track = array[j+1].track;
			    	array[j+1].track = temT;
    			}
    		}
    	}
    }


    public static void swapTrack (CD[] array, int size) {

		int swap = -1;
		int i = 0;
		int j = 0;

    	for (i=0; i<(size-1); i++) {
    		if (swap == 0) {
    			j=size;
    			i=size;
    		}

    		swap = 0;

    		for (j=0; j<(size-1); j++) {
    			if (array[j].track > array[j+1].track) {
    				//Artist
    				String temp = array[j].artist;
			    	array[j].artist = array[j+1].artist;
			    	array[j+1].artist = temp;

			    	//Title
			    	temp = array[j].title;
			    	array[j].title = array[j+1].title;
			    	array[j+1].title = temp;

			    	//Track
			    	int temT = array[j].track;
			    	array[j].track = array[j+1].track;
			    	array[j+1].track = temT;
			    	swap++;

    			}
    		}
    	}
    }
}//Class