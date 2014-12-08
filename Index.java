import java.io.BufferedReader;

public class Index {
	String pathFolder = "20_newsgroups";
	String pathIndex = "20_newsgroups\\index.txt";
	Node root;
	int JmlhFileBerisiPencarianKata=0;
	
	public void isi(){
		System.out.println("Kelompok 4_SI3701");
		System.out.println("1.Anisa Ika Goldeningtyas");
		System.out.println("2.Ramdhani Priandatama");
		System.out.println("3.Chris Kevin Patayang");
		}


	boolean Indexing(){

		File check = new File(pathIndex);
		boolean ya=false;
		if(check.exists()){
			ya=true;
			}

		return ya;
		}

	private boolean isEmpty(){
		return(root==null);
		}

	public void indexFolderFile(File fd, FileWriter FWrite) throws IOException{

	if(fd.exists()){
		File[] ar = fd.listFiles();
		for(int i=0; i<ar.length; i++){
			File x = ar[i];
			if(x.isFile()){
				if(!x.getName().equals("index.txt")){
					FWrite.write(x.getPath());
					FWrite.write("\r\n");
					}
				}else{
					indexerFolderFile(x,FWrite);
					}
			}
		}
	}
	
	public void insert() throws FileNotFoundException, IOException{
		FileReader fread=new FileReader(pathIndex);
		BufferedReader br = new BufferedReader(fread);
		String baris = br.readLine();
		
		while(baris!=null){
			File filename = new File(baris);
			Data input = new Data();
			tmp.path = baris;
			input.data = new Integer(filename.getName());
			
			Node root;
			if(isEmpty()){
				root = input;
			}else{
				//cari parent yang sesuai 
				Node current = root;
				Node parent = null;
				boolean dikiri = true;
				while(current!=null){
					parent=current;
					//kalau data yang diinputkan lebih besar, bergerak ke kanan
					if(current.id<input.id){
						current = current.kanan;
						dikiri = false;
					//else, gerak ke kiri
					}else{
						current = current.kiri;
						dikiri = true;
					}
				}
				//hubungkan ke parent
					if(dikiri){
						parent.kiri = input;
						}else{
							parent.kanan = input;
							}
					} line=br.readLine();
		}

		fr.close();
		br.close();
		}
	public void traverseinorder(String MencariKata) throws IOException{
		inorder(root,wordToFind);
		}
	private void inorder(Data root, String MencariKata) throws IOException{
		if(root!=null){

			inorder(root.left,MencariKata);
			proses(root.path,MencariKata);
			inorder(root.right,MencariKata);
			}

	}
	
	private void prosesFile(String path,String MencariKata) throws FileNotFoundException, IOException{
		FileReader freader = new FileReader(path);
		BufferedReader br = new BufferedReader(freader);
		int lineNumber = 1;
		boolean found = false;
		String baris = br.readLine();
		
		while(baris!=null){
			int index = baris.indexOf(MencariKata);
			if(index > -1){
				if(found==false){
					System.out.println("Data ditemukan di : " + path);
					found = true;
					JmlhFileBerisiPencarianKata++;
					}
				System.out.println("\tLine-" + lineNumber + "-->" + baris);
				}
			baris=br.readLine();
			lineNumber++;
			}
		freader.close();
		br.close();
		}
}