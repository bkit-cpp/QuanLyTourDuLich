package BUS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import DTO.CheDo;

public class CheDo_BUS {
	public boolean readClientList() {
		try {
			FileReader fr = new FileReader("./.settings/CheDo.txt");
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();
			if(line != null) {
				if (line.trim().equals("true")) {
					br.close();
					fr.close();
					return true;
				}else {
					br.close();
					fr.close();
					return false;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Da xay ra loi khi doc du lieu che do mau!");
		} 
		return true;
	}
	
	public void writeClientList(boolean x) {
		try {
			FileWriter fw = new FileWriter("./.settings/CheDo.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			if (x) {
				bw.write("true");
			} else {
				bw.write("false");
			}
			bw.newLine();
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("Luu du lieu che do mau that bai!");
		}
	}
}
