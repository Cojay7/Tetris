package fr.formation.tetris_dao.tetrimino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.tetrimino_model.ModelTetrimino;

@Repository
public class TetriminoDAO {
	@Autowired
	private DataSource dataSource;
	private Connection conn;

	public void findById(int id) {
		System.out.println("Recherche ...");
		try {
			dataSource.getConnection().createStatement().executeQuery("SELECT * from tetrimino WHERE id = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ModelTetrimino> getAll() {
		ArrayList<ModelTetrimino> liste = new ArrayList<ModelTetrimino>();
		try {
			ResultSet rs = dataSource.getConnection().createStatement().executeQuery("SELECT * from tetrimino");
			while (rs.next()) {
				ModelTetrimino mt = new ModelTetrimino();
				mt.setId(rs.getInt("id"));
				mt.setNom(rs.getString("name"));
				mt.setCouleur(rs.getString("color"));
				liste.add(mt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return liste;
	}

	public void insterTetrimino(int id, String nom, String couleur) throws SQLException {
		String str = "INSERT into tetrimino (id, name, color) values(?,?,?)";
		PreparedStatement ps = dataSource.getConnection().prepareStatement(str);
		ModelTetrimino mt = new ModelTetrimino();
		ps.setInt(1, id);
		ps.setString(2, nom);
		ps.setString(3, couleur);
		ps.executeUpdate();
	}

	public String toString() {
		return "Ceci est le toString de TetriminoDAO";
	}

}
