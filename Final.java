
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Final {
public static void main(String[] args) throws IOException {

	
	String pathFolder = "20_newsgroups";
	String pathIndex="20_newsgroups\\index.txt";
	File fd = new File(pathFolder);
	Scanner x = new Scanner(System.in);
	Index file = new Index();

	file.isi();
	
	if(!file.Indexing()){
		FileWriter fwrite = new FileWriter(pathIndex,true);
		file.indexFolderFile(fd, fwrite);
		fwrite.close();
		}
	
	fi.insertDataToTree();
	while(exit==0){
		System.out.print("Cari kata pada file : ");
		String wordToFind=s.nextLine();
		if(wordToFind.equals("1")){
			exit=1;
		}else{
			file.inOrder(wordToFind);
			}
		}
	}
}