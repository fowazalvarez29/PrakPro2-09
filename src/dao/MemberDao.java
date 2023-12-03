/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao; // Mendefinisikan package 'dao' untuk kelas-kelas terkait dengan objek akses data (Data Access Objects).

import db.MySqlConnection; // Mengimpor kelas MySqlConnection dari paket db untuk koneksi dengan basis data.
import java.sql.Connection; // Mengimpor kelas Connection dari paket java.sql untuk koneksi dengan basis data.
import java.sql.PreparedStatement; // Mengimpor kelas PreparedStatement dari paket java.sql untuk membuat statement SQL yang telah di-prepared.
import java.sql.SQLException; // Mengimpor kelas SQLException dari paket java.sql untuk menangani pengecualian SQL.
import java.sql.Statement; // Mengimpor kelas Statement dari paket java.sql untuk membuat statement SQL.
import java.sql.ResultSet; // Mengimpor kelas ResultSet dari paket java.sql untuk merepresentasikan hasil dari sebuah query SQL.
import java.util.List; // Mengimpor kelas List dari paket java.util untuk mengelola koleksi objek.
import java.util.ArrayList; // Mengimpor kelas ArrayList dari paket java.util sebagai implementasi dari antarmuka List.
import member.Member; // Mengimpor kelas Member dari paket member untuk merepresentasikan data anggota.
import jenis_member.JenisMember; // Mengimpor kelas JenisMember dari paket jenis_member untuk merepresentasikan jenis-jenis member.

/**
 *
 * @author alvarez // Komentar yang menyatakan penulis kelas ini.
 */
public class MemberDao { // Mendefinisikan kelas MemberDao.

    public int insert(Member member) { // Metode untuk menambahkan data anggota ke dalam basis data.
        int result = -1; // Inisialisasi variabel result sebagai indikator keberhasilan operasi.
        try (Connection connection = MySqlConnection.getInstance().getConnection();) { // Membuat koneksi ke basis data menggunakan kelas MySqlConnection.
            PreparedStatement statement = connection.prepareStatement("insert into member (id, nama, jenis_member_id) values (?, ?, ?)"); // Menyiapkan pernyataan SQL untuk memasukkan data ke dalam tabel member.
            statement.setString(1, member.getId()); // Mengatur parameter pertama (id) pada pernyataan SQL.
            statement.setString(2, member.getNama()); // Mengatur parameter kedua (nama) pada pernyataan SQL.
            statement.setString(3, member.getJenisMember().getId()); // Mengatur parameter ketiga (jenis_member_id) pada pernyataan SQL.
            
            result = statement.executeUpdate(); // Menjalankan pernyataan SQL dan mendapatkan jumlah baris yang terpengaruh.
        } catch (SQLException e) { // Menangkap dan menangani pengecualian jika terjadi kesalahan dalam operasi SQL.
            e.printStackTrace(); // Mencetak jejak eksepsi jika terjadi kesalahan.
        }
        return result; // Mengembalikan hasil dari operasi penambahan data.
    }
    
    public int update(Member member) { // Metode untuk memperbarui data anggota yang ada di dalam basis data.
        int result = -1; // Inisialisasi variabel result sebagai indikator keberhasilan operasi.
        try (Connection connection = MySqlConnection.getInstance().getConnection();) { // Membuat koneksi ke basis data menggunakan kelas MySqlConnection.
            PreparedStatement statement = connection.prepareStatement("update member set nama = ?, jenis_member_id = ? where id = ?"); // Menyiapkan pernyataan SQL untuk memperbarui data dalam tabel member.
            statement.setString(1, member.getNama()); // Mengatur parameter pertama (nama) pada pernyataan SQL.
            statement.setString(2, member.getJenisMember().getId()); // Mengatur parameter kedua (jenis_member_id) pada pernyataan SQL.
            statement.setString(3, member.getId()); // Mengatur parameter ketiga (id) pada pernyataan SQL.
            
            result = statement.executeUpdate(); // Menjalankan pernyataan SQL dan mendapatkan jumlah baris yang terpengaruh.
        } catch (SQLException e) { // Menangkap dan menangani pengecualian jika terjadi kesalahan dalam operasi SQL.
            e.printStackTrace(); // Mencetak jejak eksepsi jika terjadi kesalahan.
        }
        return result; // Mengembalikan hasil dari operasi pembaruan data.
    }
    
    public int delete(Member member) { // Metode untuk menghapus data anggota dari basis data.
        int result = -1; // Inisialisasi variabel result sebagai indikator keberhasilan operasi.
        try (Connection connection = MySqlConnection.getInstance().getConnection();) { // Membuat koneksi ke basis data menggunakan kelas MySqlConnection.
            PreparedStatement statement = connection.prepareStatement("delete from member where id = ?"); // Menyiapkan pernyataan SQL untuk menghapus data dari tabel member.
            statement.setString(1, member.getId()); // Mengatur parameter (id) pada pernyataan SQL.
            
            result = statement.executeUpdate(); // Menjalankan pernyataan SQL dan mendapatkan jumlah baris yang terpengaruh.
        } catch (SQLException e) { // Menangkap dan menangani pengecualian jika terjadi kesalahan dalam operasi SQL.
            e.printStackTrace(); // Mencetak jejak eksepsi jika terjadi kesalahan.
        }
        return result; // Mengembalikan hasil dari operasi penghapusan data.
    }
    
    public List<Member> findAll() { // Metode untuk mendapatkan semua data anggota dari basis data.
        List<Member> list = new ArrayList<>(); // Mendeklarasikan list untuk menyimpan data anggota.
        try (Connection connection = MySqlConnection.getInstance().getConnection(); // Membuat koneksi ke basis data menggunakan kelas MySqlConnection.
                Statement statement = connection.createStatement();) { // Membuat objek Statement untuk mengeksekusi pernyataan SQL.
            try (ResultSet resultSet = statement.executeQuery("select member.id, member.nama, jenis_member.id jenis_member_id, jenis_member.nama " + " jenis_member_nama from member join jenis_member on jenis_member.id = member.jenis_member_id ");) { // Mengeksekusi pernyataan SQL untuk mendapatkan data dari tabel member dan jenis_member dengan JOIN.
                while(resultSet.next()) { // Iterasi melalui setiap baris hasil query.
                    Member member = new Member(); // Membuat objek Member untuk setiap baris data anggota.
                    member.setId(resultSet.getString("id")); // Mendapatkan data id dari hasil query dan disimpan dalam objek member.
                    member.setNama(resultSet.getString("Nama")); // Mendapatkan data nama dari hasil query dan disimpan dalam objek member.
                    
                    JenisMember jenisMember = new JenisMember(); // Membuat objek JenisMember untuk setiap baris data jenis anggota.
                    jenisMember.setId(resultSet.getString("jenis_member_id")); // Mendapatkan data jenis_member_id dari hasil query dan disimpan dalam objek jenisMember.
                    jenisMember.setNama(resultSet.getString("jenis_member_nama")); // Mendapatkan data jenis_member_nama dari hasil query dan disimpan dalam objek jenisMember.
                    
                    member.setJenisMember(jenisMember); // Mengatur jenis anggota dari objek member.
                    
                    list.add(member); // Menambahkan objek member ke dalam list.
                }
            } catch (SQLException e) { // Menangkap dan menangani pengecualian jika terjadi kesalahan dalam operasi SQL.
                e.printStackTrace(); // Mencetak jejak eksepsi jika terjadi kesalahan.
            }
        } catch (SQLException e) { // Menangkap dan menangani pengecualian jika terjadi kesalahan dalam operasi SQL.
            e.printStackTrace(); // Mencetak jejak eksepsi jika terjadi kesalahan.
        }
        return list; // Mengembalikan list yang berisi data anggota dari basis data.
    }
}
