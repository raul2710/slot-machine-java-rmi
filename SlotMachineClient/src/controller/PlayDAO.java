///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package controller;
//
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import model.Play;
//
///**
// *
// * @author rault
// */
//public class PlayDAO {
//
///*
//    DAO - Data Access Object
//    
//    É um padrão de projeto em que são implementadas
//    todas as operações que serão realizadas na tabela
//    do banco.
//
//*/
//
//    
//    private Connection con;
//    private PreparedStatement cmd;
//    
//    public PlayDAO(){
//        //abrir uma nova conexão com o banco de dados
//        this.con = ConnectionDatabase.conectar();
//    }
////    
////    //OPERAÇÃO: inserir
////    public int inserir(Editora edt){
////        try {
////            String SQL = "insert into tb_editora (nome, cidade) values (?,?)";
////                    
////            cmd = con.prepareStatement(
////                SQL,
////                Statement.RETURN_GENERATED_KEYS
////            );
////            //definir o valor do parâmetro
////            cmd.setString(1,edt.getNome());
////            cmd.setString(1,edt.getCidade());
////            
////            //executar a operação
////            if (cmd.executeUpdate() > 0){
////                //operação realizada com sucesso!
////                ResultSet rs = cmd.getGeneratedKeys();
////                return rs.next() ? rs.getInt(1) : -1;
////            }else{
////                //não foi possível realizar a operação
////                return -1;
////            }
////            
////        } catch (Exception e) {
////            System.err.println("ERRO: " + e.getMessage());
////            return -1;
////        }finally{
////            ConnectionDatabase.desconectar(con);
////        }
////    }
////    
////    public int atualizar(Editora edt){
////        try {
////            String SQL = "update tb_editora set nome=?, cidade=? where id=?";
////            
////            cmd = con.prepareStatement(SQL);
////            cmd.setString(1, edt.getNome());
////            cmd.setString(2, edt.getCidade());
////            cmd.setInt(3, edt.getId());
////            
////            if (cmd.executeUpdate() > 0){
////                //Tudo certo com a atualização
////                return edt.getId();
////            }else{
////                //Ocorreu um erro ao atualizar;
////                return -1;
////            }
////        } catch (Exception e) {
////            System.err.println("ERRO: " + e.getMessage());
////            return -1;
////        }finally{
////            ConnectionDatabase.desconectar(con);
////        }
////    }
////    
////        
////    public Editora pesquisarPorId(int id){
////        try {
////            String SQL = "select * from tb_editora where id=?";
////            cmd = con.prepareStatement(SQL);
////            cmd.setInt(1, id);
////            
////            //executar a consulta
////            ResultSet rs = cmd.executeQuery();
////            if (rs.next()){
////                Editora e = new Editora();
////                e.setId(rs.getInt("id"));
////                e.setNome(rs.getString("nome"));
////                e.setCidade(rs.getString("cidade"));
////                return e;
////            }else{
////                return null;
////            }
////        } catch (Exception e) {
////            System.err.println("ERRO: " + e.getMessage());
////            return null;
////        }finally{
////            ConnectionDatabase.desconectar(con);
////        }
////    }
////    
////    public List<Editora> pesquisarPorNome(String nome){
////        try {
////            String SQL = "select * from tb_editora where nome ilike ?";
////            cmd = con.prepareStatement(SQL);
////            cmd.setString(1, "%" + nome + "%");
////            ResultSet rs = cmd.executeQuery();
////            List<Editora> lista = new ArrayList<>();
////            while(rs.next()){
////                Editora e = new Editora(
////                    rs.getInt("id"),
////                    rs.getString("nome"),
////                    rs.getString("cidade")
////                );
////                lista.add(e);
////            }
////            return lista;
////        } catch (Exception e) {
////            System.err.println("ERRO: " + e.getMessage());
////            return null;
////        }finally{
////            Conexao.desconectar(con);
////        }
////    }
////    
////    
////     
////    public List<Editora> listarPorId(){
////        try {
////            String SQL = "select * from tb_editora order by id";
////            cmd = con.prepareStatement(SQL);
////            ResultSet rs = cmd.executeQuery();
////            List<Editora> lista = new ArrayList<>();
////            while(rs.next()){
////                Editora e = new Editora(
////                    rs.getInt("id"),
////                    rs.getString("nome"),
////                    rs.getString("cidade")
////                );
////                lista.add(e);
////            }
////            return lista;
////        } catch (Exception e) {
////            System.err.println("ERRO: " + e.getMessage());
////            return null;
////        }finally{
////            ConnectionDatabase.desconectar(con);
////        }
////    }
////    
////     
////    public List<Editora> listarPorNome(){
////        try {
////            String SQL = "select * from tb_editora order by nome";
////            cmd = con.prepareStatement(SQL);
////            ResultSet rs = cmd.executeQuery();
////            List<Editora> lista = new ArrayList<>();
////            while(rs.next()){
////                Editora e = new Editora(
////                    rs.getInt("id"),
////                    rs.getString("nome"),
////                    rs.getString("cidade")
////                );
////                lista.add(e);
////            }
////            return lista;
////        } catch (Exception e) {
////            System.err.println("ERRO: " + e.getMessage());
////            return null;
////        }finally{
////            Conexao.desconectar(con);
////        }
////    };
//     
//    
//    
//    
//
//}
