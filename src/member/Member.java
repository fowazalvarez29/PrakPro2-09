/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member; // Mendefinisikan package 'member' untuk kelas-kelas terkait dengan anggota.

import jenis_member.JenisMember; // Mengimpor kelas JenisMember dari paket jenis_member.

/**
 *
 * @author alvarez // Komentar yang menyatakan penulis kelas ini.
 */
public class Member { // Mendefinisikan kelas Member.

    public String id; // Mendeklarasikan variabel id untuk menyimpan ID anggota.
    public String nama; // Mendeklarasikan variabel nama untuk menyimpan nama anggota.
    private JenisMember jenisMember; // Mendeklarasikan objek jenisMember untuk merepresentasikan jenis anggota.
    
    public void setId(String id) { // Metode untuk mengatur nilai ID anggota.
        this.id = id; // Menetapkan nilai id dengan nilai yang diberikan.
    }
    
    public String getId() { // Metode untuk mendapatkan nilai ID anggota.
        return id; // Mengembalikan nilai id.
    }
    
    public void setNama(String nama) { // Metode untuk mengatur nama anggota.
        this.nama = nama; // Menetapkan nilai nama dengan nilai yang diberikan.
    }
    
    public String getNama() { // Metode untuk mendapatkan nama anggota.
        return nama; // Mengembalikan nilai nama.
    }
    
    public void setJenisMember(JenisMember jenisMember) { // Metode untuk mengatur jenis anggota.
        this.jenisMember = jenisMember; // Menetapkan jenis anggota dengan nilai yang diberikan.
    }
    
    public JenisMember getJenisMember() { // Metode untuk mendapatkan jenis anggota.
        return jenisMember; // Mengembalikan jenis anggota.
    }
    
}
