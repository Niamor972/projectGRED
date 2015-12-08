package fr.rg.logic;
	
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.ObjectInputStream;
	import java.util.ArrayList;

	public class Collecter {
		
		private ArrayList<FileProperty> listFileProperty;
		
		public Collecter(){
			listFileProperty = new ArrayList<>();
		}
		
		public void load () throws IOException, ClassNotFoundException{
			
				File f = new File("result.save");
				ObjectInputStream ois;
				if (f.exists())
				{
					ois = new ObjectInputStream( 
							new FileInputStream(
									new File ("result.save")));
					listFileProperty = (ArrayList<FileProperty>) ois.readObject();
				} 
				else 
					throw new IOException();
			} 
		
		public void startScan () throws IOException{
			try {	
				load();	
			}catch (IOException e){
				Scanner scan = new Scanner();
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Choose the type of your document :");
				String selectedType = bufferRead.readLine();
				System.out.println("Choose the rootPath : ");
				String rootPath= bufferRead.readLine();
				scan.listFile(selectedType, rootPath);
				listFileProperty = scan.getList();
			} catch (ClassNotFoundException e){
				e.printStackTrace();
			}
		}

		public String toString() {
			return "Collecter [listFileProperty=" + listFileProperty + "]";
		}
		
		
	}
}
