import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		int[]array = new int[]{1,1,35,6,2};
		NumberFileWriter test = new NumberFileWriter("./numberFileOut.txt");
		test.write(array);
	}

}
