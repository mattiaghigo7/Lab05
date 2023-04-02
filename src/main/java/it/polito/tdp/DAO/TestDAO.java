package it.polito.tdp.DAO;

public class TestDAO {

	public static void main(String[] args) {
		AnagrammaDAO dao = new AnagrammaDAO();
		boolean result = dao.isCorrect("cane");
		System.out.println(result);
	}

}
