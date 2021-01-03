package nongsan.webmvc.dao.impl;

import nongsan.webmvc.dao.BoardnewDao;
import nongsan.webmvc.jdbc.connectDB;
import nongsan.webmvc.model.Boardnew;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardnewDaoImpl extends connectDB implements BoardnewDao {
    @Override
    public void insert(Boardnew boardnew) {
        String sql = "INSERT INTO boardnew(title, content,image_link, author, created) VALUES (?, ?, ?, ?, ?)";
        new connectDB();
        Connection con = getConnect();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, boardnew.getTitle());
            ps.setString(2, boardnew.getContent());
            ps.setString(3, boardnew.getImage_link());
            ps.setString(4, boardnew.getAuthor());
            ps.setString(5, boardnew.getCreated());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM boardnew WHERE id=?";
        Connection con = getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void edit(Boardnew boardnew) {
        String sql = "UPDATE boardnew SET title=?,content=?,image_link=?,author=?,created=? WHERE id=?";
        Connection con = getConnect();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, boardnew.getTitle());
            ps.setString(2, boardnew.getContent());
            ps.setString(3, boardnew.getImage_link());
            ps.setString(4, boardnew.getAuthor());
            ps.setString(5, boardnew.getCreated());
            ps.setString(6, boardnew.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Boardnew get(int id) {
        Connection con = connectDB.getConnect();
        String sql = "SELECT * FROM boardnew WHERE id = ? ";
        /*Connection con = getConnect();*/

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Boardnew boardnew = new Boardnew();

                boardnew.setId(rs.getString("id"));
                boardnew.setTitle(rs.getString("title"));
                boardnew.setContent(rs.getString("content"));
                boardnew.setImage_link(rs.getString("image_link"));
                boardnew.setAuthor(rs.getString("author"));
                boardnew.setCreated(rs.getString("created"));
                //System.out.println("cc"+rs.getString("title"));
                return boardnew;

            }
            con.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boardnew get(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Boardnew> getAll() {
        Connection conn = connectDB.getConnect();
        List<Boardnew> boardnews = new ArrayList<Boardnew>();
        String sql = "SELECT * FROM boardnew";
        /*Connection conn = getConnect();*/

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Boardnew boardnew = new Boardnew();

                boardnew.setId(rs.getString("id"));
                boardnew.setTitle(rs.getString("title"));
                boardnew.setContent(rs.getString("content"));
                boardnew.setImage_link(rs.getString("image_link"));
                boardnew.setAuthor(rs.getString("author"));
                boardnew.setCreated(rs.getString("created"));
                boardnews.add(boardnew);
            }
            conn.close();
            ps.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return boardnews;
    }
}
