

/*
 Student's Name: Gustavo Costa
 Student's Number: M00272117
 Student's Program: Computer Science
 Date:07/03/11
 Title: Cd collection
 Description: Store details of a CD collection
 */

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import javax.swing.JFrame;//Creating a Frame
import java.awt.*;//Class Button and BorderLayout
import java.applet.Applet;//Add LayoutComponent
import javax.swing.JScrollPane;//Scroll
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;


class MainMenu {

	public static void main (String[] args) throws IOException {

    	//Declaring and Initializing Variables
		int mainMenu       = -1;
		int searchMenu     = -1;
		int addMenu        = -1;
		int editMenu       = -1;
		int displayMenu    = -1;
		int saveMenu       = -1;
		int openMenu       = -1;
		int quitMenu       = -1;
		int quitOptionMenu = -1;
		int overwriteMenu  = -1;
		int delRowMenu     = -1;

		int next = 0;//Variable to track object

		//Searching Variables
		String searchStr = null;
		int searchInt    = -1;

		String fileName = "CD Collection";//Saving File

		JTextArea output = new JTextArea ("Artist\t\t" + "Title\t\t" + "Tracks\t" +"\n\n");

		boolean test = false;//Check if file exists

		int counter = 0;//To Read file

		//Object
		CD obj[] = new CD [1000];

    	//Images
    	Icon mainMenuPicture = new ImageIcon ("Pictures/CD.png");       	   //Main 0
		Icon searchPicture = new ImageIcon ("Pictures/CD_Search.png");  	   //Search 1
		Icon addPicture = new ImageIcon ("Pictures/CD_Add.png");         	   //Add 2
		Icon editPicture = new ImageIcon ("Pictures/CD_Edit.png");      	   //Edit 3
		Icon displayPicture = new ImageIcon ("Pictures/CD_Display.png"); 	   //Display 4
		Icon savePicture = new ImageIcon ("Pictures/CD_Save.png");     		   //Save 5
		Icon openPicture = new ImageIcon ("Pictures/CD_Open.png");     		   //Read 6
		Icon quitPicture = new ImageIcon ("Pictures/CD_Quit.png");     		   //Quit 7
		Icon quitOptionPicture = new ImageIcon ("Pictures/CD_QuitOption.png"); //Quit Option 8


    	//Menu Options
    	//Main 0
    	Object arrayMain[] = {
    		"Full Screen",
    		"1. Search",
    		"2. Add",
    		"3. Edit",
    		"4. Display in order",
    		"5. Save",
    		"6. Open",
    		"7. Quit"
    	};

    	//Search 1
    	Object arraySearch[] = {
    		"Main Menu",
    		"by Artist Name",
    		"by Album Title",
    		"by Track No."
    	};

    	//Add 2
    	Object arrayAdd[] = {
    		"Main Menu",
    		"Add a CD"
    	};

    	//Edit 3
    	Object arrayEdit[] = {
    		"Main Menu",
    		"Artist Name",
    		"Album Title",
    		"Track Number"
    	};

    	//Display 4
    	Object arrayDisplay[] = {
    		"Main Menu",
    		"by Artist Name",
    		"by Album Title",
    		"by Track Number"
    	};

    	//Save 5
    	Object arraySave[] = {
    		"Main Menu",
    		"Save File"
    	};

    	//Open 6
    	Object arrayOpen[] = {
    		"Main Menu",
    		"Open File"
    	};

    	//Quit 7
    	Object arrayQuit[] = {
    		"Yes",
    		"No"
    	};

    	//QuitOption 8 (Save option before quit)
    	Object arrayQuitOption[] = {
    		"Yes",
    		"No"
    	};

    	//Exist 9
    	Object arrayOverwrite[] = {
    		"Yes",
    		"No"
    	};

		//Opening Window
		JFrame frame = new JFrame("CD COLLECTION");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create components and put them in the frame
		frame.setLocation(550, 200);


		//Windows only closes when the programs closes
		frame.getContentPane().add(new Button("Student Name: Gustavo Costa,     Student Number: M00272117,     Programme: Computer Science"));
		//Size the frame
		frame.pack();
		//Show it
		frame.setVisible(true);
		JOptionPane.showMessageDialog (frame, "            Welcome to CD Collection         " + "\n"+
											  " Press the 'OK' button to start using the program");


		//Loops the whole Menu
		while (mainMenu!=7) {

				//Show objects next to the picture on the main menu
				String rowLine = "";
				for (int i=0; i<next; i++) {
					rowLine += obj[i].printCD();
				}

				output = new JTextArea ("Artist\t\t" + "Title\t\t" + "Tracks\t" +"\n\n"+ rowLine, 10, 40);
				output.setFont(new Font("Serif", Font.ITALIC, 16));
				output.setForeground(new Color(0x306EFF));
				output.setOpaque(false);
				output.setVisible(true);
				int len1 = rowLine.length();
				output.setPreferredSize(new Dimension(450, (len1*2)));

				//Frame To be Displayed on Main Menu
				JPanel panel = new JPanel();
				output.add(panel);
				JScrollPane optScroll = new JScrollPane (output);
				optScroll.getHorizontalScrollBar();
				optScroll.getVerticalScrollBar();
				JFrame frameScroll = new JFrame();

				//Menu dependent on integers
	    		mainMenu = JOptionPane.showOptionDialog (null, frameScroll.getContentPane().add(optScroll),
	    		 "Main Menu: Select an Option",
	    		 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, mainMenuPicture, arrayMain, arrayMain[0]);

	    		//Default Button, Show all Cd colletion on Full Screen
	    		if (mainMenu==0) {

	    			String row = "";
	    			for (int i=0; i<next; i++) {
	    				row += obj[i].printCDFull();
	    			}


	    			JTextArea opt = new JTextArea ("Artist\t\t\t Title\t\t\t Tracks\n\n" + row, 15, 55);
	    			opt.setFont(new Font("Serif", Font.ITALIC, 36));
	    			opt.setOpaque(false);
	    			opt.setVisible(true);
	    			int len2 = rowLine.length();
	    			opt.setPreferredSize(new Dimension(800, (4*len2)));

	    			//Frame To be Displayed on Main Menu
					JPanel panel2 = new JPanel();
					opt.add(panel2);
					JScrollPane optScroll2 = new JScrollPane (opt);
					optScroll2.getHorizontalScrollBar();
					optScroll2.getVerticalScrollBar();
					JFrame frameScroll2 = new JFrame();

	    			JOptionPane.showMessageDialog (null, frameScroll2.getContentPane().add(optScroll2));
	    		}

	    		//Options 1 Search for items
	    		if (mainMenu==1) {

					//Loop search Menu
					while (searchMenu!=0) {

		    			searchMenu = JOptionPane.showOptionDialog (null,null,
		    				"Search Menu: Select an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, searchPicture, arraySearch, arraySearch[0]);

		    				//Searching variables
		    				searchStr = null;
		    				searchInt    = -1;

							//Search by Artist Name
		    				if (searchMenu==1) {
	    						searchStr = JOptionPane.showInputDialog ("Artist Name: ");
	    						searchInt = CD.searchItem (obj, searchStr, searchInt, obj.length);
	    						if (searchInt >= 0) {
	    							output = new JTextArea ("Artist\t\t" + "Title\t\t" + "Tracks\t" +"\n\n"+ obj[searchInt].printCD());
									output.setFont(new Font("Serif", Font.ITALIC, 18));
									output.setForeground(new Color(0x348017));
									output.setOpaque(false);
									output.setPreferredSize(new Dimension(500, 100));
    								JOptionPane.showMessageDialog (null, output);
	    						}else{
	    							if (searchInt != -1) {
	    								JOptionPane.showMessageDialog (null, "The item does not exist!");
	    							}
	    						}
		    				}

							//Search by Album Title
		    				if (searchMenu==2) {
	    						searchStr = JOptionPane.showInputDialog ("Title Name: ");
	    						searchInt = CD.searchItem (obj, searchStr, searchInt, obj.length);
	    						if (searchInt >= 0) {
	    							output = new JTextArea ("Artist\t\t" + "Title\t\t" + "Tracks\t" +"\n\n"+ obj[searchInt].printCD());
									output.setFont(new Font("Serif", Font.ITALIC, 18));
									output.setForeground(new Color(0x348017));
									output.setOpaque(false);
									output.setPreferredSize(new Dimension(500, 100));
    								JOptionPane.showMessageDialog (null, output);
	    						}else{
	    							if (searchInt != -1) {
	    								JOptionPane.showMessageDialog (null, "The item does not exist!");
	    							}
	    						}
		    				}

							//Search by Track Number
		    				if (searchMenu==3) {
		    					searchInt = Integer.parseInt (JOptionPane.showInputDialog ("Track Number: "));
	    						searchInt = CD.searchItem (obj, searchStr, searchInt, obj.length);
	    						if (searchInt >= 0) {
	    							output = new JTextArea ("Artist\t\t" + "Title\t\t" + "Tracks\t" +"\n\n"+ obj[searchInt].printCD());
									output.setFont(new Font("Serif", Font.ITALIC, 18));
									output.setForeground(new Color(0x348017));
									output.setOpaque(false);
									output.setPreferredSize(new Dimension(500, 100));
    								JOptionPane.showMessageDialog (null, output);
	    						}else{
	    							if (searchInt != -1) {
	    								JOptionPane.showMessageDialog (null, "The item does not exist!");
	    							}
	    						}
		    				}

		    				//Back to Main Menu
		    				searchMenu = 0;
					}

					//Refresh Variable
					searchMenu = -1;
	    		}

	    		//Opton 2 Add a new CD
	    		if (mainMenu==2) {

	    			while (addMenu!=0) {

		    			addMenu = JOptionPane.showOptionDialog (null,null,
		    				"Add Menu: Select an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, addPicture, arrayAdd, arrayAdd[0]);

							//Add a CD
		    				if (addMenu==1) {
						    	obj[next] = new CD();
						    	next++;
		    				}

		    				//Back to Main Menu
		    				addMenu = 0;
					}

					//Refresh Variable
					addMenu=-1;
	    		}

	    		//Option 3 Edit a CD
	    		if (mainMenu==3) {
	    			while (editMenu!=0) {

		    			editMenu = JOptionPane.showOptionDialog (null,null,
		    				"Edit Menu: Select an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, editPicture, arrayEdit, arrayEdit[0]);

							//Searching variables
		    				searchStr = null;
		    				searchInt    = -1;

							//Edit Artist Name
		    				if (editMenu==1) {
		    					searchStr = JOptionPane.showInputDialog ("Artist Name: ");
		    					searchInt = CD.searchItem (obj, searchStr, searchInt, obj.length);
		    					obj[searchInt].getArtist(JOptionPane.showInputDialog ("New Artist Name: "));
		    				}

		    				//Edit Album Title
		    				if (editMenu==2) {
		    					searchStr = JOptionPane.showInputDialog ("Album Name: ");
		    					searchInt = CD.searchItem (obj, searchStr, searchInt, obj.length);
		    					obj[searchInt].getTitle(JOptionPane.showInputDialog (" New Album Name: "));
		    				}

		    				//Edit Track No.
		    				if (editMenu==3) {
		    					searchInt = Integer.parseInt (JOptionPane.showInputDialog ("Track Number: "));
		    					searchInt = CD.searchItem (obj, searchStr, searchInt, obj.length);
		    					obj[searchInt].getTrack (Integer.parseInt (JOptionPane.showInputDialog ("New Track Number: ")));
		    				}

		    				//Back to Main Menu
		    				editMenu = 0;
					}

					//Refresh Variable
					editMenu = -1;
	    		}

	    		//Option 4 Display a CD
	    		if (mainMenu==4) {
	    			while (displayMenu!=0) {

		    			displayMenu = JOptionPane.showOptionDialog (null,null,
		    				"Display Menu: Select an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, displayPicture, arrayDisplay, arrayDisplay[0]);

							//Order by Artist Name
		    				if (displayMenu==1) {
		    					CD.swapArtist(obj, next);
		    				}

		    				//Order by Album Title
		    				if (displayMenu==2) {
								CD.swapTitle(obj, next);
		    				}

		    				//Order by Track Number
		    				if (displayMenu==3) {
								CD.swapTrack(obj, next);
		    				}

		    				//Back to main Menu
		    				displayMenu=0;
					}

					//Refresh Variable
					displayMenu = -1;
	    		}

	    		//Option 5 Save a CD into a File
	    		if (mainMenu==5) {
	    			while (saveMenu!=0) {

		    			saveMenu = JOptionPane.showOptionDialog (null,null,
		    				"Save Menu: Select an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, savePicture, arraySave, arraySave[0]);

		    				if (saveMenu==1) {
		    					//Naming File
		    					fileName = new String (JOptionPane.showInputDialog ("File name: "));

			    				//Check if file exists. Exist: Return True. Not Exist: Return False.
					    		test = obj[0].existFile(fileName);

					    		//If file exists user may overwrite or not file
					    		if (test) {
					    			overwriteMenu  = JOptionPane.showOptionDialog (null, "File already exists.\n Do you want to overwrite the existing file?",
					    			"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, arrayOverwrite, arrayOverwrite[1]);

					    			//Yes. Overwrite
					    			if (overwriteMenu==0) {
						    			try {
						    				File f = new File ("Saved File/" +fileName+ ".txt");
						    				f.delete();
						    			}catch (Exception e) { //In case file is open or another errors
						    				JOptionPane.showMessageDialog (null, "Error deleting file.\n If the file is open, please close it.");
						    				return;
						    			}
						    			//Save over same fileName
						    			for (int i=0; i<next; i++) {
					    					obj[i].saveCD(fileName);
					    				}
					    			}

					    			//No. Don't Overwrite
					    			if (overwriteMenu==1) {
					    				//Renaming File
			    						fileName = new String (JOptionPane.showInputDialog ("File name: "));

			    						//Check if file exists. Exist: Return True. Not Exist: Return False.
					    				test = obj[0].existFile(fileName);

						    			//If exists save file as a copy file
						    			if (test) {
							    			//Saving Copy File
							    			fileName = new String (fileName + " (copy)");

							    			//Check if file exists. Exist: Return True. Not Exist: Return False.
					    					test = obj[0].existFile(fileName);

					    					//Variable to add and check existence of different number of copies
							    			int check = 1;
							    			//String to reset the number of copies: Variable Check
							    			String fileNameCopy = null;

					    					while (test) {
					    						fileNameCopy = new String (fileName +" "+ check);

					    						//Check if file exists. Exist: Return True. Not Exist: Return False.
					    						test = obj[0].existFile(fileNameCopy);

					    						if (test) {
					    							test = true;
					    							fileNameCopy = new String (fileName);
					    						}else{
					    							test = false;
					    						}
					    						check++;

					    					}
					    					//In case the fileNameCopy never entered on the while test loop
					    					if (fileNameCopy != null)
					    						fileName = fileNameCopy;
							    			//Save Copy
											for (int i=0; i<next; i++) {
						    				obj[i].saveCD(fileName);
						    				}
						    			}else{
						    				//Save file if doesn't exist
											for (int i=0; i<next; i++) {
							    				obj[i].saveCD(fileName);
							    			}
						    			}
					    			}
								}else{ //Save if there isn't a file with the same name
							    	for (int i=0; i<next; i++) {
								    	obj[i].saveCD(fileName);
								    }
		    					}
		    				}
		    				//Refresh Variable
					    	overwriteMenu=-1;
					    	//Back to Main Menu
		    				saveMenu = 0;
					}
					//Refresh Variable
					saveMenu = -1;
	    		}

	    		//Option 6 Read CDs from a File
	    		if (mainMenu==6) {
	    			while (openMenu!=0) {

		    			openMenu = JOptionPane.showOptionDialog (null,null,
		    				"Open Menu: Select an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, openPicture, arrayOpen, arrayOpen[0]);

		    				if (openMenu==1) {
		    					//Name of the file to be opened
		    					fileName = new String (JOptionPane.showInputDialog ("File name: "));
		    					fileName = new String ("Saved File/" +fileName+ ".txt");

								try{
									final BufferedReader readBuffer = new BufferedReader (new FileReader (fileName));
			    					//First line
									String line = readBuffer.readLine();

			    					//Reading File
			    					counter = 0;

			    					while (line!=null) {
			    						String x = (line);
			    						String y = (readBuffer.readLine());
			    						int    z = (Integer.parseInt (readBuffer.readLine()));

			    						obj[counter] = new CD (x, y, z);

			    						line = readBuffer.readLine();
			    						counter++;

			    						//Defines the size of the array to the printing method
			    						next = counter;
			    					}

			    					//Close Buffer
									readBuffer.close();

		    					}catch (IOException e) {
		    						System.out.print ("An error has ocurred while trying to read the file.");
		    					}
							}

							//Back to Main Menu
		    				openMenu = 0;
					}
					//Refresh Variable
					openMenu = -1;
	    		}

	    		//Option 7 Quit Program
	    		if (mainMenu==7) {
		    			quitMenu = JOptionPane.showOptionDialog (null, null,
		    				"Quit Menu: Select an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, quitPicture, arrayQuit, arrayQuit[0]);

							//"Yes". Wants to exit the program. Asks if wants to save file?
							if (quitMenu==0) {
								quitOptionMenu = JOptionPane.showOptionDialog (null, null,
		    					"Quit Option Menu: Select an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
		    					quitOptionPicture, arrayQuitOption, arrayQuitOption[0]);

									//Yes. Save file first, then exit.
		    						if (quitOptionMenu==0) {

					    				//Naming File
					    				fileName = new String (JOptionPane.showInputDialog ("File name: "));

					    				//Check if file exists. Exist: Return True. Not Exist: Return False.
							    		test = obj[0].existFile(fileName);

							    		//If file exists user may overwrite or not the file
							    		if (test) {
							    			overwriteMenu  = JOptionPane.showOptionDialog (null, "File already exists.\n Do you want to overwrite the existing file?",
							    			"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, arrayOverwrite, arrayOverwrite[1]);

							    			//Yes. Overwrite
							    			if (overwriteMenu==0) {
								    			try {
								    				File f = new File ("Saved File/" +fileName+ ".txt");
								    				f.delete();
								    			}catch (Exception e) { //In case file is open or another errors
								    				JOptionPane.showMessageDialog (null, "Error deleting file.\n If the file is open, please close it.");
								    				return;
								    			}
								    			//Save
								    			for (int i=0; i<next; i++) {
							    					obj[i].saveCD(fileName);
							    				}
							    			}


							    			//No. Don't Overwrite
							    			if (overwriteMenu==1) {
							    				//Renaming File
					    						fileName = new String (JOptionPane.showInputDialog ("File name: "));

					    						//Check if file exists. Exist: Return True. Not Exist: Return False.
							    				test = obj[0].existFile(fileName);

								    			//If exists save file as a copy file
								    			if (test) {
									    			//Saving Copy File
									    			fileName = new String (fileName + " (copy)");

									    			//Check if file exists. Exist: Return True. Not Exist: Return False.
							    					test = obj[0].existFile(fileName);

							    					//Variable to add and check existence of different number of copies: Variable CheckExit
									    			int checkExit = 1;
									    			String fileNameCopy = null;

							    					while (test) {
							    						fileNameCopy = new String (fileName +" "+ checkExit);

							    						//Check if file exists. Exist: Return True. Not Exist: Return False.
							    						test = obj[0].existFile(fileNameCopy);

							    						checkExit++;
							    					}

							    					//In case the fileNameCopy never entered on the while test loop
							    					if (fileNameCopy != null)
							    						fileName = fileNameCopy;
									    			//Save Copy
													for (int i=0; i<next; i++) {
								    				obj[i].saveCD(fileName);
								    				}
								    			}else{
								    				//Save file if doesn't exist
													for (int i=0; i<next; i++) {
									    				obj[i].saveCD(fileName);
									    			}
								    			}
							    			}
										}else{
											//Save if file does not exist
							    			for (int i=0; i<next; i++) {
						    					obj[i].saveCD(fileName);
						    				}
										}
										//Exit Program
										mainMenu = 7;
									}

		    						//No. Don't save and exit program.
		    						if (quitOptionMenu==1) {
		    							mainMenu = 7;
		    						}
							}

	    					//"No". Doesn't want to exit the program
		    				if (quitMenu==1) {
		    					mainMenu = -1;
		    				}
	    		}//Close quit menu

		}//While Loop Menu

		//Closing OptionDialog
	    System.exit(0);

	}//Main
}//Class

