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
import jenis_member.JenisMember; // Mengimpor kelas JenisMember dari paket jenis_member untuk merepresentasikan jenis-jenis member.

/**
 *
 * @author alvarez // Komentar yang menyatakan penulis kelas ini.
 */
public class JenisMemberDao { // Mendefinisikan kelas JenisMemberDao.

    public int insert(JenisMember jenisMember) { // Metode untuk menambahkan data jenis member ke dalam basis data.
        int result = -1; // Inisialisasi variabel result sebagai indikator keberhasilan operasi.
        try (Connection connection = MySqlConnection.getInstance().getConnection();) { // Membuat koneksi ke basis data menggunakan kelas MySqlConnection.
            PreparedStatement statement = connection.prepareStatement("insert into jenis_member (id, nama) values (?, ?)"); // Menyiapkan pernyataan SQL untuk memasukkan data ke dalam tabel jenis_member.
            statement.setString(1, jenisMember.getId()); // Mengatur parameter pertama (id) pada pernyataan SQL.
            statement.setString(2, jenisMember.getNama()); // Mengatur parameter kedua (nama) pada pernyataan SQL.
            
            result = statement.executeUpdate(); // Menjalankan pernyataan SQL dan mendapatkan jumlah baris yang terpengaruh.
        } catch (SQLException e) { // Menangkap dan menangani pengecualian jika terjadi kesalahan dalam operasi SQL.
            e.printStackTrace(); // Mencetak jejak eksepsi jika terjadi kesalahan.
        }
        return result; // Mengembalikan hasil dari operasi penambahan data.
    }
    
    public int update(JenisMember jenisMember) { // Metode untuk memperbarui data jenis member yang ada di dalam basis data.
        int result = -1; // Inisialisasi variabel result sebagai indikator keberhasilan operasi.
        try (Connection connection = MySqlConnection.getInstance().getConnection();) { // Membuat koneksi ke basis data menggunakan kelas MySqlConnection.
            PreparedStatement statement = connection.prepareStatement("update jenis_member set nama = ? where id = ?"); // Menyiapkan pernyataan SQL untuk memperbarui data dalam tabel jenis_member.
            statement.setString(1, jenisMember.getNama()); // Mengatur parameter pertama (nama) pada pernyataan SQL.
            statement.setString(2, jenisMember.getId()); // Mengatur parameter kedua (id) pada pernyataan SQL.
            
            result = statement.executeUpdate(); // Menjalankan pernyataan SQL dan mendapatkan jumlah baris yang terpengaruh.
        } catch (SQLException e) { // Menangkap dan menangani pengecualian jika terjadi kesalahan dalam operasi SQL.
            e.printStackTrace(); // Mencetak jejak eksepsi jika terjadi kesalahan.
        }
        return result; // Mengembalikan hasil dari operasi pembaruan data.
    }
    
    public int delete(JenisMember jenisMember) { // Metode untuk menghapus data jenis member dari basis data.
        int result = -1; // Inisialisasi variabel result sebagai indikator keberhasilan operasi.
        try (Connection connection = MySqlConnection.getInstance().getConnection();) { // Membuat koneksi ke basis data menggunakan kelas MySqlConnection.
            PreparedStatement statement = connection.prepareStatement("delete from jenis_member where id = ?"); // Menyiapkan pernyataan SQL untuk menghapus data dari tabel jenis_member.
            statement.setString(1, jenisMember.getId()); // Mengatur parameter (id) pada pernyataan SQL.
            
            result = statement.executeUpdate(); // Menjalankan pernyataan SQL dan mendapatkan jumlah baris yang terpengaruh.
        } catch (SQLException e) { // Menangkap dan menangani pengecualian jika terjadi kesalahan dalam operasi SQL.
            e.printStackTrace(); // Mencetak jejak eksepsi jika terjadi kesalahan.
        }
        return result; // Mengembalikan hasil dari operasi penghapusan data.
    }
    
    public List<JenisMember> findAll() { // Metode untuk mendapatkan semua data jenis member dari basis data.
        List<JenisMember> list = new ArrayList<>(); // Mendeklarasikan list untuk menyimpan data jenis member.
        try (Connection connection = MySqlConnection.getInstance().getConnection(); // Membuat koneksi ke basis data menggunakan kelas MySqlConnection.
                Statement statement = connection.createStatement();) { // Membuat objek Statement untuk mengeksekusi pernyataan SQL.
            try (ResultSet resultSet = statement.executeQuery("select * from jenis_member ");) { // Mengeksekusi pernyataan SQL untuk mendapatkan data dari tabel jenis_member.
                while(resultSet.next()) { // Iterasi melalui setiap baris hasil query.
                    JenisMember jenisMember = new JenisMember(); // Membuat objek JenisMember untuk setiap baris data.
                    jenisMember.setId(resultSet.getString("id")); // Mendapatkan data id dari hasil query dan disimpan dalam objek jenisMember.
                    jenisMember.setNama(resultSet.getString("Nama")); // Mendapatkan data nama dari hasil query dan disimpan dalam objek jenisMember.
                    
                    list.add(jenisMember); // Menambahkan objek jenisMember ke dalam list.
                }
            } catch (SQLException e) { // Menangkap dan menangani pengecualian jika terjadi kesalahan dalam operasi SQL.
                e.printStackTrace(); // Mencetak jejak eksepsi jika terjadi kesalahan.
            }
        } catch (SQLException e) { // Menangkap dan menangani pengecualian jika terjadi kesalahan dalam operasi SQL.
            e.printStackTrace(); // Mencetak jejak eksepsi jika terjadi kesalahan.
        }
        return list; // Mengembalikan list yang berisi data jenis member dari basis data.
    }
}